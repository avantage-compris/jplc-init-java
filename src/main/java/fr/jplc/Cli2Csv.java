package fr.jplc;

public class Cli2Csv {

	/* point d'entree obligatoire */

	public static void main(String[] args) throws java.io.IOException {

	/* lower case name of variables */ 
	
	String fileName;
	
	fileName = args[0];
	
	java.io.File f0 = new java.io.File(fileName);
	
	Table t0 = Table.importCsv(f0);
	
	Table t=t0;
	
	t.setCell(1,0,"Bonjour");
	
	java.io.File outputFile = new java.io.File("target/output.csv");
	
	t.export2Csv(outputFile);
	
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

} //fin classe Cli2Csv
