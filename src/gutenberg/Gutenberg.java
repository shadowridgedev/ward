package gutenberg;

import org.apache.solr.common.util.NamedList;

public class Gutenberg {
	static ReverbTest Test;
	SolrInputDocumentWriter writer;;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NamedList<Object> result;

		try {
			String base = args[0];
			
			String filepath = "Z:\\gut\\gutenberg\\0\\1\\1.txt";
			String filepath2 = "C:\\Users\\shado\\git\\ward\\text";
			
			GuttenbergHelper helper = new GuttenbergHelper(base);
			FindGuttenbergInfo info = new FindGuttenbergInfo();
			String filetype = "txt";

			SolrCellRequestDemo request = new SolrCellRequestDemo();

			result = request.test("610-2", "gutenberg", filepath, filetype);
			System.out.println("Result: " + result);

			Test = new ReverbTest();

			TestFusionPipelineClient connectTest = new TestFusionPipelineClient();

			Openiework ie = new Openiework();
			Openiework.test();

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
