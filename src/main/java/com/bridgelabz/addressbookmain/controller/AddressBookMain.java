package com.bridgelabz.addressbookmain.controller;
import com.bridgelabz.addressbookmain.service.PersonOperation;
import com.bridgelabz.addressbookmain.service.ReadWriteImpl;
import com.bridgelabz.addressbookmain.util.Input;
import org.json.simple.parser.ParseException;

import java.io.IOException;
public class AddressBookMain extends PersonOperation {

    public static void main(String[] args) throws IOException, ParseException {
        final String JSON_PATH = "/home/saurabh/IdeaProjects/AaddressBookMain/src/main/resources/PersonContact.json";
        final String CSV_PATH = "/home/saurabh/IdeaProjects/AaddressBookMain/src/main/resources/CsvContact.csv";
        final String GSON_JSON_PATH = "/home/saurabh/IdeaProjects/AaddressBookMain/src/main/resources/GsonJson.json";
        int personCount = 0;
        ReadWriteImpl readWrite = new ReadWriteImpl();
        System.out.println("1  json Operation");
        System.out.println("2  csv Operation");
        System.out.println("3  gson Operation");
        System.out.println("4  database Operation");
        System.out.println("Enter Choice");
        int fileChoice = Input.getIntValue();
        switch (fileChoice) {
            case 1:
                personCount = readWrite.readJson(JSON_PATH);
                break;
            case 2:
                personCount = readWrite.readCsv(CSV_PATH);
                break;
            case 3:
                personCount = readWrite.readJson(GSON_JSON_PATH);
                break;
            case 4:
                personCount = readWrite.readDatabase();
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
            System.out.println("3  Modify Person information");
            System.out.println("4  Remove Person From AddressBook");
            System.out.println("5  Sort your Data");
            System.out.println("6  View Specific City And State Person");
            System.out.println("7  Search Person in city");
            System.out.println("8  save All details");
            System.out.println("9  EXIT");
            System.out.println("Enter Choice");
            choice = Input.getIntValue();
            switch (choice) {
                case 1:
                    while (playMore == 1) {
                        personCount = callFeature.personAdd(personCount);
                        System.out.println("DO You Want To Add More Press (1)continue | (2)Cancel");
                        playMore = Input.getIntValue();
                    }
                    break;
                case 2:
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
                    personCount = callFeature.viewPersonByCityState(personCount);
                    break;
                case 7:
                    personCount = callFeature.searchInCity(personCount);
                    break;
                case 8:
                    readWrite.writeJson(JSON_PATH, personCount);
                    readWrite.writeToCsv(CSV_PATH, personCount);
                    readWrite.writeToJsonUsingGson(GSON_JSON_PATH, personCount);
                    break;
                case 9:
                    System.exit(0);
                default:
                    System.out.println("INVALID CHOICE");
            }
        }
    }
}