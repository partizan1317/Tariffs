package com.epam.tariffs.entity;

public class PhoneTariff extends Tariff {

    private final int callMinutes;
    private final double smsPrice;

    public PhoneTariff(int id, String name, Operator operatorType, double payroll, int callMinutes, double smsPrice) {
        super(id, name, operatorType, payroll);
        this.callMinutes = callMinutes;
        this.smsPrice = smsPrice;
    }

    public PhoneTariff (PhoneTariffBuilder builder) {
        super(builder);
        this.callMinutes = builder.callMinutes;
        this.smsPrice = builder.smsPrice;
    }

    public int getCallMinutes() {
        return callMinutes;
    }

    public double getSmsPrice() {
        return smsPrice;
    }

    public static class PhoneTariffBuilder extends TariffBuilder {
        private int callMinutes;
        private double smsPrice;

        public void setCallMinutes(int callMinutes) {
            this.callMinutes = callMinutes;
        }

        public void setSmsPrice(double smsPrice) {
            this.smsPrice = smsPrice;
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
        PhoneTariff phoneTariff = (PhoneTariff) o;
        return callMinutes == phoneTariff.callMinutes && smsPrice == phoneTariff.smsPrice;
    }

    @Override
    public int hashCode() {
        int prime = 17;
        prime = 31 * prime + super.hashCode();
        prime = 31 * prime + callMinutes;
        prime = 31 * prime + (int) smsPrice;
        return prime;
    }

    @Override
    public String toString() {
        return "Phone Tariff{" +
                "call minutes= " + callMinutes +
                ", sms price= " + smsPrice +
                "}";
    }

}
