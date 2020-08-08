package com.example.server.service;

import com.example.server.dao.DepartmentmemberDao;
import com.example.server.model.Department_member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DepartmentPersonService {
    private final DepartmentmemberDao memberDao;

    @Autowired //spring specific which directly access the constructor
    public DepartmentPersonService(@Qualifier("ImplementedDepartmentMemberDao") DepartmentmemberDao memberDao) { //there can be multiple istantiations so qualifier used
        this.memberDao = memberDao;
    }

    public int addDepartmentPerson(Department_member member) {
        return memberDao.insertDepartmentPerson(member);
    }

    public List<Department_member> getAllDepartmentPeople() {
        return memberDao.selectAllDepartmentPeople();
    }

    public Department_member getDepartmentPersonByID(Integer id) {
        List<Department_member> result = memberDao.selectDepartmentPersonByID(id);
        Department_member specific = result.get(0);
        return specific;
    }

    public Integer deleteDepartmentPerson(Integer id) {
        return memberDao.deleteDepartmentPersonById(id);
    }

    public Integer updateDepartmentPerson(Integer id, Department_member newDepartmentPerson) {
        return memberDao.updateDepartmentPersonById(id, newDepartmentPerson);
    }
}
