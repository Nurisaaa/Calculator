package com.company;

import java.util.HashMap;
import java.util.Map;

public class RomanNum {
    // Program to convert Roman

    private static final Map<Character, Integer> roman = new HashMap<>() {{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
    }};

    public static int romanToInt(String s)throws NumberFormatException {
            int sum = 0;
            int n = s.length();

            for (int i = 0; i < n; i++) {
                if (i != n - 1 && roman.get(s.charAt(i)) < roman.get(s.charAt(i + 1))) {
                    sum += roman.get(s.charAt(i + 1)) - roman.get(s.charAt(i));
                    i++;
                } else {
                    sum += roman.get(s.charAt(i));
                }
            }
            return sum;
    }


    public static String intToRoman(int num) {
            StringBuilder sb = new StringBuilder();
            int times = 0;
            String[] romans = new String[]{"I", "IV", "V", "IX", "X", "XL", "L",
                    "XC", "C", "CD", "D", "CM", "M"};
            int[] ints = new int[]{1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500,
                    900, 1000};
            for (int i = ints.length - 1; i >= 0; i--) {
                times = num / ints[i];
                num %= ints[i];
                while (times > 0) {
                    sb.append(romans[i]);
                    times--;
                }
            }
            return sb.toString();

    }

}


