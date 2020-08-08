package com.example.server.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    private Integer Police_Id;
    private String Email_Id;
    private String Password;
    private String First_Name;
    private String Last_Name;
    private String Position_type;
    private String Work_Area;
    private String Station_Name;
    private String Phone_Number;
    private String Blood_Group;
    private String Address;
}