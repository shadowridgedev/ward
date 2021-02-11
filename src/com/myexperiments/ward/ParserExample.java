package com.myexperiments.ward;

import java.io.FileInputStream;
import java.io.InputStream;

import opennlp.tools.cmdline.parser.ParserTool;
import opennlp.tools.parser.Parse;
import opennlp.tools.parser.Parser;
import opennlp.tools.parser.ParserFactory;
import opennlp.tools.parser.ParserModel;

public class ParserExample {

	public static void main(String args[]) throws Exception {
		// Loading parser model
		InputStream inputStream = new FileInputStream(".../en-parserchunking.bin");
		ParserModel model = new ParserModel(inputStream);

		// Creating a parser
		Parser parser = ParserFactory.create(model);

		// Parsing the sentence
		String sentence = "Tutorialspoint is the largest tutorial library.";
		Parse topParses[] = ParserTool.parseLine(sentence, parser, 1);

		for (Parse p : topParses)
			p.show();
	}
}