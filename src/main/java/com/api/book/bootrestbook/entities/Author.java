package com.api.book.bootrestbook.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int author_id;
	private String first_name;
	private String last_name;
	private String language;

	@OneToOne(mappedBy = "author")
	@JsonBackReference
	private Book book;

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public int getAuthor_id() {
		return author_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public String getLanguage() {
		return language;
	}

	public void setAuthor_id(int author_id) {
		this.author_id = author_id;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public Author(int author_id, String first_name, String last_name, String language) {
		super();
		this.author_id = author_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.language = language;
	}

	public Author() {
		super();
		// TODO Auto-generated constructor stub
	}

}
