package com.epam.tariffs.parser;

import com.epam.tariffs.entity.HomeTariff;
import com.epam.tariffs.entity.Operator;
import com.epam.tariffs.entity.PhoneTariff;
import com.epam.tariffs.entity.Tariff;
import com.sun.org.apache.bcel.internal.generic.Type;
import jdk.nashorn.internal.runtime.arrays.TypedArrayData;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

public class TariffsDomBuilder {

    private final Document doc;
    private static final int FIRST_ITEM = 0;
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

    public TariffsDomBuilder (Document doc) {
        this.doc = doc;
    }

    public List<Tariff> buildListTariffs() {
        Element rootElement = doc.getDocumentElement();
        List<Tariff> tariffs = new ArrayList<>();
        NodeList phoneTariffsList = rootElement.getElementsByTagName(PHONE_TARIFF);
        for(int i = 0; i < phoneTariffsList.getLength(); i++) {
            Element phoneTariffElement = (Element) phoneTariffsList.item(i);
            PhoneTariff phoneTariff = buildPhoneTariff(phoneTariffElement);
            tariffs.add(phoneTariff);
        }
        NodeList homeTariffsList = rootElement.getElementsByTagName(HOME_TARIFF);
        for(int i = 0; i < homeTariffsList.getLength(); i++) {
            Element homeTariffElement = (Element) homeTariffsList.item(i);
            HomeTariff homeTariff = buildHomeTariff(homeTariffElement);
            tariffs.add(homeTariff);
        }
        return tariffs;
    }

    public HomeTariff buildHomeTariff(Element homeTariffElement) {
        HomeTariff.HomeTariffBuilder homeTariffBuilder = new HomeTariff.HomeTariffBuilder();
        buildTariff(homeTariffBuilder, homeTariffElement);
        String routerTypeLine = getElementTextContent(homeTariffElement, ROUTER_TYPE);
        homeTariffBuilder.setRouterType(routerTypeLine);
        String internetSpeedLine = getElementTextContent(homeTariffElement, INTERNED_SPEED);
        double homeTariffInternetSpeed = Double.parseDouble(internetSpeedLine);
        homeTariffBuilder.setInternetSpeed(homeTariffInternetSpeed);
        return new HomeTariff(homeTariffBuilder);
    }

    public PhoneTariff buildPhoneTariff(Element phoneTariffElement) {
        PhoneTariff.PhoneTariffBuilder phoneTariffBuilder = new PhoneTariff.PhoneTariffBuilder();
        buildTariff(phoneTariffBuilder, phoneTariffElement);
        String smsPriceLine = getElementTextContent(phoneTariffElement, SMS_PRICE);
        double phoneTariffSmsPrice = Double.parseDouble(smsPriceLine);
        phoneTariffBuilder.setSmsPrice(phoneTariffSmsPrice);
        String callMinutesLine = getElementTextContent(phoneTariffElement, CALL_MINUTES);
        int phoneTariffCallMinutes = Integer.parseInt(callMinutesLine);
        phoneTariffBuilder.setCallMinutes(phoneTariffCallMinutes);
        return new PhoneTariff(phoneTariffBuilder);
    }

    public void buildTariff(Tariff.TariffBuilder tariffBuilder, Element tariffElement) {
        String idAttributeLine = tariffElement.getAttribute(ID);
        int homeTariffId = Integer.parseInt(idAttributeLine);
        tariffBuilder.setId(homeTariffId);
        String operatorAttributeLine = tariffElement.getAttribute(OPERATOR);
        switch (operatorAttributeLine) {
            case "MTS":
                tariffBuilder.setOperatorType(Operator.MTS);
            case "A1":
                tariffBuilder.setOperatorType(Operator.A1);
            case "LIFE":
                tariffBuilder.setOperatorType(Operator.LIFE);
        }
        String name = getElementTextContent(tariffElement, NAME);
        tariffBuilder.setName(name);
        String payrollLine = getElementTextContent(tariffElement, PAYROLL);
        double homeTariffPayroll = Double.parseDouble(payrollLine);
        tariffBuilder.setPayroll(homeTariffPayroll);
    }

    private String getElementTextContent(Element element, String elementName) {
        NodeList nodeList = element.getElementsByTagName(elementName);
        Node node = nodeList.item(FIRST_ITEM);
        return node.getTextContent();
    }

}
