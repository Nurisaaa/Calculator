package com.company;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("write  ");
            String input = scanner.nextLine().toUpperCase(Locale.ROOT);
            String[] str = input.split(" ");
            if (str.length != 3) try {
                throw new MyException();
            } catch (MyException e) {
                System.out.println("Something get wrong, try again");
                continue;
            }
            try {
                int numberOne = RomanNum.romanToInt(str[0]);
                int numberTwo = RomanNum.romanToInt(str[2]);
                String operation = str[1];
                int result = Calculate.calculate(numberOne, operation, numberTwo);
                System.out.println(RomanNum.intToRoman(result));
            } catch (NullPointerException e) {
                try {
                    int numberOne = Integer.parseInt(str[0]);
                    int numberTwo = Integer.parseInt(str[2]);
//                    if(numberOne>10 && numberTwo>10) try {
//                        throw new MyException();
//                    } catch (MyException ex) {
//                        System.out.println("");
//                    }
                    System.out.println(Calculate.calculate(numberOne, str[1], numberTwo));
                } catch (NumberFormatException c) {
                    System.out.println("вы вели не правильные данные! ");
                    ;
                }
            }
        }
    }
}