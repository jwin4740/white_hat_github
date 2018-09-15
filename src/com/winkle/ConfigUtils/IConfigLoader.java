package com.winkle.ConfigUtils;

import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public interface IConfigLoader {
	
	// pull github users from a file and return them in an ArrayList
//	ArrayList<String> grabUsersFromFile();

	void setProperties();

	WebDriver setDriverOptions();



}
