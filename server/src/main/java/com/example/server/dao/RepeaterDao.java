package com.example.server.dao;

import com.example.server.model.Repeater;

import java.util.List;

public interface RepeaterDao {

    Integer insertRecord(Repeater repeater, String License_number);

    List<List<String>> selectAllRecords(String License_number);
}
