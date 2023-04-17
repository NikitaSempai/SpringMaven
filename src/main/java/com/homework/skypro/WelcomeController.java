package com.homework.skypro;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator")
public class WelcomeController {
    private final CalculatorService calculatorService;

    public WelcomeController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping
    public String welcome() {
        return "<b>Добро пожаловать в калькулятор</b>";
    }

    @GetMapping(path = "/plus")
    public ResponseEntity<String> sumResult(@RequestParam(name = "num1", required = false) Integer firstNumber, @RequestParam(name = "num2", required = false) Integer secondNumber) {
        var status = check(firstNumber, secondNumber);
        if(status != null){
            return ResponseEntity.status(400).body("<b>" + status + "</b>");
        }
        return calculatorService.sumResult(firstNumber, secondNumber);
    }

    @GetMapping(path = "/minus")
    public ResponseEntity<String> minusResult(@RequestParam(name = "num1", required = false) Integer firstNumber, @RequestParam(name = "num2", required = false) Integer secondNumber) {
        var status = check(firstNumber, secondNumber);
        if(status != null){
            return ResponseEntity.status(400).body("<b>" + status + "</b>");
        }
        return calculatorService.minusResult(firstNumber, secondNumber);
    }

    @GetMapping(path = "/multiply")
    public ResponseEntity<String> multiplyResult(@RequestParam(name = "num1", required = false) Integer firstNumber, @RequestParam(name = "num2", required = false) Integer secondNumber) {
        var status = check(firstNumber, secondNumber);
        if(status != null){
            return ResponseEntity.status(400).body("<b>" + status + "</b>");
        }
        return calculatorService.multiplyResult(firstNumber, secondNumber);
    }

    @GetMapping(path = "/divide")
    public ResponseEntity<String> divideResult(@RequestParam(name = "num1", required = false) Integer firstNumber, @RequestParam(name = "num2", required = false) Integer secondNumber) {
        var status = check(firstNumber, secondNumber);
        if(status != null){
            return ResponseEntity.status(400).body("<b>" + status + "</b>");
        }
        return calculatorService.divideResult(firstNumber, secondNumber);
    }

    public String check(Integer num1, Integer num2){
        if(num1 == null || num2 == null){
            return "Please enter a number";
        }
        return null;
    }
}
