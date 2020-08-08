package com.example.server.dao;

import com.example.server.model.Department_member;
import com.example.server.model.Violator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository("violatorDaoImplemented")
public class ViolatorDaoImplementation extends JdbcDaoSupport implements ViolatorDao{
    @Autowired
    DataSource dataSource;

    @PostConstruct
    private void initialize() {
        setDataSource(dataSource);
    }


    @Override
    public Integer insertViolatorPerson(Violator violator, Integer policeId) {
        System.out.println("ID is "+violator.getViolator_ID());
        String sql = "INSERT INTO violator "+
                "(Violator_name, Violator_mob_number, Vehicle_number, License_number, Violation_type, "+
                "Type_of_vehicle, Model_of_vehicle, Date_and_time, Latitude, Longitude, Police_Id) "+
                "Values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        getJdbcTemplate().update(sql, violator.getViolator_name(), violator.getViolator_mob_number(),
                violator.getVehicle_number(), violator.getLicense_number(), violator.getViolation_type(),
                violator.getType_of_vehicle(), violator.getModel_of_vehicle(), violator.getDate_and_time(),
                violator.getLatitude(), violator.getLongitude(), policeId);
        return 1;
    }

    @Override
    public List<List<String>> selectAllViolatorPeople() {
        String sql = "SELECT * FROM violator";
        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);

        List<List<String>> final_result = new ArrayList<>();
        for (Map<String, Object> row : rows) {
            List<String> result = new ArrayList<>();
            result.add(row.get("Violator_Id").toString());
            result.add(row.get("Violator_name").toString());
            result.add(row.get("Violator_mob_number").toString());
            result.add(row.get("Vehicle_number").toString());
            result.add(row.get("License_number").toString());
            result.add(row.get("Violation_type").toString());
            result.add(row.get("Type_of_vehicle").toString());
            result.add(row.get("Model_of_vehicle").toString());
            result.add(row.get("Date_and_time").toString());
            result.add(row.get("Latitude").toString());
            result.add(row.get("Longitude").toString());
            result.add(row.get("police_id").toString());
            final_result.add(result);
        }
        return final_result;
    }

    @Override
    public List<Violator> selectViolatorPersonByID(Integer id) {
        return null;
    }

    @Override
    public Integer deleteViolatorPersonById(Integer id) {
        return null;
    }

    @Override
    public Integer updateViolatorPersonById(Integer id, Violator member) {
        return null;
    }
}

/*
{
	"Violator_name" : "kani",
	"Violator_mob_number" : "9787539615",
	"Vehicle_number" : "TN 42 AK 6815",
	"License_number" : "97867482",
	"Violation_type" : "over speeding",
	"Type_of_vehicle" : "car",
	"Model_of_vehicle" : "swift",
	"Date_and_time" : "2020-07-20 12:30:00",
	"Latitude" : "11.0168° N",
	"Longitude" : "76.9558° E"
}
 */