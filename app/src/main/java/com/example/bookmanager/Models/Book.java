package com.example.bookmanager.Models;

public class Book {
	private int id;
	private String name;
	private String author;
	private int numberOdPages;
	private String imageUrl;
	private String shortDescription;
	private String longDescription;

	public Book(int id, String name, String author, int numberOdPages, String imageUrl, String shortDescription, String longDescription) {
		this.id = id;
		this.name = name;
		this.author = author;
		this.numberOdPages = numberOdPages;
		this.imageUrl = imageUrl;
		this.shortDescription = shortDescription;
		this.longDescription = longDescription;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getNumberOdPages() {
		return numberOdPages;
	}

	public void setNumberOdPages(int numberOdPages) {
		this.numberOdPages = numberOdPages;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getLongDescription() {
		return longDescription;
	}

	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
	}

	@Override
	public String toString() {
		return "Book{" +
				"id=" + id +
				", name='" + name + '\'' +
				", author='" + author + '\'' +
				", numberOdPages=" + numberOdPages +
				", imageUrl='" + imageUrl + '\'' +
				", shortDescription='" + shortDescription + '\'' +
				", longDescription='" + longDescription + '\'' +
				'}';
	}
}
