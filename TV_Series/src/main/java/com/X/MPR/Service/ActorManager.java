package com.X.MPR.Service;

import com.X.MPR.DBConn;
import com.X.MPR.Domain.Actor;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;






public class ActorManager {

	 public ActorManager() throws SQLException, ClassNotFoundException {
	        DBConn.getStatementInstance().executeUpdate("CREATE TABLE IF NOT EXISTS actors (id int(11) PRIMARY KEY AUTO_INCREMENT, name VARCHAR(255) NOT NULL, dateOfBirth DATE NOT NULL, biography TEXT) ");
	    }

	    public void create(Actor actor) throws SQLException, ClassNotFoundException {
	        PreparedStatement stmt = DBConn.getConnectionInstance().prepareStatement("INSERT INTO actors (name, dateOfBirth, biography) VALUES (?, ?, ?)");
	        stmt.setString(1, actor.getName());
	        stmt.setDate(2, Date.valueOf(actor.getDateOfBirth()));
	        stmt.setString(3, actor.getBiography());
	        stmt.executeUpdate();
	    }


	    public Actor getLast() throws SQLException, ClassNotFoundException {
	        ResultSet rs = DBConn.getStatementInstance().executeQuery("SELECT * FROM actors ORDER BY id DESC LIMIT 1");
	        Actor a = new Actor();
	        if(rs.next()) {
	            a.setId(rs.getInt("id"));
	            a.setName(rs.getString("name"));
	            a.setDateOfBirth(rs.getDate("dateOfBirth").toLocalDate());
	            a.setBiography(rs.getString("biography"));
	        }
	        return a;
	    }


	    public List<Actor> getActors() throws SQLException, ClassNotFoundException {
	        List<Actor> list = new ArrayList<Actor>();
	        ResultSet rs = DBConn.getStatementInstance().executeQuery("SELECT * FROM actors");

	        while(rs.next()) {
	            Actor a = new Actor();
	            a.setId(rs.getInt("id"));
	            a.setName(rs.getString("name"));
	            a.setDateOfBirth(rs.getDate("dateOfBirth").toLocalDate());
	            a.setBiography(rs.getString("biography"));
	            list.add(a);
	        }

	        return list;
	    }

}
