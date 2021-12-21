package com.epam.tariffs.entity;

import java.util.Objects;

public class HomeTariff extends Tariff {
    private final String routerType;
    private final double internetSpeed;

    public HomeTariff(int id, String name, Operator operatorType, double payroll, String routerType, double internetSpeed) {
        super(id, name, operatorType, payroll);
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
