package com.epam.tariffs.parser;

import com.epam.tariffs.entity.HomeTariff;
import com.epam.tariffs.entity.PhoneTariff;
import com.epam.tariffs.entity.Tariff;
import jdk.nashorn.internal.runtime.arrays.TypedArrayData;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.List;

public class TariffsDomBuilder {

    private final Document doc;
    private static final String TARIFFS = "tariffs";
    private static final String HOME_TARIFF = "home-tariff";
    private static final String PHONE_TARIFF = "phone-tariff";
    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String OPERATOR = "operator";
    private static final String PAYROLL = "payroll";
    private static final String SMS_PRICE = "sms-price";
    private static final String CALL_MINUTES = "call-minutes";
    private static final String ROUTER_TYPE = "router-type";
    private static final String INTERNED_SPEED = "internet-speed";

    private List<Tariff> tariffs;
    private Tariff.TariffBuilder currentTariffBuilder;
    private HomeTariff.HomeTariffBuilder bufferedHomeTariffBuilder;
    private PhoneTariff.PhoneTariffBuilder bufferedPhoneTariffBuilder;

    public TariffsDomBuilder (Document doc) {
        this.doc = doc;
    }

    public List<Tariff> buildListTariffs() {
        Element rootElement = doc.getDocumentElement();
        NodeList homeTariffsList = rootElement.getElementsByTagName(HOME_TARIFF);
        for(int i = 0; i < homeTariffsList.getLength(); i++) {
            Element homeTariffElement = (Element) homeTariffsList.item(i);

        }
        NodeList phoneTariffsList = rootElement.getElementsByTagName(PHONE_TARIFF);
        for(int i = 0; i < phoneTariffsList.getLength(); i++) {
            Element phoneTariffElement = (Element) phoneTariffsList.item(i);

        }
    }

    public void buildTariff(Element tariffElement) {
        switch (tariffElement) {

        }
    }



    private String getElementTextContent(Element element, String elementName) {
        NodeList nodeList = element.getElementsByTagName(elementName);
        Node node = nodeList.item(0);
        return node.getTextContent();
    }

}
