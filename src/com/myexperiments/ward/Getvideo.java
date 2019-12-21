package com.myexperiments.ward;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;

public class Getvideo {
	ArrayList<?> op;
	Prop theprop;

	public Getvideo(URL url, File f) throws IOException {

		int size = 4096;
		byte[] buf = new byte[size];

		FileUtils.copyURLToFile(url, f);
//		boolean result = readvideo(op.get(3), op.get(4), op.get(5));

	}

	boolean readvideo(Object destinationDir, Object fAddress, Object localFileName) {
		URL url;
		byte[] buf = null;
		int byteRead, byteWritten = 0;
		FilterOutputStream outStream = null;
		InputStream is = null;
		try {

			url = getFinalLocation(fAddress.toString());

			outStream = new BufferedOutputStream(
					new FileOutputStream(destinationDir.toString() + "\\" + localFileName.toString()));
			URLConnection conn = url.openConnection();
			Object obj = conn.getContent();

			conn = url.openConnection();
			obj = conn.getContent();
			is = conn.getInputStream();
			int j = is.available();

			while ((byteRead = is.read(buf)) != -1) {
				outStream.write(buf, 0, byteRead);
				byteWritten += byteRead;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				is.close();

				outStream.close();
			} catch (IOException e) {
				e.printStackTrace();
				return false;
			}
		}

		return true;

	}

	URL getFinalLocation(String address) throws IOException {
		URL url = new URL(address);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		int status = conn.getResponseCode();
		if (status != HttpURLConnection.HTTP_OK) {
			if (status == HttpURLConnection.HTTP_MOVED_TEMP || status == HttpURLConnection.HTTP_MOVED_PERM
					|| status == HttpURLConnection.HTTP_SEE_OTHER) {
				String newLocation = conn.getHeaderField("Location");
				return getFinalLocation(newLocation);
			}
		}
		return url;
	}
}
