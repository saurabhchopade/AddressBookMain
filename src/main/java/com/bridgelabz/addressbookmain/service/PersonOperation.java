package com.bridgelabz.addressbookmain.service;

import com.bridgelabz.addressbookmain.model.Person;
import com.bridgelabz.addressbookmain.util.Input;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.IntStream;

public class PersonOperation extends Person {
    public static int addressBookSize = 100;
    public static int personTotalCount;
    final AddPersonServiceImpl addPersonService = new AddPersonServiceImpl();
    public static List<String>[] arrayLists = new ArrayList[addressBookSize];
    HashMap<String, String> stateMap = new HashMap<>();
    HashMap<String, String> searchMap = new HashMap<>();

    /**
     * This function Add person To arraylist
     *
     * @param personNum
     * @return
     * @throws Exception
     */
    public int personAdd(int personNum) {
        int personNumber = personNum;
        personTotalCount = personNum;
        arrayLists[personNumber] = new ArrayList();
        addPersonService.addPerson(personNumber);
        personNumber++;
        return personNumber;
    }

    /**
     * this will Display Entire AddressBook
     *
     * @param noOfRecord
     * @return
     * @throws Exception
     */
    public int personDisplay(int noOfRecord) {
        IntStream.range(0, noOfRecord).forEach(records -> {
            System.out.println("Name:  " + arrayLists[records].get(0));
            System.out.println("LastName:  " + arrayLists[records].get(1));
            System.out.println("Address:  " + arrayLists[records].get(2));
            System.out.println("City:  " + arrayLists[records].get(3));
            System.out.println("State:  " + arrayLists[records].get(4));
            System.out.println("Zip:  " + arrayLists[records].get(5));
            System.out.println("Phone:  " + arrayLists[records].get(6));
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
        int count = personCount;
        System.out.println("Enter Person name to Edit Info=");
        dummyName = Input.getStringValue();
        IntStream.range(0, count).forEach(records -> {
            if (dummyName.equals(arrayLists[records].get(0))) {
                System.out.println("Record Found");
                System.out.println("Enter LastName: ");
                firstName = dummyName;
                arrayLists[records].set(0, firstName);
                System.out.println("Enter LastName: ");
                lastName = Input.getStringValue();
                arrayLists[records].set(1, lastName);
                System.out.println("Enter Address: ");
                address = Input.getStringValue();
                arrayLists[records].set(2, address);
                System.out.println("Enter city: ");
                city = Input.getStringValue();
                arrayLists[records].set(3, city);
                System.out.println("Enter state: ");
                state = Input.getStringValue();
                arrayLists[records].set(4, state);
                System.out.println("Enter zip: ");
                zip = Input.getStringValue();
                arrayLists[records].set(5, zip);
                System.out.println("Enter Phone: ");
                phone = Input.getStringValue();
                arrayLists[records].set(6, phone);
            } else {
                System.out.println("Record Not Found");
            }
        });
        return count;
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
        IntStream.range(0, recordsInList).filter(records -> dummyName.equals(arrayLists[records].get(0))).forEach(records -> arrayLists[records].clear());
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
        for (int record = 0; record < recordsInList; record++) sorted.add(arrayLists[record].get(sortChoice));
        Collections.sort(sorted);
        sorted.forEach(s -> IntStream.range(0, recordsInList).filter(records -> s.equals(arrayLists[records].get(sortChoice))).forEachOrdered(records -> {
            System.out.println("Name:  " + arrayLists[records].get(0));
            System.out.println("LastName:  " + arrayLists[records].get(1));
            System.out.println("Address:  " + arrayLists[records].get(2));
            System.out.println("City:  " + arrayLists[records].get(3));
            System.out.println("State:  " + arrayLists[records].get(4));
            System.out.println("Zip:  " + arrayLists[records].get(5));
            System.out.println("Phone:  " + arrayLists[records].get(6));
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
        int personCount = var;
        String checkCity;
        String checkState;
        System.out.println("Enter City");
        checkCity = Input.getStringValue();
        System.out.println("Enter State");
        checkState = Input.getStringValue();
        IntStream.range(0, personCount).filter(addInMap -> checkCity.equals(arrayLists[addInMap].get(3)) && checkState.equals(arrayLists[addInMap].get(4))).forEach(addInMap -> {
            searchMap.put(arrayLists[addInMap].get(3), arrayLists[addInMap].get(0));
            stateMap.put(arrayLists[addInMap].get(4), arrayLists[addInMap].get(0));
        });
        searchMap.forEach((key, checkName) -> IntStream.range(0, personCount).filter(records -> checkName.equals(arrayLists[records].get(0))).forEach(records -> {
            System.out.println("Name:  " + arrayLists[records].get(0));
            System.out.println("LastName:  " + arrayLists[records].get(1));
            System.out.println("Address:  " + arrayLists[records].get(2));
            System.out.println("City:  " + arrayLists[records].get(3));
            System.out.println("State:  " + arrayLists[records].get(4));
            System.out.println("Zip:  " + arrayLists[records].get(5));
            System.out.println("Phone:  " + arrayLists[records].get(6));
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
        int personCount = dummyCount;
        String specificCity;
        String personName;
        System.out.println("Enter CITY To search Person:");
        specificCity = Input.getStringValue();
        System.out.println("Person name");
        personName = Input.getStringValue();
        IntStream.range(0, personCount).filter(recordNum -> specificCity.equals(arrayLists[recordNum].get(3))).forEach(recordNum -> searchMap.put(arrayLists[recordNum].get(3), arrayLists[recordNum].get(0)));
        searchMap.forEach((key, checkName) -> {
            if (personName.equals(checkName)) {
                IntStream.range(0, personCount).filter(records -> checkName.equals(arrayLists[records].get(0))).forEach(records -> {
                    System.out.println("\n");
                    System.out.println("RECORDS IN CITY");
                    System.out.println("Name:  " + arrayLists[records].get(0));
                    System.out.println("LastName:  " + arrayLists[records].get(1));
                    System.out.println("Address:  " + arrayLists[records].get(2));
                    System.out.println("City:  " + arrayLists[records].get(3));
                    System.out.println("State:  " + arrayLists[records].get(4));
                    System.out.println("Zip:  " + arrayLists[records].get(5));
                    System.out.println("Phone:  " + arrayLists[records].get(6));
                    System.out.println("\n\n");
                });
            }
        });
        return personCount;
    }
}
