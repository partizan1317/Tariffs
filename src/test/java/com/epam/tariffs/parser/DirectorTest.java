package com.epam.tariffs.parser;

import com.epam.tariffs.entity.HomeTariff;
import com.epam.tariffs.entity.Operator;
import com.epam.tariffs.entity.PhoneTariff;
import com.epam.tariffs.entity.Tariff;
import com.epam.tariffs.validation.ValidatorException;
import com.epam.tariffs.validation.XmlValidator;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

public class DirectorTest {

    private static final String XML_FILE_PATH = "xmlFile.xml";
    private static final String XSD_FILE_PATH = "xsdFile.xsd";
    private static final List<Tariff> LIST_WITH_THO_PHONE_TARIFFS_AND_TWO_HOME_TARIFFS = Arrays.asList(
            new PhoneTariff(1, Operator.MTS, "Безлимитище", 18.90, 150, 0.2),
            new PhoneTariff(2, Operator.LIFE, "Пенсионный", 9.40, 100, 0.1),
            new HomeTariff(3, Operator.A1, "HomeSmart", 25, "ADSL", 50),
            new HomeTariff(4, Operator.A1, "HomeLuxury", 50, "Ethernet (FTTB)", 150));

    @Test
    public void testParseShouldReturnAListOfTariffsWhenXmlIsValid() throws ParserException, DirectorException, ValidatorException {
        //given
        XmlValidator validator = Mockito.mock(XmlValidator.class);
        Mockito.when(validator.validate(XML_FILE_PATH, XSD_FILE_PATH)).thenReturn(true);
        Parser parser = Mockito.mock(Parser.class);
        Mockito.when(parser.parse(XML_FILE_PATH)).thenReturn(LIST_WITH_THO_PHONE_TARIFFS_AND_TWO_HOME_TARIFFS);
        Director director = new Director(parser, validator);
        //when
        List<Tariff> actualList = director.parse(XML_FILE_PATH, XSD_FILE_PATH);
        //then
        Assert.assertEquals(LIST_WITH_THO_PHONE_TARIFFS_AND_TWO_HOME_TARIFFS, actualList);
    }

    @Test(expected = DirectorException.class)
    public void testParseShouldThrowDirectorExceptionWhenXmlFileIsNotValid() throws ParserException, DirectorException, ValidatorException {
        //given
        XmlValidator validator = Mockito.mock(XmlValidator.class);
        Mockito.when(validator.validate(XML_FILE_PATH, XSD_FILE_PATH)).thenReturn(false);
        Parser parser = Mockito.mock(Parser.class);
        Mockito.when(parser.parse(XML_FILE_PATH)).thenReturn(LIST_WITH_THO_PHONE_TARIFFS_AND_TWO_HOME_TARIFFS);
        Director director = new Director(parser, validator);
        //when
        List<Tariff> actualList = director.parse(XML_FILE_PATH, XSD_FILE_PATH);
        //then
        Assert.assertEquals(LIST_WITH_THO_PHONE_TARIFFS_AND_TWO_HOME_TARIFFS, actualList);
    }
}
