package gutenberg;

import java.io.IOException;
import java.util.LinkedList;

import edu.washington.cs.knowitall.examples.ReVerbExample;
/* For representing a sentence that is annotated with pos tags and np chunks.*/
import edu.washington.cs.knowitall.nlp.ChunkedSentence;

/* String -> ChunkedSentence */
import edu.washington.cs.knowitall.nlp.OpenNlpSentenceChunker;
import edu.washington.cs.knowitall.nlp.extraction.ChunkedBinaryExtraction;
/* The class that is responsible for extraction. */
import edu.washington.cs.knowitall.extractor.ReVerbExtractor;

/* The class that is responsible for assigning a confidence score to an
 * extraction.
 */
import edu.washington.cs.knowitall.extractor.conf.ConfidenceFunction;
import edu.washington.cs.knowitall.extractor.conf.ConfidenceFunctionException;
import edu.washington.cs.knowitall.extractor.conf.ReVerbOpenNlpConfFunction;

public class ReverbTest {
	
	
	ReverbProcessing processor;
	
	ReverbTest () throws Exception {
		processor = new ReverbProcessing();
			
	}
	
	public LinkedList<ChunkedBinaryExtraction> chunksentence(String sentStr) throws IOException {
		ChunkedSentence chunked = processor.ReverbChunk(sentStr);
		return processor.ReverbChunk(chunked);	
	}
}
