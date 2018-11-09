package com.bellinfo.adavanced.jdbc;

import java.sql.*;
import java.util.Properties;

public class HospitalRespository {
    private static final String CREATE_SQL = "CREATE TABLE Hospital(Hospitalid int NOT NULL, HospitalName VarChar,HospitalLocation VarChar,Reviews float8)";
    private static final String INSERT_SQL = "INSERT INTO Hospital values(? , ? ,? ,?)";
    private static  final String SELECT_SQL = "select * from Hospital";
    private static final  String UPDATE_SQL = "Update Hospital set Location=? where HospitalName=?";
    private static final  String VALIDATE_SQL = "select exists(select 1 from pg_tables where schemaname='public' and tablename='hospital')";

    private static final String URL = "jdbc:postgresql://127.0.0.1:5432/BellInfoBatch11";
    Connection con = null;

    void getConnection()  {


        try {
            Class.forName("org.postgresql.Driver");
            Properties prop = new Properties();
            prop.setProperty("user","postgres");
            prop.setProperty("password","admin");
            con = DriverManager.getConnection(URL,prop);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
void createHospital() throws SQLException {
    getConnection();

        PreparedStatement psValidate = con.prepareStatement(VALIDATE_SQL);
        ResultSet rs = psValidate.executeQuery();
         boolean isTableExsist = false;
         while(rs.next()) {
             isTableExsist = (rs.getBoolean(1));
         }
         if(isTableExsist){
             System.out.println("Hey...Table already careted in yor schema,so..Skiping it");
         } else{
             PreparedStatement ps = con.prepareStatement(CREATE_SQL);
             boolean isCreated = ps.execute();
             System.out.println("Hey Table has been created");
         }

    }



     void insertHospitalRecord(Hospital hr) {
        getConnection();
         try {
             PreparedStatement ps = con.prepareStatement(INSERT_SQL);
             ps = con.prepareStatement(INSERT_SQL);
             ps.setInt(1,hr.getId());
             ps.setString(2,hr.getHospitalName());
             ps.setString(3,hr.getHospitalLocation());
             ps.setDouble(4,hr.getReviews());

             ps.executeUpdate();
             System.out.println("Record created");
         } catch (SQLException e) {
             e.printStackTrace();
         }}



    void updateHospitalRecord(String HospitalLocation, String HospitalName)  {
        getConnection();
        try {
            PreparedStatement ps = con.prepareStatement(UPDATE_SQL);
            ps.setString(1, HospitalLocation);
            ps.setString(2, HospitalName);
            int count = ps.executeUpdate();
            System.out.println("Records Updated count " + count);
        } catch (SQLException e) {
            e.printStackTrace();


        }
    }

    void fetchRecords() throws SQLException {
            getConnection();
            PreparedStatement ps = con.prepareStatement(SELECT_SQL);
        ResultSet rs = ps.executeQuery();
            while(rs.next()){
            System.out.println(rs.getInt("Hospitalid") + "  "+rs.getString("HospitalName") + "    "+rs.getString("HospitalLocation")+"  "+rs.getDouble("Reviews") );

            }


}

}
