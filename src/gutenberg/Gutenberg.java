package gutenberg;

import com.lucidworks.client.SolrInputDocumentWriter;
import com.lucidworks.client.TestFusionPipelineClient;

public class Gutenberg {
	static ReverbTest Test;
	SolrInputDocumentWriter writer;;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			String base = args[0];
			GuttenbergHelper helper = new GuttenbergHelper(base);
			FindGuttenbergInfo info = new FindGuttenbergInfo();
			String sentStr = "Michael McGinn is the mayor of Seattle.";
//			Test = new ReverbTest();

			TestFusionPipelineClient connectTest = new TestFusionPipelineClient();
			
//			Openiework ie = new Openiework();
//			ie.test();

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
