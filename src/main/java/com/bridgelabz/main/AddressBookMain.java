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
            System.out.println("4  Delete Person");
            System.out.println("Enter Choice");
            choice=inputint.nextInt();
            switch (choice)
            {
                case 1:
                        //inserting new record
                        int playMore=1;
                        ///condition to check to continue
                        while(playMore==1)
                        {
                            personCount=obj.personAdd(personCount);
                            System.out.println("DO You Want To Add More Press (1) To continue");
                            playMore=inputint.nextInt();
                        }

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
                case 4:
                        personCount=obj.deletePerson(personCount);
                        break;
                default:
                    System.out.println("INVALID CHOICE");

            }
        }
    }
}