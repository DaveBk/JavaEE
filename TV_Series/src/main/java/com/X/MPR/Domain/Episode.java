package com.X.MPR.Domain;

import java.time.Duration;
import java.time.LocalDate;

public class Episode extends Entity {
	 private String name;
	    private LocalDate releaseDate;
	    private int episodeNumber;
	    private Duration duration;

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public LocalDate getReleaseDate() {
	        return releaseDate;
	    }

	    public void setReleaseDate(LocalDate releaseDate) {
	        this.releaseDate = releaseDate;
	    }

	    public int getEpisodeNumber() {
	        return episodeNumber;
	    }

	    public void setEpisodeNumber(int episodeNumber) {
	        this.episodeNumber = episodeNumber;
	    }

	    public Duration getDuration() {
	        return duration;
	    }

	    public void setDuration(Duration duration) {
	        this.duration = duration;
	    }

	    @Override
	    public String toString() {
	        return "{ id: " + getId() + ", name: " + getName() + ", releaseDate: " + getReleaseDate().toString() + ", episodeNumber: " + getEpisodeNumber() + ", duration: " + getDuration().toString() + " }";
	    }
}
