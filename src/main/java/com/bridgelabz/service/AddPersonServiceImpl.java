package com.bridgelabz.service;

import com.bridgelabz.model.PersonInformation;
import com.bridgelabz.util.Input;

public class AddPersonServiceImpl implements AddPersonService {
    public static String firstName, lastName, address, city, state, zip, phone;

    @Override
    public void addPerson() {
        System.out.println("Enter Name");
        firstName = Input.getStringValue();
        System.out.println("Enter LastName");
        lastName = Input.getStringValue();
        System.out.println("Enter Address");
        address = Input.getStringValue();
        System.out.println("Enter City");
        city = Input.getStringValue();
        System.out.println("Enter State");
        state = Input.getStringValue();
        System.out.println("Enter ZipCode");
        zip = Input.getStringValue();
        System.out.println("Enter PhoneNumber");
        phone = Input.getStringValue();
        PersonInformation personInformation = new PersonInformation(firstName, lastName, address, city, state, zip, phone);

    }
}
