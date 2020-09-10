package com.websales.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the category database table.
 * 
 */
@Embeddable
public class CategoryPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private String id;

	@Column(name="`KEY`")
	private String key;

	public CategoryPK() {
	}
	public String getId() {
		return this.id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getKey() {
		return this.key;
	}
	public void setKey(String key) {
		this.key = key;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof CategoryPK)) {
			return false;
		}
		CategoryPK castOther = (CategoryPK)other;
		return 
			this.id.equals(castOther.id)
			&& this.key.equals(castOther.key);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.id.hashCode();
		hash = hash * prime + this.key.hashCode();
		
		return hash;
	}
}