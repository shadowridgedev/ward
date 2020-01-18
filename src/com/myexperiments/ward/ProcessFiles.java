package com.myexperiments.ward;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Properties;

public class ProcessFiles {
	protected DisplayMemory dm = new DisplayMemory();

	public int getFiles(Properties theprop, String extension, ArrayList map) throws IOException {
		int count = 0;
		String base = theprop.getProperty("GutenbergFileBase");

		File root = new File(base);

		if (root.exists()) {
			if (root.canRead()) {
				if (root.isDirectory()) {

					int max = Integer.parseInt(theprop.getProperty("numberfiles"));
					return searchForFiles(root, map, extension, count, max);
				}
			} else {
				System.out.println("toString " + root.toString());
				System.out.println("isFile " + root.isFile());
				System.out.println("Absolute Path " + root.getAbsolutePath());
				System.out.println("Name " + root.getName());
				System.out.println("Parent " + root.getParentFile());
				System.out.println("IsDirectory " + root.isDirectory());
				System.out.println("canRead " + root.canRead());
				System.out.println("Path" + root.toPath());
			}
		}
		return count;
	}

	private int searchForFiles(File root, ArrayList<Book> map, String ext, int count, int max) throws IOException {
		// TODO Auto-generated method stub
//		System.out.println("File " + root.toString());
//		System.out.println(root.getPath());
		if (count > max)
			return count;

		if (root == null || map == null || root.getPath().toString().contains("old"))
			return count; // just for safety || !root.getPath().toString().contains("old"))

		if (root.isDirectory()) {
			// System.out.println(root.toString());

			for (File file : root.listFiles()) {
				if (file != null) {
					count = searchForFiles(file, map, ext, count, max);
				}
			}
		} else if (root.isFile() && root.getName().endsWith(ext)) {
			count++;

			Book theBook = new Book();
			theBook.filename = root.getName();
			theBook.verified = false;
			theBook.path = root.getAbsoluteFile().toString();
			theBook.parsed = false;
			theBook.source = "Guttenberg";
			// theBook.EtextNumber = root.getParent().replaceAll("\\D+", "");
			String text = new String(Files.readAllBytes(Paths.get(theBook.path)));
			// theBook.text = text;
			// HashMap<String, String> items = GetBookMetadata(theBook.text);
			// theBook = addMetadata(theBook, items);
			// theBook = RemoveText(theBook);
			System.out.println("");
			System.out.println("Filename  " + theBook.filename);
			System.out.println("Book Count " + Integer.toString(count));
			System.out.println("Text Length" + Integer.toString(text.length()));
			map.add(theBook);
			text = null;
			if (count > 0) {
				// System.out.println("Count " + Integer.toString(count));
				dm.display();
			}
		}

		return count;
	}

}
