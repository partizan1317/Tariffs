package com.epam.tariffs.parser;

import com.epam.tariffs.entity.Tariff;
import com.epam.tariffs.validation.xmlValidator;

import java.util.List;

public class Director {

    private final Parser parser;
    private final xmlValidator validator;

    public Director (Parser parser, xmlValidator validator) {
        this.parser = parser;
        this.validator = validator;
    }

    List<Tariff> parse(String filePath) {
        return null;
    }

}
