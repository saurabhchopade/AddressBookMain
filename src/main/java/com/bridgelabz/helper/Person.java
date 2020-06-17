package com.bridgelabz.helper;

import java.util.ArrayList;
import java.util.Scanner;

public class Person {
    Scanner inputstr=new Scanner(System.in);
    int addressBookSize=1;
    ArrayList<String>[] arr = new ArrayList[addressBookSize];
    //This function Add person To arrayylist
    public void personAdd()
    {
        for (int insert=0;insert<addressBookSize;insert++)
        {
            //Variables
            String firstName;
            String lastName;
            String address;
            String city;
            String state;
            String zip;
            String phone;

            arr[insert]=new ArrayList<String>();
            System.out.println("Enter Name");
            //first name Imput
            firstName=inputstr.nextLine();
            arr[insert].add(firstName);
            //Input Address
            System.out.println("Enter LastName");
            lastName=inputstr.nextLine();
            arr[insert].add(lastName);
            // Adress
            System.out.println("Enter Address");
            address=inputstr.nextLine();
            arr[insert].add(address);
            //City
            System.out.println("Enter City");
            city=inputstr.nextLine();
            arr[insert].add(city);
            //State
            System.out.println("Enter State");
            state=inputstr.nextLine();
            arr[insert].add(state);
            //ZIp
            System.out.println("Enter ZipCode");
            zip=inputstr.nextLine();
            arr[insert].add(zip);
            //Phone Number
            System.out.println("Enter PhoneNumber");
            phone=inputstr.nextLine();
            arr[insert].add(phone);
        }
    }
    //this will Display AdressBook
    public void personDisplay()
    {   //each person
        for (int records = 0; records < addressBookSize; records++)
        {   //this for to display person information from adressBook
            for (int dispData = 0; dispData < arr[records].size(); dispData++)
            {
                System.out.println(arr[records].get(dispData) + " ");
            }
            System.out.println();
        }

    }

}
