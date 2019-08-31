package com.X.MPR.Service;

import com.X.MPR.DBConn;
import com.X.MPR.Domain.Episode;
import com.X.MPR.Domain.Season;



import java.time.Duration;

import java.sql.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


public class EpisodeManager {
	
	 public EpisodeManager() throws SQLException, ClassNotFoundException {
		 DBConn.getStatementInstance().executeUpdate("CREATE TABLE IF NOT EXISTS episodes (id int(11) IDENTITY PRIMARY KEY AUTO_INCREMENT, season_id int(11), name VARCHAR(255) NOT NULL, releaseDate DATE NOT NULL, episodeNumber int(11), duration TIME)");
	    }

	    public void create(Episode episode) throws SQLException, ClassNotFoundException {
	        PreparedStatement stmt = DBConn.getConnectionInstance().prepareStatement("INSERT INTO episodes (name, releaseDate, episodeNumber, duration) VALUES (?, ?, ?, ?)");
	        stmt.setString(1, episode.getName());
	        stmt.setDate(2, Date.valueOf(episode.getReleaseDate()));
	        stmt.setInt(3, episode.getEpisodeNumber());
	        stmt.setTime(4, Time.valueOf(LocalTime.MIDNIGHT.plus(episode.getDuration())));
	        stmt.executeUpdate();
	    }

	    public void create(Season season, Episode episode) throws SQLException, ClassNotFoundException {
	        PreparedStatement stmt = DBConn.getConnectionInstance().prepareStatement("INSERT INTO episodes (season_id, name, releaseDate, episodeNumber, duration) VALUES (?, ?, ?, ?, ?)");
	        stmt.setInt(1, season.getId());
	        stmt.setString(2, episode.getName());
	        stmt.setDate(3, Date.valueOf(episode.getReleaseDate()));
	        stmt.setInt(4, episode.getEpisodeNumber());
	        stmt.setTime(5, Time.valueOf(LocalTime.MIDNIGHT.plus(episode.getDuration())));
	        stmt.executeUpdate();
	    }

	    public List<Episode> getEpisodes() throws SQLException, ClassNotFoundException {
	        List<Episode> list = new ArrayList<Episode>();
	        ResultSet rs = DBConn.getStatementInstance().executeQuery("SELECT * FROM episodes");

	        while(rs.next()) {
	            Episode episode = new Episode();
	            episode.setId(rs.getInt("id"));
	            episode.setName(rs.getString("name"));
	            episode.setReleaseDate(rs.getDate("releaseDate").toLocalDate());
	            episode.setEpisodeNumber(rs.getInt("episodeNumber"));
	            episode.setDuration(Duration.between(LocalTime.MIDNIGHT, rs.getTime("duration").toLocalTime()));
	            list.add(episode);
	        }

	        return list;
	    }

	    public Episode getLast() throws SQLException, ClassNotFoundException {
	        ResultSet rs = DBConn.getStatementInstance().executeQuery("SELECT * FROM episodes ORDER BY id DESC LIMIT 1");
	        Episode episode = new Episode();

	        if (rs.next()) {
	            episode.setId(rs.getInt("id"));
	            episode.setName(rs.getString("name"));
	            episode.setReleaseDate(rs.getDate("releaseDate").toLocalDate());
	            episode.setEpisodeNumber(rs.getInt("episodeNumber"));
	            episode.setDuration(Duration.between(LocalTime.MIDNIGHT, rs.getTime("duration").toLocalTime()));
	        }
	        return episode;
	    }

	    public List<Episode> getEpisodesForSeason(Season season) throws SQLException, ClassNotFoundException {
	        List<Episode> episodes = new ArrayList<Episode>();
	        PreparedStatement stmt = DBConn.getConnectionInstance().prepareStatement("SELECT * FROM episodes WHERE id = ?");
	        stmt.setInt(1, season.getId());
	        ResultSet rs = stmt.executeQuery();

	        while(rs.next()) {
	            Episode episode = new Episode();
	            episode.setId(rs.getInt("id"));
	            episode.setName(rs.getString("name"));
	            episode.setReleaseDate(rs.getDate("releaseDate").toLocalDate());
	            episode.setEpisodeNumber(rs.getInt("episodeNumber"));
	            episode.setDuration(Duration.between(LocalTime.MIDNIGHT, rs.getTime("duration").toLocalTime()));
	            episodes.add(episode);
	        }

	        return episodes;
	    }

	

}
