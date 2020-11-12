package com.JS.Bean;

public class Song {
	private String id;
	private String song_name;
	private String singer_name;
	private String song_duration;  //≤•∑≈ ±≥§
	private String song_size;
	private String song_path;


	public Song()
	{
		
	}
	public Song(String song_name, String singer_name, String song_duration, String song_size, String song_path) {
		super();
		this.song_name = song_name;
		this.singer_name = singer_name;
		this.song_duration = song_duration;
		this.song_size = song_size;
		this.song_path = song_path;
	}

	public Song(String id, String song_name, String singer_name) {
		super();
		this.id = id;
		this.song_name = song_name;
		this.singer_name = singer_name;
	}

	public Song(String id, String song_name, String singer_name, String song_duration, String song_size,
			String song_path) {
		super();
		this.id = id;
		this.song_name = song_name;
		this.singer_name = singer_name;
		this.song_duration = song_duration;
		this.song_size = song_size;
		this.song_path = song_path;
	}

	public String getSong_path() {
		return song_path;
	}

	public void setSong_path(String song_path) {
		this.song_path = song_path;
	}

	public String getSong_duration() {
		return song_duration;
	}

	public void setSong_duration(String song_duration) {
		this.song_duration = song_duration;
	}

	public String getSong_size() {
		return song_size;
	}

	public void setSong_size(String song_size) {
		this.song_size = song_size;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSong_name() {
		return song_name;
	}

	public void setSong_name(String song_name) {
		this.song_name = song_name;
	}

	public String getSinger_name() {
		return singer_name;
	}

	public void setSinger_name(String singer_name) {
		this.singer_name = singer_name;
	}

}
