//package com.example.springproject.response;
//
//import org.w3c.dom.Document;
//import org.w3c.dom.NodeList;
//import org.xml.sax.InputSource;
//
//import javax.xml.parsers.DocumentBuilderFactory;
//import java.io.StringReader;
//
//public class XMLParser {
//    public static NodeList parseXML(String xmlContent) throws Exception {
//        Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder()
//                .parse(new InputSource(new StringReader(xmlContent)));
//        doc.getDocumentElement().normalize();
//        return doc.getElementsByTagName("title");
//    }
//}
