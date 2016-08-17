package com.db;

import com.core.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jigar on 7/10/2016.
 */
public class UserDAO extends DAOBase {
    public void createUser(User newUser) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            _log.debug("in user creation " + newUser + ":");
            conn = DAOBase.getConnection();
            String SQL = "insert into USER(USERID,NAME) VALUES (?,?)";

            pstmt = conn.prepareStatement(SQL);
            pstmt.setInt(1, newUser.getUserid());
            pstmt.setString(2, newUser.getName());
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

    public List<User> listUser() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet userResult = null;
        List<User> UserList = new ArrayList<User>();
        try {
            conn = DAOBase.getConnection();
            String SQL = "SELECT ID,USERID,NAME FROM USER";
            pstmt = conn.prepareStatement(SQL);
            userResult = pstmt.executeQuery();
            while (userResult.next()) {
                UserList.add(new User(userResult.getInt("ID"), userResult.getInt("USERID"), userResult.getString("NAME"), null));
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
        return UserList;
    }

    public void deleteUser(int id) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            _log.debug("in user deletion " + id + ":");
            conn = DAOBase.getConnection();
            String SQL = "DELETE FROM USER WHERE ID = ?";

            pstmt = conn.prepareStatement(SQL);
            pstmt.setString(1, String.valueOf(id));
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

    public void updateUser(User updatedUser) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            _log.debug("in bike updation " + updatedUser + ":");
            conn = DAOBase.getConnection();
            String SQL = "UPDATE USER SET NAME= ? WHERE USERID = ? ";

            pstmt = conn.prepareStatement(SQL);
            pstmt.setString(1, updatedUser.getName());
            pstmt.setString(2, String.valueOf(updatedUser.getUserid()));

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

    public User getUserByID(int userId) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet userResult = null;
        User foundUser = null;
        try {
            _log.debug("in bike fetch using ID " + userId + ":");
            conn = DAOBase.getConnection();
            String SQL = "SELECT NAME,ID,EMAIL FROM USER WHERE USERID = ? ";

            pstmt = conn.prepareStatement(SQL);
            pstmt.setInt(1, userId);

            userResult = pstmt.executeQuery();
            while (userResult.next()) {
                foundUser = (new User(userResult.getInt("ID"), userId, userResult.getString("NAME"), userResult.getString("EMAIL")));
            }


        } catch (Exception e) {
            _log.error("NEW Error: unable to SQL execute!");
            _log.error(e.getStackTrace());
        } finally {
            try {
                pstmt.close();
                conn.close();
            } catch (Exception e) {
                _log.error(e);
            }

        }
        _log.debug("found user " + foundUser);
        return foundUser;
    }

    public ArrayList<User> notifyUsers() {
        ArrayList<User> userList = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet userResult = null;
        try {
            conn = DAOBase.getConnection();
            String SQL = "select b.EMAIL, b.ID,b.USERID,b.NAME " +
                    " from association a, user b " +
                    " where a.BINDDATE < now() and a.id = b.id;";
            pstmt = conn.prepareStatement(SQL);
            userResult = pstmt.executeQuery();
            while (userResult.next()) {
                userList.add(new User(userResult.getInt("ID"), userResult.getInt("USERID"), userResult.getString("NAME"), userResult.getString("EMAIL")));
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
        return userList;
    }
}
