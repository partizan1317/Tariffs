package com.epam.tariffs.entity;

import java.util.Objects;

public class Tariff {
    private final int id;
    private final String name;
    private final Operator operatorType;
    private final double payroll;

    public Tariff(int id, String name, Operator operatorType, double payroll) {
        this.id = id;
        this.name = name;
        this.operatorType = operatorType;
        this.payroll = payroll;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Operator getOperatorType() {
        return operatorType;
    }

    public double getPayroll() {
        return payroll;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Tariff tariff = (Tariff) o;
        return id == tariff.id && Objects.equals(name, tariff.name) && operatorType == tariff.operatorType && payroll == tariff.payroll;
    }

    @Override
    public int hashCode() {
        int prime = 17;
        prime = 31 * prime + id;
        prime = 31 * prime + name.hashCode();
        prime = 31 * prime + operatorType.hashCode();
        prime = 31 * prime + (int) payroll;
        return prime;
    }

    @Override
    public String toString(){
        return "Tariff{" +
                ", id= " + id +
                ", name= " + name +
                ", operatorType= " + operatorType +
                ", payroll= " + payroll +
                "}";
    }
}
