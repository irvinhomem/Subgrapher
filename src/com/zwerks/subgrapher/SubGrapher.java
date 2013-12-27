package com.zwerks.subgrapher;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class SubGrapher {
	
	private RankedNodeList theRankedList;
	private String myBigGraphFilePath;


	public SubGrapher() {
		//myTop1000 = new ArrayList<String>();
		
		this.theRankedList = new RankedNodeList();
		this.theRankedList.readFile();
		
		//FullGraphList theFullGraph = new FullGraphList();
		//theFullGraph.readFile();
		
		myBigGraphFilePath = System.getProperty("user.dir") + "\\" + "Web-Google.txt";
	}

	public static void main(String[] args) {
		SubGrapher mySubGrapher = new SubGrapher();
		mySubGrapher.compareBigGraph();
	}
	
	public void compareBigGraph(){
		System.out.println(this.getBigGraphFilePath());
		
		Scanner s = null;
		try {
			s = new Scanner(new File(this.getBigGraphFilePath()));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String leftNode = null;
		String rightNode = null;
		int edgeCounter = 0;
		try {
			PrintWriter writeToFile = new PrintWriter(System.getProperty("user.dir") + "\\" + "outputFile.txt");
			
			
			while (s.hasNext()){
			   //myList.add(s.next());
			    leftNode = s.next();
			    if(this.theRankedList.checkForItem(leftNode)){
			    	rightNode = s.next();
			    	if(this.theRankedList.checkForItem(rightNode)){
			    		//Write to file
			    		writeToFile.println(leftNode + "\t" + rightNode);
			    		edgeCounter++;
			    		//Print out progress feedback
			    		if(edgeCounter % 100 == 0){
			    			System.out.print(".");
			    		}
			    	}
			    }else{
			    	s.next();
			    }
			}
			writeToFile.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			System.out.println();
		    System.out.println("Total Edges: " + edgeCounter);
		}
		
		//System.out.println("BIG List Size: "+myList.size());
		
	public String getBigGraphFilePath(){
		return this.myBigGraphFilePath;
	}

}
