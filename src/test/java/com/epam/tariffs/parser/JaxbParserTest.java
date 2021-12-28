package com.epam.tariffs.parser;

import com.epam.tariffs.entity.HomeTariff;
import com.epam.tariffs.entity.Operator;
import com.epam.tariffs.entity.PhoneTariff;
import com.epam.tariffs.entity.Tariff;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class JaxbParserTest {

    private static final TariffsJaxbParser PARSER = new TariffsJaxbParser();
    private static final String  FILE_WITH_TWO_PHONE_TARIFFS_AND_TWO_HOME_TARIFFS = "src/test/resources/tariffs.xml";
    private static final List<Tariff> LIST_WITH_THO_PHONE_TARIFFS_AND_TWO_HOME_TARIFFS = Arrays.asList(
            new PhoneTariff(1, Operator.MTS, "Безлимитище", 18.90, 150, 0.2),
            new PhoneTariff(2, Operator.LIFE, "Пенсионный", 9.40, 100, 0.1),
            new HomeTariff(3, Operator.A1, "HomeSmart", 25, "ADSL", 50),
            new HomeTariff(4, Operator.A1, "HomeLuxury", 50, "Ethernet (FTTB)", 150));

    @Test
    public void testShouldReturnListOfTariffsWhenThereAreBothHomeTariffsAndPhoneTariffsInFile() throws ParserException {
        //given
        //when
        List<Tariff> actualList = PARSER.parse(FILE_WITH_TWO_PHONE_TARIFFS_AND_TWO_HOME_TARIFFS);
        //then
        Assert.assertEquals(LIST_WITH_THO_PHONE_TARIFFS_AND_TWO_HOME_TARIFFS, actualList);
    }

}
