package com.bridgelabz.helper;

import javax.lang.model.type.NullType;
import java.util.*;

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

    List<String>[] arr = new ArrayList[addressBookSize];
    HashMap<String, String> cityMap = new HashMap<String, String>();
    HashMap<String, String> stateMap = new HashMap<String, String>();
    //This function Add person To arrayylist
    public int personAdd(int var ) throws  Exception
    {
        int personNumber=var;
        arr[personNumber]=new ArrayList<String>();
        System.out.println("Enter Name");
        firstName=inputstr.nextLine();
        //Duplicates Not allowed
        for(int i=0;i<personNumber;i++)
        {
            if(firstName.equals(arr[i].get(0)))
            {
                System.out.println("Duplicates Not Allowed");
                return personNumber;
            }
        }
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
    {
        //each person
        //noOfRecords iterate upto inserted Count
        for (int records = 0; records <noOfRecord; records++)
        {
                //Display Records in Order of insertion
                System.out.println("Name:  " + arr[records].get(0));
                System.out.println("LastName:  " + arr[records].get(1));
                System.out.println("Address:  " + arr[records].get(2));
                System.out.println("City:  " + arr[records].get(3));
                System.out.println("State:  " + arr[records].get(4));
                System.out.println("Zip:  " + arr[records].get(5));
                System.out.println("Phone:  " + arr[records].get(6));
                //Newline
                System.out.println();

        }
        return noOfRecord;
    }
    //this will update all data of person excluding name
   public int updateRecord(int personCount)
    {
        String dummyName;
        int count=personCount;
        System.out.println("Enter Person name to Edit Info=");
        dummyName=inputstr.nextLine();
        for (int records = 0; records <count; records++)
        {
            //Display Records in Order of insertion
            if(dummyName.equals(arr[records].get(0)))
            {
                System.out.println("Record Found");
                System.out.println("Enter LastName: ");
                firstName=dummyName;
                arr[records].set(0,firstName);

                System.out.println("Enter LastName: ");
                lastName=inputstr.nextLine();
                arr[records].set(1,lastName);

                System.out.println("Enter Address: ");
                lastName=inputstr.nextLine();
                arr[records].set( 2, lastName);

                System.out.println("Enter city: ");
                lastName=inputstr.nextLine();
                arr[records].set(3,lastName);

                System.out.println("Enter state: ");
                lastName=inputstr.nextLine();
                arr[records].set(4,lastName);

                System.out.println("Enter zip: ");
                lastName=inputstr.nextLine();
                arr[records].set(5,lastName);

                System.out.println("Enter Phone: ");
                lastName=inputstr.nextLine();
                arr[records].set(6,lastName);
            }
            else
            {   //if Record Not found in Entire List
                System.out.println("Record Not Found");
            }

        }

        return  count;
    }
//This will Delete The Element
    public int deletePerson(int personCount)
    {
        int count=personCount;
        String dummyName;
        //Delete By person Name
        System.out.println("Enter Person Name To remove");
        dummyName=inputstr.nextLine();

        for (int records = 0; records <count; records++) {
            //Display Records in Order of insertion
            if (dummyName.equals(arr[records].get(0))) {
                arr[records].clear();
            }
        }
        return count-1;
    }


    //This Function USed To all Sorting Techniques
    public int allSort(int per,int choice)
    {
        int personCount=per;
        //Here We Are Passing Which Sorting Techniques
        int sortChoice=choice;
        List<String> sorted= new ArrayList<String>();

        for (int in=0;in<personCount;in++)
        {
            sorted.add(arr[in].get(sortChoice));
        }

        //Inbuilt Library To Sort The Collection
        Collections.sort(sorted);
        //Iterator To catch Every Record
        Iterator<String> iterator = sorted.iterator();
        while (iterator.hasNext())
        {
            String s=iterator.next();

            //Display All the Records
            for (int records = 0; records <personCount; records++) {
                //Display Records in Order of insertion
                if (s.equals(arr[records].get(sortChoice))) {
                    System.out.println("Name:  " + arr[records].get(0));
                    System.out.println("LastName:  " + arr[records].get(1));
                    System.out.println("Address:  " + arr[records].get(2));
                    System.out.println("City:  " + arr[records].get(3));
                    System.out.println("State:  " + arr[records].get(4));
                    System.out.println("Zip:  " + arr[records].get(5));
                    System.out.println("Phone:  " + arr[records].get(6));
                    System.out.println("\n\n");
                }
            }
        }
        return personCount;
    }

    public int viewPersonByCityState(int var) {
        int personCount=var;
        String checkCity;
        String checkState;
        System.out.println("Enter City");
        checkCity = inputstr.nextLine();
        System.out.println("Enter State");
        checkState = inputstr.nextLine();

        for (int in = 0; in <personCount; in++) {

          if (checkCity.equals(arr[in].get(3))&&checkState.equals(arr[in].get(4)))
            {
            cityMap.put(arr[in].get(3),arr[in].get(0));
            stateMap.put(arr[in].get(4),arr[in].get(0));

            }

        }

        cityMap.entrySet().forEach(entry -> {
            String checkName=entry.getValue();
            for (int records = 0; records <personCount; records++) {
                //Display Records in Order of insertion
                if (checkName.equals(arr[records].get(0))) {
                    System.out.println("Name:  " + arr[records].get(0));
                    System.out.println("LastName:  " + arr[records].get(1));
                    System.out.println("Address:  " + arr[records].get(2));
                    System.out.println("City:  " + arr[records].get(3));
                    System.out.println("State:  " + arr[records].get(4));
                    System.out.println("Zip:  " + arr[records].get(5));
                    System.out.println("Phone:  " + arr[records].get(6));
                    System.out.println("\n\n");
                }
            }
        });


        return personCount;
    }
}
