package com.example.server.dao;

import com.example.server.model.Department_member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface DepartmentmemberDao {//extends JpaRepository<Department_member, Long> {
    Integer insertDepartmentPerson(Department_member member);

    List<Department_member> selectAllDepartmentPeople();

    List<Department_member> selectDepartmentPersonByID(Integer id);

    Integer deleteDepartmentPersonById(Integer id);

    Integer updateDepartmentPersonById(Integer id, Department_member member);

    //Optional<Department_member> findByUsername(String departmentMemberName);
}
