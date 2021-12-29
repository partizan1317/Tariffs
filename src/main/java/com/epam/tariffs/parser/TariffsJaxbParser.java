package com.epam.tariffs.parser;

import com.epam.tariffs.entity.Tariff;
import com.epam.tariffs.entity.TariffsWrapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.UnmarshalException;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class TariffsJaxbParser implements Parser {

    private static final Logger LOGGER = LogManager.getLogger(TariffsJaxbParser.class);

    @Override
    public List<Tariff> parse(String filePath) throws ParserException {
        LOGGER.info("Started parsing tariffs from " + filePath);
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(TariffsWrapper.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            FileReader reader = new FileReader(filePath);
            TariffsWrapper tariffsWrapper = (TariffsWrapper) unmarshaller.unmarshal(reader);
            return tariffsWrapper.getTariffs();
        } catch (JAXBException | FileNotFoundException exception) {
            throw new ParserException(exception);
        }
    }
}
