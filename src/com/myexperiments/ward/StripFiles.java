package com.myexperiments.ward;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class StripFiles {

	String ProcessOneFile(String one, String two) throws IOException {
		FileInputStream fstream1 = new FileInputStream(one);
		FileInputStream fstream2 = new FileInputStream(two);

		DataInputStream in1 = new DataInputStream(fstream1);
		BufferedReader br1 = new BufferedReader(new InputStreamReader(in1));
		DataInputStream in2 = new DataInputStream(fstream2);
		BufferedReader br2 = new BufferedReader(new InputStreamReader(in2));

		String result = null, text = null;

		while (br1.readLine() == br2.readLine()) {
		}
		while ((result = br2.readLine()) != null && result.length() != 0) {
			text += result;
		}
		br1.close();
		br2.close();
		return text;
	}

	String CreateRemoveString(String one, String two) throws IOException {

		String[] lines1 = one.split(System.getProperty("line.separator"));
		String[] lines2 = two.split(System.getProperty("line.separator"));
		int place = 0;
		String text = null;
		while (lines1[place] == lines2[place]) {
			text += lines1[place];
			place++;
		}
		return text;
	}
}
