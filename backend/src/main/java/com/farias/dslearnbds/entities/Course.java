package com.farias.dslearnbds.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="tb_course")
public class Course implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String imgUri;
	private String imgGrayUri;
	
	@OneToMany(mappedBy = "course")
	List<Offer> offers = new ArrayList<>();
	
	public Course() {
		super();
	}

	public Course(Long id, String name, String imgUri, String imgGrayUri) {
		super();
		this.id = id;
		this.name = name;
		this.imgUri = imgUri;
		this.imgGrayUri = imgGrayUri;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImgUri() {
		return imgUri;
	}

	public void setImgUri(String imgUri) {
		this.imgUri = imgUri;
	}

	public String getImgGrayUri() {
		return imgGrayUri;
	}

	public void setImgGrayUri(String imgGrayUri) {
		this.imgGrayUri = imgGrayUri;
	}

	public List<Offer> getOffers() {
		return offers;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((imgGrayUri == null) ? 0 : imgGrayUri.hashCode());
		result = prime * result + ((imgUri == null) ? 0 : imgUri.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (imgGrayUri == null) {
			if (other.imgGrayUri != null)
				return false;
		} else if (!imgGrayUri.equals(other.imgGrayUri))
			return false;
		if (imgUri == null) {
			if (other.imgUri != null)
				return false;
		} else if (!imgUri.equals(other.imgUri))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", imgUri=" + imgUri + ", imgGrayUri=" + imgGrayUri + "]";
	}
	
	
	
}
