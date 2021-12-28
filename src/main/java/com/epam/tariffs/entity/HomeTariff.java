package com.epam.tariffs.entity;

import javax.xml.bind.annotation.*;
import java.util.Objects;

@XmlRootElement(name = "home-tariff")
@XmlAccessorType(XmlAccessType.FIELD)
public class HomeTariff extends Tariff {

    @XmlElement(name = "router-type", namespace = "http://www.example.com/tariffs")
    private String routerType;
    @XmlElement(name = "internet-speed", namespace = "http://www.example.com/tariffs")
    private double internetSpeed;

    public HomeTariff () {

    }

    public HomeTariff(int id, Operator operatorType, String name, double payroll, String routerType, double internetSpeed) {
        super(id, operatorType, name, payroll);
        this.routerType = routerType;
        this.internetSpeed = internetSpeed;
    }

    public HomeTariff(HomeTariffBuilder builder){
        super(builder);
        this.routerType = builder.routerType;
        this.internetSpeed = builder.internetSpeed;
    }

    public String getRouterType() {
        return routerType;
    }

    public double getInternetSpeed() {
        return internetSpeed;
    }

    public static class HomeTariffBuilder extends TariffBuilder {
        private String routerType;
        private double internetSpeed;

        public void setRouterType(String routerType) {
            this.routerType = routerType;
        }

        public void setInternetSpeed(double internetSpeed) {
            this.internetSpeed = internetSpeed;
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
        HomeTariff homeTariff = (HomeTariff) o;
        return Objects.equals(routerType, homeTariff.routerType) && internetSpeed == homeTariff.internetSpeed;
    }

    @Override
    public int hashCode() {
        int prime = 17;
        prime = 31 * prime + super.hashCode();
        prime = 31 * prime + routerType.hashCode();
        prime = 31 * prime + (int) internetSpeed;
        return prime;
    }

    @Override
    public String toString() {
        return "Home Tariff{" +
                "router type= " + routerType +
                ", internet speed= " + internetSpeed +
                "}";
    }
}
