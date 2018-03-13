package gutenberg;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;

import org.apache.solr.common.util.NamedList;

public class Gutenberg {
	static ReverbTest Test;
	SolrInputDocumentWriter writer;;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NamedList<Object> result;
      
		try {


			String base = "Z:\\gut\\";
			ArrayList<File> only = null;
			String filepath1 = base+ "gutenberg\\0\\1\\1.txt";
			String filetype = "txt";
			GuttenbergHelper helper = new GuttenbergHelper("/resources/ward.properties");
			int num = helper.searchForFilesExt(new File(helper.GuttenbergPath),  only, filetype, 2);
			
			
			FindGuttenbergInfo info = new FindGuttenbergInfo();
		
/*
			SolrCellRequestDemo request = new SolrCellRequestDemo();

			result = request.test("610-1", "gutenberg", helper.GuttenbergPath, filetype);
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
