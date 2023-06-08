package org.example.parsers;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import java.io.File;

public class DOMParser {
    public void parseXML(String filePath, String xsdFilePath) {
        try {
            // Create a DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Enable validation if needed
            factory.setValidating(false);

            // Create a SchemaFactory
            SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

            // Load the XSD schema file
            File xsdFile = new File(xsdFilePath);
            Schema schema = schemaFactory.newSchema(xsdFile);

            // Set the XSD schema for validation
            factory.setSchema(schema);

            // Create a DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Set a custom error hangler
            builder.setErrorHandler(new CustomErrorHandler());

            // Parse the XML file and obtain the Document object
            Document document = builder.parse(new File(filePath));

            // ADD METHODS HERE TO ACCESS ELEMENTS, ATTRIBUTES, ETC using DOM methods
            Element rootElement = document.getDocumentElement();
            String rootElementName = rootElement.getNodeName();
            System.out.println("Root element: " + rootElementName);
        } catch (Exception e) {
            // Handle the exception gracefully
            String errorMessage = "An error occurred during XML parsing: " + e.getMessage();
            // Perform any other necessary actions or error handling
            System.out.println(errorMessage);
        }
    }

    //Custom error handler class
    private class CustomErrorHandler implements ErrorHandler {
        @Override
        public void warning(SAXParseException exception) throws SAXException {
            // Handle validation warnings
            System.out.println("Warning: " + exception.getMessage());
        }

        @Override
        public void error(SAXParseException exception) throws SAXException {
            // Handle validation errors
            System.out.println("Error: " + exception.getMessage());
        }

        @Override
        public void fatalError(SAXParseException exception) throws SAXException {
            // Handle fatal errors
            System.out.println("Fatal Error: " + exception.getMessage());
        }
    }
}
