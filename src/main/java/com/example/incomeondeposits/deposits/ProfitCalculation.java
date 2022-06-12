package com.example.incomeondeposits.deposits;

import static java.lang.Math.round;

//Класс для выполнения расчетов
public class ProfitCalculation {

    //печать
    private String print(Long percent, long sumOfDeposit){
        return "Начисленные проценты: " + percent + " ₽" + "##" +
                "Сумма вклада с процентами: " + sumOfDeposit + " ₽";
    }
    //Расчет простого процента
    public String simplePercentages(Deposit deposit){
        double profit = 0;
        long sum = deposit.getSum();
        for (int i = 0; i < deposit.getYears(); i++) {
            for (int j = 0; j < 12; j++) {
                //Средние количество дней в месяце деленное на год
                double monthsDivYear = 0.08333348473176674;
                profit = profit + ((sum * deposit.getPercent() * monthsDivYear) / 100);
                sum = sum + deposit.getRefill();
            }
        }
        return print((long) profit, (sum + (long) profit - deposit.getRefill()));
    }

    //Расчет сложного процента
    public String compoundInterest(Deposit deposit){
        double profit;
        long sum = deposit.getSum();
        long refill = 0;
        for (int i = 0; i < deposit.getYears(); i++) {
            for (int j = 0; j < 12; j++) {
                profit = (sum * (1 + ((deposit.getPercent() / 100) / 12))) - sum;
                sum = (sum + deposit.getRefill() + round(profit));
                refill = refill + deposit.getRefill();
            }
        }
        return print((sum - deposit.getSum() - refill), (sum - deposit.getRefill()));
    }
}
