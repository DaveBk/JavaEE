package com.X.MPR.Domain;


import java.time.LocalDate;

public class Actor  extends Entity{
	
	 private String name;
	    private LocalDate dateOfBirth;
	    private String biography;

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public LocalDate getDateOfBirth() {
	        return dateOfBirth;
	    }

	    public void setDateOfBirth(LocalDate dateOfBirth) {
	        this.dateOfBirth = dateOfBirth;
	    }

	    public String getBiography() {
	        return biography;
	    }

	    public void setBiography(String biography) {
	        this.biography = biography;
	    }

	    @Override
	    public String toString() {
	        return "{ id: " + getId() + ", name: " + getName() + ", dateOfBirth: " + getDateOfBirth().toString() + ", biography: " + getBiography() + " }";
	    }

}
