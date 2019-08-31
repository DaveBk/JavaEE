package com.MPR.X.Manager;

import com.X.MPR.Domain.Director;
import com.X.MPR.Service.DirectorManager;

import org.junit.Test;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;


public class DirectorManagerTest {
	
	private DirectorManager directorManager;
    private static final String directorName = "Adam";
    private static final LocalDate directorDateOfBirth = LocalDate.of(1222,11, 21);
    private static final String directorBiography = "Bio";

    public DirectorManagerTest() throws SQLException, ClassNotFoundException
    {
        directorManager = new DirectorManager();
    }

    @Test
    public void itCorrectlyCreatesNewDirector() throws SQLException, ClassNotFoundException {
        Director director = new Director();
        director.setName(directorName);
        director.setDateOfBirth(directorDateOfBirth);
        director.setBiography(directorBiography);
        directorManager.create(director);

        Director lastDirector = directorManager.getLast();

        assertEquals(lastDirector.getName(), directorName);
        assertEquals(lastDirector.getDateOfBirth(), directorDateOfBirth);
        assertEquals(lastDirector.getBiography(), directorBiography);
    }

    @Test
    public void itCorrectlyReturnsAllActors() throws SQLException, ClassNotFoundException
    {
        List<Director> directors = directorManager.getDirectors();
        assertNotNull(directors);
    }

}
