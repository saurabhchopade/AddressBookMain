package com.bridgelabz.addressbookmain.service;
public interface ReadWrite {
    int readJson(String jsonPath);
    void writeJson(String jsonPath,int noOfRecord);
}
