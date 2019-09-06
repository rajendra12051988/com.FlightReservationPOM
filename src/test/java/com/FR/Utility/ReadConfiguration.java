package com.FR.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfiguration {
	
	static Properties p = new Properties();
	
	public static Properties getTestData() throws IOException {
		
		File file = new File(System.getProperty("user.dir")+"\\testData.properties");
		FileInputStream stream = new FileInputStream(file);
		
		p.load(stream);
		
		return p;
		
	}

}
