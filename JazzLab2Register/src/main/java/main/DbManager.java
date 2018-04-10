package main;

import java.sql.*;

public class DbManager {

    private static final String url = "jdbc:hsqldb:hsql://localhost/workdb";
    private static final String username = "SA";
    private static final String password = "";
    
    private Connection connection;
    
    public Connection DbConnection() {
    	try {
    		Class.forName("org.hsqldb.jdbc.JDBCDriver");
    		connection = DriverManager.getConnection(url, username, password);
    		if(!DatabaseWork()) createTable();
    	} catch (SQLException | ClassNotFoundException e) {
    		e.printStackTrace();
    	}
    	return connection;
    }
    
    private boolean DatabaseWork() {
    	ResultSet resultSet = null;
    	try {
    		resultSet = connection.getMetaData().getCatalogs();
    		
    		while (resultSet.next()) {
    			
    		}
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
    	return resultSet != null;
    }
    
    private void createTable(){
        String query = "CREATE TABLE USERS (" +
                "ID INT IDENTITY PRIMARY KEY," +
                "LOGIN VARCHAR(30) NOT NULL," +
                "PASSWORD VARCHAR(30) NOT NULL," +
                "EMAIL VARCHAR(50)," +
                "RIGHTS VARCHAR(50)" +
                ")";
        
        String queryUsers = "INSERT INTO USERS (LOGIN,PASSWORD,EMAIL,RIGHTS) VALUES ('admin','admin','admin@admin','administrator')";
    
        try {

            Statement s = connection.createStatement();
            s.executeUpdate(query);
            s.executeUpdate(queryUsers);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
}
}