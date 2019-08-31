package com.X.MPR.Service.mapper;


import com.X.MPR.Domain.Director;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DirectorMapper implements Mapper<Director> {

	private PreparedStatement addDirectorStmt;
	private PreparedStatement deleteAllDirectorsStmt;
	private PreparedStatement getAllDirectorsStmt;
	private PreparedStatement selectById;
	private Connection connection;

	public DirectorMapper(Connection connection) {
		this.connection = connection;
		try {
			addDirectorStmt = connection
					.prepareStatement("INSERT INTO directors (name, dateOfBirth, biography) VALUES (?, ?, ?)");
			deleteAllDirectorsStmt = connection.prepareStatement("DELETE FROM directors ");
			getAllDirectorsStmt = connection.prepareStatement("SELECT * FROM directors ");
			selectById = connection.prepareStatement("Select * from episodes where id=?");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}



	public List<Director> getAll() {
		List<Director> Directors = new ArrayList<Director>();

		try {
			ResultSet rs = getAllDirectorsStmt.executeQuery();

			while (rs.next()) {
				Director d = new Director();
				d.setId(rs.getInt("id"));
				d.setName(rs.getString("name"));
				d.setDateOfBirth(rs.getDate("dateOfBirth").toLocalDate());
				d.setBiography(rs.getString("biography"));
				Directors.add(d);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Directors;
	}

	public int add(Director Director) {
		int count = 0;
		try {
			addDirectorStmt.setString(1, Director.getName());
			addDirectorStmt.setDate(2, Date.valueOf(Director.getDateOfBirth()));
			addDirectorStmt.setString(3, Director.getBiography());

			count = addDirectorStmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
	public ArrayList<Director> getById(int Id) throws SQLException {
		selectById.setInt(1, Id);
		ResultSet rs = selectById.executeQuery();
		ArrayList<Director> directors = new ArrayList<Director>();
		while (rs.next()) {
			Director director = getDirector(rs);
			directors.add(director);
		}
		return directors;
	}

	private Director getDirector(ResultSet rs) throws SQLException {
		Director d = new Director();
		d.setId(rs.getInt("id"));
        d.setName(rs.getString("name"));
        d.setDateOfBirth(rs.getDate("dateOfBirth").toLocalDate());
        d.setBiography(rs.getString("biography"));
		int directorId = rs.getInt("id");
		d.setId(directorId);
		return d;
	}



	public void remove(Director entity) {
		try {
			deleteAllDirectorsStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


}
