package com.zwerks.subgrapher;

import java.io.File;
import java.io.FileNotFoundException;
//import java.util.HashMap;
import java.util.ArrayList;
import java.util.Scanner;

public class RankedNodeList {
	private Scanner s;
	private String myFilePath = System.getProperty("user.dir") + "\\" + "Top-1000-Nodes.txt";
	private ArrayList<String> myList;
	
	public RankedNodeList() {
		System.out.println(myFilePath);
	}
	
	public void readFile(){
		try {
			s = new Scanner(new File(myFilePath));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//HashMap<String,String> myHashMap = new HashMap<String, String>();
		this.myList = new ArrayList<String>();
		
		while (s.hasNext()){
		    this.myList.add(s.next());
		}
		
		System.out.println("List Size: "+myList.size());
	}
	
	public boolean checkForItem(String myNode){
		Boolean containsValue = false;
		
		containsValue = this.myList.contains(myNode);
		
		return containsValue;
	}

}
