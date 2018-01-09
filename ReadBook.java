// Shruthi Venkata, Kenny Lin, Maryann Foley
// APCS1 pd8
// Final Project
// 2018-01-07

//import cs1.Keyboard;
import java.util.Scanner;
import java.io.File;

public class ReadBook {
	
	//instance vars
	private String book;
	private int page;
	//**check this:
	//private static final String[] WORDS = Stats.wordCounter();

	//each "page" is a specified number of words that, with average word length, is calculated to fit on a default terminal window
	//instead of making these Strings we can just make it void and SOP--evaluate return types for this and other classes
    //changes int page += 1 so the book "flips" forward
    /* 	public String next() { 
		
	} */

    //changes int page -= 1 so the book "flips" backward
/* 	public String back() {
		
	} */

    //flips  book to specific int page number
/* 	public String goToPage() {
		
	} */
	
	//RETURN TYPE? will it return a page number so that the user can check?
    //int? maybe a string containing all listing of word 
    /* 	public String findWord() {
		
	} */

    //stores int page for future visits to book
    //how does it store it tho?
    //It will write to a file but we still have to determine exactly how we are doing that
/* 	public void pageMarker() {
		
	} */

    //flips book to int page stored by pageMarker
    //we can prob build this one off goToPage()
/* 	public String returnToPage() {
		
	}
 */
 
	public static void main (String[] args) {
	    try {File test = new File("Genres/Nonfiction/Paine_CommonSense.txt");
	Scanner sc = new Scanner(test);
	Scanner lineScanner;
		while (sc.hasNext()) {
		    int counter = 0;
		    String nextInputLine = sc.nextLine();
		    lineScanner = new Scanner(nextInputLine);
		    while (lineScanner.hasNext())
		    {
			counter += 1;
			System.out.print(lineScanner.next() + " "); //prints out word plus space 
			if (counter > 10) { //after ten words add a line break 
			    counter = 0;
			    System.out.print("\n");
			}
		    }
		}
	    }
	catch (Exception FileNotFoundException) {
		System.out.println("Sorry, file not found.");
	}
	}

} //end class ReadBook
