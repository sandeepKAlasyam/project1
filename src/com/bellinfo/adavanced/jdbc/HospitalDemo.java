package com.bellinfo.adavanced.jdbc;

import java.sql.SQLException;
import java.util.Scanner;

public class HospitalDemo {
    enum OPERATIONS {INSERT, UPDATE};

    public static void main(String[] args) throws SQLException {
        HospitalRespository Hr = new HospitalRespository();
        Hr.createHospital();
        Scanner scan = new Scanner(System.in);
        System.out.println("Hey what you are looking  to type");
        String oper = scan.next();
        if (oper.equalsIgnoreCase(OPERATIONS.INSERT.name())) {
            System.out.println("How many records");
            int count = scan.nextInt();
            Hospital d = null;
            for (int i = 0; i < count; i++) {
                d = new Hospital();
                System.out.println("Hospitalid");
                d.setId(scan.nextInt());
                System.out.println("HosiptalName");
                d.setHospitalName(scan.next());
                System.out.println("HospitalLocation");
                d.setHospitalLocation(scan.next());
                System.out.println("Reviews");
                d.setReviews(scan.nextDouble());
                Hr.insertHospitalRecord(d);

            }


        } else if (oper.equalsIgnoreCase(OPERATIONS.UPDATE.name())) {
            System.out.println("which review you want to update");
            String Hospital = scan.next();
            System.out.println("What is the new location");
            String HospitalLocation =scan.next();
            Hr.updateHospitalRecord(HospitalLocation, Hospital);
        }

        System.out.println("After requested operation, records in DB");
        Hr.fetchRecords();

    }
}