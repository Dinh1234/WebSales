package com.websales.model;

import java.io.Serializable;
import java.util.Date;

/**
 * The persistent class for the subject database table.
 * 
 */
public class SubjectModel implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;

	private String name;

	public SubjectModel() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}