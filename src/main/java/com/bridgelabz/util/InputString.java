package com.bridgelabz.util;

import java.util.Scanner;

public class InputString {
    private final static Scanner strInput = new Scanner(System.in);
    //To give the String Values
    public static String getStringValue(){
        return strInput.nextLine();
    }
}
