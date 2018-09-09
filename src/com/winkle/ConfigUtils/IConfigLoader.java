package com.winkle.ConfigUtils;

import org.openqa.selenium.WebDriver;

import java.io.File;
import java.util.ArrayList;

public interface IConfigLoader {
	
	// pull github users from a file and return them in an ArrayList
	ArrayList<String> grabUsersFromFile(File fileName);

	void setProperties();

	WebDriver setDriverOptions();



}
