package com.rueggerllc.dataretriever;

import java.util.HashMap;
import java.util.Map;

public class DataRetrieverFactory {
	
	private static DataRetrieverFactory instance;
	private static Map<String,DataRetriever> dataRetrievers;
	private static final String PET_DATA_RETRIEVER = "pet";
	private static final String COMPANY_DATA_RETRIEVER = "company";
	private static final String FILEBLOB_DATA_RETRIEVER = "fileblob";
	
	
	private DataRetrieverFactory() {
		dataRetrievers = new HashMap<String,DataRetriever>();
		dataRetrievers.put(PET_DATA_RETRIEVER, new PetDataRetriever());
		// dataRetrievers.put(COMPANY_DATA_RETRIEVER, new CompanyDataRetriever());
		// dataRetrievers.put(FILEBLOB_DATA_RETRIEVER, new FileBlobDataRetriever());
	}
	
	private static DataRetrieverFactory getInstance() {
		if (instance == null) {
			instance = new DataRetrieverFactory();
		}
		return instance;
	}
	
	public static DataRetriever getDataRetriever(String type) throws Exception {
		DataRetriever dataRetriever = getInstance().dataRetrievers.get(type);
		if (dataRetriever == null) {
			throw new Exception ("Data Retriver not found for type: " + type);
		}
		return dataRetriever;
	}

}
