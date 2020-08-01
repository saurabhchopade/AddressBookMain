package com.bridgelabz.addressbookmain.service;
import com.bridgelabz.addressbookmain.model.Person;
import com.bridgelabz.addressbookmain.util.Input;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.IntStream;

public class PersonOperation extends Person {
    public static int addressBookSize = 100;
    public static int personTotalCount;
    final AddPersonServiceImpl addPersonService = new AddPersonServiceImpl();
    public static List<String>[] personData = new ArrayList[addressBookSize];

    /**
     * This function Add person To arraylist
     *
     * @param personNum
     * @return
     * @throws Exception
     */
    public int personAdd(int personNum) throws IOException, ParseException {
        int personNumber = personNum;
        personTotalCount = personNum;
        personData[personNumber] = new ArrayList();
        addPersonService.addPerson(personNumber);
        personNumber++;
        return personNumber;
    }

    public int personDisplay(int noOfRecord) {
        IntStream.range(0, noOfRecord).forEach(records -> {
            System.out.println("Name:  " + personData[records].get(0));
            System.out.println("LastName:  " + personData[records].get(1));
            System.out.println("Address:  " + personData[records].get(2));
            System.out.println("City:  " + personData[records].get(3));
            System.out.println("State:  " + personData[records].get(4));
            System.out.println("Zip:  " + personData[records].get(5));
            System.out.println("Phone:  " + personData[records].get(6));
            System.out.println();
        });
        return noOfRecord;
    }

    /**
     * this will update all data of person excluding name
     *
     * @param personCount
     * @return
     */
    public int updateRecord(int personCount) {
        String dummyName;
        System.out.println("Enter Person name to Edit Info=");
        dummyName = Input.getStringValue();
        IntStream.range(0, personCount).forEach(records -> {
            if (dummyName.equals(personData[records].get(0))) {
                System.out.println("Record Found");
                System.out.println("Enter LastName: ");
                firstName = dummyName;
                personData[records].set(0, firstName);
                System.out.println("Enter LastName: ");
                lastName = Input.getStringValue();
                personData[records].set(1, lastName);
                System.out.println("Enter Address: ");
                address = Input.getStringValue();
                personData[records].set(2, address);
                System.out.println("Enter city: ");
                city = Input.getStringValue();
                personData[records].set(3, city);
                System.out.println("Enter state: ");
                state = Input.getStringValue();
                personData[records].set(4, state);
                System.out.println("Enter zip: ");
                zip = Input.getStringValue();
                personData[records].set(5, zip);
                System.out.println("Enter Phone: ");
                phone = Input.getStringValue();
                personData[records].set(6, phone);
            } else {
//                System.out.println("Record Not Found");
            }
        });
        return personCount;
    }

    /**
     * This will Delete The Person
     *
     * @param noOfPerson
     * @return
     */
    public int deletePerson(int noOfPerson) {
        int recordsInList = noOfPerson;
        String dummyName;
        System.out.println("Enter Person Name To remove");
        dummyName = Input.getStringValue();
        IntStream.range(0, recordsInList).filter(records -> dummyName.equals(personData[records].get(0))).forEach(records -> personData[records].clear());
        return recordsInList - 1;
    }

    /**
     * This Function USed To all Sorting Techniques
     *
     * @param noOfPerson
     * @param choiceOfSort
     * @return
     */
    public int allSort(int noOfPerson, int choiceOfSort) {
        int recordsInList = noOfPerson;
        int sortChoice = choiceOfSort;
        List<String> sorted = new ArrayList();
        for (int record = 0; record < recordsInList; record++)
            sorted.add(personData[record].get(sortChoice));
        Collections.sort(sorted);
        sorted.forEach(s -> IntStream.range(0, recordsInList).filter(records -> s.equals(personData[records].get(sortChoice))).forEachOrdered(records -> {
            System.out.println("Name:  " + personData[records].get(0));
            System.out.println("LastName:  " + personData[records].get(1));
            System.out.println("Address:  " + personData[records].get(2));
            System.out.println("City:  " + personData[records].get(3));
            System.out.println("State:  " + personData[records].get(4));
            System.out.println("Zip:  " + personData[records].get(5));
            System.out.println("Phone:  " + personData[records].get(6));
            System.out.println("\n\n");
        }));
        return recordsInList;
    }

    /**
     * View Person By city and State
     *
     * @param var
     * @return
     */
    public int viewPersonByCityState(int var) {
        HashMap<String, String> searchMap = new HashMap<>();
        HashMap<String, String> stateMap = new HashMap<>();
        int personCount = var;
        String checkCity;
        String checkState;
        System.out.println("Enter City");
        checkCity = Input.getStringValue();
        System.out.println("Enter State");
        checkState = Input.getStringValue();
        IntStream.range(0, personCount).filter(addInMap -> checkCity.equals(personData[addInMap].get(3)) && checkState.equals(personData[addInMap].get(4))).forEach(addInMap -> {
            searchMap.put(personData[addInMap].get(3), personData[addInMap].get(0));
            stateMap.put(personData[addInMap].get(4), personData[addInMap].get(0));
        });
        searchMap.forEach((key, checkName) -> IntStream.range(0, personCount).filter(records -> checkName.equals(personData[records].get(0))).forEach(records -> {
            System.out.println("Name:  " + personData[records].get(0));
            System.out.println("LastName:  " + personData[records].get(1));
            System.out.println("Address:  " + personData[records].get(2));
            System.out.println("City:  " + personData[records].get(3));
            System.out.println("State:  " + personData[records].get(4));
            System.out.println("Zip:  " + personData[records].get(5));
            System.out.println("Phone:  " + personData[records].get(6));
            System.out.println("\n\n");
        }));
        return personCount;
    }

    /**
     *  search person in city
     * @param dummyCount
     * @return
     */
    public int searchInCity(int dummyCount) {
        HashMap<String, String> searchMap = new HashMap<>();
        int personCount = dummyCount;
        String specificCity;
        String personName;
        System.out.println("Enter CITY To search Person:");
        specificCity = Input.getStringValue();
        System.out.println("Person name");
        personName = Input.getStringValue();
        IntStream.range(0, personCount).filter(recordNum -> specificCity.equals(personData[recordNum].get(3))).forEach(recordNum -> searchMap.put(personData[recordNum].get(3), personData[recordNum].get(0)));
        searchMap.forEach((key, checkName) -> {
            if (personName.equals(checkName)) {
                IntStream.range(0, personCount).filter(records -> checkName.equals(personData[records].get(0))).forEach(records -> {
                    System.out.println("\n");
                    System.out.println("RECORDS IN CITY");
                    System.out.println("Name:  " + personData[records].get(0));
                    System.out.println("LastName:  " + personData[records].get(1));
                    System.out.println("Address:  " + personData[records].get(2));
                    System.out.println("City:  " + personData[records].get(3));
                    System.out.println("State:  " + personData[records].get(4));
                    System.out.println("Zip:  " + personData[records].get(5));
                    System.out.println("Phone:  " + personData[records].get(6));
                    System.out.println("\n\n");
                });
            }
        });
        return personCount;
    }
}
