package gutenberg;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

import org.apache.solr.common.util.NamedList;

public class Gutenberg {
	static ReverbTest Test;
	SolrInputDocumentWriter writer;;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NamedList<Object> result;
		LinkedList<Book> only = new LinkedList<Book>();
		LinkedList<Book> books = new LinkedList<Book>();
		try {


//			String base = "Z:\\gut\\";
			String base = "/media/sf_gutenberg/";

			String filetype = "txt";
			GuttenbergHelper helper = new GuttenbergHelper("resources/ward.properties");
			only = helper.searchForFilesExt(new File(helper.GuttenbergPath),  only, filetype,  Integer.parseInt(helper.getprop("numberfiles")));
			
			
			FindGuttenbergInfo info = new FindGuttenbergInfo();
			books =  info.getinfo(only);
			only.clear();
			int I = 1;
			
/*
			SolrCellRequestDemo request = new SolrCellRequestDemo();

			result = request.test(helper.getprop("FusionServer"), "gutenberg", helper.GuttenbergPath, filetype);
			System.out.println("Result: " + result);

			Test = new ReverbTest();

			TestFusionPipelineClient connectTest = new TestFusionPipelineClient();

			Openiework ie = new Openiework();
			Openiework.test();
*/
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     
	}

	private static void writedoc() {
	}

	interface SolarInputDocumentWriter {
		// TODO Auto-generated method stub

	}

}
