package com.company;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    final static byte MONTHS_IN_YEAR = 12;
    final static byte PERCENT = 100;
    public static void main(String[] args) {
	// write your code here
       int principal =(int) readValue("Principal: ",1000, 1000000);
      float annualInterest = (float)readValue("Annual Rate: ", 1,30);
      byte years= (byte)readValue("Period(Years): ", 1, 30);

        printBalance(principal, annualInterest, years);
        for(short months = 1; months <= years * MONTHS_IN_YEAR; months++){
           double balance = calculateBalance(principal,annualInterest,years,months);
            System.out.println(NumberFormat.getCurrencyInstance().format(balance));
        }

    }

    private static void printBalance(int principal, float annualInterest, byte years) {
        double mortgage = calculatemortgage(principal, annualInterest, years);
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage");
        System.out.println("--------");
        System.out.println("Monthly Payments: " + mortgageFormatted);
        System.out.println();
        System.out.println("Payment Schedule");
    }

    public static double calculatemortgage(int principal, float annualInterest, byte years){
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

    public static double calculateBalance(int principal,float annualInterest, byte years, short numberOfPaymentsMade){

        double monthlyInterest = annualInterest/MONTHS_IN_YEAR/PERCENT;
        short numberOfPayments = (short)(years * MONTHS_IN_YEAR);

            double balance = principal
                    *(Math.pow(1 + monthlyInterest,numberOfPayments) - Math.pow(1 + monthlyInterest, numberOfPaymentsMade))
                    / (Math.pow(1 + monthlyInterest,numberOfPayments) - 1);

           return balance;

    }
}

