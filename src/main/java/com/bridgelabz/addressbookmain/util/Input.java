package com.bridgelabz.addressbookmain.util;
import java.util.Scanner;
import com.bridgelabz.addressbookmain.model.Person;
public class Input extends Person{
    private final static Scanner strInput = new Scanner(System.in);
    private final static Scanner intInput = new Scanner(System.in);

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
    public static int getIntValue(){
        return intInput.nextInt();
    }
}
