package Amazon_Framework;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Config {

	
		public static Properties properties;
		public static String propertyFilePath="Configuration//Config.properties";
		
		public static String configfileReader(String Configproname) throws java.io.IOException 
		{
			String value = null;
			BufferedReader reader;
			try {
				reader = new BufferedReader(new FileReader(propertyFilePath));
				properties = new Properties();
				try {
					properties.load(reader);
					value = properties.getProperty(Configproname);
					reader.close();
				}
			
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}
			catch (FileNotFoundException e)
			{
				e.printStackTrace();
				throw new RuntimeException("Configuration path not found at" + propertyFilePath);
			}
		
			return value;
		}	
}
