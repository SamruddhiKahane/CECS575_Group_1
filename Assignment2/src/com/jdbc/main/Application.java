package com.jdbc.main;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import com.jdbc.dao.UserDaoImplementation;
import com.jdbc.model.User;

public class Application {

    public static void main(String[] args)
            throws SQLException
    {
        String user_id = UUID.randomUUID().toString();
        User usr = new User();
        usr.setUser_id(user_id);
        usr.setFirst_name("John");
        usr.setLast_name("Snow");
        usr.setEmail("Jhonsnow12@gmail.com");
        UserDaoImplementation usrDao
                = new UserDaoImplementation();

        // add
        usrDao.add(usr);

        // read
        //User u = usrDao.getUser(String.valueOf(1));
        //System.out.println(u.getUser_id() + " "
              //  + u.getFirst_name() + " "
              //  + u.getLast_name() + " " + u.getEmail());

        // read All
        List<User> ls = usrDao.getUser();
        for (User allUsr : ls) {
            System.out.println(allUsr);
        }

        // update
        User tempUser = usrDao.getUser(String.valueOf(1));
        tempUser.setEmail("Jhonsnow12@gmail.com");
        usrDao.update(tempUser);

        // delete
        usrDao.delete(String.valueOf(1));
    }
}
