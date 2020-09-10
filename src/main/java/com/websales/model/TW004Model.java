package com.websales.model;

import java.io.Serializable;

public class TW004Model implements Serializable {
	public TW004Model(String id, String typeQuestion) {
		super();
		this.id = id;
		this.typeQuestion = typeQuestion;
	}

	public TW004Model() {
	};

	private static final long serialVersionUID = 1L;

	private String id;

	private String typeQuestion;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTypeQuestion() {
		return typeQuestion;
	}

	public void setTypeQuestion(String typeQuestion) {
		this.typeQuestion = typeQuestion;
	}

}