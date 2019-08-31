package com.X.MPR.Service.repo;

import com.X.MPR.DBConn;
import com.X.MPR.Domain.Actor;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class ActorRepository implements Repository<Actor>{

	 public ActorRepository() throws SQLException, ClassNotFoundException {
	        DBConn.getStatementInstance().executeUpdate("CREATE TABLE IF NOT EXISTS actors (id int(11) PRIMARY KEY AUTO_INCREMENT, name VARCHAR(255) NOT NULL, dateOfBirth DATE NOT NULL, biography TEXT) ");
	    }

}
