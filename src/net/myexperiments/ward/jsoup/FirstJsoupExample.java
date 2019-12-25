package net.myexperiments.ward.jsoup;

import java.io.File;
import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class FirstJsoupExample {
	public static void main(String[] args) throws IOException {
		Document doc = Jsoup.connect("http://www.javatpoint.com").get();
		String title = doc.title();
		System.out.println("title is: " + title);

		Document doc1 = Jsoup.connect("http://www.javatpoint.com").get();
		String keywords = doc1.select("meta[name=keywords]").first().attr("content");
		System.out.println("Meta keyword : " + keywords);
		String description = doc1.select("meta[name=description]").get(0).attr("content");
		System.out.println("Meta description : " + description);

	}

	void getvideo() {
		try {
			String htmlUrl = null;
			Connection.Response response = Jsoup.connect(htmlUrl).userAgent(
					"Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/535.21 (KHTML, like Gecko) Chrome/19.0.1042.0 Safari/535.21")
					.timeout(1000000).execute();

			int statusCode = response.statusCode();
			println("TAG", " status code is: " + statusCode);
			if (statusCode == 200) {
				Element doc = Jsoup.connect(htmlUrl).timeout(1000 * 1000).get();
				Elements meta = doc.select("meta[property=og:video]");

				for (Element src : meta) {
					if (src.tagName().equals("meta"))
						println("TAG", " content: " + src.attr("content"));
					else
						println("TAG", src.tagName());
				}
			} else {
				System.out.println("received error code : " + statusCode);
			}
		} catch (IOException e) {
			println("TAG", " Exception " + e);
			e.printStackTrace();

		}
	}

	private void println(String string, String string2) {
		// TODO Auto-generated method stub
		System.out.print(string);
		System.out.println(string2);
	}

	void printimages() throws IOException {

		Document doc = Jsoup.connect("http://www.javatpoint.com").get();
		Elements images = doc.select("img[src~=(?i)\\.(png|jpe?g|gif)]");
		for (Element image : images) {
			System.out.println("src : " + image.attr("src"));
			System.out.println("height : " + image.attr("height"));
			System.out.println("width : " + image.attr("width"));
			System.out.println("alt : " + image.attr("alt"));
		}

	}

	void GetLinks() throws IOException {

		Document doc = Jsoup.connect("http://www.javatpoint.com").get();

		Elements links = doc.select("a[href]");

		for (Element link : links) {
			System.out.println("\nlink : " + link.attr("href"));
			System.out.println("text : " + link.text());
		}
	}

	void getimager() throws IOException {

		Document doc = Jsoup.connect("http://www.javatpoint.com").get();
		Elements images = doc.select("img[src~=(?i)\\.(png|jpe?g|gif)]");
		for (Element image : images) {
			System.out.println("src : " + image.attr("src"));
			System.out.println("height : " + image.attr("height"));
			System.out.println("width : " + image.attr("width"));
			System.out.println("alt : " + image.attr("alt"));
		}
	}

	String getformvalues() throws IOException {

		Document doc = Jsoup.parse(new File("e:\\register.html"), "utf-8");
		Element loginform = doc.getElementById("registerform");

		Elements inputElements = loginform.getElementsByTag("input");
		for (Element inputElement : inputElements) {
			String key = inputElement.attr("name");
			String value = inputElement.attr("value");
			System.out.println("Param name: " + key + " \nParam value: " + value);

		}
		return null;

	}
}