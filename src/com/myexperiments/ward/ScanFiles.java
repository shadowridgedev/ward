package com.myexperiments.ward;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;
import com.myexperiments.ward.Book;

import opennlp.tools.cmdline.parser.ParserTool;
import opennlp.tools.parser.Parse;
import opennlp.tools.parser.Parser;
import opennlp.tools.parser.ParserFactory;
import opennlp.tools.parser.ParserModel;

public class ScanFiles {
	static ArrayList<String> options;
	static String PropPath;
	static String Textstring;
	static Prop prop;
	static Properties Theprop;
	static Boolean isWindows;
	private static File taeDescriptor;
	private static File inputDir;
	TreeMap<Integer, Book> map;
	int count;

	static public void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		String[] video = { "flac", "mpeg", "mp4", "oog", "mov", "webm", "avi", "mkv" };
		String[] text = { "txt", "pdf", "tff", "doc", "docx", "rtf", "mobi" };
		String[] audio = { "mp3", "m4a", "wav", "wma", "aac" };
		String[] image = { "jpeg", "jiff", "exif", "tiff", "gif", "bmp", "png", "ppm", "pmb", "pnm", "webp" };

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
		CRC32 calcCRC = new CRC32();
		// InputStream inputStream = new FileInputStream(".../en-parserchunking.bin");

		// ExampleApplication example = new ExampleApplication( taeDescriptor,
		// inputDir);
		String rootString = "Z:\\";
		File root = new File(rootString);
//		TreeMap<Integer, Book> map = new TreeMap<Integer, Book>();
//		TreeMap<Integer, Book> result;

		searchForFilesExt(root, text, calcCRC);
	}

	private static <calcCRC> void searchForFilesExt(File root, String[] video, int i, calcCRC calc) {
		// TODO Auto-generated method stub

	}

	Parse[] parse(String sentence) throws IOException {
		InputStream inputStream = new FileInputStream(".../en-parserchunking.bin");
		ParserModel model = new ParserModel(inputStream);

		// Creating a parser
		Parser parser = ParserFactory.create(model);
		Parse topParses[] = ParserTool.parseLine(sentence, parser, 1);

		for (Parse p : topParses)
			p.show();
		return topParses;
	}

	static public ArrayList<String> getargs(String[] args) {
		final Map<String, List<String>> params = new HashMap<>();

		ArrayList<String> options = new ArrayList<>();

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

	public static void searchForFilesExt(File root, String[] type, CRC32 calc) throws Exception {
		// TODO Auto-generated method stub
		// System.out.println("File " + root.toString());

//		if (count > string)
//			return null;

		if (root == null)
			return; // just for safety || !root.getPath().toString().contains("old"))

		if (root.isDirectory()) {
			// System.out.println(root.toString());

			for (File file : root.listFiles()) {
				if (file != null) {
					searchForFilesExt(file, type, calc);
				}
			}
		} else if (root.isFile()) {

			String ext = getExt(root);
			if (isType(type, ext)) {
				Book theBook = new Book();
				theBook.Path = root.getAbsoluteFile().toString();
				theBook.EtextNumber = root.getParent().replaceAll("\\D+", "");
				theBook.Ext = ext;
				theBook.FileName = root.getName();
				theBook.Size = root.length();
				theBook.Path = root.getPath();
				theBook.Source = "local";
				theBook.CRC = calc.GetCRC32(new String(Files.readAllBytes(root.getAbsoluteFile().toPath())));
//				theBook.Text = new String(Files.readAllBytes(Paths.get(theBook.Path)));
//				HashMap<String, String> items = GetBookMetadata(theBook.Text);
//				theBook = addMetadata(theBook, items);
//				theBook = RemoveText(theBook);
//				String temp = theBook.Text;
//				theBook.Text = null;
				System.out.println(theBook.Path + " " + theBook.Size + " " + theBook.CRC);
//				theBook.Text = temp;

//					map.put(count, theBook);
			}
		}
		return;
	}

	static String getExt(File current) {
		int end = current.toString().lastIndexOf(".");
		return current.toString().substring(end).replace(".", "");
	}

	static boolean isType(String[] type, String ext) {
		for (String example : type) {

			if (ext.compareTo(example) == 0)
				return true;
		}
		return false;
	}

}
