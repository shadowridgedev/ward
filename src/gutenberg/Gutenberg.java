package gutenberg;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Properties;

import org.apache.solr.common.util.NamedList;
import org.apache.tika.xmp.convert.*;
import org.mapdb.*;
import org.mapdb.DBMaker.Maker;
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

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Prop prop = new Prop(args[0]);
		WardDB wardDB = new WardDB(prop);

		Maker db = DBMaker.fileDB(prop.filedb);

		GuttenbergHelper helper = new GuttenbergHelper(prop, wardDB);

		if (wardDB.map.isEmpty()) {
			helper.searchForFilesExt(prop.GutenbergFileBase, prop.numfiles);
//				FindGuttenbergInfo info = new FindGuttenbergInfo();
//				info.getinfo(map);
		}

		prop.close();
	}

	private static void writedoc() {

	}

	interface SolarInputDocumentWriter {
		// TODO Auto-generated method stub

	}

}
