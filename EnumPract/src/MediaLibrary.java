//package com.gradescope.medialibrary;
import java.util.ArrayList;

public class MediaLibrary {
	private ArrayList<Media> MediaCollection = new ArrayList<Media>();
	
	public void addMedia(Media media) {
		MediaCollection.add(media);
	}
	
	public Media getMedia(String title) {
		for(Media media : MediaCollection) {
			if(media.getTitle().equals(title)) {
				return media;
			}
		}
		return null;
	}
	
	public String toString() {
		String allMedia = "";
		for(Media media : MediaCollection) {
			allMedia += media.toString() + "\n";
		}
		
		return allMedia.trim();
	}
}
