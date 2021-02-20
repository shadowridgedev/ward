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
import java.sql.SQLException;
import java.sql.BatchUpdateException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import com.mysql.cj.jdbc.Driver;

// change
@Entity
@Table(name = "FileItem")
public class FileData implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5068990239464021287L;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	int idItem;

	String FileName;

	Date Date;

	String Path;

	String Host;

	String Source;

	String Ext;

	String Language;

	boolean Verified = false;

	boolean ParsedUIMA = false;
	boolean TooBig = false;

	boolean Fix;

	String CRC;
	long Size;
	int UIMAref;
	int Neo4Jref;
	boolean parsed = false;
	boolean audio;
	boolean text;
	boolean image;
	boolean video;

	public int getIdItem() {
		return idItem;
	}

	public void setIdItem(int idItem) {
		this.idItem = idItem;
	}

	public String getFileName() {
		return FileName;
	}

	public void setFileName(String fileName) {
		FileName = fileName;
	}

	public Date getDate() {
		return Date;
	}

	public void setDate(Date date) {
		Date = date;
	}

	public String getPath() {
		return Path;
	}

	public void setPath(String path) {
		Path = path;
	}

	public String getHost() {
		return Host;
	}

	public void setHost(String host) {
		Host = host;
	}

	public String getSource() {
		return Source;
	}

	public void setSource(String source) {
		Source = source;
	}

	public String getExt() {
		return Ext;
	}

	public void setExt(String ext) {
		Ext = ext;
	}

	public String getLanguage() {
		return Language;
	}

	public void setLanguage(String language) {
		Language = language;
	}

	public boolean isVerified() {
		return Verified;
	}

	public void setVerified(boolean verified) {
		Verified = verified;
	}

	public boolean isParsedUIMA() {
		return ParsedUIMA;
	}

	public void setParsedUIMA(boolean parsedUIMA) {
		ParsedUIMA = parsedUIMA;
	}

	public boolean isTooBig() {
		return TooBig;
	}

	public void setTooBig(boolean tooBig) {
		TooBig = tooBig;
	}

	public boolean isFix() {
		return Fix;
	}

	public void setFix(boolean fix) {
		Fix = fix;
	}

	public String getCRC() {
		return CRC;
	}

	public void setCRC(String cRC) {
		CRC = cRC;
	}

	public long getSize() {
		return Size;
	}

	public void setSize(long size) {
		Size = size;
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

	public boolean isParsed() {
		return parsed;
	}

	public void setParsed(boolean parsed) {
		this.parsed = parsed;
	}

	public boolean isAudio() {
		return audio;
	}

	public void setAudio(boolean audio) {
		this.audio = audio;
	}

	public boolean isText() {
		return text;
	}

	public void setText(boolean text) {
		this.text = text;
	}

	public boolean isImage() {
		return image;
	}

	public void setImage(boolean image) {
		this.image = image;
	}

	public boolean isVideo() {
		return video;
	}

	public void setVideo(boolean video) {
		this.video = video;
	}

	public String toString() {
		String result = "";
		/*
		 * String result = Fix(Integer.toString(idFileItem)); result += "Title  " +
		 * Fix(Title); result += "Author  " + Fix(Author); result += "Date  " +
		 * Fix(Date.toString()); result += "Posting Date " +
		 * Fix(PostingDate.toString()); result += "Release Date " +
		 * Fix(ReleaseDate.toString()); result += "Filename  " + Fix(FileName); result
		 * += "Path  " + Fix(Path); result += "EtextNumber  " + Fix(EtextNumber); result
		 * += "Source  " + Fix(Source); result += "Name  " + Fix(FileName);
		 */
		return result;
	}

	public void InsertFileData(FileData FileItem, Connection conn, String table) {
//System.out.println("Writimg records into the table...");
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String lExt = FileItem.Ext;
		String lFileName = FileItem.FileName;
		long lSize = FileItem.Size;
		String lPath = FileItem.Path;
		String lSource = "ASROCK";
		String lHost = "ASROCK";
		String lLanguage = "English";
		boolean lVerified = false;

		boolean lParsedUIMA = false;
		boolean lTooBig = false;
		long lUIMAref = 0;
		long lNeo4Jref = 0;
		boolean lparsed = false;

		boolean laudio = false;
		boolean ltext = false;
		boolean image = false;
		boolean lvideo = false;

		String lfilename = FileItem.getFileName();
		String lCRC64 = FileItem.getCRC();

		String sql = "INSERT  INTO " + table + " " + "( Path, Filename,  Source, Host, Ext, Size, CRC64 ) VALUES ( "
				+ fix(lPath) + fix(lfilename) + fix(lSource) + fix(lHost) + fix(lExt) + lSize + ", "
				+ fix(lCRC64).substring(0, fix(lCRC64).lastIndexOf(",")) + ")";

		try {
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			try {

				long l = 1000000000;

				stmt.executeUpdate(sql);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}

	}

	String fix(String field) {
		field = " '" + field + "',";
		return field;

	}

	void delay(long n) {
		System.gc();
		for (long i = 0; i < n; i++)
			;
		{

		}
	}

}
