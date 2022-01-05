package com.company;

import java.util.InputMismatchException;

public class Calculate {

    public static int calculate(int number1, String operator, int number2 ) throws InputMismatchException {
        char operation = operator.charAt(0);
        int counter = 0;
        switch (operation) {
            case '+' -> counter = number1 + number2;
            case '-' -> counter = number1 - number2;
            case '*' -> counter = number1 * number2;
            case '/' -> counter = number1 / number2;
            default -> System.out.println("Wrong symbol");

        }
        return counter;
    }


}
