package com.myexperiments.ward;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
		CRC64 calcCRC = new CRC64();
		// InputStream inputStream = new FileInputStream(".../en-parserchunking.bin");

		// ExampleApplication example = new ExampleApplication( taeDescriptor,
		// inputDir);
		String rootString = "E:\\AVI";
//		String rootString = "E:\\big";
//		String rootString = "Z:\\";
		File root = new File(rootString);
//		TreeMap<Integer, Book> map = new TreeMap<Integer, Book>();
//		TreeMap<Integer, Book> result;

		searchForFilesExt(root, video, calcCRC);
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

	public static void searchForFilesExt(File root, String[] type, CRC64 calc) throws Exception {
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

			long value = (long) 1073741832;
			String ext = getExt(root);
			if (isType(type, ext)) {
				Book theBook = new Book();
				theBook.Path = root.getAbsoluteFile().toString();
				theBook.EtextNumber = root.getParent().replaceAll("\\D+", "");
				theBook.Ext = ext;
				theBook.FileName = root.getName();
				theBook.Size = root.length();
				theBook.Path = root.getPath();
				theBook.Source = "asrock";
				Path thePath = root.getAbsoluteFile().toPath();
				long heapFreeSize = Runtime.getRuntime().freeMemory() / (1024 * 1024);
				long heapMaxSize = Runtime.getRuntime().maxMemory() / (1024 * 1024);
				System.out.println(theBook.Path + " " + theBook.Size / (1024 * 1024) + " " + theBook.Ext + "     "
						+ heapFreeSize + "  " + heapMaxSize);
				if (theBook.Size < value) {
					String data = new String(Files.readAllBytes(Paths.get(theBook.Path)));
					long datasize = data.getBytes().length;
					if (datasize != 0)
						theBook.CRC = calc.fromBytes(data.getBytes()).getValue();
					data = null;
				} else
					System.out.println("TOO BIG!!!");

//				theBook.Text = ;
//				HashMap<String, String> items = GetBookMetadata(theBook.Text);
//				theBook = addMetadata(theBook, items);
//				theBook = RemoveText(theBook);
//				String temp = theBook.Text;
//				theBook.Text = null;
//				System.out.println(theBook.Path + " " + theBook.Size / 1024*1024 + " " + theBook.Ext);
//				theBook.Text = temp;

//					map.put(count, theBook);

				theBook = null;
//				System.gc();
			}
		}
		return;
	}

	static String getExt(File current) {
		int end = current.toString().lastIndexOf(".");
		if (end < 0) {
			return "bad";
		}

		String currentString = current.toString();
		String endstring = currentString.substring(end);
		String result = endstring.replace(".", "");
		return result;
	}

	static boolean isType(String[] type, String ext) {
		for (String example : type) {

			if (ext.compareTo(example) == 0)
				return true;
		}
		return false;
	}

}
