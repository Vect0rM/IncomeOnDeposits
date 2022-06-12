package com.example.incomeondeposits.controller;

import com.example.incomeondeposits.deposits.Deposit;
import com.example.incomeondeposits.deposits.ProfitCalculation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
//Контролер приложения
@Controller
public class MainController {
    //Отслеживает Get запросы
    @GetMapping("/")
    public String main(){
        return "main";
    }

    //Отслеживает Get запросы и отправляет информацию на сервер для расчетов
    @PostMapping("/")
    public String mainPost(@RequestParam String sum, @RequestParam String years, @RequestParam String percent, @RequestParam String accrued,
                           @RequestParam(defaultValue = "0") String refillIn, Model model) {

        Deposit deposit = new Deposit(Long.parseLong(sum), Long.parseLong(years), Double.parseDouble(percent), Long.parseLong(refillIn));
        ProfitCalculation profitCalculation = new ProfitCalculation();
        String[] calculation;
        if (accrued.contains("Выплачивать")) {
            calculation = profitCalculation.simplePercentages(deposit).split("##");
        } else {
            calculation = profitCalculation.compoundInterest(deposit).split("##");
        }
        model.addAttribute("calculation" , calculation);
        return "main";
    }
}
