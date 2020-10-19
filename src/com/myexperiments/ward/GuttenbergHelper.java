package com.myexperiments.ward;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;
import java.util.Scanner;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import org.mapdb.HTreeMap;

public class GuttenbergHelper {
	int GuttenbergFiles = 0;
	int NotGuttenbergFiles = 0;
	ArrayList<Book> only = null;
	private ArrayList<String> removetext = new ArrayList<String>();
	int count;
	String GuttenbergPath;
	String NotGuttenbergPath;
	String RemoveText;
	String CleanBook;
	Prop prop;
	Properties wardprop = new Properties();
	ArrayList<String> cuttext;
	int max;
	// load a properties file
	// wardprop.load(input);
	// ArrayList<String> checklist = new ArrayList<String> ();

	GuttenbergHelper(Properties prop, WardDB theWardDB) throws IOException {

		WardDB wardDB = theWardDB;
		String base = prop.getProperty("GutenbergFileBase");
		GuttenbergPath = base + "/com.myexperiments.ward/";
		NotGuttenbergPath = base + "/NotGuttenberg/";
		RemoveText = base + "/RemoveText";
		CleanBook = prop + "/CleanBook/";
		cuttext = removetext();

		max = Integer.parseInt(prop.getProperty("numfiles"));
//		ScriptEngine engine = new ScriptEngineManager().getEngineByName("python");
	}

	String getprop(String property) {
		return wardprop.getProperty(property);
	}

	ArrayList<String> removetext() throws IOException {

		String[] paths = new File(RemoveText).list();
		if (paths != null) {
			for (String remove : paths) {
				Path path = Paths.get(RemoveText + remove);
				removetext.add(new String(Files.readAllBytes(path)));
			}

		}
		return removetext;
	}

	boolean isGuttenberg(File current) throws FileNotFoundException {
		;
		if (current.isFile() && current.exists() && current.getName().endsWith("txt") && lookslikeGuttenberg(current)) {
			GuttenbergFiles++;
			return true;
		}
		NotGuttenbergFiles++;
		return false;

	}

	boolean lookslikeGuttenberg(File current) throws FileNotFoundException {
		Scanner scanner = null;

		try {
			scanner = new Scanner(current);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		// now read the file line by line...

		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			if (line.contains(" Project Gutenberg ") || line.contains("Project Gutenberg's")
					|| !line.contains("Preliminary Matter.")
							&& !line.contains("The Project Gutenberg Etext of Human Genome Project")) {
				// System.out.println("ho hum, i found it on line " + lineNum);
				scanner.close();
				return true;
			}
		}
		// System.out.println("Not Guttenberg1 file is " + current.toString() +
		// "
		// Size is " + current.length() + " Not Guttenberg1 " +
		// NotGuttenbergFiles++ + " GuttenbergFiles " + GuttenbergFiles);
		/*
		 * scanner.close(); scanner = new Scanner(current);
		 * 
		 * for (int x = 0; x < 3; x++) { while (scanner.hasNextLine()) {
		 * System.out.println(scanner.nextLine()); } }
		 */
		scanner.close();
		return false;
	}

	HashMap<String, String> GetBookMetadata(String text) {

		HashMap<String, String> items = new HashMap<String, String>();
		int index;
		String split = System.getProperty("line.separator");
		String[] lines = text.split(split);
		int is;
		for (String line : lines) {
			if (line == null)
				break;
			if ((index = line.lastIndexOf("Title:")) != -1) {
				line = line.replace("Title:", "");
				if (!items.containsKey("Title")) {
					items.put("Title", line.substring(index++).trim());
				}
				continue;
			}
			if ((index = line.lastIndexOf("Author:")) != -1) {
				line = line.replace("Author:", "");
				items.put("Author", line.substring(index++).trim());
				continue;
			}
			if ((index = line.lastIndexOf("of several works by")) != -1) {
				if (!items.containsKey("Author")) {
					items.put("Author", line.substring(index++).trim());
				}
				continue;
			}

			if ((index = line.lastIndexOf("Release")) != -1) {
				line = line.replace("Release Date:", "");

				int index2;
				String line2;
				if (line.contains("[")) {
					line2 = line;
					if ((index2 = line2.lastIndexOf("[")) != -1) {
						items.put("ReleaseDate", line2.substring(index2).trim());
						line = line.substring(0, index2 - 1);
					}
				}
				continue;
			}
			if ((index = line.lastIndexOf("Posting")) != -1) {
				int index2;
				line = line.replace("Posting Date:", "");
				String line2 = line;

				if ((index2 = line2.lastIndexOf("[")) != -1) {
					line2 = line2.replace("[EBook #", "");
					line2 = line2.replace("]", "");
					line2 = line2.replace("[", "");
					items.put("Ebook", line2.substring(index2++).trim());
					line = line.substring(0, index2);
				}

				items.put("PostingDate", line.substring(index).trim());
				continue;
			}

			if ((index = line.lastIndexOf("Date:")) != -1) {
				int index2;
				String line2 = line;

				if ((index2 = line2.lastIndexOf("[")) != -1) {
					items.put("Ebook", line2.substring(index2++).trim());
					line = line.substring(0, index2);
				}
				line = line.replace("Date:", "");
				items.put("Date", line.substring(index++).trim());
				continue;
			}

			if ((index = line.lastIndexOf("Etext")) != -1) {
				line = line.replace("Etext of ", "");
				if (!items.containsKey("Title")) {
					items.put("Title", line.substring(index).replace("]", "").trim());
				}
				continue;
			}

			if ((index = line.lastIndexOf("The Project Gutenberg Etext of")) != -1) {
				if (!items.containsKey("Title")) {
					line.replace("Title:", "");
					items.put("Title", line.substring(index++).trim());
				}
				continue;
			}

			if ((index = line.lastIndexOf("Translanted by")) != -1) {
				items.put("Translanted by", line.substring(index++).trim());
				continue;
			}

			if ((index = line.lastIndexOf("*** START OF THIS PROJECT GUTENBERG EBOOK")) != -1) {
				if (!items.containsKey("Title")) {
					line.replace("Title:", "");
					items.put("Title", line.substring(index++).replace("***", "").trim());
				}
				continue;
			}

			if ((index = line.lastIndexOf("Language:")) != -1) {
				items.put("Language", line.substring(index++).trim());
				continue;
			}

		}
		return items;

	}

