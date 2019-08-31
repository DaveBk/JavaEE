package com.X.MPR.Service.mapper;

import com.X.MPR.Domain.Season;
import com.X.MPR.Domain.Episode;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SeasonMapper {

	private PreparedStatement addSeasonStmt;
	private PreparedStatement deleteAllSeasonStmt;
	private PreparedStatement getAllSeasonsStmt;
	private PreparedStatement selectById;
	private PreparedStatement selectByTvSeriesId;
	private Connection connection;

	public SeasonMapper(Connection connection) {
		this.connection = connection;
		try {
			addSeasonStmt = connection.prepareStatement(
					"INSERT INTO seasons (seasonNumber, yearOfRelease) VALUES (?, ?)");
			deleteAllSeasonStmt = connection.prepareStatement("DELETE FROM seasons");
			getAllSeasonsStmt = connection.prepareStatement("SELECT * FROM seasons");
			selectById = connection.prepareStatement("Select * from seasons where id=?");
			selectByTvSeriesId = connection.prepareStatement("Select * from seasons where tvseriesid=?");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	Connection getConnection() {
		return connection;
	}

	public ArrayList<Season> getById(int Id) throws SQLException {
		selectById.setInt(1, Id);
		ResultSet rs = selectById.executeQuery();
		ArrayList<Season> seasons = new ArrayList<Season>();

		while (rs.next()) {
			Season season = getSeasonById(rs);
			seasons.add(season);
		}
		return seasons;
	}

	private Season getSeasonById(ResultSet rs) throws SQLException {

		Season s = new Season();
		s.setSeasonNumber(rs.getInt("seasonNumber"));
		s.setYearOfRelease(rs.getInt("yearOfRlease"));
		int seasonId = rs.getInt("id");
		s.setId(seasonId);
		EpisodeMapper episodeMapper = new EpisodeMapper(connection);
		ArrayList<Episode> episodes = episodeMapper.getBySeasonId(seasonId);
		s.setEpisodes(episodes);

		return s;
	}

	public ArrayList<Season> getByTvSeriesId(int tvSeriesId) throws SQLException {
		selectByTvSeriesId.setInt(1, tvSeriesId);
		ResultSet rs = selectByTvSeriesId.executeQuery();
		ArrayList<Season> seasons = new ArrayList<Season>();

		while (rs.next()) {
			Season season = getSeason(rs);
			seasons.add(season);
		}
		return seasons;
	}

	private Season getSeason(ResultSet rs) throws SQLException {

		Season s = new Season();
		s.setSeasonNumber(rs.getInt("seasonNumber"));

		s.setYearOfRelease(rs.getInt("yearOfRlease"));
		int seasonId = rs.getInt("id");
		s.setId(seasonId);
		EpisodeMapper episodeMapper = new EpisodeMapper(connection);
		ArrayList<Episode> episodes = episodeMapper.getBySeasonId(seasonId);
		s.setEpisodes(episodes);

		return s;
	}


	public List<Season> getAll() {
		List<Season> seasons = new ArrayList<Season>();

		try {
			ResultSet rs = getAllSeasonsStmt.executeQuery();

			while (rs.next()) {
				Season season = getSeason(rs);
				seasons.add(season);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return seasons;
	}

	public void add(ArrayList<Season> seasons, int tvSeriesID) {
		for (Season season : seasons) {
			addSeason(season, tvSeriesID);
		}
	}



	private void addSeason(Season season, int tvSeriesID) {
		// TODO Auto-generated method stub

	}

	public void remove(Season entity) {
		try {
			deleteAllSeasonStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
