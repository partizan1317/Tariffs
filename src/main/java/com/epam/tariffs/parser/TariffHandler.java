package com.epam.tariffs.parser;

import com.epam.tariffs.entity.HomeTariff;
import com.epam.tariffs.entity.Operator;
import com.epam.tariffs.entity.PhoneTariff;
import com.epam.tariffs.entity.Tariff;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;


public class TariffHandler extends DefaultHandler {

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
    private StringBuilder bufferedString;
    private Tariff.TariffBuilder currentTariffBuilder;
    private HomeTariff.HomeTariffBuilder bufferedHomeTariffBuilder;
    private PhoneTariff.PhoneTariffBuilder bufferedPhoneTariffBuilder;

    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
    }

    @Override
    public void startElement(String uri, String localName, String elementName, Attributes attributes) throws SAXException {
        switch (elementName) {
            case TARIFFS:
                tariffs = new ArrayList<>();
                break;
            case HOME_TARIFF:
                bufferedHomeTariffBuilder = new HomeTariff.HomeTariffBuilder();
                parseAttributes(bufferedHomeTariffBuilder, attributes);
                currentTariffBuilder = bufferedHomeTariffBuilder;
                break;
            case PHONE_TARIFF:
                bufferedPhoneTariffBuilder = new PhoneTariff.PhoneTariffBuilder();
                parseAttributes(bufferedPhoneTariffBuilder, attributes);
                currentTariffBuilder = bufferedPhoneTariffBuilder;
                break;
            default:
                if (elementName.equals(OPERATOR) || elementName.equals(PAYROLL) || elementName.equals(SMS_PRICE)
                || elementName.equals(CALL_MINUTES) || elementName.equals(ROUTER_TYPE) || elementName.equals(INTERNED_SPEED)) {
                    bufferedString = new StringBuilder();
                }
                break;
        }
    }

    @Override
    public void endElement(String uri, String localName, String elementName) throws SAXException {
        switch (elementName) {
            case HOME_TARIFF:
                tariffs.add(new HomeTariff(bufferedHomeTariffBuilder));
                break;
            case PHONE_TARIFF:
                tariffs.add(new PhoneTariff(bufferedPhoneTariffBuilder));
                break;
            case OPERATOR:
                String operatorLine = bufferedString.toString();
                Operator operator = Operator.valueOf(operatorLine);
                currentTariffBuilder.setOperatorType(operator);
                break;
            case PAYROLL:
                String payrollLine = bufferedString.toString();
                double payroll = Double.parseDouble(payrollLine);
                currentTariffBuilder.setPayroll(payroll);
                break;
            case CALL_MINUTES:
                String callMinutesLine = bufferedString.toString();
                int callMinutes = Integer.parseInt(callMinutesLine);
                bufferedPhoneTariffBuilder.setCallMinutes(callMinutes);
                break;
            case SMS_PRICE:
                String smsPriceLine = bufferedString.toString();
                double smsPrice = Double.parseDouble(smsPriceLine);
                bufferedPhoneTariffBuilder.setSmsPrice(smsPrice);
                break;
            case ROUTER_TYPE:
                String routerTypeLine = bufferedString.toString();
                bufferedHomeTariffBuilder.setRouterType(routerTypeLine);
                break;
            case INTERNED_SPEED:
                String internetSpeedLine = bufferedString.toString();
                double internetSpeed = Double.parseDouble(internetSpeedLine);
                bufferedHomeTariffBuilder.setInternetSpeed(internetSpeed);
                break;
        }
    }

    @Override
    public void characters(char [] characters, int start, int length) throws SAXException {
        if (bufferedString == null) {
            bufferedString = new StringBuilder();
        }
        else {
            bufferedString.append(characters, start, length);
        }
    }

    private void parseAttributes(Tariff.TariffBuilder destination, Attributes attributes) {
        for (int i = 0; i < attributes.getLength(); i++) {
            if (attributes.getLocalName(i).equals(ID)) {
                String idLine = attributes.getValue(i);
                int id = Integer.parseInt(idLine);
                destination.setId(id);
            }
            else if (attributes.getLocalName(i).equals(NAME)) {
                String name = attributes.getValue(i);
                destination.setName(name);
            }
        }
    }

    public List<Tariff> getTariffs() {
        return tariffs;
    }
}
