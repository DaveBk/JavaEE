package com.X.MPR.Service;

import com.X.MPR.DBConn;

import com.X.MPR.Domain.Director;




import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DirectorManager {

	public DirectorManager() throws SQLException, ClassNotFoundException {
		DBConn.getStatementInstance().executeUpdate("CREATE TABLE IF NOT EXISTS directors (id int(11) PRIMARY KEY AUTO_INCREMENT, name VARCHAR(255) NOT NULL, dateOfBirth DATE NOT NULL, biography TEXT) ");
    }

    
    public void create(Director director) throws SQLException, ClassNotFoundException {
        PreparedStatement stmt = DBConn.getConnectionInstance().prepareStatement("INSERT INTO directors (name, dateOfBirth, biography) VALUES (?, ?, ?)");
        stmt.setString(1, director.getName());
        stmt.setDate(2, Date.valueOf(director.getDateOfBirth()));
        stmt.setString(3, director.getBiography());
        stmt.executeUpdate();
    }

    
    public List<Director> getDirectors() throws SQLException, ClassNotFoundException {
        List<Director> list = new ArrayList<Director>();
        ResultSet rs = DBConn.getStatementInstance().executeQuery("SELECT * FROM directors");

        while(rs.next()) {
            Director a = new Director();
            a.setId(rs.getInt("id"));
            a.setName(rs.getString("name"));
            a.setDateOfBirth(rs.getDate("dateOfBirth").toLocalDate());
            a.setBiography(rs.getString("biography"));
            list.add(a);
        }

        return list;
    }

   
    public Director getLast() throws SQLException, ClassNotFoundException {
        ResultSet rs = DBConn.getStatementInstance().executeQuery("SELECT * FROM directors ORDER BY id DESC LIMIT 1");
        Director director = new Director();

        if (rs.next()) {
            director.setId(rs.getInt("id"));
            director.setName(rs.getString("name"));
            director.setDateOfBirth(rs.getDate("dateOfBirth").toLocalDate());
            director.setBiography(rs.getString("biography"));
        }
        return director;
    }
}
