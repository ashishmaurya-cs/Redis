package com.ashish.entities;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ashish_note")
public class Notes implements Serializable{
	@Id
	 private String id;
	 private String title;
	 private String content;
	 private boolean live=false;
	public Notes(String id, String title, String content, boolean live) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.live = live;
	}
	 
	public Notes () {
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public boolean isLive() {
		return live;
	}

	public void setLive(boolean live) {
		this.live = live;
	}
	
	
	 
}
