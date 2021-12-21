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

    public Tariff(TariffBuilder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.operatorType = builder.operatorType;
        this.payroll = builder.payroll;
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

    public static class TariffBuilder {
        private int id;
        private String name;
        private Operator operatorType;
        private double payroll;


        public void setId(int id) {
            this.id = id;
        }

        public void setPayroll(double payroll) {
            this.payroll = payroll;
        }

        public void setOperatorType(Operator operatorType) {
            this.operatorType = operatorType;
        }

        public void setName(String name) {
            this.name = name;
        }
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
