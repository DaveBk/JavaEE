package com.X.MPR.Domain;

import java.util.List;



public class Season extends Entity{
	private int seasonNumber;
    private int yearOfRelease;
    private List<Episode> episodes;

    public int getSeasonNumber() {
        return seasonNumber;
    }

    public void setSeasonNumber(int seasonNumber) {
        this.seasonNumber = seasonNumber;
    }

    public int getYearOfRelease() {
        return yearOfRelease;
    }

    public void setYearOfRelease(int yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    public List<Episode> getEpisodes() {
        return episodes;
    }

    public void setEpisodes(List<Episode> episodes) {
        this.episodes = episodes;
    }

    @Override
    public String toString() {
        return "{ id: "+ getId() +", seasonNumber: "+ getSeasonNumber() +", yearOfRelease: "+ getYearOfRelease() +", episodes: "+ getEpisodes() +" }";
    }
}
