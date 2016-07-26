package fr.jplc;

public class Cli2Csv {

	/* point d'entree obligatoire */

	public static void main(String[] args) throws java.io.IOException {

	/* lower case name of variables */ 
	
	String fileName;
	
	fileName = args[0];
	
	java.io.File outputFile = new java.io.File("target/output.csv");
	
	java.io.PrintWriter writer = new java.io.PrintWriter(new java.io.FileWriter(outputFile));
	
	writer.println(new java.util.Date() + ",1");

	writer.println(fileName + ",2");
	
	writer.flush();
	
	writer.close();
	
	} //fin main 

} //fin classe Cli2Csv
