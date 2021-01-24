package com.myexperiments.ward;

import java.io.Serializable;
import java.util.LinkedList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

// change
@Entity
@Table(name = "book")
public class Book implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5068990239464021287L;

	int idBook;
	String Title;
	String Author;
	String FileName;
	Date Date;
	Date PostingDate;
	Date ReleaseDate;
	String Path;
	String EtextNumber;
	String Source;
	String Host;
	String Ext;
	String Language;
	boolean Verified = false;
	boolean ParsedUIMA = false;
	boolean Fix;
	int UIMAref;
	int Neo4Jref;

	public boolean isParsedUIMA() {
		return ParsedUIMA;
	}

	public void setParsedUIMA(boolean parsedUIMA) {
		this.ParsedUIMA = parsedUIMA;
	}

	public int getUIMAref() {
		return UIMAref;
	}

	public void setUIMAref(int uIMAref) {
		UIMAref = uIMAref;
	}

	public int getNeo4Jref() {
		return Neo4Jref;
	}

	public void setNeo4Jref(int neo4Jref) {
		Neo4Jref = neo4Jref;
	}

	private String Fix(String line) {
		return line + System.getProperty("line.separator");
	}

	public String toString() {
		String result = Fix(Integer.toString(idBook));
		result += "Title  " + Fix(Title);
		result += "Author  " + Fix(Author);
		result += "Date  " + Fix(Date.toString());
		result += "Posting Date " + Fix(PostingDate.toString());
		result += "Release Date " + Fix(ReleaseDate.toString());
		result += "Filename  " + Fix(FileName);
		result += "Path  " + Fix(Path);
		result += "EtextNumber  " + Fix(EtextNumber);
		result += "Source  " + Fix(Source);
		result += "Name  " + Fix(FileName);
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
		return Title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.Title = title;
	}

	/**
	 * @return the author
	 */
	public String getAuthor() {
		return Author;
	}

	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.Author = author;
	}

	/**
	 * @return the date
	 */
	public java.sql.Date getDate() {
		return Date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(java.sql.Date date) {
		this.Date = date;
	}

	/**
	 * @return the text
	 */

	/**
	 * @return the filename
	 */
	public String getFilename() {
		return FileName;
	}

	/**
	 * @param filename the filename to set
	 */
	public void setFilename(String filename) {
		this.FileName = filename;
	}

	/**
	 * @return the path
	 */
	public String getPath() {
		return Path;
	}

	/**
	 * @param path the path to set
	 */
	public void setPath(String path) {
		this.Path = path;
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
		return Source;
	}

	/**
	 * @param source the source to set
	 */
	public void setSource(String source) {
		this.Source = source;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return FileName;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.FileName = name;
	}

	/**
	 * @return the verified
	 */
	public boolean isVerified() {
		return Verified;
	}

	/**
	 * @param verified the verified to set
	 */
	public void setVerified(boolean verified) {
		this.Verified = verified;
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

	public java.sql.Date getPostingDate() {
		return PostingDate;
	}

	public void setPostingDate(java.sql.Date postingDate) {
		PostingDate = postingDate;
	}

	public java.sql.Date getReleaseDate() {
		return ReleaseDate;
	}

	public void setReleaseDate(java.sql.Date releaseDate) {
		ReleaseDate = releaseDate;
	}

	public String getLanguage() {
		return Language;
	}

	public void setLanguage(String language) {
		this.Language = language;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	boolean parsed = false;

}
