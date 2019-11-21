package com.myexperiments.ward;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.uima.UIMAException;
import org.apache.uima.analysis_engine.AnalysisEngine;
import org.apache.uima.analysis_engine.AnalysisEngineDescription;
import org.apache.uima.collection.CollectionReader;
import org.apache.uima.fit.factory.AggregateBuilder;
import org.apache.uima.fit.factory.AnalysisEngineFactory;
import org.apache.uima.fit.pipeline.SimplePipeline;
import org.apache.uima.fit.testing.util.HideOutput;
import org.apache.uima.resource.ResourceInitializationException;

import org.apache.uima.UimaContext;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.fit.descriptor.TypeCapability;
import org.apache.uima.jcas.JCas;
import org.cleartk.ml.CleartkSequenceAnnotator;
import org.cleartk.ml.Feature;
import org.cleartk.ml.Instances;
import org.cleartk.ml.chunking.BioChunking;
import org.cleartk.ml.feature.extractor.CleartkExtractor;
import org.cleartk.ml.feature.extractor.CleartkExtractor.Following;
import org.cleartk.ml.feature.extractor.CleartkExtractor.Preceding;
import org.cleartk.ml.feature.extractor.CombinedExtractor1;
import org.cleartk.ml.feature.extractor.CoveredTextExtractor;
import org.cleartk.ml.feature.extractor.FeatureExtractor1;
import org.cleartk.ml.feature.function.CharacterCategoryPatternFunction;
import org.cleartk.ml.feature.function.FeatureFunctionExtractor;
import org.cleartk.ml.jar.DefaultSequenceDataWriterFactory;
import org.cleartk.ml.jar.DirectoryDataWriterFactory;
import org.cleartk.ml.jar.GenericJarClassifierFactory;
import org.mapdb.DBMaker;
import org.mapdb.DBMaker.Maker;

import static org.apache.uima.fit.factory.AnalysisEngineFactory.createEngine;
import static org.apache.uima.fit.pipeline.SimplePipeline.runPipeline;
import static org.apache.uima.fit.factory.AnalysisEngineFactory.*;

import edu.stanford.nlp.pipeline.SentenceAnnotator;
import opennlp.tools.stemmer.snowball.SnowballStemmer;
import org.ie4opendata.octroy.ContractClassifier;
import org.ie4opendata.octroy.AmountAnnotator;
import org.ie4opendata.octroy.FilesCollectionReader;
import org.ie4opendata.octroy.ReasonAnnotator;
import org.ie4opendata.octroy.ContractFlowController;
import org.ie4opendata.octroy.TsvWriter;

public class Gutenberg {
	static ArrayList<String> options;
	static String PropPath;
	static Prop prop;

	static public void main(String[] args) throws Exception {

		options = getargs(args);
		String PropPath = System.getProperty("user.dir") + "\\" + options.get(1);
		Prop prop = new Prop(PropPath);
		if (options != null) {

			String function = options.get(0);

			if (function.equals("youtube")) {
				Getvideo video = new Getvideo(options, prop);
			}
			if (function.equals("GetFiles")) {
				doparse();
			}
		}
	}

	static public ArrayList<String> getargs(String[] args) {
		final Map<String, List<String>> params = new HashMap<>();

		ArrayList<String> options = new ArrayList<String>();

		for (int i = 0; i < args.length; i++) {
			final String a = args[i];

			if (a.charAt(0) == '-') {
				if (a.length() < 2) {
					System.err.println("Error at argument " + a);
					return null;
				}

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

	@SuppressWarnings("unchecked")
	public static void doparse() throws Exception {

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
