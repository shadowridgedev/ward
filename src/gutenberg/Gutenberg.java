package gutenberg;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.ArrayList;
import org.apache.solr.common.util.NamedList;
import org.apache.tika.xmp.convert.*;
import org.mapdb.*;
import org.mapdb.DBMaker.Maker;
import org.mapdb.HTreeMap.KeySet;

import com.hp.hpl.jena.sparql.pfunction.library.str;

import de.citec.scie.ner.db.mapdb.MapDBDatabase;
import de.citec.scie.ner.*;
import org.apache.clerezza.rdf.core.*;
import org.apache.uima.conceptMapper.*;
import org.apache.uima.solrcas.*;

public class Gutenberg {
	static public void main(String[] args) throws IOException {
		List<String> options;

		options = getargs(args);

		if (options != null) {

			String function = options.get(0);
			Prop prop = new Prop(System.getProperty("user.dir") + options.get(1));
			;

			if (function == "youtube") {

			}

			if (function == "GetFiles") {

			}
		}
	}

	static List<String> getargs(String[] args) {
		final Map<String, List<String>> params = new HashMap<>();

		List<String> options = null;
		for (int i = 0; i < args.length; i++) {
			final String a = args[i];

			if (a.charAt(0) == '-') {
				if (a.length() < 2) {
					System.err.println("Error at argument " + a);
					return null;
				}

				options = new ArrayList<>();
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

	static ReverbTest Test;
	SolrInputDocumentWriter writer;;

	@SuppressWarnings("unchecked")
	public void doparse(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String PropPath = System.getProperty("user.dir") + args[0];
		Prop prop = new Prop(PropPath);
		WardDB wardDB = new WardDB(prop);

		Maker db = DBMaker.fileDB(prop.filedb);

		GuttenbergHelper helper = new GuttenbergHelper(prop, wardDB);

		if (wardDB.map.isEmpty()) {
			helper.searchForFilesExt(null, null, prop.GutenbergFileBase, prop.numfiles);
			FindGuttenbergInfo info = new FindGuttenbergInfo();
//			info.getinfo(map);
		}

		prop.close();
	}

}
