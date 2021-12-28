package com.epam.tariffs.parser;

import com.epam.tariffs.entity.Tariff;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

public class TariffsDomParser implements Parser{

    private static final Logger LOGGER = LogManager.getLogger(TariffsDomParser.class);

    @Override
    public List<Tariff> parse(String filePath) throws ParserException {
        LOGGER.info("Started parsing tariffs from " + filePath);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder documentBuilder = factory.newDocumentBuilder();
            Document doc = documentBuilder.parse(filePath);
            TariffsDomBuilder tariffsDomBuilder = new TariffsDomBuilder(doc);
            return tariffsDomBuilder.buildListTariffs();
        } catch (ParserConfigurationException | SAXException | IOException exception) {
            throw new ParserException(exception);
        }
    }
}
