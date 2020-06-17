package com.bridgelabz.main;
import java.util.*;
import com.bridgelabz.helper.Person;

public class AddressBookMain {

    public static void main(String args[]) throws Exception {
        //For Input perpose
        Scanner inputint=new Scanner(System.in);
        //Created Person Object To call Helper Functions
        Person obj=new Person();
        int personCount=0;
        int choice=0;
        int upadteId=0;

        while (true)
        {
            //For Display Perpose
            System.out.println("\n======= Address Book Features===========\n\n");
            System.out.println("1  ADD New Person");
            System.out.println("2  DISPLAY AddressBook Records");
            System.out.println("3  Edit Existing Data");
            System.out.println("Enter Choice");
            choice=inputint.nextInt();
            switch (choice)
            {
                case 1:
                        //inserting new record
                        personCount=obj.personAdd(personCount);
                        break;
                case 2:
                        //Displaying all records
                        obj.personDisplay(personCount);
                        break;
                case 3:
                        obj.personDisplay(personCount);
                       // System.out.println("Enter ");
                        obj.updateRecord(personCount);
                        break;
                default:
                    System.out.println("INVALID CHOICE");
            }
        }
    }
}