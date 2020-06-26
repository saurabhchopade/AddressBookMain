package com.bridgelabz.service;

import com.bridgelabz.model.PersonInformation;
import com.bridgelabz.util.Input;
public class AddPersonServiceImpl implements AddPersonService {
    public static String firstName, lastName, address, city, state, zip, phone;


    public void addPerson() {

        int nextInfo = 1;
        while (true) {
            switch (nextInfo) {
                case 1: {
                    System.out.println("Enter Name");
                    firstName = Input.getStringValue();
                    if (firstName.matches("^[A-Z]{1}[a-z]{2,}$")) {
                        nextInfo++;
                        break;
                    } else {
                        System.out.println("Please Enter FirstName in Correct Format like Saurabh");
                        break;
                    }
                }
                case 2: {
                    System.out.println("Enter LastName");
                    lastName = Input.getStringValue();
                    if (lastName.matches("^[A-Z]{1}[a-z]{2,}$")) {
                        nextInfo++;
                        break;
                    } else {
                        System.out.println("Please Enter LastName in Correct Format like Shah");
                        break;
                    }
                }
                case 3: {
                    System.out.println("Enter Address");
                    address = Input.getStringValue();

                    if (address.matches("[A-Za-z-a0-9]{5,}$")) {
                        nextInfo++;
                        break;
                    } else {
                        System.out.println("Please Enter City in Correct Format like  Ramgad");
                        break;
                    }
                }
                case 4: {

                    System.out.println("Enter City");
                    city = Input.getStringValue();
                    if (city.matches("^[A-Z]{1}[a-z]{2,}$")) {
                        nextInfo++;
                        break;
                    } else {
                        System.out.println("Please Enter City in Correct Format like Pune");
                        break;
                    }

                }
                case 5: {

                    System.out.println("Enter State");
                    state = Input.getStringValue();
                    if (state.matches("^[A-Z]{1}[a-z]{2,}$")) {
                        nextInfo++;
                        break;
                    } else {
                        System.out.println("Please Enter State in Correct Format like Maharashtra");
                        break;
                    }
                }

                case 6: {
                    System.out.println("Enter ZipCode");
                    zip = Input.getStringValue();
                    if (zip.matches("^[1-9][0-9]{5}$")) {
                        nextInfo++;
                        break;
                    } else {
                        System.out.println("Please Enter Zipcode in Correct Format like 9999999(6 Digit)");
                        break;
                    }
                }

                case 7: {
                    System.out.println("Enter PhoneNumber");
                    phone = Input.getStringValue();
                    if (phone.matches("^(91)[ ][0-9]{10}$")) {
                        nextInfo++;
                        break;
                    } else {
                        System.out.println("Please Enter Phone in Correct Format like 91 (number)");
                        break;
                    }
                }
            }
            if (nextInfo == 8) {
                break;
            }
        }
        PersonInformation personInformation = new PersonInformation(firstName, lastName, address, city, state, zip, phone);

    }
}
