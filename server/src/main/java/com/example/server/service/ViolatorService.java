package com.example.server.service;

import com.example.server.dao.ViolatorDao;
import com.example.server.model.Violator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ViolatorService {
    private final ViolatorDao violatorDao;

    @Autowired
    public ViolatorService(@Qualifier("violatorDaoImplemented") ViolatorDao violator) {
        this.violatorDao = violator;
    }

    public int addviolatorPerson(Violator violator, Integer policeId) {
        return violatorDao.insertViolatorPerson(violator, policeId);
    }

    public List<List<String>> getAllviolatorPeople() {
        return violatorDao.selectAllViolatorPeople();
    }

    public Violator getviolatorPersonByID(Integer id) {
        List<Violator> result = violatorDao.selectViolatorPersonByID(id);
        Violator specific = result.get(0);
        return specific;
    }

    public Integer deleteviolatorPerson(Integer id) {
        return violatorDao.deleteViolatorPersonById(id);
    }

    public Integer updateviolatorPerson(Integer id, Violator newDepartmentPerson) {
        return violatorDao.updateViolatorPersonById(id, newDepartmentPerson);
    }
}
