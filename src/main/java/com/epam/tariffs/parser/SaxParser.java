package com.epam.tariffs.parser;

import com.epam.tariffs.entity.Tariff;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.util.List;

public class SaxParser implements Parser{
    private String filePath;

    public SaxParser(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public List<Tariff> parse(String filePath) throws ParserException {
        SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        try {
            Schema schema = factory.newSchema(new File(filePath));
            SAXParserFactory spf = SAXParserFactory.newInstance();
            spf.setSchema(schema);
            SAXParser parser = spf.newSAXParser();
       //     parser.parse();
        } catch (ParserConfigurationException exception){

        } catch (SAXException event) {

        }

        return null;
    }
}
