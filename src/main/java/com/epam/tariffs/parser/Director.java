package com.epam.tariffs.parser;

import com.epam.tariffs.entity.Tariff;
import com.epam.tariffs.validation.XmlValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class Director {

    private static final Logger LOGGER = LogManager.getLogger(Director.class);

    private final Parser parser;
    private final XmlValidator validator;

    public Director (Parser parser, XmlValidator validator) {
        this.parser = parser;
        this.validator = validator;
    }

    public List<Tariff> parse(String xmlPath, String xsdPath) throws DirectorException {
        LOGGER.info("Started parsing tariffs from " + xmlPath + " while validating by " + xsdPath);
        try {
            if (!validator.validate(xmlPath, xsdPath)) {
                throw new DirectorException("The xml file by specified path does not validate by the xsd file by inputted path");
            }
            return parser.parse(xmlPath);
        } catch (Exception exception) {
            throw new DirectorException(exception);
        }
    }
}
