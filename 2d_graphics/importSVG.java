package test;
/*
 * @author:
 * Read in SVG file and save the file into string varible.
 * TODO: create a class to parse SVG file. Then according to the parsed information, draw SVG file.
 */
import java.io.*;

public class importSVG {
	private String importSVG="",Line;
	public importSVG(){
		File file = new File("legoMan.svg");
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			
			//read SVG file line by line.
			Line = reader.readLine();
			while(Line != null){
				importSVG = importSVG + Line;
				Line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	public static void main(String[] args){
		importSVG i1 = new importSVG();
		System.out.print(i1.importSVG);
	}

}
