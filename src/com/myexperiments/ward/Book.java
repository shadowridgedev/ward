package com.myexperiments.ward;

import java.io.Serializable;
import java.util.LinkedList;

public class Book implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5068990239464021287L;

	int idBook;
	String title;
	String author;
	String date;
	String PostingDate;
	String ReleaseDate;
	String text;
	LinkedList<?> extra;
	String filename;
	String path;
	String EtextNumber;
	String source;
	String name;

	public boolean isParsedUIMA() {
		return parsedUIMA;
	}

	public void setParsedUIMA(boolean parsedUIMA) {
		this.parsedUIMA = parsedUIMA;
	}

	public String getUIMAref() {
		return UIMAref;
	}

	public void setUIMAref(String uIMAref) {
		UIMAref = uIMAref;
	}

	public String getNeo4Jref() {
		return Neo4Jref;
	}

	public void setNeo4Jref(String neo4Jref) {
		Neo4Jref = neo4Jref;
	}

	public LinkedList<?> getExtra() {
		return extra;
	}

	String language;
	String Translatedby;
	boolean verified = false;
	boolean parsedUIMA = false;
	String UIMAref;
	String Neo4Jref;

	private String Fix(String line) {
		return line + System.getProperty("line.separator");
	}

	public String toString() {
		String result = Fix(Integer.toString(idBook));
		result += "Title  " + Fix(title);
		result += "Author  " + Fix(author);
		result += "Translatedby " + Fix(Translatedby);
		result += "Date  " + Fix(date);
		result += "Posting Date " + Fix(PostingDate);
		result += "Release Date " + Fix(ReleaseDate);
		result += "Text  " + Fix(text);
		result += "Filename  " + Fix(filename);
		result += "Path  " + Fix(path);
		result += "EtextNumber  " + Fix(EtextNumber);
		result += "Source  " + Fix(source);
		result += "Name  " + Fix(name);
		return result;
	}

	/**
	 * @return the idBook
	 */
	public int getIdBook() {
		return idBook;
	}

	/**
	 * @param idBook the idBook to set
	 */
	public void setIdBook(int idBook) {
		this.idBook = idBook;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * @return the filename
	 */
	public String getFilename() {
		return filename;
	}

	/**
	 * @param filename the filename to set
	 */
	public void setFilename(String filename) {
		this.filename = filename;
	}

	/**
	 * @return the path
	 */
	public String getPath() {
		return path;
	}

	/**
	 * @param path the path to set
	 */
	public void setPath(String path) {
		this.path = path;
	}

	/**
	 * @return the etextNumber
	 */
	public String getEtextNumber() {
		return EtextNumber;
	}

	/**
	 * @param etextNumber the etextNumber to set
	 */
	public void setEtextNumber(String etextNumber) {
		EtextNumber = etextNumber;
	}

	/**
	 * @return the source
	 */
	public String getSource() {
		return source;
	}

	/**
	 * @param source the source to set
	 */
	public void setSource(String source) {
		this.source = source;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the verified
	 */
	public boolean isVerified() {
		return verified;
	}

	/**
	 * @param verified the verified to set
	 */
	public void setVerified(boolean verified) {
		this.verified = verified;
	}

	/**
	 * @return the parsed
	 */
	public boolean isParsed() {
		return parsed;
	}

	/**
	 * @param parsed the parsed to set
	 */
	public void setParsed(boolean parsed) {
		this.parsed = parsed;
	}

	public String getPostingDate() {
		return PostingDate;
	}

	public void setPostingDate(String postingDate) {
		PostingDate = postingDate;
	}

	public String getReleaseDate() {
		return ReleaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		ReleaseDate = releaseDate;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getTranslatedby() {
		return Translatedby;
	}

	public void setTranslatedby(String translatedby) {
		Translatedby = translatedby;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setExtra(LinkedList<?> extra) {
		this.extra = extra;
	}

	boolean parsed = false;

}
