package com.X.MPR.Service.repo;

import java.sql.SQLException;

import com.X.MPR.DBConn;

public class SeasonRepository {
	public SeasonRepository () throws SQLException, ClassNotFoundException {
        DBConn.getStatementInstance().executeUpdate("CREATE TABLE IF NOT EXISTS seasons (id int(11) PRIMARY KEY AUTO_INCREMENT, tvseries_id int(11), seasonNumber int(11), yearOfRelease int(11))");
    }
}
