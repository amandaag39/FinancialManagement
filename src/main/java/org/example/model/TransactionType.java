package org.example.model;

import org.example.annotations.Column;
import org.example.annotations.Id;

public class TransactionType {
    @Id(name = "transaction_type_id")
    @Column(name = "transaction_type_id")
    private int transactionTypeId;
    @Column(name = "transaction_type_name")
    private String transactionTypeName;

    public TransactionType() {
    }

    public TransactionType(int transactionTypeId, String transactionTypeName) {
        this.transactionTypeId = transactionTypeId;
        this.transactionTypeName = transactionTypeName;
    }

    public int getTransactionTypeId() {
        return transactionTypeId;
    }

    public void setTransactionTypeId(int transactionTypeId) {
        this.transactionTypeId = transactionTypeId;
    }

    public String getTransactionTypeName() {
        return transactionTypeName;
    }

    public void setTransactionTypeName(String transactionTypeName) {
        this.transactionTypeName = transactionTypeName;
    }

    @Override
    public String toString() {
        return "TransactionType{" +
                "transactionTypeId=" + transactionTypeId +
                ", transactionTypeName='" + transactionTypeName + '\'' +
                '}';
    }
}
