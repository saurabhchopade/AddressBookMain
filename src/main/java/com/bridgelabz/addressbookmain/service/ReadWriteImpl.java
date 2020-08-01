package com.bridgelabz.addressbookmain.service;
import com.opencsv.CSVWriter;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.IntStream;
public class ReadWriteImpl extends PersonOperation implements ReadWrite {
    public static int counter = 0;

    @Override
    public int readJson(String jsonPath) {
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader(jsonPath)) {
            //Read JSON file
            Object obj = jsonParser.parse(reader);
            JSONArray personList = (JSONArray) obj;
            System.out.println(personList);
            personList.forEach(person -> jsonToList((JSONObject) person));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return counter;
    }

    public void jsonToList(JSONObject personInfo) {
        personData[counter] = new ArrayList();
        JSONObject personDetail = (JSONObject) personInfo.get("personDetail");
        String firstName = (String) personDetail.get("firstName");
        PersonOperation.personData[counter].add(firstName);
        String lastName = (String) personDetail.get("lastName");
        PersonOperation.personData[counter].add(lastName);
        String address = (String) personDetail.get("address");
        PersonOperation.personData[counter].add(address);
        String city = (String) personDetail.get("city");
        PersonOperation.personData[counter].add(city);
        String phone = (String) personDetail.get("phone");
        PersonOperation.personData[counter].add(phone);
        String state = (String) personDetail.get("state");
        PersonOperation.personData[counter].add(state);
        String zip = (String) personDetail.get("zip");
        PersonOperation.personData[counter].add(zip);
        counter++;
    }

    @Override
    public void writeJson(String jsonPath, int noOfRecord) {
        JSONArray personList = new JSONArray();
        IntStream.range(0, noOfRecord).forEach(records -> {
            JSONObject personDetail = new JSONObject();
            JSONObject personInfo = new JSONObject();
            personDetail.put("firstName", personData[records].get(0));
            personDetail.put("lastName", personData[records].get(1));
            personDetail.put("address", personData[records].get(2));
            personDetail.put("city", personData[records].get(3));
            personDetail.put("phone", personData[records].get(4));
            personDetail.put("state", personData[records].get(5));
            personDetail.put("zip", personData[records].get(6));
            personInfo.put("personDetail", personDetail);
            personList.add(personInfo);
        });
        try (FileWriter file = new FileWriter(jsonPath)) {
            file.write(personList.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void writeToCsv(String csvPath, int noOfRecord) {
        try (Writer writer = Files.newBufferedWriter(Paths.get(csvPath)); CSVWriter csvWriter = new CSVWriter(writer,
                CSVWriter.DEFAULT_SEPARATOR, CSVWriter.NO_QUOTE_CHARACTER, CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                CSVWriter.DEFAULT_LINE_END);) {
            String[] columnName = {"firstName", "lastName", "address", "city", "state", "zip", "phone"};
            csvWriter.writeNext(columnName);
            IntStream.range(0, noOfRecord).forEach(records -> {
                csvWriter.writeNext(new String[]{personData[records].get(0), personData[records].get(1),
                        personData[records].get(2), personData[records].get(3), personData[records].get(4),
                        personData[records].get(5), personData[records].get(6)});
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}