package com.rueggerllc.dataretriever;

import javax.servlet.http.HttpServletResponse;

public interface DataRetriever {
	
	public byte[] getData(HttpServletResponse response, String idString);

}
