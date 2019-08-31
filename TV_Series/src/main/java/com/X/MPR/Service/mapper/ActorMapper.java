package com.X.MPR.Service.mapper;

import com.X.MPR.Domain.Actor;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

public class ActorMapper implements Mapper<Actor>{

	private PreparedStatement addActorStmt;
	private PreparedStatement deleteAllActorsStmt;
	private PreparedStatement getAllActorsStmt;
	private PreparedStatement selectById;
	private Connection connection;

	public ActorMapper(Connection connection) {
		this.connection = connection;
		try {
			addActorStmt = connection
					.prepareStatement("INSERT INTO actors (name, dateOfBirth, biography) VALUES (?, ?, ?)");
			deleteAllActorsStmt = connection.prepareStatement("DELETE FROM actors");
			getAllActorsStmt = connection.prepareStatement("SELECT * FROM actors");
			selectById = connection.prepareStatement("Select * from actors where id=?");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	Connection getConnection() {
		return connection;
	}


	public List<Actor> getAll() {

		List<Actor> actors = new ArrayList<Actor>();

		try {
			ResultSet rs = getAllActorsStmt.executeQuery();

			while (rs.next()) {
				Actor d = new Actor();
				d.setId(rs.getInt("id"));
				d.setName(rs.getString("name"));
				d.setDateOfBirth(rs.getDate("dateOfBirth").toLocalDate());
				d.setBiography(rs.getString("biography"));
				actors.add(d);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return actors;
	}

	public int add(Actor actor) {
		int count = 0;
		try {
			addActorStmt.setString(1, actor.getName());
			addActorStmt.setDate(2, Date.valueOf(actor.getDateOfBirth()));
			addActorStmt.setString(3, actor.getBiography());

			count = addActorStmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
	public ArrayList<Actor> getById(int Id) throws SQLException {
		selectById.setInt(1, Id);
		ResultSet rs = selectById.executeQuery();
		ArrayList<Actor> actors = new ArrayList<Actor>();
		while (rs.next()) {
			Actor actor = getActor(rs);
			actors.add(actor);
		}
		return actors;
	}

	private Actor getActor(ResultSet rs) throws SQLException {
		Actor a = new Actor();
		a.setId(rs.getInt("id"));
		a.setName(rs.getString("name"));
		a.setDateOfBirth(rs.getDate("dateOfBirth").toLocalDate());
		a.setBiography(rs.getString("biography"));
		int actorId = rs.getInt("id");
		a.setId(actorId);
		return a;
	}

	public void remove(Actor entity) {
		try {
			deleteAllActorsStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}





}
