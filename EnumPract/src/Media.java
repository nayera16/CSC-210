//package com.gradescope.medialibrary;
public abstract class Media {
	protected String title;
	public enum Genre{ SCIFI, COMEDY, ROMCOM, ACTION, HORROR };
	public Genre genre;
	protected enum MediaType{ MOVIE, TVSHOW };
	
	public String getTitle() {
		return title;
	}
	
	public abstract MediaType getMediaType();
	
	public String toString() {
		
		MediaType thisType = getMediaType();
		switch(thisType) {
		case MOVIE:
			return "Movie title: " + getTitle();
		case TVSHOW:
			return "Show title: " + getTitle();
		default:
			return null;
		}
	}
	
}
