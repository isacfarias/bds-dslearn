package com.farias.dslearnbds.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="tb_content")
public class Content extends Lesson implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String textContent;
	private String videoUri;
	
	public Content() {
		super();
	}


	public Content(Long id, String title, Integer position, Section section, String textContent, String videoUri) {
		super(id, title, position, section);
		this.textContent = textContent;
		this.videoUri = videoUri;
	}


	public String getTextContent() {
		return textContent;
	}


	public void setTextContent(String textContent) {
		this.textContent = textContent;
	}


	public String getVideoUri() {
		return videoUri;
	}


	public void setVideoUri(String videoUri) {
		this.videoUri = videoUri;
	}


	@Override
	public String toString() {
		return "Content [textContent=" + textContent + ", videoUri=" + videoUri + "]";
	}
	
}
