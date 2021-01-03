package com.myexperiments.ward;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import com.myexperiments.ward.ExampleApplication;

public class ScanFiles {
	static ArrayList<String> options;
	static String PropPath;
	static String Textstring;
	static Prop prop;
	static Properties Theprop;
	static Boolean isWindows;

	static ExampleApplication example = new ExampleApplication();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		options = getargs(args);
		String PropPath = System.getProperty("user.dir") + "/properties";
		isWindows = testOS();
		if (isWindows)
			PropPath += "/wardwindows.properties";
		else
			PropPath += "/wardlinux.properties";

		Properties prop = new Prop(PropPath).theProp;
		PropPath = prop.getProperty("GutPath");
		Textstring = prop.getProperty("TextString");

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

	static boolean testOS() {
		String test = System.getProperty("user.dir");

		if (test.startsWith("/"))
			return false;
		else
			return true;
	}

}
