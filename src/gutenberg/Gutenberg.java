package gutenberg;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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

public class Gutenberg {
	static ReverbTest Test;
	SolrInputDocumentWriter writer;;
	static String propfilepath = "resources/ward.properties";
	static Properties wardprop = new Properties();

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File initialFile = new File(propfilepath);
		InputStream in = new FileInputStream(initialFile);
		wardprop.load(in);
		String dbname = wardprop.getProperty("filedb");

		DB db = DBMaker.fileDB(wardprop.getProperty("filedb")).make();
		HTreeMap<Integer, Book> map = (HTreeMap<Integer, Book>) db.hashMap("map").createOrOpen();

		try {

			GuttenbergHelper helper = new GuttenbergHelper(propfilepath);
			int numfiles = Integer.parseInt(wardprop.getProperty("numberfiles"));
			String filetype = wardprop.getProperty("filetype");
			if (map.isEmpty()) {
				helper.searchForFilesExt(new File(helper.GuttenbergPath), map, filetype, numfiles);
//				FindGuttenbergInfo info = new FindGuttenbergInfo();
//				info.getinfo(map);
			}
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String s = "Ok";
			while (s != "") {
				System.out.print("Enter number");
				s = br.readLine();
				if (s != "")
					System.out.print(map.get(Integer.parseInt(s)).text);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		map.close();
	}

	private static void writedoc() {
	}

	interface SolarInputDocumentWriter {
		// TODO Auto-generated method stub

	}

}
