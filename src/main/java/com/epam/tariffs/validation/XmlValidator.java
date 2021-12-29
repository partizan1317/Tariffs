package com.epam.tariffs.validation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class XmlValidator {

    private static final Logger LOGGER = LogManager.getLogger(XmlValidator.class);

    public boolean validate(String xmlPath, String xsdPath) throws ValidatorException {
        try {
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            File schemaLocation = new File(xsdPath);
            Schema schema = factory.newSchema(schemaLocation);
            Validator validator = schema.newValidator();
            Source source = new StreamSource(xmlPath);
            try {
                validator.validate(source);
            } catch (IllegalArgumentException exception) {
                return false;
            }
            return true;
        } catch (IOException | SAXException exception) {
            throw new ValidatorException(exception);
        }
    }

}
