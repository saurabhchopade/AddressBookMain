package com.bridgelabz.helper;

import java.util.ArrayList;
import java.util.Scanner;

public class Person {
    Scanner inputstr=new Scanner(System.in);
    //Variables Of AddressBook
    int addressBookSize=100;
    String firstName;
    String lastName;
    String address;
    String city;
    String state;
    String zip;
    String phone;

    ArrayList<String>[] arr = new ArrayList[addressBookSize];
    //This function Add person To arrayylist
    public int personAdd(int var) throws  Exception
    {       int personNumber=var;

            arr[personNumber]=new ArrayList<String>();
            System.out.println("Enter Name");
            //first name Imput
            firstName=inputstr.nextLine();
            arr[personNumber].add(firstName);
            //Input Address
            System.out.println("Enter LastName");
            lastName=inputstr.nextLine();
            arr[personNumber].add(lastName);
            // Adress
            System.out.println("Enter Address");
            address=inputstr.nextLine();
            arr[personNumber].add(address);
            //City
            System.out.println("Enter City");
            city=inputstr.nextLine();
            arr[personNumber].add(city);
            //State
            System.out.println("Enter State");
            state=inputstr.nextLine();
            arr[personNumber].add(state);
            //ZIp
            System.out.println("Enter ZipCode");
            zip=inputstr.nextLine();
            arr[personNumber].add(zip);
            //Phone Number
            System.out.println("Enter PhoneNumber");
            phone=inputstr.nextLine();
            arr[personNumber].add(phone);
            //Next person
            personNumber++;
            return  personNumber;
    }

    //this will Display Entire AdressBook
    public int personDisplay(int noOfRecord) throws Exception
    {   //each person
        //noOfRecords iterate upto inserted Count
        for (int records = 0; records <noOfRecord; records++)
        {
            //Display Records in Order of insertion
            System.out.println("Name:  "+arr[records].get(0));
            System.out.println("LastName:  "+arr[records].get(1));
            System.out.println("Address:  "+arr[records].get(2));
            System.out.println("City:  "+arr[records].get(3));
            System.out.println("State:  "+arr[records].get(4));
            System.out.println("Zip:  "+arr[records].get(5));
            System.out.println("Phone:  "+arr[records].get(6));
            //Newline
            System.out.println();
        }
        return noOfRecord;
    }

}
