package com.bridgelabz.addressbookmain.service;
import com.bridgelabz.addressbookmain.model.Person;
import com.bridgelabz.addressbookmain.util.Input;
import org.json.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;

import java.io.FileWriter;
import java.io.IOException;
public class AddPersonServiceImpl extends Person implements AddPersonService {
    public void addPerson(int personCounter) throws IOException, ParseException {
        JSONObject personDetail = new JSONObject();
        int nextInfo = 1;
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
                        personDetail.put("firstName", firstName);
                        //                        PersonOperation.arrayLists[personCounter].add(firstName);
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
                        //                        PersonOperation.arrayLists[personCounter].add(lastName);
                        personDetail.put("lastName", lastName);
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
                        //                        PersonOperation.arrayLists[personCounter].add(address);
                        personDetail.put("address", address);
                        break;
                    } else {
                        System.out.println("Please Entered Address should be more than 5 word");
                        break;
                    }
                }

                case 4: {
                    System.out.println("Enter City");
                    city = Input.getStringValue();
                    if (city.matches("^[A-Z]{1}[a-z]{2,}$")) {
                        nextInfo++;
                        //                        PersonOperation.arrayLists[personCounter].add(city);
                        personDetail.put("city", city);
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
                        //                        PersonOperation.arrayLists[personCounter].add(state);
                        personDetail.put("state", state);
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
                        //                        PersonOperation.arrayLists[personCounter].add(zip);
                        personDetail.put("zip", zip);
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
                        //                        PersonOperation.arrayLists[personCounter].add(phone);
                        personDetail.put("phone", phone);
                        break;
                    } else {
                        System.out.println("Please Enter Phone in Correct Format like 91 (number)");
                        break;
                    }
                }
            }
        } while (nextInfo != 8);
        JSONObject employeeObject = new JSONObject();
        employeeObject.put("personDetail", personDetail);
        JSONArray employeeList = new JSONArray();
        employeeList.add(employeeObject);
        try (FileWriter file = new FileWriter("/home/saurabh/IdeaProjects/AaddressBookMain/src/main/resources" +
                "/PersonContact.json")) {
            file.write(employeeList.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
