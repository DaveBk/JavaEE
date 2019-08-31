package com.MPR.X.Manager;

import com.X.MPR.Domain.Episode;
import com.X.MPR.Domain.Season;
import com.X.MPR.Service.SeasonManager;

import org.junit.Test;

import java.sql.SQLException;
import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class SeasonManagerTest {
	
	  private SeasonManager seasonManager;
	    private static final int seasonNumber = 2;
	    private static final int yearOfRelease = 99;
	    private static final String episodeName = "M Jak Milosc";
	    private static final Duration episodeDuration = Duration.ofHours(2);
	    private static final LocalDate episodeReleaseDate = LocalDate.of(1111, 3, 3);
	    private static final int episodeNumber = 2;

	    public SeasonManagerTest() throws SQLException, ClassNotFoundException {
	        seasonManager = new SeasonManager();
	    }

	    @Test
	    public void itCorrectlyCreatesNewSeason() throws SQLException, ClassNotFoundException {
	        List<Episode> episodes = new ArrayList<Episode>();
	        Episode episode = new Episode();
	        episode.setName(episodeName);
	        episode.setEpisodeNumber(episodeNumber);
	        episode.setDuration(episodeDuration);
	        episode.setReleaseDate(episodeReleaseDate);
	        episodes.add(episode);
	        Season season = new Season();
	        season.setSeasonNumber(seasonNumber);
	        season.setYearOfRelease(yearOfRelease);
	        season.setEpisodes(episodes);

	        seasonManager.create(season);

	        Season lastSeason = seasonManager.getLast();

	        assertEquals(lastSeason.getSeasonNumber(), seasonNumber);
	        assertEquals(lastSeason.getYearOfRelease(), yearOfRelease);

	        for (Episode ep : season.getEpisodes()) {
	            assertEquals(ep.getName(), episodeName);
	            assertEquals(ep.getDuration(), episodeDuration);
	            assertEquals(ep.getReleaseDate(), episodeReleaseDate);
	            assertEquals(ep.getEpisodeNumber(), episodeNumber);
	        }
	    }

	    @Test
	    public void itCorrectlyReturnsSeasons() throws SQLException, ClassNotFoundException {
	        assertNotNull(seasonManager.getSeasons());
	    }

}
