//package com.gradescope.medialibrary;
public class TVShow extends Media{
	public TVShow(String title, Genre genre) {
		this.title = title;
		this.genre = genre;
	}
	
	public MediaType getMediaType() {
		return MediaType.TVSHOW;
	}
	
}
