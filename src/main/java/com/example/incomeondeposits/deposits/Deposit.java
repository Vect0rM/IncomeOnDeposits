package com.example.incomeondeposits.deposits;

import java.util.Objects;
// Класс вклада, его конструкторы, геттеры и сеттеры
public class Deposit {
    private long sum;
    private long years;
    private double percent;
    private long refill;

    public Deposit() {
    }

    public Deposit(long sum, long years, double percent, long refill) {
        this.sum = sum;
        this.years = years;
        this.percent = percent;
        this.refill = refill;
    }

    public long getSum() {
        return sum;
    }

    public void setSum(long sum) {
        this.sum = sum;
    }

    public long getYears() {
        return years;
    }

    public void setYears(long years) {
        this.years = years;
    }

    public double getPercent() {
        return percent;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }

    public long getRefill() {
        return refill;
    }

    public void setRefill(long refill) {
        this.refill = refill;
    }

    @Override
    public String toString() {
        return "Deposit{" +
                "sum=" + sum +
                ", years=" + years +
                ", percent=" + percent +
                ", refill=" + refill +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Deposit deposit = (Deposit) o;
        return sum == deposit.sum && years == deposit.years && Double.compare(deposit.percent, percent) == 0 && refill == deposit.refill;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sum, years, percent, refill);
    }
}
