package com.winkle;

import java.util.ArrayList;

public interface IConfigLoader {
	
	// pull github users from a file and return them in an ArrayList
	ArrayList<String> grabUsersFromFile();

}
