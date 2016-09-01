package fr.jplc;

import java.io.*;

public class Table {

	private int colCountMax;
	private int rowCountMax;
	
	public Table() {
		colCountMax = 500;
		rowCountMax = 20000;
		h = new String [colCountMax];
		v = new String [colCountMax][rowCountMax];
		d = new double [colCountMax][rowCountMax];		
	}

	public Table(int c, int r) {
		colCountMax = c;
		rowCountMax = r;
		h = new String [colCountMax];
		v = new String [colCountMax][rowCountMax];
		d = new double [colCountMax][rowCountMax];		
	}
	
	public int rowCount=0;
	public int colCount=0;
	
	private String[] h;
	private String[][] v; 
	private double[][] d;
	
	public void setCell(int x, int y, String s) {
	
		/*
		v[x][y] = s;
		*/
		Double dbl;
		try {
			dbl=Double.valueOf(s);
			} catch(Exception e) {
			dbl=null;
			}
		if (dbl!=null) {
			d[x][y]=dbl.doubleValue();
			v[x][y]=null;
		} else {
			v[x][y]=s;
		}
		if (rowCount<=y) rowCount=y+1;
		if (colCount<=x) colCount=x+1;
	}
	
	public void setCell(int x, int y, double z) {
		d[x][y]=z;
		v[x][y]=null;
		if (rowCount<=y) rowCount=y+1;
		if (colCount<=x) colCount=x+1;
	}
	
	public boolean hasDoubleValue(int x, int y) {
		return (v[x][y]==null);
	}
	
	public boolean hasMissingData(int x, int y) {
		return (v[x][y]!=null && v[x][y].length()==0);
	}
	
	public double getDoubleValue(int x, int y) {
		return d[x][y];
	}
	
	public void export2Csv(File f) throws IOException {
	
	PrintWriter writer = new PrintWriter(new FileWriter(f));
	
	for (int j=0; j < rowCount; j++) {
		for (int i=0; i < colCount; i++) {
			if (i>0) writer.print(',');
			/*
			writer.print(v[i][j]);
			*/
			if (v[i][j]==null) {
				writer.print(d[i][j]);
			} else {
				writer.print(v[i][j]);
			}
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
