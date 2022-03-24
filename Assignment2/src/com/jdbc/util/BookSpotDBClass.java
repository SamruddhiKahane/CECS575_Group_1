package com.jdbc.util;

        import java.sql.Connection;
        import java.sql.DriverManager;
        import java.sql.SQLException;

public class BookSpotDBClass {

    private static Connection con = null;

    static
    {
        String url = "jdbc:mysql:// localhost:3306/thebookspotdb";
        String user = "root";
        String pass = "Spring@444";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, user, pass);
        }
        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection()
    {
        return con;
    }
}
