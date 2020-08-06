package com.bridgelabz.addressbookmain.service;
import com.bridgelabz.addressbookmain.model.Person;
import com.bridgelabz.addressbookmain.util.DbOperations;
import com.bridgelabz.addressbookmain.util.Input;
import org.json.simple.parser.ParseException;

import java.io.IOException;
public class AddPersonServiceImpl extends Person implements AddPersonService {
    public void addPerson(int personCounter) throws IOException, ParseException {
        int nextInfo = 1;
        Person person=new Person();
        do {
            switch (nextInfo) {
                case 1: {
                    System.out.println("Enter Name");
                    firstName = Input.getStringValue();
                    Input duplicateCheck = new Input();
                    int checker = duplicateCheck.checkDuplicate(firstName);
                    if (checker == 0) {
                        break;
                    }
                    if (firstName.matches("^[A-Z]{1}[a-z]{2,}$")) {
                        nextInfo++;
                        PersonOperation.personData[personCounter].add(firstName);
                        person.setFirstName(firstName);
                        break;
                    } else {
                        System.out.println("Please Enter FirstName in Correct Format");
                        break;
                    }
                }
                case 2: {
                    System.out.println("Enter LastName");
                    lastName = Input.getStringValue();
                    if (lastName.matches("^[A-Z]{1}[a-z]{2,}$")) {
                        nextInfo++;
                        PersonOperation.personData[personCounter].add(lastName);
                        person.setLastName(lastName);
                        break;
                    } else {
                        System.out.println("Please Enter LastName in Correct Format");
                        break;
                    }
                }
                case 3: {
                    System.out.println("Enter Address");
                    address = Input.getStringValue();

                    if (address.matches("[A-Za-z-a0-9]{5,}$")) {
                        nextInfo++;
                        PersonOperation.personData[personCounter].add(address);
                        person.setAddress(address);
                        break;
                    } else {
                        System.out.println("Minimum 5 letters address allowed");
                        break;
                    }
                }

                case 4: {
                    System.out.println("Enter City");
                    city = Input.getStringValue();
                    if (city.matches("^[A-Z]{1}[a-z]{2,}$")) {
                        nextInfo++;
                        PersonOperation.personData[personCounter].add(city);
                        person.setCity(city);
                        break;
                    } else {
                        System.out.println("Please Enter City in Correct Format");
                        break;
                    }
                }

                case 5: {
                    System.out.println("Enter State");
                    state = Input.getStringValue();
                    if (state.matches("^[A-Z]{1}[a-z]{2,}$")) {
                        nextInfo++;
                        PersonOperation.personData[personCounter].add(state);
                        person.setState(state);
                        break;
                    } else {
                        System.out.println("Please Enter State in Correct Format");
                        break;
                    }
                }

                case 6: {
                    System.out.println("Enter ZipCode");
                    zip = Input.getStringValue();
                    if (zip.matches("^[1-9][0-9]{5}$")) {
                        nextInfo++;
                        PersonOperation.personData[personCounter].add(zip);
                        person.setZip(zip);
                        break;
                    } else {
                        System.out.println("Please Enter (6 Digit) Zipcode ");
                        break;
                    }
                }

                case 7: {
                    System.out.println("Enter PhoneNumber");
                    phone = Input.getStringValue();
                    if (phone.matches("^(91)[ ][0-9]{10}$")) {
                        nextInfo++;
                        PersonOperation.personData[personCounter].add(phone);
                        person.setPhone(phone);
                        break;
                    } else {
                        System.out.println("Please Enter Valid Phone Number");
                        break;
                    }
                }
            }
        } while (nextInfo != 8);
        DbOperations dbOperations=new DbOperations();
        dbOperations.addRecord(person);
    }
}
