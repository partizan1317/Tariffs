package com.epam.tariffs.parser;

import com.epam.tariffs.entity.Tariff;

import java.util.List;

public interface Parser {
    List<Tariff> parse(String filePath) throws ParserException;
}
