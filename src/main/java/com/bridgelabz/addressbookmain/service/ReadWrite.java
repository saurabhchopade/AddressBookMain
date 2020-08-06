package com.bridgelabz.addressbookmain.service;
public interface ReadWrite {
    int readJson(String jsonPath);
    void writeJson(String jsonPath, int noOfRecord);
    int  readCsv(String csvPath);
    void writeToCsv(String csvPath, int noOfRecord);
    void writeToJsonUsingGson(String csvPath, int noOfRecord);
    int readDatabase();
}
