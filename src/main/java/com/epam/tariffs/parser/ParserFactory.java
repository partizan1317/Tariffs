package com.epam.tariffs.parser;

public class ParserFactory {
    private ParserFactory() {
    }

    static Parser getParser(ParserType parserType) throws ParserFactoryException{
        switch (parserType) {
            case JAXB:
                return new TariffsJaxbParser();
            case DOM:
                return new TariffsDomParser();
            case SAX:
                return new TariffsSaxParser();
            default:
                throw new ParserFactoryException("Could not identify the parser type");
        }
    }
}
