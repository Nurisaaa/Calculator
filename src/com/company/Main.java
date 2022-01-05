package com.company;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)  {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("write operation ");
            String input = scanner.nextLine().toUpperCase(Locale.ROOT);
            char[] findOperation = new char[10];
            String operation = null;

            for (int i = 0; i < input.length(); i++) {
                findOperation[i] = input.charAt(i);
                if (findOperation[i] == '+') {
                    operation = "+";
                }
                if (findOperation[i] == '-') {
                    operation = "-";
                }
                if (findOperation[i] == '*') {
                    operation = "*";
                }
                if (findOperation[i] == '/') {
                    operation = "/";
                }

            }
            String[] str = input.split("[+-/*]");
            try {
                int numberOne = RomanNum.romanToInt(str[0]);
                int numberTwo = RomanNum.romanToInt(str[1]);
                int result = Calculate.calculate(numberOne, operation, numberTwo);
                System.out.println(RomanNum.intToRoman(result));
            } catch (NullPointerException e) {
                try {
                    int numberOne = Integer.parseInt(str[0]);
                    int numberTwo = Integer.parseInt(str[1]);
                    if(numberOne>10 || numberTwo>10) try {
                        throw new MyException();
                    } catch (MyException ex) {
                        System.out.println("!!!");
                        continue;
                    }
                    System.out.println(Calculate.calculate(numberOne, operation, numberTwo));
                } catch (NumberFormatException c) {
                    System.out.println("вы вели не правильные данные! ");

                }
            }
        }
    }
}