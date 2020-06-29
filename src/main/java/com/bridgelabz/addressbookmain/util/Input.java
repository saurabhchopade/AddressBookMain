package com.bridgelabz.addressbookmain.util;

import com.bridgelabz.addressbookmain.model.Person;

import java.util.Scanner;
public class Input extends Person{
    private final static Scanner strInput = new Scanner(System.in);
    private final static Scanner intInput = new Scanner(System.in);

    //To give the String Values
    public int checkDuplicate(String firstN) {
        int doNotAdd = 0;
        int add = 1;
        for (int duplicatePerson = 0; duplicatePerson < personTotalCount; duplicatePerson++) {
            if (firstN.equals(Person.dataStorage[duplicatePerson].get(0))) {
                System.out.println("Duplicates Not Allowed");
                return doNotAdd;
            }
        }
        return add;
    }
    public static String getStringValue(){
        return strInput.nextLine();

    }
    public static int getIntValue(){
        return intInput.nextInt();

    }
}
