package com.example.server.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name="repeater")
public class Repeater {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="License_number")
    private Violator violator;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String violation_type;

    public Violator getViolator() {
        return violator;
    }

    public void setViolator(Violator violator) {
        this.violator = violator;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getViolation_type() {
        return violation_type;
    }

    public void setViolation_type(@JsonProperty("violation_type") String violation_type) {
        this.violation_type = violation_type;
    }
}
