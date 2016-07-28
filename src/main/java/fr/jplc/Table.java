package fr.jplc;

import java.io.*;

public class Table {

	public int rowCount=0;
	public int colCount=0;
	
	private String[] h = new String [500]; 
	private String[][] v = new String [500][20000]; 
	
	private double[][] d = new double [500][20000]; 
	
	public void setCell(int x, int y, String s) {
	
		v[x][y] = s;
		if (rowCount<=y) rowCount=y+1;
		if (colCount<=x) colCount=x+1;
	
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
	
	public static Table importCsv(File f0) throws IOException {
	
		Table t0 = new Table();
		FileReader r = new FileReader(f0);
		BufferedReader br = new BufferedReader(r);
	
		for (int j=0; ;j++) {  
			String line = br.readLine();
			if (line == null) break;
			int index = 0;
			for (int i=0; ;i++) {
				int end=line.indexOf(',',index);
				if (end==-1) {
					t0.setCell(i,j, line.substring(index));
					break;
				}
				t0.setCell(i,j,line.substring(index, end));
				index=end+1;
			}
		}
	return t0;
	}
	
} //fin classe Table
