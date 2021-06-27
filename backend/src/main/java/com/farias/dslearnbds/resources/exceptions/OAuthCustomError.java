package com.farias.dslearnbds.resources.exceptions;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OAuthCustomError implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String error;
	
	@JsonProperty("error_description")
	private String errorDescripiton;
	
	public OAuthCustomError() {	}

	public OAuthCustomError(String error, String errorDescripiton) {
		super();
		this.error = error;
		this.errorDescripiton = errorDescripiton;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getErrorDescripiton() {
		return errorDescripiton;
	}

	public void setErrorDescripiton(String errorDescripiton) {
		this.errorDescripiton = errorDescripiton;
	}

}
