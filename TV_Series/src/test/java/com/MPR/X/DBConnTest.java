package com.MPR.X;


import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

import com.X.MPR.DBConn;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class DBConnTest {
	
	 @Rule
	    public TestRule watcher = new TestWatcher() {
	        protected void starting(Description description) {
	            System.out.println("Starting test: " + description.getMethodName());
	        }
	    };

	    @Test
	    public void itCorrectlyReturnsConnectionInstance() throws SQLException, ClassNotFoundException {
	        assertNotNull(DBConn.getConnectionInstance());
	    }

	    @Test
	    public void itCorrectlyReturnsStatementInstance() throws SQLException, ClassNotFoundException {
	        assertNotNull(DBConn.getStatementInstance());
	    }

}
