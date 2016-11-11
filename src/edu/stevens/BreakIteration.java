package BreakIteration;

import java.text.*;
import java.util.*;

public class BreakIteration {
	//Creating and using text boundaries:

		 public static void main(String args[]) {
		      if (args.length == 1) {
		          String stringToExamine = args[0];
		          //print each word in order
		          BreakIterator boundary = BreakIterator.getWordInstance();
		          boundary.setText(stringToExamine);
		          printEachForward(boundary, stringToExamine);
		          //print each sentence in reverse order
		          boundary = BreakIterator.getSentenceInstance(Locale.US);
		          boundary.setText(stringToExamine);
		          printEachBackward(boundary, stringToExamine);
		          printFirst(boundary, stringToExamine);
		          printFirst(boundary, stringToExamine);
		      }
		 }

	private static void printFirst(BreakIterator boundary, String stringToExamine) {
			// TODO Auto-generated method stub
			
		}

	private static void printEachBackward(BreakIterator boundary, String stringToExamine) {
		// TODO Auto-generated method stub
		
	}

	private static void printEachForward(BreakIterator boundary, String stringToExamine) {
		// TODO Auto-generated method stub
		
	}
		 
	
	//   Find the next word:
		 public static int nextWordStartAfter(int pos, String text) {
		     BreakIterator wb = BreakIterator.getWordInstance();
		     wb.setText(text);
		     int last = wb.following(pos);
		     int current = wb.next();
		     while (current != BreakIterator.DONE) {
		         for (int p = last; p < current; p++) {
		             if (Character.isLetter(text.codePointAt(p)))
		                 return last;
		         }
		         last = current;
		         current = wb.next();
		     }
		     return BreakIterator.DONE;
		 }
}
