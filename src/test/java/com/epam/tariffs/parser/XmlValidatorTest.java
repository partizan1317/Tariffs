package com.epam.tariffs.parser;

import com.epam.tariffs.validation.ValidatorException;
import com.epam.tariffs.validation.XmlValidator;
import org.junit.Assert;
import org.junit.Test;

public class XmlValidatorTest {

    public static final XmlValidator VALIDATOR = new XmlValidator();
    private static final String VALID_XML_FILE = "src/test/resources/tariffs.xml";
    private static final String INVALID_XML_FILE = "src/test/resources/invalidTariffs.xml";
    private static final String XSD_FILE = "src/test/resources/tariffs.xsd";

    @Test
    public void testValidateShouldReturnTrueForAValidXmlXsdPair() throws ValidatorException {
        //given
        //when
        boolean actualIsValid = VALIDATOR.validate(VALID_XML_FILE, XSD_FILE);
        //then
        Assert.assertTrue(actualIsValid);
    }

    @Test
    public void testValidateShouldReturnFalseForAnInvalidXmlXsdPair() throws ValidatorException {
        //given
        //when
        boolean actualIsValid = VALIDATOR.validate(INVALID_XML_FILE, XSD_FILE);
        //then
        Assert.assertFalse(actualIsValid);
    }

}
