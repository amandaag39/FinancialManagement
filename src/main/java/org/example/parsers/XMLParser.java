package org.example.parsers;

public class XMLParser {
    public static void parseXMLWithXSD(String xmlFilePath, String xsdFilePath) {
        DOMParser parser = new DOMParser();
        parser.parseXML(xmlFilePath, xsdFilePath);
    }
}
