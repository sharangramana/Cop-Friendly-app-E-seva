package com.example.server.dao;

import com.example.server.model.Department_member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository("ImplementedDepartmentMemberDao")
public class DepartmentmemberDaoimplementation  extends JdbcDaoSupport implements DepartmentmemberDao {
    @Autowired
    DataSource dataSource;

    @PostConstruct
    private void initialize() {
        setDataSource(dataSource);
    }

    @Override
    public Integer insertDepartmentPerson(Department_member member) {

        System.out.println("ID is "+member.getPolice_Id());
        String sql = "INSERT INTO department_members " + "(Police_Id, Password, First_Name, Last_Name, Position_type, " +
                "Work_Area, Station_Name, Phone_Number, Blood_Group, Address) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        getJdbcTemplate().update(sql, member.getPolice_Id(), member.getPassword(),
                member.getFirst_Name(), member.getLast_Name(), member.getPosition_type(),
                member.getWork_Area(), member.getStation_Name(), member.getPhone_Number(),
                member.getBlood_Group(), member.getAddress());

        return 1;
    }

    @Override
    public List<Department_member> selectAllDepartmentPeople() {
        String sql = "SELECT * FROM department_members";
        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);

        List<Department_member> result = new ArrayList<>();
        for (Map<String, Object> row : rows) {
            result.add(new Department_member((Integer) row.get("Police_Id"),
                    //String.valueOf(row.get("Email_Id")),
                    String.valueOf(row.get("Password")),
                    String.valueOf(row.get("First_Name")),
                    String.valueOf(row.get("Last_Name")),
                    String.valueOf(row.get("Position_type")),
                    String.valueOf(row.get("Work_Area")),
                    String.valueOf(row.get("Station_Name")),
                    String.valueOf(row.get("Phone_Number")),
                    String.valueOf(row.get("Blood_Group")),
                    String.valueOf(row.get("Address"))));
        }
        return result;
    }

    @Override
    public List<Department_member> selectDepartmentPersonByID(Integer id) {
        String sql = "SELECT * FROM department_members WHERE Police_Id = ?";
        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);

        List<Department_member> result = new ArrayList<>();
        for (Map<String, Object> row : rows) {
            result.add(new Department_member((Integer) row.get("Police_Id"),
                    //String.valueOf(row.get("Email_Id")),
                    String.valueOf(row.get("Password")),
                    String.valueOf(row.get("First_Name")),
                    String.valueOf(row.get("Last_Name")),
                    String.valueOf(row.get("Position_type")),
                    String.valueOf(row.get("Work_Area")),
                    String.valueOf(row.get("Station_Name")),
                    String.valueOf(row.get("Phone_Number")),
                    String.valueOf(row.get("Blood_Group")),
                    String.valueOf(row.get("Address"))));
        }
        return result;
    }

    @Override
    public Integer deleteDepartmentPersonById(Integer id) {
        return 0;
    }

    @Override
    public Integer updateDepartmentPersonById(Integer id, Department_member member) {
        return 0;
    }

//    public Optional<Department_member> findByUsername(String departmentMemberName) {
//        return Optional.empty();
//    }
//
//    @Override
//    public List<Department_member> findAll() {
//        return null;
//    }
//
//    @Override
//    public List<Department_member> findAll(Sort sort) {
//        return null;
//    }
//
//    @Override
//    public Page<Department_member> findAll(Pageable pageable) {
//        return null;
//    }
//
//    @Override
//    public List<Department_member> findAllById(Iterable<Long> iterable) {
//        return null;
//    }
//
//    @Override
//    public long count() {
//        return 0;
//    }
//
//    @Override
//    public void deleteById(Long aLong) {
//
//    }
//
//    @Override
//    public void delete(Department_member department_member) {
//
//    }
//
//    @Override
//    public void deleteAll(Iterable<? extends Department_member> iterable) {
//
//    }
//
//    @Override
//    public void deleteAll() {
//
//    }
//
//    @Override
//    public <S extends Department_member> S save(S s) {
//        return null;
//    }
//
//    @Override
//    public <S extends Department_member> List<S> saveAll(Iterable<S> iterable) {
//        return null;
//    }
//
//    @Override
//    public Optional<Department_member> findById(Long aLong) {
//        return Optional.empty();
//    }
//
//    @Override
//    public boolean existsById(Long aLong) {
//        return false;
//    }
//
//    @Override
//    public void flush() {
//
//    }
//
//    @Override
//    public <S extends Department_member> S saveAndFlush(S s) {
//        return null;
//    }
//
//    @Override
//    public void deleteInBatch(Iterable<Department_member> iterable) {
//
//    }
//
//    @Override
//    public void deleteAllInBatch() {
//
//    }
//
//    @Override
//    public Department_member getOne(Long aLong) {
//        return null;
//    }
//
//    @Override
//    public <S extends Department_member> Optional<S> findOne(Example<S> example) {
//        return Optional.empty();
//    }
//
//    @Override
//    public <S extends Department_member> List<S> findAll(Example<S> example) {
//        return null;
//    }
//
//    @Override
//    public <S extends Department_member> List<S> findAll(Example<S> example, Sort sort) {
//        return null;
//    }
//
//    @Override
//    public <S extends Department_member> Page<S> findAll(Example<S> example, Pageable pageable) {
//        return null;
//    }
//
//    @Override
//    public <S extends Department_member> long count(Example<S> example) {
//        return 0;
//    }
//
//    @Override
//    public <S extends Department_member> boolean exists(Example<S> example) {
//        return false;
//    }
}

/*
{
	"Police_Id" : 123,
	"Password" : "sharang123",
	"First_Name" : "Sharang",
	"Last_Name" : "Ramana",
	"Position_type":"inspector",
	"Work_Area" : "pollachi",
	"Station_Name" : "r1",
	"Phone_Number" : "9688060700",
	"Blood_Group" : "B+ve",
	"Address" : "pollachi,cbe"
}
 */