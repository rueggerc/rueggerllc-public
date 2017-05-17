package com.rueggerllc.beans;

import java.util.List;

public class MySingleton {

	private static MySingleton instance = new MySingleton();
	private MySingleton() {
	}
	
	public static MySingleton getInstance() {
		return instance;
	}

}
