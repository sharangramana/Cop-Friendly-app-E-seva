package com.example.server.model;


import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "Department_members")
public class Department_member {

    @Id
    @Column(name = "Police_Id")
    private final Integer Police_Id;

    //@NotBlank
    //@Column(name="Email should not be empty")
    //private final String Email_Id;

    @NotBlank(message = "Password should not be blank")
    @Column(name = "Password")
    private final String Password;

    @NotBlank(message = "First Name should not be blank")
    @Column(name = "First_Name")
    private final String First_Name;

    @NotBlank(message = "Last Name should not be blank")
    @Column(name = "Last_Name")
    private final String Last_Name;

    @NotBlank(message = "Position type should not be blank")
    @Column(name = "Position_type")
    private final String Position_type;

    @NotBlank(message = "Work Area should not be blank")
    @Column(name = "Work_Area")
    private final String Work_Area;

    @NotBlank(message = "Station name should not be blank")
    @Column(name = "Station_Name")
    private final String Station_Name;

    @NotBlank(message = "PhoneNumber should not be blank")
    @Column(name = "Phone_Number")
    private final String Phone_Number;

    @NotBlank(message = "Blood Group should not be blank")
    @Column(name = "Blood_Group")
    private final String Blood_Group;

    @NotBlank(message = "Address should not be blank")
    @Column(name = "Address")
    private final String Address;

    //private List<Violator> violators;

    public Department_member(@JsonProperty("Police_Id") Integer police_id,
                             //@JsonProperty("Email_Id") @NotBlank String emailID,
                             @JsonProperty("Password") String password,
                             @JsonProperty("First_Name") String first_name,
                             @JsonProperty("Last_Name") String last_name,
                             @JsonProperty("Position_type") String position_type,
                             @JsonProperty("Work_Area") String work_area,
                             @JsonProperty("Station_Name") String station_name,
                             @JsonProperty("Phone_Number") String phone_number,
                             @JsonProperty("Blood_Group") String blood_group,
                             @JsonProperty("Address") String address) {
        Police_Id = police_id;
        //this.Email_Id = emailID;
        Password = password;
        First_Name = first_name;
        Last_Name = last_name;
        Position_type = position_type;
        Work_Area = work_area;
        Station_Name = station_name;
        Phone_Number = phone_number;
        Blood_Group = blood_group;
        Address = address;
    }

    // Getter methods
    public String getPosition_type() {
        return Position_type;
    }

    public Integer getPolice_Id() {
        return Police_Id;
    }

    public String getPassword() {
        return Password;
    }

    public String getFirst_Name() {
        return First_Name;
    }

    public String getLast_Name() {
        return Last_Name;
    }

    public String getWork_Area() {
        return Work_Area;
    }

    public String getStation_Name() {
        return Station_Name;
    }

    public String getPhone_Number() {
        return Phone_Number;
    }

    public String getBlood_Group() {
        return Blood_Group;
    }

    public String getAddress() {
        return Address;
    }

//    public String getEmail_Id() {
//        return Email_Id;
//    }

//    @OneToMany(targetEntity = Violator.class, mappedBy = "Police_Id", fetch = FetchType.LAZY)
//    public List<Violator> getViolators() {
//        return violators;
//    }
//
//    public void setViolators(List<Violator> violators) {
//        this.violators = violators;
//    }
}
