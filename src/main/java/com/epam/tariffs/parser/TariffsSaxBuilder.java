package com.epam.tariffs.parser;

import com.epam.tariffs.entity.Tariff;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;
import java.util.List;

public class TariffsSaxBuilder {
    private List<Tariff> tariffs;
    private final XMLReader reader;
    private final TariffsSaxHandler handler;

    public TariffsSaxBuilder() throws ParserException{
        handler = new TariffsSaxHandler();
        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(handler);
        } catch (SAXException exception) {
            throw new ParserException(exception);
        }
    }

    public List<Tariff> getTariffs() {
        return tariffs;
    }

    public void buildSetTariffs(String filePath)throws ParserException {
        try {
            reader.parse(filePath);
        } catch (SAXException | IOException exception) {
            throw new ParserException(exception);
        }
        tariffs = handler.getTariffs();
    }

}
