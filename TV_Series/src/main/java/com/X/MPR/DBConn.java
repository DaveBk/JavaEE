package com.X.MPR;


import java.sql.*;


public class DBConn {

	  private static final String DRIVER = "com.mysql.jdbc.Driver";
	    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/mpr";
	    private static final String USER = "root";
	    private static final String PASS = "root123";
	    private static Connection connectionInstance;
	    private static Statement statementInstance;

	    public DBConn() throws SQLException, ClassNotFoundException {
	        if (connectionInstance == null || connectionInstance.isClosed()) {
	            connectionInstance = getConnection();
	        }
	        if (statementInstance == null || statementInstance.isClosed()) {
	            statementInstance = getStatementInstance();
	        }
	    }

	    public static Connection getConnectionInstance() throws SQLException, ClassNotFoundException {
	        if (connectionInstance == null || connectionInstance.isClosed() || !connectionInstance.isValid(1)) {
	            connectionInstance = getConnection();
	        }
	        return connectionInstance;
	    }

	    public static void setConnectionInstance(Connection connInstance) {
	        connectionInstance = connInstance;
	    }

	    public static Statement getStatementInstance() throws SQLException, ClassNotFoundException {
	        if (statementInstance == null || statementInstance.isClosed()) {
	            statementInstance = createStatement(getConnectionInstance());
	        }
	        return statementInstance;
	    }

	    public static void setStatementInstance(Statement stmtInstance) {
	        statementInstance = stmtInstance;
	    }

	    private static Connection getConnection() throws SQLException, ClassNotFoundException {
	        Class.forName(DRIVER);
	        return DriverManager.getConnection(DATABASE_URL, USER, PASS);
	    }

	    private static Statement createStatement(Connection conn) throws SQLException {
	        return conn.createStatement();
	    }
}
