package com.jdbc.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.jdbc.model.User;
import com.jdbc.util.BookSpotDBClass;

public class UserDaoImplementation
        implements UserDao {

    static Connection con
            = BookSpotDBClass.getConnection();

    @Override
    public int add(User usr)
            throws SQLException
    {
    //String user_id = UUID.randomUUID().toString();
        String query
                = "insert into thebookspotdb(user_id, first_name, "
                + "last_name, email) VALUES (?, ?, ?, ?)";
        PreparedStatement ps
                = con.prepareStatement(query);
        ps.setString(1, usr.getUser_id());;
        ps.setString(2, usr.getFirst_name());
        ps.setString(3, usr.getLast_name());
        ps.setString(4, usr.getEmail());
        int n = ps.executeUpdate();
        return n;
    }

    @Override
    public void delete(String user_id)
            throws SQLException
    {
        String query
                = "delete from thebookspotdb where user_id =?";
        PreparedStatement ps
                = con.prepareStatement(query);
        ps.setString(1, user_id);
        ps.executeUpdate();
    }

    @Override
    public User getUser(String  user_id)
            throws SQLException
    {

        String query
                = "select * from thebookspotdb where user_id= ?";
        PreparedStatement ps
                = con.prepareStatement(query);

        ps.setString(1, user_id);
        User usr = new User();
        ResultSet rs = ps.executeQuery();
        boolean check = false;

        while (rs.next()) {
            check = true;
            usr.setUser_id(rs.getString("user_id"));
            usr.setFirst_name(rs.getString("first_name"));
            usr.setLast_name(rs.getString("last_name"));
            usr.setEmail(rs.getString("email"));
        }

        if (check == true) {
            return usr;
        }
        else
            return null;
    }

    @Override
    public List<User> getUser()
            throws SQLException
    {
        String query = "select * from thebookspotdb";
        PreparedStatement ps
                = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        List<User> ls = new ArrayList();

        while (rs.next()) {
            User usr = new User();
            usr.setUser_id(rs.getString("user_id"));
            usr.setFirst_name(rs.getString("first_name"));
            usr.setLast_name(rs.getString("last_name"));
            usr.setEmail(rs.getString("email"));
            ls.add(usr);
        }
        return ls;
    }

    @Override
    public void update(User usr)
            throws SQLException
    {

        String query
                = "update thebookspotdb set first_name=?, "
                + " last_name= ?, "+ " email =? where user_id = ?";
        PreparedStatement ps
                = con.prepareStatement(query);
        ps.setString(1, usr.getUser_id());
        ps.setString(2, usr.getFirst_name());
        ps.setString(3, usr.getLast_name());
        ps.setString(4, usr.getEmail());
        ps.executeUpdate();
    }
}

