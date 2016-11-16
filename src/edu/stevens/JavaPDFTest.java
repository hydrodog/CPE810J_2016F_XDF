package edu.stevens;

import java.io.IOException;

public class JavaPDFTest {

    public static void main(String[] args) throws IOException {

       ImportPDF pdfManager = new ImportPDF();

//EDIT THIS FILE PATH WHEN YOU WANT TO USE THE CODE IN YOUR LOCAL PC FOR TESTING.

       //pdfManager.setFilePath("C:\\Users\\Ashutosh Gajankush\\Desktop\\file.pdf"); //Setting the file path.
       System.out.print("Text in the file:- ");
       System.out.println(pdfManager.ToText()); // Calling the toText method of the ImportPDF class.
       
       FontExtraction font = new FontExtraction();
       System.out.println("Font of the text in the File:- ");
       font.getFont();
    
}    
}