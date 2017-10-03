package com.rueggerllc;

import java.io.Serializable;
import java.util.Arrays;

import org.apache.log4j.Logger;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.api.java.function.PairFunction;

import scala.Tuple2;

public class WordCounter implements Serializable {
	
	
	private static final Logger logger = Logger.getLogger(WordCounter.class);
	
	public void execute() {
		try {
			logger.info("WordCounter.execute() BEGIN");
			SparkConf conf = new SparkConf().setMaster("local").setAppName("ChrisApp");
			JavaSparkContext sc = new JavaSparkContext(conf);
			logger.info("SparkContext init");
			
			// String inputFile = "C:/junk/data/README.md";
			String inputFile = "C:/junk/data/junk.txt";
			String outputFile = "C:/junk/data/counts";

			JavaRDD<String> input = sc.textFile(inputFile);
			logger.info("Got File");
			
			JavaRDD<String> words = input.flatMap(new FlatMapFunction<String,String>() {
				public Iterable<String> call(String x) {
					return Arrays.asList(x.split(" "));
				}});
			
			logger.info("Got Words");
			
			// Transform into pairs and count
			JavaPairRDD<String,Integer> counts = words.mapToPair(new PairFunction<String,String,Integer>() {
				public Tuple2<String,Integer> call(String x) {
					return new Tuple2(x,1);
				}}).reduceByKey(new Function2<Integer,Integer,Integer>() {
					public Integer call(Integer x, Integer y) {
						return x+y;}});
			counts.saveAsTextFile(outputFile);
			logger.info("Data Written To File");
			
		} catch (Exception e) {
			logger.error("Error", e);
		}
	}

}
