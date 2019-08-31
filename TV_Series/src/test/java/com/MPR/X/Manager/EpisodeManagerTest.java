package com.MPR.X.Manager;

import com.X.MPR.Domain.Episode;
import com.X.MPR.Service.EpisodeManager;

import org.junit.Test;

import java.sql.SQLException;
import java.time.Duration;
import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

public class EpisodeManagerTest {

	  private EpisodeManager episodeManager;
	    private static final String episodeName = "Michal";
	    private static final LocalDate episodeReleaseDate = LocalDate.of(2211, 11, 2);
	    private static final int episodeNumber = 2;
	    private static final Duration episodeDuration = Duration.ofHours(1);


	    public EpisodeManagerTest() throws SQLException, ClassNotFoundException {
	        episodeManager = new EpisodeManager();
	    }

	    @Test
	    public void itCorrectlyCreatesNewEpisode() throws SQLException, ClassNotFoundException {
	        Episode episode = new Episode();
	        episode.setName(episodeName);
	        episode.setReleaseDate(episodeReleaseDate);
	        episode.setEpisodeNumber(episodeNumber);
	        episode.setDuration(episodeDuration);
	        episodeManager.create(episode);

	        Episode lastEpisode = episodeManager.getLast();

	        assertEquals(lastEpisode.getName(), episodeName);
	        assertEquals(lastEpisode.getReleaseDate(), episodeReleaseDate);
	        assertEquals(lastEpisode.getEpisodeNumber(), episodeNumber);
	        assertEquals(lastEpisode.getDuration(), episodeDuration);
	    }

	    @Test
	    public void itCorrectlyGetListOfEpisodes() throws SQLException, ClassNotFoundException {
	        List<Episode> episodes = episodeManager.getEpisodes();

	        assertNotNull(episodes);
	    }
}
