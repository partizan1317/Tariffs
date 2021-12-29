package com.epam.tariffs.entity;

import javax.xml.bind.annotation.*;
import java.util.Objects;

@XmlSeeAlso({PhoneTariff.class, HomeTariff.class})
@XmlAccessorType(XmlAccessType.FIELD)
public class Tariff {

    @XmlAttribute(name = "id")
    private int id;
    @XmlAttribute(name = "name")
    private String name;
    @XmlElement(name = "operator-type", namespace = "http://www.example.com/tariffs")
    private Operator operatorType;
    @XmlElement(name = "payroll", namespace = "http://www.example.com/tariffs")
    private double payroll;

    public Tariff () {

    }

    public Tariff(int id, Operator operatorType, String name, double payroll) {
        this.id = id;
        this.operatorType = operatorType;
        this.name = name;
        this.payroll = payroll;
    }

    public Tariff(TariffBuilder builder) {
        this.id = builder.id;
        this.operatorType = builder.operatorType;
        this.name = builder.name;
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
