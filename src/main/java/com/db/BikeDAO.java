package com.db;

import com.core.Bike;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jigar on 6/28/2016.
 */
public class BikeDAO extends DAOBase {

    public void createBike(Bike newBike) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            _log.debug("in bike createion " + newBike + ":");
            conn = DAOBase.getConnection();
            String SQL = "insert into BIKE(NAME,DESCRIPTION) VALUES (?,?)";

            pstmt = conn.prepareStatement(SQL);
            pstmt.setString(1, newBike.getName());
            pstmt.setString(2, newBike.getDescription());
            int i = pstmt.executeUpdate();

        } catch (Exception e) {
            _log.error("Error: unable to SQL execute!");
            _log.error(e);
        } finally {
            try {
                pstmt.close();
                conn.close();
            } catch (Exception e) {
                _log.error(e);
            }

        }
    }

    public List<Bike> listBike() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet bikeResult = null;
        List<Bike> bikeList = new ArrayList<Bike>();
        try {
            conn = DAOBase.getConnection();
            String SQL = "SELECT ID,NAME,DESCRIPTION FROM BIKE";
            pstmt = conn.prepareStatement(SQL);
            bikeResult = pstmt.executeQuery();
            while (bikeResult.next()) {
                bikeList.add(new Bike(bikeResult.getInt("ID"), bikeResult.getString("NAME"), bikeResult.getString("DESCRIPTION")));
            }
        } catch (Exception e) {
            _log.error("Error: unable to SQL execute!");
            _log.error(e);
        } finally {
            try {
                pstmt.close();
                conn.close();
            } catch (Exception e) {
                _log.error(e);
            }
        }
        return bikeList;
    }

    public void deleteBike(int bike) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            _log.debug("in bike deletion " + bike + ":");
            conn = DAOBase.getConnection();
            String SQL = "DELETE FROM BIKE WHERE ID = ?";

            pstmt = conn.prepareStatement(SQL);
            pstmt.setString(1, String.valueOf(bike));
            int i = pstmt.executeUpdate();

        } catch (Exception e) {
            _log.error("Error: unable to SQL execute!");
            _log.error(e);
        } finally {
            try {
                pstmt.close();
                conn.close();
            } catch (Exception e) {
                _log.error(e);
            }

        }
    }

    public void updateBike(Bike updatedBike) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            _log.debug("in bike updation " + updatedBike + ":");
            conn = DAOBase.getConnection();
            String SQL = "UPDATE BIKE SET NAME= ?, DESCRIPTION =? WHERE ID = ? ";

            pstmt = conn.prepareStatement(SQL);
            pstmt.setString(1, updatedBike.getName());
            pstmt.setString(2, updatedBike.getDescription());
            pstmt.setInt(3, updatedBike.getId());
            int i = pstmt.executeUpdate();

        } catch (Exception e) {
            _log.error("Error: unable to SQL execute!");
            _log.error(e);
        } finally {
            try {
                pstmt.close();
                conn.close();
            } catch (Exception e) {
                _log.error(e);
            }

        }
    }
}
