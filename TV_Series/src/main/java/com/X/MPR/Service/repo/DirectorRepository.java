package com.X.MPR.Service.repo;
import java.sql.SQLException;

import com.X.MPR.DBConn;

public class DirectorRepository {

	public DirectorRepository() throws SQLException, ClassNotFoundException {
		DBConn.getStatementInstance().executeUpdate("CREATE TABLE IF NOT EXISTS directors (id int(11) PRIMARY KEY AUTO_INCREMENT, name VARCHAR(255) NOT NULL, dateOfBirth DATE NOT NULL, biography TEXT) ");
    }

}
