package edu.stevens;

import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;


public class myPrintSetup {
	// data member
		private PrinterJob pj = PrinterJob.getPrinterJob();
		//private MenuItem convertPdg2Ps = new MenuItem("Convert");
		//private MenuItem printSetup = new MenuItem("Print Setup");
		
		// method part
		public myPrintSetup(){
			
		}
		
		//TODO: maybe we should add a file choose window; 
		
		/*@author Alex Qu
		 * NOTICE!!! in this method you must deploy printMenuItem() to add action listener to menu item
		 * */
		public void GUIInitial(){}
		
		/*@author Alex Qu
		 * this method is used to set the action of menu item
		 * */
	/*	public void printMenuItem(){
			convertPdg2Ps.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					
				}
				
			});
			
			printSetup.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
				}
				
			});
		}
		*/
		/*@author Alex Qu
		 * this method is used to create a printer dialog
		 * in the dialog the information of page format should be delivery to service class
		 * */
		public void myPrintDialog(){
			//PrinterJob pj = PrinterJob.getPrinterJob();
			if(pj.printDialog()){
				try{pj.print();}
				catch(PrinterException exc){
					//TODO get a warning window
					System.out.println(exc);
				}
			}
		}
		
		public static void main(String[] arg){
			myPrintSetup pg= new myPrintSetup();
			pg.myPrintDialog();
			
		}
}
