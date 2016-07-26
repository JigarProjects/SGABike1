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

    public List<Attachment>  listAttachments() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet atatahmentResult = null;
        List<Attachment> attachmentList = new ArrayList<Attachment>();
        try {
            conn = DAOBase.getConnection();
            String SQL = "Select ID,BIKEID FROM ASSOCIATION";
            pstmt = conn.prepareStatement(SQL);
            atatahmentResult = pstmt.executeQuery();
            while (atatahmentResult.next()) {
                attachmentList.add(new Attachment(atatahmentResult.getInt("ID"), atatahmentResult.getInt("BIKEID")));
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
        System.out.println("in dao "+attachmentList);
        return attachmentList;
    }

    public void detachBike(int attachmentID) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        PreparedStatement insertStmt = null;
        try {
            _log.debug("in detachment process" + attachmentID + ":");
            conn = DAOBase.getConnection();
            conn.setAutoCommit(false);
            //Transaction opening
            String SQL = "INSERT INTO ASSOCIATIONHISTORY (ID,BIKEID) SELECT ID, BIKEID FROM ASSOCIATION WHERE ID =?";
            insertStmt = conn.prepareStatement(SQL);
            insertStmt.setInt(1, attachmentID);
            insertStmt.executeUpdate();
            //Delete call
            SQL = "DELETE FROM ASSOCIATION WHERE ID =?";
            pstmt = conn.prepareStatement(SQL);
            pstmt.setInt(1, attachmentID);
            int i = pstmt.executeUpdate();

            // End of transaction
            conn.commit();

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

