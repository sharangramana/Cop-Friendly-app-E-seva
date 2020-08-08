package com.example.server.dao;

import com.example.server.model.Violator;

import java.util.List;

public interface ViolatorDao {

    Integer insertViolatorPerson(Violator violator, Integer policeId);

    List<List<String>> selectAllViolatorPeople();

    List<Violator> selectViolatorPersonByID(Integer id);

    Integer deleteViolatorPersonById(Integer id);

    Integer updateViolatorPersonById(Integer id, Violator violator);
}