	Book addMetadata(Book book, HashMap<String, String> items) {
		book.author = items.get("Author");
		book.title = items.get("Title");
		book.language = items.get("Language");
		book.Translatedby = items.get("Translanted by");
		book.date = items.get("Date");
		book.EtextNumber = items.get("Ebook");
		return book;
	}

	Book RemoveText(Book book) throws IOException {

		String text = book.getText();
		Iterator<String> itt = cuttext.listIterator();
		String replaced;
		while (itt.hasNext()) {
			replaced = itt.next();
			text.replace(replaced, "%^%^");

		}
		book.setText(text);
		return book;
	}

	public HTreeMap<Integer, Book> searchForFilesExt(File root, HTreeMap<Integer, Book> map, String ext, String string)
			throws Exception {
		// TODO Auto-generated method stub
		// System.out.println("File " + root.toString());

//		if (count > string)
//			return null;

		if (root == null || map == null)
			return map; // just for safety || !root.getPath().toString().contains("old"))

		if (root.isDirectory()) {
			// System.out.println(root.toString());

			for (File file : root.listFiles()) {
				if (file != null) {
					map = searchForFilesExt(file, map, ext, string);
				}
			}
		} else if (root.isFile() && root.getName().endsWith(ext)) {
			count++;
			if (!map.containsKey(count)) {
				Book theBook = new Book();
				theBook.path = root.getAbsoluteFile().toString();
				theBook.EtextNumber = root.getParent().replaceAll("\\D+", "");
				theBook.text = new String(Files.readAllBytes(Paths.get(theBook.path)));
				HashMap<String, String> items = GetBookMetadata(theBook.text);
				theBook = addMetadata(theBook, items);
				theBook = RemoveText(theBook);
				String temp = theBook.text;
				theBook.text = null;
				System.out.println(count + " " + theBook.toString());
				theBook.text = temp;
				map.put(count, theBook);
			}
		}

		return map;
	}

	String printBook(Book book) {
		return book.toString();
	}
	/*
	 * void ProcessFiles(ArrayList<File> only, int max) { while ( i++ != max) {
	 * 
	 * for (File current : only) { String result = ("File " + current.getName() +
	 * " "); if (isGuttenberg(current)) { result += (" is Guttenbberg"); Path local
	 * = Paths.get(GuttenbergPath + current.getName()); Files.copy(current.toPath(),
	 * local, REPLACE_EXISTING); Book book = new Book();
	 * book.setPath(local.toString()); book.setText(new
	 * String(Files.readAllBytes(local))); book.setName(current.getName()); metadata
	 * = GetBookMetadata(book.text);
	 * 
	 * // add own metadata metadata.put("extra", "Things");
	 * 
	 * System.out.println(Arrays.asList(metadata)); // method 1 book =
	 * addMetadata(book, metadata);
	 * 
	 * book = helper.RemoveText(book); book.setPath(CleanBook + book.getName());
	 * Files.write(Paths.get(book.getPath()), book.getText().getBytes());
	 * 
	 * result += current.getPath() + "    " + current.getName();
	 * storage.InsertBook(book);
	 * 
	 * } else { Path local = Paths.get(NotGuttenbergPath + current.getName());
	 * Files.copy(current.toPath(), local, REPLACE_EXISTING); result +=
	 * " is not Guttenberg"; } System.out.println(result);
	 * 
	 * } /* int problem = count - (helper.GuttenbergFiles +
	 * helper.NotGuttenbergFiles); if (problem != 0) System.out.println("Problem " +
	 * problem); System.out.println("Final count Guttenberg Files" +
	 * helper.GuttenbergFiles + " Not Guttenberg Files " +
	 * helper.NotGuttenbergFiles); }
	 */
}
