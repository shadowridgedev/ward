package gutenberg;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

public class FindGuttenbergInfo {

	private String title;
	LinkedList<Book> books = new LinkedList<Book>();

	public FindGuttenbergInfo() {

		// TODO Auto-generated constructor stub
	}

	LinkedList<Book> getinfo(LinkedList<Book> only) throws IOException {
		Book result;
		for (Book book : only) {
			result = getindexfileinfo(book);
			if (result != null)
				books.add(result);
		}
		return books;

	}

	private Book getindexfileinfo(Book current) throws IOException {
		if (current.path != null) {
			String path = current.path.toString();
			if (!(path.contains("old") || path.contains("readme") || path.contains("-") || path.contains("etext")
					|| path.contains("cache"))) {
				current.text = new String(Files.readAllBytes(Paths.get(current.path)));
				current.source = "Index";
				current.verified = false;
				current.parsed = false;
				System.out.println("Book stored Name" + current.path);
			} else
				System.out.println("Book not stored  " + current.path);
			return null;
		}
		return current;

	}

	String removeBracket(String line) {
		String result = getBrackted(line);
		if (result != "")
			line = line.replace(result, " ");
		return line;
	}

	private Book parsebook(String line, Book current) {
		String title = "";
		String author = "";
		boolean flag = true;

		String[] sentence = line.split(" ");
		for (String word : sentence) {
			if (word.equals("by"))
				flag = false;
			if (flag)
				title = title + " " + word;
			else
				author = author + " " + word;

		}
		title = title.replace(",", " ");
		author = author.replace("by", "");
		current.title = title.trim();
		current.author = author.trim();
		return current;
	}

	private String getBrackted(String line) {
		if (line.contains("[") && line.contains("]")) {
			int begin = line.indexOf('[');
			int end = line.indexOf(']');
			if ((begin >= 0) && (begin < end) && end <= line.length())
				return line.substring(begin, end) + "]";

		}
		return "";
	}

	String TrimLastChar(String s) {
		char c = s.charAt(s.length() - 1);
		if (s.charAt(s.length() - 1) == 'C') {
			return s.substring(0, s.length() - 1);
		}
		return s;

	}

	public int lastDigit(String s) {
		int count = 0;

		if (s != null && !s.isEmpty()) {
			String d = new StringBuilder(s).reverse().toString();
			for (char c : d.toCharArray()) {
				if (Character.isDigit(c)) {
					count++;
				} else
					break;
			}
		}

		return count;
	}

}
