package com.epam.tariffs.parser;

import com.epam.tariffs.entity.Tariff;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.List;


public class TariffsSaxParser implements Parser{

    private static final Logger LOGGER = LogManager.getLogger(TariffsSaxParser.class);

    @Override
    public List<Tariff> parse(String filePath) throws ParserException {
        LOGGER.info("Started parsing tariffs from " + filePath);
        TariffsSaxBuilder builder = new TariffsSaxBuilder();
        builder.buildSetTariffs(filePath);
        return builder.getTariffs();
    }
}
