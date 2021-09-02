package com.company;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here

      int principal =(int) readValue("Principal: ",1000, 1000000);
      float annualInterest = (float)readValue("Annual Rate: ", 1,30);
      byte years= (byte)readValue("Period(Years): ", 1, 30);

        double mortgage = calculatemortgage(principal,annualInterest,years);

        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage: " + mortgageFormatted );
    }
    public static double calculatemortgage(int principal, float annualInterest, byte years){
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;
        float numberOfPayments = years * MONTHS_IN_YEAR;
        float monthlyInterest = annualInterest/MONTHS_IN_YEAR/PERCENT;
        double mortgage = principal * ((monthlyInterest* (Math.pow((1 + monthlyInterest),numberOfPayments)))
                / (Math.pow((1 + monthlyInterest),numberOfPayments) - 1));

        return mortgage;
    }
    public static double readValue(String prompt, double min, double max ){
        Scanner scanner = new Scanner(System.in);
        double value;
        while(true){
            System.out.print(prompt);
            value = scanner.nextFloat();
            if(value >= min && value <= max){
                break;
            }
            System.out.println("Please enter a value between " + min +  "and" + max);
        }
        return value;
    }
}

