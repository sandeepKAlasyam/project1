package com.bellinfo.adavanced.jdbc;

import java.util.Objects;

public class Hospital {
    private int id;
    private String HospitalName;
    private String HospitalLocation;
    private Double Reviews;

    public Hospital(){
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHospitalName() {
        return HospitalName;
    }

    public void setHospitalName(String hospitalName) {
        HospitalName = hospitalName;
    }

    public String getHospitalLocation() {
        return HospitalLocation;
    }

    public void setHospitalLocation(String hospitalLocation) {
        HospitalLocation = hospitalLocation;
    }

    public Double getReviews() {
        return Reviews;
    }

    public void setReviews(Double reviews) { Reviews = reviews;
    }

    public Hospital(int id, String HospitalName, String HospitalLocation, Double Reviews){


    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hospital hospital = (Hospital) o;
        return id == hospital.id &&
                Reviews == hospital.Reviews &&
                Objects.equals(HospitalName, hospital.HospitalName) &&
                Objects.equals(HospitalLocation, hospital.HospitalLocation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, HospitalName, HospitalLocation, Reviews);
    }

    @Override
    public String toString() {
        return "Hospital{" +
                "id=" + id +
                ", HospitalName='" + HospitalName + '\'' +
                ", HospitalLocation='" + HospitalLocation + '\'' +
                ", Reviews=" + Reviews +
                '}';
    }
}
