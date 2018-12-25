package gutenberg;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Properties;

import org.apache.solr.common.util.NamedList;
import org.apache.tika.xmp.convert.*;
import org.mapdb.*;
import org.mapdb.HTreeMap.KeySet;

import de.citec.scie.ner.db.mapdb.MapDBDatabase;
import de.citec.scie.ner.*;
import org.apache.clerezza.rdf.core.*;
import org.apache.uima.conceptMapper.*;
import org.apache.uima.solrcas.*;
import org.apache.uima.examples.*;
import opennlp.uima.sentdetect.SentenceDetector;

public class ProcessGutenberg {
	int count;
	String GuttenbergPath;
	String NotGuttenbergPath;
	String RemoveText;
	String CleanBook;
	String prop;
	Properties wardprop = new Properties();
	ArrayList<String> cuttext;
	private ArrayList<String> removetext = new ArrayList<String>();

	ProcessGutenberg(String propertyfilepath) throws IOException {
		File initialFile = new File(propertyfilepath);
		InputStream in = new FileInputStream(initialFile);
		wardprop.load(in);
		prop = getprop("GutenbergFileBase");
		GuttenbergPath = prop + "/gutenberg/";
		NotGuttenbergPath = prop + "/NotGuttenberg/";
		RemoveText = "E:/RemoveText/";
		CleanBook = prop + "/CleanBook/";
		cuttext = removetext();
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

}
