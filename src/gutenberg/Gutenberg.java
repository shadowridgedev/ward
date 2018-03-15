package gutenberg;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.solr.common.util.NamedList;

public class Gutenberg {
	static ReverbTest Test;
	SolrInputDocumentWriter writer;;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NamedList<Object> result;
      
		try {


			String base = "Z:\\gut\\";
			ArrayList<String> only = new ArrayList<String>();
			String filepath1 = base+ "gutenberg\\0\\1\\1.txt";
			String filetype = "txt";
			GuttenbergHelper helper = new GuttenbergHelper("resources\\ward.properties");
			int num = helper.searchForFilesExt(new File(helper.GuttenbergPath),  only, filetype,  Integer.parseInt(helper.getprop("numberfiles")));
			
			
			FindGuttenbergInfo info = new FindGuttenbergInfo();
			List<Book> booklist =  info.getinfo(only);
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
