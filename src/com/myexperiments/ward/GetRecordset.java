package com.myexperiments.ward;

import java.sql.Connection;
import java.sql.ResultSet;

public class GetRecordset {

	String[] video = { "flac", "mpeg", "mp4", "oog", "mov", "webm", "avi", "mkv" };
	String[] text = { "txt", "pdf", "tff", "doc", "docx", "rtf", "mobi", "epub" };
	String[] audio = { "mp3", "m4a", "wav", "wma", "aac", "md" };
	String[] image = { "jpeg", "jiff", "exif", "tiff", "gif", "bmp", "png", "ppm", "pmb", "pnm", "webp" };

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ResultSet getResultSet(String query, Connection con, String table) {
		FileData arecord = new FileData();

		ResultSet r = null;
		String sql = "select * FROM ward.files WHERE " + query;
		r = arecord.GetFileData(sql, con, table);
		return r;

	}

}
