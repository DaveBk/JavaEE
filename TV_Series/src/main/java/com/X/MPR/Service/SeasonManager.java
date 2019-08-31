package com.X.MPR.Service;

import com.X.MPR.DBConn;
import com.X.MPR.Domain.Episode;
import com.X.MPR.Domain.Season;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;



public class SeasonManager {

	 EpisodeManager episodeManager;

	    public SeasonManager() throws SQLException, ClassNotFoundException {
	        episodeManager = new EpisodeManager();
	        DBConn.getStatementInstance().executeUpdate("CREATE TABLE IF NOT EXISTS seasons (id int(11) PRIMARY KEY AUTO_INCREMENT, tvseries_id int(11), seasonNumber int(11), yearOfRelease int(11))");
	    }

	    public void create(Season season) throws SQLException, ClassNotFoundException {
	        String generatedColumns[] = { "id" };
	        PreparedStatement stmt = DBConn.getConnectionInstance().prepareStatement("INSERT INTO seasons (seasonNumber, yearOfRelease) VALUES (?, ?)", generatedColumns);
	        stmt.setInt(1, season.getSeasonNumber());
	        stmt.setInt(2, season.getYearOfRelease());
	        stmt.executeUpdate();
	        ResultSet generatedKeys = stmt.getGeneratedKeys();
	        if (generatedKeys.next()) {
	            season.setId(generatedKeys.getInt(1));
	        }
	        for(Episode episode : season.getEpisodes()) {
	            episodeManager.create(season, episode);
	        }
	    }

	    public List<Season> getSeasons() throws SQLException, ClassNotFoundException {
	        List<Season> seasons = new ArrayList<Season>();
	        ResultSet rs = DBConn.getStatementInstance().executeQuery("SELECT * FROM seasons");
	        while(rs.next()) {
	            Season season = new Season();
	            season.setId(rs.getInt("id"));
	            season.setSeasonNumber(rs.getInt("seasonNumber"));
	            season.setYearOfRelease(rs.getInt("yearOfRelease"));
	            season.setEpisodes(episodeManager.getEpisodesForSeason(season));
	            seasons.add(season);
	        }

	        return seasons;
	    }

	    public Season getLast() throws SQLException, ClassNotFoundException {
	        ResultSet rs = DBConn.getStatementInstance().executeQuery("SELECT * FROM seasons ORDER BY id DESC LIMIT 1");
	        Season season = new Season();

	        if (rs.next()) {
	            season.setId(rs.getInt("id"));
	            season.setYearOfRelease(rs.getInt("yearOfRelease"));
	            season.setSeasonNumber(rs.getInt("seasonNumber"));
	            season.setEpisodes(episodeManager.getEpisodesForSeason(season));
	        }

	        return season;
	    }
}
