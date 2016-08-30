package fr.jplc;

import java.io.File;

public class Cli2Csv {

	/* point d'entree obligatoire */

	public static void main(String[] args) throws java.io.IOException {

	/* lower case name of variables */ 
	
	String fileName;
	
	fileName = args[0];
	
	java.io.File f0 = new java.io.File(fileName);
	
	Table t0 = Table.importCsv(f0);
	
	Table t=t0;
	
	/*
	t.setCell(1,0,"Bonjour");
	*/
	miDaFill(t);
	//fillMissingData(t);
	
	java.io.File outputFile = new java.io.File("target/output.csv");
	
	t.export2Csv(outputFile);
	
	Table t2 = covm(t, 1, 60);
	
	File f2 = new File("target/covm.csv");
	
	t2.export2Csv(f2);
		
	/*
	java.io.PrintWriter writer = new java.io.PrintWriter(new java.io.FileWriter(outputFile));
	writer.println(new java.util.Date() + ",1");
	writer.println(fileName + ",2");
	writer.flush();
	writer.close();
	*/
	
	/*
	Table t = new Table();
	t.setCell(0,0,new java.util.Date().toString());
	t.setCell(1,0,"1");
	t.setCell(0,1,fileName);
	t.setCell(1,1,"2");
	t.export2Csv(outputFile);
	*/

	
	} //fin main 

	private static void miDaFill(Table t) {
		for (int i=0; i<t.colCount; i++) {
			double firstData=0.0;
			for (int j=0; j<t.rowCount; j++) {
				if (t.hasDoubleValue(i, j)) {
					firstData=t.getDoubleValue(i,j);
					break;
				}
			}
			for (int j=0; j<t.rowCount; j++) {
				if (t.hasMissingData(i, j)) {
					t.setCell(i,j, firstData);
				} else if (t.hasDoubleValue(i,j)) {
					firstData=t.getDoubleValue(i,j);
				}
			}
		}
	}
	
	private static Table covm(Table t, double lda0, int stp) {
	
		double y[][] = new double [t.colCount][t.rowCount];
	
		double lda=0.0;
		double temp=0.0;
	
		Table u = new Table();
		
		for (int k=stp; k<t.rowCount; k++) {	
			lda=0.0;
			for (int i=0; i<t.colCount; i++) {
				for (int j=0; j<=i; j++) {
					temp = (t.getDoubleValue(i,k) - t.getDoubleValue(i,k-stp)) * (t.getDoubleValue(j,k) - t.getDoubleValue(j,k-stp)) ;
					y[i][j]= lda * y[i][j] + (1.0 - lda) * temp ;
					y[j][i] = y[i][j] ;
				}
			}
			lda = 1.0 / (2.0 - lda);
			if (lda > lda0) {lda = lda0;
			}
		}
		for (int i=0; i<t.colCount; i++) {
			for (int j=0; j<t.colCount; j++) {
				u.setCell(i, j, y[i][j]);
			}
		}
		return u;			
	}
	
	
} //fin classe Cli2Csv
