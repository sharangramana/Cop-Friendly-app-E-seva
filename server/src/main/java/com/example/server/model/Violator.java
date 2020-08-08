package com.example.server.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name="Violator")
public class Violator {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="Police_Id")
    private Department_member departmentMember;


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Violator_ID;

    private final String Violator_name;
    private final String Violator_mob_number;
    private final String Vehicle_number;
    @Id
    @Size(max = 15)
    private final String License_number;

    private final String Violation_type;
    private final String Type_of_vehicle;
    private final String Model_of_vehicle;
    private final String Date_and_time ;
    private final String Latitude;
    private final String Longitude;


    public Violator(
                    @JsonProperty("Violator_name") String violator_name,
                    @JsonProperty("Violator_mob_number") String violator_mob_number,
                    @JsonProperty("Vehicle_number") String vehicle_number,
                    @JsonProperty("License_number") String license_number,
                    @JsonProperty("Violation_type") String violation_type,
                    @JsonProperty("Type_of_vehicle") String type_of_vehicle,
                    @JsonProperty("Model_of_vehicle") String model_of_vehicle,
                    @JsonProperty("Date_and_time") String date_and_time,
                    @JsonProperty("Latitude") String latitude,
                    @JsonProperty("Longitude") String longitude) {
        Violator_name = violator_name;
        Violator_mob_number = violator_mob_number;
        Vehicle_number = vehicle_number;
        License_number = license_number;
        Violation_type = violation_type;
        Type_of_vehicle = type_of_vehicle;
        Model_of_vehicle = model_of_vehicle;
        Date_and_time = date_and_time;
        Latitude = latitude;
        Longitude = longitude;
    }




    public void setViolator_Id(Integer violator_Id) {
        Violator_ID = violator_Id;
    }

    // getters
    public String getVehicle_number() {
        return Vehicle_number;
    }

    public String getLicense_number() {
        return License_number;
    }

    public String getViolation_type() {
        return Violation_type;
    }

    public String getType_of_vehicle() {
        return Type_of_vehicle;
    }

    public String getModel_of_vehicle() {
        return Model_of_vehicle;
    }

    public String getDate_and_time() {
        return Date_and_time;
    }

    public String getLatitude() {
        return Latitude;
    }

    public String getLongitude() {
        return Longitude;
    }

    public Department_member getDepartmentMember() {
        return departmentMember;
    }

    public void setDepartmentMember(Department_member departmentMember) {
        this.departmentMember = departmentMember;
    }

    public Integer getViolator_ID() {
        return Violator_ID;
    }

    public String getViolator_name() {
        return Violator_name;
    }

    public String getViolator_mob_number() {
        return Violator_mob_number;
    }
}