package com.myexperiments.ward;

import java.io.Serializable;
import java.util.LinkedList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "book")
public class Book implements Serializable {
	/**
	 * 
	 */
	private static long serialVersionUID = -5068990239464021287L;

	int idBook;
	String title;
	String author;
	Date date;

	Date postingdate;
	Date releasedate;
	String text;
	String filebase;
	String filename;
	String path;
	String etextnumber;
	String source;
	String name;
	String language;
	String translatedby;
	boolean verified = false;
	boolean parseduima = false;
	boolean parsedneo4j;
	String neo4jref;

	public int getIdBook() {
		return idBook;
	}

	public void setIdBook(int idBook) {
		this.idBook = idBook;
	}

	public String getFilebase() {
		return filebase;
	}

	public void setFilebase(String filebase) {
		this.filebase = filebase;
	}

	public static void setSerialversionuid(long serialversionuid) {
		serialVersionUID = serialversionuid;
	}

	public String getNeo4Jref() {
		return neo4jref;
	}

	public void setNeo4Jref(String neo4Jref) {
		neo4jref = neo4Jref;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public static void setSerialVersionUID(long serialVersionUID) {
		Book.serialVersionUID = serialVersionUID;
	}

	public Date getPostingdate() {
		return postingdate;
	}

	public void setPostingdate(Date postingdate) {
		this.postingdate = postingdate;
	}

	public Date getReleasedate() {
		return releasedate;
	}

	public void setReleasedate(Date releasedate) {
		this.releasedate = releasedate;
	}

	public boolean isParseduima() {
		return parseduima;
	}

	public void setParseduima(boolean parseduima) {
		this.parseduima = parseduima;
	}

	public boolean isParsedneo4j() {
		return parsedneo4j;
	}

	public void setParsedneo4j(boolean parsedneo4j) {
		this.parsedneo4j = parsedneo4j;
	}

	public String getNeo4jref() {
		return neo4jref;
	}

	public void setNeo4jref(String neo4jref) {
		this.neo4jref = neo4jref;
	}

	private String Fix(String line) {
		return line + System.getProperty("line.separator");
	}

	public String toString() {
		String result = Fix(Integer.toString(idBook));
		result += "Title  " + Fix(title);
		result += "Author  " + Fix(author);
		result += "Translatedby " + Fix(translatedby);
		result += "Date  " + Fix(date.toString());
		result += "Posting Date " + Fix(postingdate.toString());
		result += "Release Date " + Fix(releasedate.toString());
		result += "Text  " + Fix(text);
		result += "Filename  " + Fix(filename);
		result += "Path  " + Fix(path);
		result += "etextNumber  " + Fix(etextnumber);
		result += "Source  " + Fix(source);
		result += "Name  " + Fix(name);
		return result;
	}

	/**
	 * @return the idBook
	 */
	@Id
	@Column(name = "idBook")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getidBook() {
		return idBook;
	}

	/**
	 * @param idBook the idBook to set
	 */
	public void setidBook(int idBook) {
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
	public Date getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
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
		return etextnumber;
	}

	/**
	 * @param etextNumber the etextNumber to set
	 */
	public void setEtextNumber(String etextNumber) {
		etextnumber = etextNumber;
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

	public Date getPostingDate() {
		return postingdate;
	}

	public Date getReleaseDate() {
		return releasedate;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getTranslatedby() {
		return translatedby;
	}

	public void setTranslatedby(String translatedby) {
		translatedby = translatedby;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	boolean parsed = false;

}
