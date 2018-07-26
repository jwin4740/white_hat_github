package com.winkle;

import java.util.ArrayList;
import java.io.IOException;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class IConfigLoaderImpl implements IConfigLoader {
	private Properties prop = new Properties();
	private InputStream input = null;
	private String passWord = null;
	private String userName = null;

//	public ConfigLoader(String userName, String passWord) {
//	
//		
//		this.passWord = passWord;
//		this.userName = userName;
//	}

	public ArrayList<String> grabUsersFromFile(){
		ArrayList<String> j = new ArrayList<String>();
		return j;
	}
//		String csvFile = "users.csv";
//		BufferedReader br = null;
//		String line = "";
//		String cvsSplitBy = ",";
//
//		try {
//
//			br = new BufferedReader(new FileReader(csvFile));
//			while ((line = br.readLine()) != null) {
//
//				// use comma as separator
//				String[] country = line.split(cvsSplitBy);
//
//				System.out.println("Country [code= " + country[4] + " , name=" + country[5] + "]");
//
//			}
//
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		} finally {
//			if (br != null) {
//				try {
//					br.close();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//	}

	public String getUserName() {
		return this.userName;
	}

	public String getPassword() {
		return this.passWord;
	}

	public void setUsernameAndPassword() {
		try {

			input = new FileInputStream("config.properties");

			// load a properties file
			prop.load(input);

			// get the property value and print it out
			this.userName = prop.getProperty("username");
			this.passWord = prop.getProperty("password");

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {

				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
