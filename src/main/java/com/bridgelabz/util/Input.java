package com.bridgelabz.util;
import  com.bridgelabz.service.AddPersonServiceImpl;
import java.util.Scanner;
import com.bridgelabz.model.Person;
public class Input extends Person{
    private final static Scanner strInput = new Scanner(System.in);
    //To give the String Values
    public int checkDuplicate(String firstN)
    {
        int a=1;
        int b=2;
        for(int i=0;i<pr;i++)
        {
            if(firstN.equals(arr[i].get(0)))
            {
                return a;
            }
        }

        return b;
    }
    public static String getStringValue(){
        return strInput.nextLine();


    }
}
