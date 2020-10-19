package com.myexperiments.ward;

// no test
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.mapdb.DBMaker;
import org.mapdb.HTreeMap;
import org.mapdb.DBMaker.Maker;
import org.neo4j.jdbc.impl.ListArray;

import net.myexperiments.video.Getvideo;

public class Gutenberg {
	static ArrayList<String> options;
	static String PropPath;
	static Prop prop;
	static Properties Theprop;
	static Boolean isWindows;

	static public void main(String[] args) throws Exception {
		/*
		 * URL url = new URL("https://www.w3.org/TR/PNG/iso_8859-1.txt"); URL url = new
		 * URL("https://youtu.be/4scs6J33B9E"); File f = new File("H:/test.txt");
		 * Getvideo video = new Getvideo(url, f);
		 */
// https://publish.dvlabs.com/democracynow/360/dn2020-0205.mp4
		options = getargs(args);
		String PropPath = System.getProperty("user.dir") + "/properties";
		isWindows = testOS();
		if (isWindows)
			PropPath += "/wardwindows.properties";
		else
			PropPath += "/wardlinux.properties";

		Properties prop = new Prop(PropPath).theProp;
//Test
		if (options != null) {

			String function = options.get(1);

			if (function.equals("youtube")) {
				URL url = new URL("https://youtu.be/4scs6J33B9E");
				File f = new File(PropPath + "videotest.txt");
				Getvideo video = new Getvideo(url, f);

			}
			if (function.equals("GetFiles")) {
				ProcessFiles process = new ProcessFiles();
				ArrayList<Book> map = new ArrayList<Book>();
				@SuppressWarnings("rawtypes")
				int count = process.getFiles(prop, "txt", map);
				System.out.println("Final Count" + Integer.toString(count));
				System.out.println("Map Size " + Integer.toString(map.size()));
				BookManager manager = new BookManager();
				manager.setup();
				Book thebook = null;
				for (Iterator<Book> i = map.iterator(); i.hasNext(); thebook = i.next()) {

					manager.create(thebook);
				}
				manager.exit();

			}
		}
	}

	static boolean testOS() {
		String test = System.getProperty("user.dir");

		if (test.startsWith("/"))
			return false;
		else
			return true;
	}

	static public ArrayList<String> getargs(String[] args) {
		final Map<String, List<String>> params = new HashMap<>();

		ArrayList<String> options = new ArrayList<String>();

		for (int i = 0; i < args.length; i++) {
			final String a = args[i];

			if (a.charAt(0) == '-') {
				if (a.length() < 2) {
					System.err.println("Error at argument " + a);
					return null;
				}

				params.put(a.substring(1), options);
			} else if (options != null) {
				options.add(a);
			} else {
				System.err.println("Illegal parameter usage");
				return null;
			}
		}
		return options;
	}

	@SuppressWarnings("unchecked")
	public static void doparse(Properties prop) throws Exception {

		WardDB wardDB = new WardDB(prop);

		Maker db = DBMaker.fileDB(prop.getProperty("filedb"));

		GuttenbergHelper helper = new GuttenbergHelper(prop, wardDB);

		if (wardDB.map.isEmpty()) {
			helper.searchForFilesExt(null, null, prop.getProperty("GutenbergFileBase"), prop.getProperty("numfiles"));
			FindGuttenbergInfo info = new FindGuttenbergInfo();
//			info.getinfo(map);
		}

//		prop.close();
	}

}
