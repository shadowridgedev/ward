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
/**
 * @author shado
 *
 */

@Entity
@Table(name = "filedata")
public class FileData implements Serializable {

	private static final long serialVersionUID = -5068990239464021287L;

	long RecordID;
	String Ext;
	String FileName;
	long Size;
	String Path;
	String AbsolutePath;
	String Source;
	String Host;
	String Language;
	String CRC;
	long UIMAref;
	long Neo4Jref;
	boolean Audio = false;
	boolean GoodData = false;
	boolean Duplicate = false;
	boolean Text = false;
	boolean Image = false;
	boolean Video = false;
	boolean Verified = false;
	boolean ParsedUIMA = false;
	boolean TooBig = false;
	boolean Fix = false;
	boolean Parsed = false;

	public void InsertFileData(FileData FileItem, Connection conn, String table, String source) throws SQLException {
		String[] video = { "flac", "mpeg", "mp4", "oog", "mov", "webm", "avi", "mkv" };
		String[] text = { "txt", "pdf", "tff", "doc", "docx", "rtf", "mobi", "epub", "txt.utf8", "log" };
		String[] audio = { "mp3", "m4a", "wav", "wma", "aac", "md", "m4b" };
		String[] image = { "jpeg", "jiff", "exif", "tiff", "gif", "bmp", "png", "ppm", "pmb", "pnm", "webp" };
		Statement stmt = null;
		/*
		 * try { stmt = conn.createStatement(); } catch (SQLException e) {
		 * e.printStackTrace(); }
		 */
//" " + FieldString +
		FileItem.Path = fixPath(FileItem.Path);
		FileItem.AbsolutePath = fixPath(FileItem.AbsolutePath);
		String FieldString = "( RecordID,Ext,FileName,Size,Path,AbsolutePath, Source, Host,Language,CRC,UIMAref,Neo4Jref,Audio,GoodData,Duplicate,Text,Image,Video,Verified,ParsedUIMA,TooBig,Fix,Parsed)";
		String sql = "INSERT  INTO " + table + "  " + FieldString + " VALUES  ( '0','" + Ext + "','" + FileName + "','"
				+ Size + "','" + Path + "','" + AbsolutePath + "','" + Source + "','" + Host + "','" + Language + "','"
				+ CRC + "','" + UIMAref + "','" + Neo4Jref + "'," + Audio + "," + GoodData + "," + Duplicate + ","
				+ Text + "," + Image + "," + Video + "," + Verified + "," + ParsedUIMA + "," + TooBig + "," + Fix + ","
				+ Parsed + ");";
		System.out.println(sql);
		sql = sql.substring(0, sql.length() - 2);
//		System.out.println(sql);
		sql = sql + ");";
		System.out.println(sql);
		int rs = GetFileData(sql, conn, table);
		/*
		 * try { stmt.executeUpdate(sql); } catch
		 * 
		 * (SQLException e) { try {
		 * 
		 * stmt.executeUpdate(sql); } catch (SQLException e1) {
		 * 
		 * e1.printStackTrace(); }
		 * 
		 * }
		 * 
		 * try(Connection con = getConnection(url, username, password,
		 * "org.postgresql.Driver"); Statement stmt = con.createStatement(); ResultSet
		 * rs = stmt.executeQuery(sql); ) {
		 * 
		 * // Statements } catch (SQLException e1) {
		 * 
		 * e1.printStackTrace(); }
		 * 
		 * finally { rs.close con.close }
		 */
	}

	public int GetFileData(String sql, Connection conn, String table) throws SQLException {

		Statement stmt = null;
		int r = 0;
		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		try {
			r = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			try {
				stmt.executeUpdate(sql);

			} catch (SQLException e1) {
				System.err.println("Got an exception!");
				System.err.println(e.getMessage());
			}
		} finally {
			stmt.close();
		}
		return r;
	}

	String fixPath(String field) {
		if (field != null && !field.isEmpty()) {
			field = field.replace("\\", "/");
		}

		return field;

	}

	void delay(long n) {
		System.gc();
		for (long i = 0; i < n; i++)
			;
	}

	public long getRecordID() {
		return RecordID;
	}

	public void setRecordID(long recordID) {
		RecordID = recordID;
	}

	public String getExt() {
		return Ext;
	}

	public void setExt(String ext) {
		Ext = ext;
	}

	public String getFileName() {
		return FileName;
	}

	public void setFileName(String fileName) {
		FileName = fileName;
	}

	public long getSize() {
		return Size;
	}

	public void setSize(long size) {
		Size = size;
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

	public String getSource() {
		return Source;
	}

	public void setSource(String source) {
		Source = source;
	}

	public String getHost() {
		return Host;
	}

	public void setHost(String host) {
		Host = host;
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

	public long getUIMAref() {
		return UIMAref;
	}

	public void setUIMAref(long uIMAref) {
		UIMAref = uIMAref;
	}

	public long getNeo4Jref() {
		return Neo4Jref;
	}

	public void setNeo4Jref(long neo4Jref) {
		Neo4Jref = neo4Jref;
	}

	public boolean isAudio() {
		return Audio;
	}

	public void setAudio(boolean Audio) {
		this.Audio = Audio;
	}

	public boolean isGoodData() {
		return GoodData;
	}

	public void setGoodData(boolean goodData) {
		GoodData = goodData;
	}

	public boolean isDuplicate() {
		return Duplicate;
	}

	public void setDuplicate(boolean duplicate) {
		Duplicate = duplicate;
	}

	public boolean isText() {
		return Text;
	}

	public void setText(boolean text) {
		Text = text;
	}

	public boolean isImage() {
		return Image;
	}

	public void setImage(boolean image) {
		Image = image;
	}

	public boolean isVideo() {
		return Video;
	}

	public void setVideo(boolean video) {
		Video = video;
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

	public boolean isParsed() {
		return Parsed;
	}

	public void setParsed(boolean parsed) {
		Parsed = parsed;
	}

}