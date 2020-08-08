package com.example.server.service;

import com.example.server.dao.RepeaterDao;
import com.example.server.model.Repeater;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RepeaterService {
    private final RepeaterDao repeaterDao;

    @Autowired
    public RepeaterService(@Qualifier("RepeaterDaoImplemented") RepeaterDao repeaterDao) {
        this.repeaterDao = repeaterDao;
    }

    public int addRepeaterRecord(Repeater repeater, String License_number) {
        return repeaterDao.insertRecord(repeater, License_number);
    }

    public List<List<String>> getAllRecordsByID(String License_number) {
        return repeaterDao.selectAllRecords(License_number);
    }
}
