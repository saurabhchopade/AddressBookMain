package com.bridgelabz.addressbookmain.util;

import com.bridgelabz.addressbookmain.service.PersonOperation;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.Scanner;

public class Input extends PersonOperation {
    private final static Scanner strInput = new Scanner(System.in);
    private final static Scanner intInput = new Scanner(System.in);

    public Input() throws IOException, ParseException {
    }

    /**
     * Check the duplicate record in the AddressBook
     *
     * @param firstN
     * @return
     */
    public int checkDuplicate(String firstN) {
        int doNotAdd = 0;
        int add = 1;
        for (int duplicatePerson = 0; duplicatePerson < personTotalCount; duplicatePerson++) {
            if (firstN.equals(PersonOperation.personData[duplicatePerson].get(0))) {
                System.out.println("Duplicates Not Allowed");
                return doNotAdd;
            }
        }
        return add;
    }

    /**
     * Get all string values
     *
     * @return
     */
    public static String getStringValue() {
        return strInput.nextLine();
    }

    /**
     * Get all the int value
     *
     * @return
     */
    public static int getIntValue() {
        return intInput.nextInt();
    }
}
