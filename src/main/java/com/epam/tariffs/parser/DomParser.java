package com.epam.tariffs.parser;

import com.epam.tariffs.entity.Tariff;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

public class DomParser implements Parser{
    @Override
    public List<Tariff> parse(String filePath) throws ParserException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder documentBuilder = factory.newDocumentBuilder();
            Document doc = documentBuilder.parse(filePath);
        } catch (ParserConfigurationException | SAXException | IOException exception) {
            throw new ParserException();
        }
    }
}
