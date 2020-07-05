package com.bridgelabz.addressbookmain.service;

import com.bridgelabz.addressbookmain.util.Input;

import java.util.*;

public class PersonOperation {
    public static int addressBookSize = 100;
    public static int personTotalCount;
    final AddPersonServiceImpl personImpl = new AddPersonServiceImpl();
    public static List<String>[] dataStorage = new ArrayList[addressBookSize];
    HashMap<String, String> stateMap = new HashMap<>();
    HashMap<String, String> search = new HashMap<>();

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
        dataStorage[personNumber] = new ArrayList();
        personImpl.addPerson(personNumber);
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
        for (int records = 0; records < noOfRecord; records++) {
            System.out.println("Name:  " + dataStorage[records].get(0));
            System.out.println("LastName:  " + dataStorage[records].get(1));
            System.out.println("Address:  " + dataStorage[records].get(2));
            System.out.println("City:  " + dataStorage[records].get(3));
            System.out.println("State:  " + dataStorage[records].get(4));
            System.out.println("Zip:  " + dataStorage[records].get(5));
            System.out.println("Phone:  " + dataStorage[records].get(6));
            //Newline
            System.out.println();
        }
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
        for (int records = 0; records < count; records++) {
            //Display Records in Order of insertion
            if (dummyName.equals(dataStorage[records].get(0))) {
                System.out.println("Record Found");
                System.out.println("Enter LastName: ");
                String firstName = dummyName;
                dataStorage[records].set(0, firstName);

                System.out.println("Enter LastName: ");
                String lastName = Input.getStringValue();
                dataStorage[records].set(1, lastName);

                System.out.println("Enter Address: ");
                String address = Input.getStringValue();
                dataStorage[records].set(2, address);

                System.out.println("Enter city: ");
                String city = Input.getStringValue();
                dataStorage[records].set(3, city);

                System.out.println("Enter state: ");
                String state = Input.getStringValue();
                dataStorage[records].set(4, state);

                System.out.println("Enter zip: ");
                String zip = Input.getStringValue();
                dataStorage[records].set(5, zip);

                System.out.println("Enter Phone: ");
                String phone = Input.getStringValue();
                dataStorage[records].set(6, phone);
            } else {   //if Record Not found in Entire List
                System.out.println("Record Not Found");
            }

        }

        return count;
    }

    /**
     * This will Delete The Person
     *
     * @param personCount
     * @return
     */
    public int deletePerson(int personCount) {
        int count = personCount;
        String dummyName;
        System.out.println("Enter Person Name To remove");
        dummyName = Input.getStringValue();
        for (int records = 0; records < count; records++) {
            if (dummyName.equals(dataStorage[records].get(0))) {
                dataStorage[records].clear();
            }
        }
        return count - 1;
    }

    /**
     * This Function USed To all Sorting Techniques
     *
     * @param per
     * @param choice
     * @return
     */
    public int allSort(int noOfPerson, int choiceOfSort) {
        int personCount = noOfPerson;
        int sortChoice = choiceOfSort;
        List<String> sorted = new ArrayList();
        for (int record = 0; record < personCount; record++) {
            sorted.add(dataStorage[record].get(sortChoice));
        }
        Collections.sort(sorted);
        Iterator<String> iterator = sorted.iterator();
        while (iterator.hasNext()) {
            String s = iterator.next();
            for (int records = 0; records < personCount; records++) {
                if (s.equals(dataStorage[records].get(sortChoice))) {
                    System.out.println("Name:  " + dataStorage[records].get(0));
                    System.out.println("LastName:  " + dataStorage[records].get(1));
                    System.out.println("Address:  " + dataStorage[records].get(2));
                    System.out.println("City:  " + dataStorage[records].get(3));
                    System.out.println("State:  " + dataStorage[records].get(4));
                    System.out.println("Zip:  " + dataStorage[records].get(5));
                    System.out.println("Phone:  " + dataStorage[records].get(6));
                    System.out.println("\n\n");
                }
            }
        }
        return personCount;
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
        for (int in = 0; in < personCount; in++) {

            if (checkCity.equals(dataStorage[in].get(3)) && checkState.equals(dataStorage[in].get(4))) {
                search.put(dataStorage[in].get(3), dataStorage[in].get(0));
                stateMap.put(dataStorage[in].get(4), dataStorage[in].get(0));
            }
        }
        search.entrySet().forEach(entry -> {
            String checkName = entry.getValue();
            for (int records = 0; records < personCount; records++) {
                if (checkName.equals(dataStorage[records].get(0))) {
                    System.out.println("Name:  " + dataStorage[records].get(0));
                    System.out.println("LastName:  " + dataStorage[records].get(1));
                    System.out.println("Address:  " + dataStorage[records].get(2));
                    System.out.println("City:  " + dataStorage[records].get(3));
                    System.out.println("State:  " + dataStorage[records].get(4));
                    System.out.println("Zip:  " + dataStorage[records].get(5));
                    System.out.println("Phone:  " + dataStorage[records].get(6));
                    System.out.println("\n\n");
                }
            }
        });
        return personCount;
    }

    /**
     * search person in city
     *
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
        for (int recordNum = 0; recordNum < personCount; recordNum++) {
            if (specificCity.equals(dataStorage[recordNum].get(3))) {
                search.put(dataStorage[recordNum].get(3), dataStorage[recordNum].get(0));
            }
        }
        search.entrySet().forEach(entry -> {
            String checkName = entry.getValue();
            if (personName.equals(checkName)) {
                for (int records = 0; records < personCount; records++) {
                    if (checkName.equals(dataStorage[records].get(0))) {
                        System.out.println("\n");
                        System.out.println("RECORDS IN CITY");
                        System.out.println("Name:  " + dataStorage[records].get(0));
                        System.out.println("LastName:  " + dataStorage[records].get(1));
                        System.out.println("Address:  " + dataStorage[records].get(2));
                        System.out.println("City:  " + dataStorage[records].get(3));
                        System.out.println("State:  " + dataStorage[records].get(4));
                        System.out.println("Zip:  " + dataStorage[records].get(5));
                        System.out.println("Phone:  " + dataStorage[records].get(6));
                        System.out.println("\n\n");
                    }
                }
            }
        });
        return personCount;
    }
}
