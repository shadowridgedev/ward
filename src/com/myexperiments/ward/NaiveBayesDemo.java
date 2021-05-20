package com.myexperiments.ward;
/*
 * import java.io.File;
 * 
 * import weka.classifiers.Classifier; import weka.classifiers.Evaluation;
 * import weka.classifiers.bayes.NaiveBayesMultinomial; import
 * weka.core.Instances; import weka.core.converters.ArffLoader; import
 * weka.filters.Filter; import
 * weka.filters.unsupervised.attribute.StringToWordVector;
 * 
 * 
 * public class NaiveBayesDemo {
 * 
 * public static final String TRAINING_DATA_SET_FILENAME = "naive-train.arff";
 * public static final String TESTING_DATA_SET_FILENAME = "naive-test.arff";
 * public static final String PREDICTION_DATA_SET_FILENAME =
 * "naive-confused.arff";
 * 
 * 
 * public static Instances getDataSet(String fileName) throws Exception {
 * 
 * StringToWordVector filter = new StringToWordVector(); int classIdx = 1;
 * 
 * ArffLoader loader = new ArffLoader();
 * 
 * loader.setSource(NaiveBayesDemo.class.getResourceAsStream("/" + fileName));
 * 
 * // loader.setFile(new File(fileName)); Instances dataSet =
 * loader.getDataSet();
 * 
 * dataSet.setClassIndex(classIdx); filter.setInputFormat(dataSet); dataSet =
 * Filter.useFilter(dataSet, filter); return dataSet; }
 * 
 * 
 * public static void process() throws Exception {
 * 
 * Instances trainingDataSet = getDataSet(TRAINING_DATA_SET_FILENAME); Instances
 * testingDataSet = getDataSet(TESTING_DATA_SET_FILENAME); Instances
 * predictingDataSet = getDataSet(PREDICTION_DATA_SET_FILENAME);
 * 
 * Classifier classifier = new NaiveBayesMultinomial();
 * 
 * Evaluation eval = new Evaluation(trainingDataSet);
 * eval.evaluateModel(classifier, testingDataSet);
 * 
 * System.out.println("** Naive Bayes Evaluation with Datasets **");
 * System.out.println(eval.toSummaryString());
 * System.out.print(" the expression for the input data as per alogorithm is ");
 * System.out.println(classifier); for (int i = 0; i <
 * predictingDataSet.numInstances(); i++) {
 * System.out.println(predictingDataSet.instance(i)); double index =
 * classifier.classifyInstance(predictingDataSet.instance(i)); String className
 * = trainingDataSet.attribute(0).value((int) index);
 * System.out.println(className); }
 * 
 * } }
 */