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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

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
	boolean image;
	long CRC;
	long Size;
	int UIMAref;
	int Neo4Jref;
	boolean parsed = false;

	/**
	 * @return the author
	 */
	public String getAuthor() {
		return Author;
	}

	public long getCRC() {
		return CRC;
	}

	/**
	 * @return the date
	 */
	public java.sql.Date getDate() {
		return Date;
	}

	/**
	 * @return the etextNumber
	 */
	public String getEtextNumber() {
		return EtextNumber;
	}

	public String getExt() {
		return Ext;
	}

	/**
	 * @return the filename
	 */
	public String getFilename() {
		return FileName;
	}

	public String getFileName() {
		return FileName;
	}

	public String getHost() {
		return Host;
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

	public int getIdBook() {
		return idBook;
	}

	public String getLanguage() {
		return Language;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return FileName;
	}

	public int getNeo4Jref() {
		return Neo4Jref;
	}

	/**
	 * @return the path
	 */
	public String getPath() {
		return Path;
	}

	public java.sql.Date getPostingDate() {
		return PostingDate;
	}

	public java.sql.Date getReleaseDate() {
		return ReleaseDate;
	}

	public long getSize() {
		return Size;
	}

	/**
	 * @return the source
	 */
	public String getSource() {
		return Source;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return Title;
	}

	public int getUIMAref() {
		return UIMAref;
	}

	public boolean isFix() {
		return Fix;
	}

	public boolean isImage() {
		return image;
	}

	/**
	 * @return the parsed
	 */
	public boolean isParsed() {
		return parsed;
	}

	public boolean isParsedUIMA() {
		return ParsedUIMA;
	}

	/**
	 * @return the verified
	 */
	public boolean isVerified() {
		return Verified;
	}

	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.Author = author;
	}

	public void setCRC(long cRC) {
		CRC = cRC;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(java.sql.Date date) {
		this.Date = date;
	}

	/**
	 * @param etextNumber the etextNumber to set
	 */
	public void setEtextNumber(String etextNumber) {
		EtextNumber = etextNumber;
	}

	/**
	 * @return the text
	 */

	public void setExt(String ext) {
		Ext = ext;
	}

	/**
	 * @param filename the filename to set
	 */
	public void setFilename(String filename) {
		this.FileName = filename;
	}

	public void setFileName(String fileName) {
		FileName = fileName;
	}

	public void setFix(boolean fix) {
		Fix = fix;
	}

	public void setHost(String host) {
		Host = host;
	}

	/**
	 * @param idBook the idBook to set
	 */
	public void setidBook(int idBook) {
		this.idBook = idBook;
	}

	public void setIdBook(int idBook) {
		this.idBook = idBook;
	}

	public void setImage(boolean image) {
		this.image = image;
	}

	public void setLanguage(String language) {
		this.Language = language;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.FileName = name;
	}

	public void setNeo4Jref(int neo4Jref) {
		Neo4Jref = neo4Jref;
	}

	/**
	 * @param parsed the parsed to set
	 */
	public void setParsed(boolean parsed) {
		this.parsed = parsed;
	}

	public void setParsedUIMA(boolean parsedUIMA) {
		this.ParsedUIMA = parsedUIMA;
	}

	/**
	 * @param path the path to set
	 */
	public void setPath(String path) {
		this.Path = path;
	}

	public void setPostingDate(java.sql.Date postingDate) {
		PostingDate = postingDate;
	}

	public void setReleaseDate(java.sql.Date releaseDate) {
		ReleaseDate = releaseDate;
	}

	public void setSize(long size) {
		Size = size;
	}

	/**
	 * @param source the source to set
	 */
	public void setSource(String source) {
		this.Source = source;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.Title = title;
	}

	public void setUIMAref(int uIMAref) {
		UIMAref = uIMAref;
	}

	/**
	 * @param verified the verified to set
	 */
	public void setVerified(boolean verified) {
		this.Verified = verified;
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

}
