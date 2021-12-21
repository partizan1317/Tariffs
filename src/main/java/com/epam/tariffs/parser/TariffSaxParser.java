package com.epam.tariffs.parser;

import com.epam.tariffs.entity.Tariff;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.List;

public class TariffSaxParser implements Parser{

    @Override
    public List<Tariff> parse(String filePath) throws ParserException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = factory.newSAXParser();
            TariffHandler handler = new TariffHandler();
            saxParser.parse(filePath, handler);
            return handler.getTariffs();
        } catch (ParserConfigurationException | SAXException | IOException exception) {
            throw new ParserException(exception);
        }
    }
}
