package com.db;

import com.core.Attachment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Jigar on 7/21/2016.
 */
public class AttachmentDAO extends DAOBase {
    public void attachBike(Attachment newAttachment) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            _log.debug("in attachment process" + newAttachment + ":");
            conn = DAOBase.getConnection();
            String SQL = "insert into ASSOCIATION (ID,BIKEID) VALUES (?,?)";

            pstmt = conn.prepareStatement(SQL);
            pstmt.setInt(1, newAttachment.getUserID());
            pstmt.setInt(2, newAttachment.getBikeID());
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

    /*public  listAttachments() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet bikeResult = null;
        List<Attachment> attachmentList = new ArrayList<Attachment>();
        try {
            conn = DAOBase.getConnection();
            String SQL = "SELECT ID, FROM BIKE";
            pstmt = conn.prepareStatement(SQL);
            bikeResult = pstmt.executeQuery();
            while (bikeResult.next()) {
                attachmentList.add(new Attachment(bikeResult.getInt("ID"), bikeResult.getString("NAME"), bikeResult.getString("DESCRIPTION")));
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
        return attachmentList;
    }*/
}
