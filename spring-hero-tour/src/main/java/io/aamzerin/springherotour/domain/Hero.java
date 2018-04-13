package io.aamzerin.springherotour.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Hero {

	@Id
	String ref;

	Integer id;

	String name;

	public Hero() {
		super();
	}

	public Hero(String ref, Integer id, String name) {
		super();
		this.ref = ref;
		this.id = id;
		this.name = name;
	}

	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Hero [ref=" + ref + ", id=" + id + ", name=" + name + "]";
	}
}
