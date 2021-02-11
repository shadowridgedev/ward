package com.myexperiments.ward;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.Date;
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
import com.xuggle.mediatool.MediaListenerAdapter;
import com.xuggle.mediatool.event.IAddStreamEvent;
import com.xuggle.xuggler.IStreamCoder;
import java.util.Arrays;
import java.util.Locale;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import java.util.Arrays;
import java.util.Locale;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class ScanFiles {
	static ArrayList<String> options;
	static String PropPath;
	static String Textstring;
	static Prop prop;
	static Properties Theprop;
	static Boolean isWindows;
	private static File taeDescriptor;
	private static File inputDir;
	int count;

	static public void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		String[] video = { "flac", "mpeg", "mp4", "oog", "mov", "webm", "avi", "mkv" };
		String[] text = { "txt", "pdf", "tff", "doc", "docx", "rtf", "mobi", "epub" };
		String[] audio = { "mp3", "m4a", "wav", "wma", "aac", "md" };
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
		CRC64 calcCRC = new CRC64();
		SQLInterface db = new SQLInterface();
		// InputStream inputStream = new FileInputStream(".../en-parserchunking.bin");

		// ExampleApplication example = new ExampleApplication( taeDescriptor,
		// inputDir);
//		String rootString = "E:\\AVI";
//		String rootString = "E:\\big";
//		String rootString = "Z:\\";
//		String rootString = "E:\\pdf";
		String rootString = "E:\\mp3";
//		String rootString = "D:\\onedrive";
		File root = new File(rootString);
//		TreeMap<Integer, Book> map = new TreeMap<Integer, Book>();
//		TreeMap<Integer, Book> result;
		SearchforFiles searcher = new SearchforFiles();

		searcher.searchForFilesExt(root, audio, db);
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

	static boolean testOS() {
		String test = System.getProperty("user.dir");

		if (test.startsWith("/"))
			return false;
		else
			return true;
	}

	public static ArrayList<String> getargs(String[] args) {
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
}
