package com.bridgelabz.addressbookmain.service;
import org.json.simple.parser.ParseException;

import java.io.IOException;
interface  AddPersonService {
    void addPerson(int personCounter) throws IOException, ParseException;
}
