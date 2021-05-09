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
import com.mysql.cj.protocol.Resultset;

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
	String AbsolutePath;
	String Host;
	String HostBase;
	String Source;
	String Ext;
	String Language;
	String CRC;
	long Size;
	long UIMAref;
	long Neo4Jref;

	boolean audio = false;
	boolean text = false;
	boolean image = false;
	boolean video = false;
	boolean Verified = false;
	boolean ParsedUIMA = false;
	boolean TooBig = false;
	boolean Fix = false;
	boolean Parsed = false;

	private boolean parsed;

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

	public void InsertFileData(FileData FileItem, Connection conn, String table, String source) {
//System.out.println("Writimg records into the table...");
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Long RecordID;
		String lExt = FileItem.Ext;
		String lFileName = FileItem.FileName;
		long lSize = FileItem.Size;
		String lPath = FileItem.Path;
		String lAbsolutePath = FileItem.AbsolutePath;
		String lSource = Source;
		String lHost = "ASROCK";
		String lHostBase = FileItem.HostBase;
		String FileText;
		String lLanguage = "English";
		boolean lVerified = false;
		boolean lParsedUIMA = false;
		boolean lTooBig = TooBig;
		long lUIMAref = UIMAref;
		long lNeo4Jref = Neo4Jref;
		boolean lparsed = Parsed;
		boolean laudio = audio;
		boolean ltext = text;
		boolean image = text;
		boolean lvideo = video;

		String lfilename = FileItem.getFileName();
		String lCRC64 = FileItem.getCRC();

		String sql = "INSERT  INTO " + table + " "
				+ "( Path, Filename,  Source, Host, HostBase, AbsolutePath, Ext, Size, CRC64 ) VALUES ("
				+ fixPath(lPath) + fixPath(lfilename) + fixPath(lSource) + lHost + fixPath(lHostBase)
				+ fixPath(lAbsolutePath) + fixPath(lExt) + lSize + "," + fixPath(lCRC64);
//		System.out.println(sql);
		sql = sql.substring(0, sql.length() - 2);
//		System.out.println(sql);
		sql = sql + ");";
//		System.out.println(sql);
		try {
			stmt.executeUpdate(sql);
		} catch

		(SQLException e) {
			try {

				long l = 1000000000;

				stmt.executeUpdate(sql);
			} catch (SQLException e1) {

				e1.printStackTrace();
			}

		}

	}

	public ResultSet GetFileData(String sql, Connection conn, String table) {

		Statement stmt = null;
		ResultSet r = null;
		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		/*
		 * String lExt = FileItem.Ext; String lFileName = FileItem.FileName; long lSize
		 * = FileItem.Size; String lPath = FileItem.Path; String lSource = "ASROCK";
		 * String lHost = "ASROCK"; String lLanguage = "English"; boolean lVerified =
		 * false;
		 * 
		 * boolean lParsedUIMA = false; boolean lTooBig = TooBig; long lUIMAref =
		 * UIMAref; long lNeo4Jref = Neo4Jref; boolean lparsed = parsed;
		 * 
		 * boolean laudio = audio; boolean ltext = text; boolean image = text; boolean
		 * lvideo = video;
		 * 
		 * String lfilename = FileItem.getFileName(); String lCRC64 = FileItem.getCRC();
		 * 
		 * String sql = "INSERT  INTO " + table + " " +
		 * "( Path, Filename,  Source, Host, Ext, Size, CRC64 ) VALUES ( " + fix(lPath)
		 * + fix(lfilename) + fix(lSource) + fix(lHost) + fix(lExt) + lSize + ", " +
		 * fix(lCRC64).substring(0, fix(lCRC64).lastIndexOf(",")) + ")";
		 */

		try {
			r = stmt.executeQuery(sql);
		} catch (SQLException e) {
			try {

				long l = 1000000000;

				stmt.executeQuery(sql);
			} catch (SQLException e1) {

				e1.printStackTrace();
			}

		}
		return r;

	}

	String fixPath(String field) {
		if (field != null && !field.isEmpty()) {
			field = field.replace("\\", "/");
			field.replace("'", "\\'");
		}
		field = "\'" + field + "\', ";
		return field;

	}

	void delay(long n) {
		System.gc();
		for (long i = 0; i < n; i++)
			;
	}

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

	public String getAbsolutePath() {
		return AbsolutePath;
	}

	public void setAbsolutePath(String absolutePath) {
		AbsolutePath = absolutePath;
	}

	public String getHost() {
		return Host;
	}

	public void setHost(String host) {
		Host = host;
	}

	public String getHostBase() {
		return HostBase;
	}

	public void setHostBase(String hostBase) {
		HostBase = hostBase;
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

	public long getUIMAref() {
		return UIMAref;
	}

	public void setUIMAref(int uIMAref) {
		UIMAref = uIMAref;
	}

	public long getNeo4Jref() {
		return Neo4Jref;
	}

	public void setNeo4Jref(int neo4Jref) {
		Neo4Jref = neo4Jref;
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

}
