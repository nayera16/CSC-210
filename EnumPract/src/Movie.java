//package com.gradescope.medialibrary;
public class Movie extends Media{
	
	public Movie(String title, Genre genre) {
		this.title = title;
		this.genre = genre;
	}
	
	public MediaType getMediaType() {
		return MediaType.MOVIE;
	}

}
