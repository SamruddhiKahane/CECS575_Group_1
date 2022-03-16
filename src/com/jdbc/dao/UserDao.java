package com.jdbc.dao;

import java.sql.SQLException;
import java.util.List;

import com.jdbc.model.User;

public interface UserDao {

    public int add(User usr)
            throws SQLException;
    public void delete(String user_id)
            throws SQLException;

    public default User getUser(String user_id)
            throws SQLException {
        return null;
    }

    public List<User> getUser()
            throws SQLException;
    public void update(User usr)
            throws SQLException;
}

