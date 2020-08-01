package com.bridgelabz.addressbookmain.controller;
import com.bridgelabz.addressbookmain.service.PersonOperation;
import com.bridgelabz.addressbookmain.service.ReadWriteImpl;
import com.bridgelabz.addressbookmain.util.Input;
import org.json.simple.parser.ParseException;

import java.io.IOException;
public class AddressBookMain extends PersonOperation {

    public static void main(String args[]) throws IOException, ParseException {
        final String JSON_PATH = "/home/saurabh/IdeaProjects/AaddressBookMain/src/main/resources/PersonContact.json";
        final String CSV_PATH = "/home/saurabh/IdeaProjects/AaddressBookMain/src/main/resources/CsvContact.csv";
        int personCount = 0;
        ReadWriteImpl readWrite = new ReadWriteImpl();
        System.out.println("1  json Operation");
        System.out.println("2  csv Operation");
        System.out.println("Enter Choice");
        int fileChoice = Input.getIntValue();
        switch (fileChoice) {
            case 1:
                personCount = readWrite.readJson(JSON_PATH);
                break;
            case 2:
                personCount = readWrite.readJson(JSON_PATH);
                break;
            default:
                System.out.println("INVALID CHOICE");
        }
        PersonOperation callFeature = new PersonOperation();
        int choice;
        int playMore = 1;
        while (true) {
            System.out.println("\n======= Address Book Features===========\n\n");
            System.out.println("1  ADD New Person");
            System.out.println("2  DISPLAY AddressBook Records");
            System.out.println("3  Edit Existing Data");
            System.out.println("4  Delete Person");
            System.out.println("5  Sorting Techniques");
            System.out.println("6  Specific City And State Person");
            System.out.println("7  Search Person in city");
            System.out.println("8  Save");
            System.out.println("Enter Choice");
            choice = Input.getIntValue();
            switch (choice) {
                case 1:
                    //inserting new record
                    ///condition to check to continue
                    while (playMore == 1) {
                        personCount = callFeature.personAdd(personCount);
                        System.out.println("DO You Want To Add More Press (1)continue | (2)Cancel");
                        playMore = Input.getIntValue();
                    }
                    break;
                case 2:
                    //Displaying all records
                    callFeature.personDisplay(personCount);
                    break;
                case 3:
                    callFeature.personDisplay(personCount);
                    callFeature.updateRecord(personCount);
                    break;
                case 4:
                    personCount = callFeature.deletePerson(personCount);
                    break;
                case 5:
                    //All sorting Techniques Performed By one function
                    int sortChoice;
                    System.out.println("===SELECT SORTING TECHNIQUE");
                    System.out.println("1) By Name");
                    System.out.println("2) By City");
                    System.out.println("3) by State");
                    System.out.println("4) By Zip");
                    sortChoice = Input.getIntValue();
                    switch (sortChoice) {
                        case 1:
                            personCount = callFeature.allSort(personCount, 0);
                            break;
                        case 2:
                            personCount = callFeature.allSort(personCount, 3);
                            break;
                        case 3:
                            personCount = callFeature.allSort(personCount, 4);
                            break;
                        case 4:
                            personCount = callFeature.allSort(personCount, 5);
                            break;
                        default:
                            System.out.println("Enter Correct Option");
                    }
                    break;
                case 6:
                    //for specific city and state
                    personCount = callFeature.viewPersonByCityState(personCount);
                    break;
                case 7:
                    //search According to city
                    personCount = callFeature.searchInCity(personCount);
                    break;
                case 8:
                    //Save Data to json
                    readWrite.writeJson(JSON_PATH, personCount);
                    readWrite.writeToCsv(CSV_PATH, personCount);
                    break;
                default:
                    System.out.println("INVALID CHOICE");
            }
        }
    }
}