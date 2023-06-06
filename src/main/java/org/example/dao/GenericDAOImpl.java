package org.example.dao;

import java.lang.reflect.Field;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.example.annotations.Column;
import org.example.annotations.Id;

public class GenericDAOImpl<T> implements GenericDAO<T> {
    private Connection connection;
    private Class<T> entityClass;
    private String tableName;

    public GenericDAOImpl(Connection connection, Class<T> entityClass) {
        this.connection = connection;
        this.entityClass = entityClass;
        this.tableName = entityClass.getSimpleName().toLowerCase();
        }


    @Override
    public void create(T entity) {
        Class<?> entityClass = entity.getClass();
        String tableName = entityClass.getSimpleName().toLowerCase(); //Get table name

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("INSERT INTO ")
                .append(tableName)
                .append(" (");

        StringBuilder valuesBuilder = new StringBuilder();

        Field[] fields = entityClass.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(Column.class)) {
                Column column = field.getAnnotation(Column.class);
                String columnName = column.name();
                if (columnName.isEmpty()) {
                    columnName = field.getName(); // If no explicit column name is specified, use the field name
                }
                queryBuilder.append(columnName).append(", ");
            } else {
                queryBuilder.append(field.getName()).append(", ");
            }
            valuesBuilder.append("?, ");
        }

        //Rename the last comma and space
        queryBuilder.setLength(queryBuilder.length() - 2);
        valuesBuilder.setLength(valuesBuilder.length() - 2);

        queryBuilder.append(") VALUES (").append(valuesBuilder.toString()).append(")");

        String query = queryBuilder.toString();

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            int parameterIndex = 1;
            for (Field field : fields) {
                field.setAccessible(true);
                Object value = field.get(entity);
                statement.setObject(parameterIndex, value);
                parameterIndex++;
            }
            statement.executeUpdate();

        } catch (SQLException | IllegalArgumentException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    public T getById(int id) {
        String tableName = getTableName();
        String primaryKeyColumnName = getPrimaryKeyColumnName();

        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM " + tableName + " WHERE " + primaryKeyColumnName + " = ?")) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    T entity = createEntityFromResultSet(resultSet);
                    return entity;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // Return null if the entity with the given id is not found
    }

//    protected abstract String getTableName();

    protected String getPrimaryKeyColumnName() {
        Field[] fields = entityClass.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(Id.class)) {
                Column columnAnnotation = field.getAnnotation(Column.class);
                if (columnAnnotation != null) {
                    return columnAnnotation.name();
                }
                return field.getName();
            }
        }
        throw new IllegalArgumentException("No primary key column found for entity class: " + entityClass.getName());
    }

    //getTableName method to determine table name based on the type parameter T
    private String getTableName() {
        if (entityClass != null) {
            return entityClass.getSimpleName().toLowerCase();
        }
        throw new IllegalArgumentException("Could not determine the entity class name.");
    }


    //create an instance of 'T' from the ResultSet
    public T createEntityFromResultSet(ResultSet resultSet) throws SQLException {
        T entity;
        try {
            entity = entityClass.getDeclaredConstructor().newInstance(); // Create a new instance of T using reflection
        } catch (Exception e) {
            throw new SQLException("Failed to create entity from ResultSet", e);
        }

        Field[] fields = entityClass.getDeclaredFields();
        for (Field field : fields) {
            try {
                String columnName = getColumnName(field);
                Object value = resultSet.getObject(columnName);
                field.setAccessible(true);

                // Handle conversion from java.sql.Date to java.time.LocalDate
                if (field.getType() == LocalDate.class && value instanceof java.sql.Date) {
                    java.sql.Date sqlDate = (java.sql.Date) value;
                    LocalDate localDate = sqlDate.toLocalDate();
                    field.set(entity, localDate);
                } else {
                    field.set(entity, value);
                }
            } catch (Exception e) {
                throw new SQLException("Failed to set value for field: " + field.getName(), e);
            }
        }

        return entity;
    }

    private String getColumnName(Field field) {
        Column columnAnnotation = field.getAnnotation(Column.class);
        if (columnAnnotation != null) {
            return columnAnnotation.name();
        }
        return field.getName(); // Use the field name as column name by default
    }

    @Override
    public void update(T entity) {
        Class<?> entityClass = entity.getClass();
        String tableName = entityClass.getSimpleName().toLowerCase(); // Get table name

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("UPDATE ")
                .append(tableName)
                .append(" SET ");

        Field[] fields = entityClass.getDeclaredFields();
        Field idField = null;

        List<Field> columnFields = new ArrayList<>(); // Store the column fields separately

        String idColumnName = null;

        for (Field field : fields) {
            if (field.isAnnotationPresent(Id.class)) { // Check for the @Id annotation
                idField = field;
                Column columnAnnotation = field.getAnnotation(Column.class);
                if (columnAnnotation != null && !columnAnnotation.name().isEmpty()) {
                    idColumnName = columnAnnotation.name();
                } else {
                    idColumnName = field.getName();
                }
            } else if (field.isAnnotationPresent(Column.class)) {
                Column columnAnnotation = field.getAnnotation(Column.class);
                String fieldName = field.getName();
                String columnName = columnAnnotation.name();
                if (columnName.isEmpty()) {
                    columnName = fieldName;
                }
                queryBuilder.append(columnName).append(" = ?, ");
                columnFields.add(field);
            }
        }

        if (idField == null) {
            throw new IllegalArgumentException("Entity class " + entityClass.getSimpleName() +
                    " does not have an @Id annotated field.");
        }

        queryBuilder.setLength(queryBuilder.length() - 2); // Remove the trailing comma and space

        Column columnAnnotation = idField.getAnnotation(Column.class);
        String columnName = columnAnnotation != null && !columnAnnotation.name().isEmpty()
                ? columnAnnotation.name()
                : idField.getName();

        queryBuilder.append(" WHERE ")
                .append(columnName)
                .append(" = ?");

        String query = queryBuilder.toString();

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            int parameterIndex = 1;

            for (Field field : columnFields) {
                field.setAccessible(true);
                Object value = field.get(entity);
                statement.setObject(parameterIndex, value);
                parameterIndex++;
            }

            idField.setAccessible(true);
            Object idValue = idField.get(entity);
            statement.setObject(parameterIndex, idValue);

            statement.executeUpdate();
        } catch (SQLException | IllegalAccessException e) {
            // Handle the exception appropriately, e.g., log the error or throw a custom exception
            e.printStackTrace();
        }
    }


    @Override
    public void delete(T entity) {
        Class<?> entityClass = entity.getClass();
        String tableName = entityClass.getSimpleName().toLowerCase(); // Get table name

        String primaryKeyColumn = getPrimaryKeyColumnName(entityClass);

        String query = "DELETE FROM " + tableName + " WHERE " + primaryKeyColumn + " = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            Object primaryKeyValue = getPrimaryKeyValue(entity, entityClass);
            statement.setObject(1, primaryKeyValue);

            statement.executeUpdate();
            statement.close();
        } catch (SQLException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private String getPrimaryKeyColumnName(Class<?> entityClass) {
        for (Field field : entityClass.getDeclaredFields()) {
            if (field.isAnnotationPresent(Id.class)) {
                Column columnAnnotation = field.getAnnotation(Column.class);
                return (columnAnnotation != null && !columnAnnotation.name().isEmpty())
                        ? columnAnnotation.name()
                        : field.getName();
            }
        }
        throw new IllegalArgumentException("Entity class does not have an @Id annotated field.");
    }

    private Object getPrimaryKeyValue(T entity, Class<?> entityClass) throws IllegalAccessException {
        for (Field field : entityClass.getDeclaredFields()) {
            if (field.isAnnotationPresent(Id.class)) {
                field.setAccessible(true);
                return field.get(entity);
            }
        }
        throw new IllegalArgumentException("Entity class does not have an @Id annotated field.");
    }

    @Override
    public List<T> getAll() {
        List<T> entities = new ArrayList<>();
        String query = "SELECT * FROM " + tableName;

        try (PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                T entity = createEntityFromResultSet(resultSet);
                entities.add(entity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return entities;
    }


}
