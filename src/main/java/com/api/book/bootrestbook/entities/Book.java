package com.api.book.bootrestbook.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="books")
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="book_id")
	private int  id;
	private String name;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Author author;
	
	public Book(int id, String name, Author author) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
	}
	

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Author getAuthor() {
		return author;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}


	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", author=" + author + "]";
	}

	
	
	
}
