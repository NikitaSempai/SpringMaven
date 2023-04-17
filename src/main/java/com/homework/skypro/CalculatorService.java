package com.homework.skypro;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    public ResponseEntity<String> sumResult(int firstNumber, int secondNumber) {
        int result = firstNumber + secondNumber;
        return ResponseEntity.ok("<b>" + firstNumber + " + " + secondNumber + " = " + result + "</b>");
    }

    public ResponseEntity<String> minusResult(int firstNumber, int secondNumber) {
        int result = firstNumber - secondNumber;
        return ResponseEntity.ok("<b>" + firstNumber + " - " + secondNumber + " = " + result + "</b>");
    }

    public ResponseEntity<String> multiplyResult(int firstNumber, int secondNumber) {
        int result = firstNumber * secondNumber;
        return ResponseEntity.ok("<b>" + firstNumber + " * " + secondNumber + " = " + result + "</b>");
    }

    public ResponseEntity<String> divideResult(int firstNumber, int secondNumber) {
        if (secondNumber == 0) {
            return ResponseEntity.status(444).body("<b>Деление на ноль невозможно</b>");
        }
        int result = firstNumber / secondNumber;
        return ResponseEntity.ok("<b>" + firstNumber + " / " + secondNumber + " = " + result + "</b>");
    }
}
