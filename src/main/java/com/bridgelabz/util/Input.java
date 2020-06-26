package com.bridgelabz.util;
import  com.bridgelabz.service.AddPersonServiceImpl;
import java.util.Scanner;
import com.bridgelabz.model.Person;
public class Input extends Person{
    private final static Scanner strInput = new Scanner(System.in);
    //To give the String Values
    public int checkDuplicate(String firstName)
    {
        for(int i=0;i<pr;i++)
        {
            if(firstName.equals(arr[i].get(0)))
            {
                System.out.println("Duplicates Not Allowed");
                return 0;
            }
        }
        return 1;
    }
    public static String getStringValue(){
        return strInput.nextLine();


    }
}
