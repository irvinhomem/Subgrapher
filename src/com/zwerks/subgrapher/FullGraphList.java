package com.zwerks.subgrapher;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FullGraphList {

	private Scanner s;
	private String myFilePath = System.getProperty("user.dir") + "\\" + "Web-Google.txt";
	
	public FullGraphList() {
		System.out.println(myFilePath);
	}
	
	public void readFile(){
		try {
			s = new Scanner(new File(myFilePath));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<String> myList = new ArrayList<String>();
		
		while (s.hasNext()){
		    myList.add(s.next());
		}
		
		System.out.println("BIG List Size: "+myList.size());
	}
}
