package fr.jplc;

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
	
	
	
} //fin classe Table
