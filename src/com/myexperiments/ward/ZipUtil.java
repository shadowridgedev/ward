package com.myexperiments.ward;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;
import java.util.zip.*;

//ZipUtil 
public class ZipUtil {
	public static String compress(String str) throws IOException {
		if (str == null || str.length() == 0) {
			return str;
		}

		ByteArrayOutputStream out = new ByteArrayOutputStream();
		GZIPOutputStream gzip = new GZIPOutputStream(out);
		gzip.write(str.getBytes());
		gzip.close();
		return out.toString("ISO-8859-1");
	}

	public static void main(String[] args) throws IOException {
		String string = "admin";
		System.out.println("after compress:");
		System.out.println(ZipUtil.compress(string));
	}
}