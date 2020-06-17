package com.bridgelabz.main;
import java.util.*;
import com.bridgelabz.helper.Person;

public class AddressBookMain extends Person {

    public static void main(String args[]) throws Exception {
        //For Input perpose
        Scanner inputint=new Scanner(System.in);
        //Created Person Object To call Helper Functions
        Person obj=new Person();
        int personCount=0;
        int choice=0;

        while (true)
        {
            //For Display Perpose
            System.out.println("\n======= Address Book Features===========\n\n");
            System.out.println("1  ADD New Person");
            System.out.println("2  DISPLAY AddressBook Records");
            System.out.println("3  Edit Existing Data");
            System.out.println("4  Delete Person");
            System.out.println("5  Sorting by name");
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
                            System.out.println("DO You Want To Add More Press (1)continue | (2)Cancel");
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
                case 5:
                        //All sorting Techniques Performed By one function
                        int sortChoice;
                        System.out.println("===SELECT SORTING TECHNIQUE");
                        System.out.println("1) By Name");
                        System.out.println("2) By City");
                        System.out.println("3) by State");
                        System.out.println("4) By Zip");
                        sortChoice=inputint.nextInt();
                        switch (sortChoice)
                        {
                            case 1:
                                    personCount=obj.allSort(personCount,0);
                                    break;
                            case 2:
                                    personCount=obj.allSort(personCount,3);
                                    break;
                            case 3:
                                    personCount=obj.allSort(personCount,4);
                                    break;
                            case 4:
                                personCount=obj.allSort(personCount,5);
                                break;
                            default:
                                System.out.println("Enter Correct Option");
                        }

                        break;
                default:
                    System.out.println("INVALID CHOICE");

            }
        }
    }
}