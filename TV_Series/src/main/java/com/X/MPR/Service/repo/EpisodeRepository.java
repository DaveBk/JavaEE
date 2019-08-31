package com.X.MPR.Service.repo;

import java.sql.SQLException;

import com.X.MPR.DBConn;

public class EpisodeRepository {

	public EpisodeRepository() throws SQLException, ClassNotFoundException {
		 DBConn.getStatementInstance().executeUpdate("CREATE TABLE IF NOT EXISTS episodes (id int(11) IDENTITY PRIMARY KEY AUTO_INCREMENT, season_id int(11), name VARCHAR(255) NOT NULL, releaseDate DATE NOT NULL, episodeNumber int(11), duration TIME)");
	    }

}
