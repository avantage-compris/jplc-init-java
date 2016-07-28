package fr.jplc;

import java.io.*;

public class Table {

	public int rowCount=0;
	public int colCount=0;
	
	private String[] h = new String [50]; 
	private String[][] v = new String [50][200]; 
	
	private double[][] d = new double [50][200]; 
	
	public void setCell(int x, int y, String s) {
	
		v[x][y] = s;
		if (rowCount<=y) rowCount=y+1;
		if (colCount<=x) rowCount=x+1;
	
	}
	
	public void export2Csv(File f) throws IOException {
	
	PrintWriter writer = new PrintWriter(new FileWriter(f));
	
	for (int j=0; j < rowCount; j++) {
	
		for (int i=0; i < colCount; i++) {
	
			if (i>0) writer.print(',');
			writer.print(v[i][j]);
	
		}	

	writer.println();
		
	}
	
	writer.flush();
	
	writer.close();
	
	}
	
} //fin classe Table
