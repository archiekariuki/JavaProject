package com.company;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        NumberFormat currency = NumberFormat.getCurrencyInstance();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Principal: ");
        double principal = scanner.nextDouble();
        System.out.print("Annual Rate: ");
        double rate = ((scanner.nextDouble())/MONTHS_IN_YEAR)/PERCENT;
        System.out.print("Period(Years): ");
        int period = (scanner.nextInt())*MONTHS_IN_YEAR;
        double mortgage = principal * ((rate* (Math.pow((1 + rate),period)))
                                        / (Math.pow((1 + rate),period) - 1));
        System.out.println(currency.format(mortgage));
    }
}
