package com.X.MPR.Service.mapper;
import com.X.MPR.Domain.Episode;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class EpisodeMapper implements Mapper<Episode> {

	private PreparedStatement addEpisodeStmt;
	private PreparedStatement deleteAllEpisodeStmt;
	private PreparedStatement getAllEpisodesStmt;
	private PreparedStatement selectById;
	private PreparedStatement selectBySeasonId;
	private Connection connection;

	public EpisodeMapper(Connection connection) {
		this.connection = connection;
		try {
			addEpisodeStmt = connection.prepareStatement(
					"INSERT INTO episodes (name, releaseDate, episodeNumber, duration) VALUES (?, ?, ?, ?)");
			deleteAllEpisodeStmt = connection.prepareStatement("DELETE FROM episodes");
			getAllEpisodesStmt = connection
					.prepareStatement("SELECT * FROM episodes");
			selectById = connection.prepareStatement("Select * from episodes where id=?");
			selectBySeasonId = connection.prepareStatement("Select * from episode where seasonID=?");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	Connection getConnection() {
		return connection;
	}


	public List<Episode> getAll() {
		List<Episode> episodes = new ArrayList<Episode>();

		try {
			ResultSet rs = getAllEpisodesStmt.executeQuery();

			while (rs.next()) {
				Episode e = new Episode();
				e.setName(rs.getString("name"));
				e.setReleaseDate(rs.getDate("releaseDate").toLocalDate());
				e.setEpisodeNumber(rs.getInt("episodeNumber"));
				e.setDuration(Duration.between(LocalTime.MIDNIGHT, rs.getTime("duration").toLocalTime()));
				episodes.add(e);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return episodes;
	}

	public int add(Episode episode) {
		int count = 0;
		try {
			addEpisodeStmt.setString(1, episode.getName());
			addEpisodeStmt.setDate(2, Date.valueOf(episode.getReleaseDate()));
			addEpisodeStmt.setInt(3, episode.getEpisodeNumber());
			addEpisodeStmt.setTime(4, Time.valueOf(LocalTime.MIDNIGHT.plus(episode.getDuration())));
			count = addEpisodeStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}


	public void remove(Episode entity) {
		try {
			deleteAllEpisodeStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Episode> getById(int Id) throws SQLException {
		selectById.setInt(1, Id);
		ResultSet rs = selectById.executeQuery();
		ArrayList<Episode> episodes = new ArrayList<Episode>();
		while (rs.next()) {
			Episode episode = getEpisodeById(rs);
			episodes.add(episode);
		}
		return episodes;
	}

	private Episode getEpisodeById(ResultSet rs) throws SQLException {
		Episode e = new Episode();
		e.setName(rs.getString("name"));
		e.setReleaseDate(rs.getDate("releaseDate").toLocalDate());
		e.setEpisodeNumber(rs.getInt("episodeNumber"));
		e.setDuration(Duration.between(LocalTime.MIDNIGHT, rs.getTime("duration").toLocalTime()));
		int episodeId = rs.getInt("id");
		e.setId(episodeId);
		return e;
	}

	public ArrayList<Episode> getBySeasonId(int seasonId) throws SQLException {
		selectBySeasonId.setInt(1, seasonId);
		ResultSet rs = selectBySeasonId.executeQuery();
		ArrayList<Episode> episodes = new ArrayList<Episode>();
		while (rs.next()) {
			Episode episode = getEpisode(rs);
			episodes.add(episode);
		}
		return episodes;
	}

	private Episode getEpisode(ResultSet rs) throws SQLException {
		Episode e = new Episode();
		e.setName(rs.getString("name"));
		e.setReleaseDate(rs.getDate("releaseDate").toLocalDate());
		e.setEpisodeNumber(rs.getInt("episodeNumber"));
		e.setDuration(Duration.between(LocalTime.MIDNIGHT, rs.getTime("duration").toLocalTime()));
		int episodeId = rs.getInt("id");
		e.setId(episodeId);
		return e;
	}

}
