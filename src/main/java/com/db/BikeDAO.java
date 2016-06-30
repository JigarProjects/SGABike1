package com.db;

import com.temp.resource.Bike;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * Created by Jigar on 6/28/2016.
 */
public class BikeDAO extends DAOBase {

    public void createBike(Bike newBike) {
        try {
            System.out.println("in bike createion " + newBike + ":");
            Connection conn = DAOBase.getConnection();
            String SQL = "insert into BIKE(NAME,DESCRIPTION) VALUES (?,?)";

            PreparedStatement pstmt = conn.prepareStatement(SQL);
            pstmt.setString(1, newBike.getName());
            pstmt.setString(2, newBike.getDescription());
            int i = pstmt.executeUpdate();


            pstmt.close();
            conn.close();

        } catch (Exception e) {
            System.out.println("Error: unable to SQL execute!");
            System.out.println(e);
        }

    }
}
