package com.myexperiments.ward;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.mapdb.DBMaker;
import org.mapdb.DBMaker.Maker;

public class Gutenberg {
	static ArrayList<String> options;
	static String PropPath;
	static Prop prop;
	static Properties Theprop;

	static public void main(String[] args) throws Exception {
		/*
		 * URL url = new URL("https://www.w3.org/TR/PNG/iso_8859-1.txt"); URL url = new
		 * URL("https://youtu.be/4scs6J33B9E"); File f = new File("H:/test.txt");
		 * Getvideo video = new Getvideo(url, f);
		 */

		options = getargs(args);
		String PropPath = System.getProperty("user.dir") + "/properties";

		PropPath += "/" + options.get(3);

		Properties prop = new Prop(PropPath).theProp;

		if (options != null) {

			String function = options.get(1);

			if (function.equals("youtube")) {
				URL url = new URL("https://youtu.be/4scs6J33B9E");
				File f = new File(PropPath + "videotest.txt");
				Getvideo video = new Getvideo(url, f);

			}
			if (function.equals("GetFiles")) {
				doparse();
			}
		}

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
	public static void doparse() throws Exception {

		WardDB wardDB = new WardDB(prop);

		Maker db = DBMaker.fileDB(prop.filedb);

		GuttenbergHelper helper = new GuttenbergHelper(prop, wardDB);

		if (wardDB.map.isEmpty()) {
			helper.searchForFilesExt(null, null, prop.GutenbergFileBase, prop.numfiles);
			FindGuttenbergInfo info = new FindGuttenbergInfo();
//			info.getinfo(map);
		}

		prop.close();
	}

}
