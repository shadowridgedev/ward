package gutenberg;
import  com.lucidworks.client.SolrInputDocumentWriter;

public class Eclipsetest {
	static ReverbTest	  Test;
	SolrInputDocumentWriter writer;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	   
		try {
			String base = args[0];
			GuttenbergHelper helper = new GuttenbergHelper(base);
			FindGuttenbergInfo info = new FindGuttenbergInfo();
			String sentStr = "Michael McGinn is the mayor of Seattle.";
			 Test = new ReverbTest();


			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


}

	
}
