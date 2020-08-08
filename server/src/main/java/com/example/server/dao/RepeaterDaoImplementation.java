package com.example.server.dao;

import com.example.server.model.Repeater;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository("RepeaterDaoImplemented")
public class RepeaterDaoImplementation extends JdbcDaoSupport implements RepeaterDao {

    @Autowired
    DataSource dataSource;

    @PostConstruct
    private void initialize() {
        setDataSource(dataSource);
    }

    @Override
    public Integer insertRecord(Repeater repeater, String License_number) {
        System.out.println(repeater.getId());
        String sql = "INSERT INTO repeater (license_number, violation_type) VALUES(?, ?)";
        getJdbcTemplate().update(sql, License_number, repeater.getViolation_type());
        return 1;
    }

    @Override
    public List<List<String>> selectAllRecords(String License_number) {
        System.out.println(License_number);
        String sql = "SELECT * FROM repeater WHERE license_number="+License_number;
        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);

        List<List<String>> final_result = new ArrayList<>();

        for (Map<String, Object> row : rows) {
            List<String> result = new ArrayList<>();
            result.add(row.get("license_number").toString());
            result.add(row.get("violation_type").toString());
            final_result.add(result);
        }
        return final_result;
    }
}
