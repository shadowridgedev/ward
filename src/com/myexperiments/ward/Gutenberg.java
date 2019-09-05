package com.myexperiments.ward;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mapdb.DBMaker;
import org.mapdb.DBMaker.Maker;

public class Gutenberg {
	static ArrayList<String> options;
	static String PropPath;
	static Prop prop;

	static public void main(String[] args) throws Exception {

		options = getargs(args);
		String PropPath = System.getProperty("user.dir") + "\\" + options.get(1);
		Prop prop = new Prop(PropPath);
		if (options != null) {

			String function = options.get(0);

			if (function.equals("youtube")) {
				Getvideo video = new Getvideo(options, prop);
			}
			if (function.equals("GetFiles")) {
				doparse();
			}
		}
	}

	static ArrayList<String> getargs(String[] args) {
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
