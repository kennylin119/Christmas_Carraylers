// Shruthi Venkata, Kenny Lin, Maryann Foley
// APCS1 pd8
// Final Project
// 2018-01-07

import cs1.Keyboard;
import java.util.Scanner;
import java.io.File;

public class ReadBook {
	
    //instance vars
	
	private Scanner _book;
	private Scanner _book2;
    private int _page;
	private int _numPgs;
	public int _counter;
	private double _avgWordLength;
	
	//constructor
	
	public ReadBook(String genre, String subgenre, String title) {
		
		try {
		File text = new File("Genres/" + genre + "/" + subgenre + "/" + title);
		_book = new Scanner(text);
		_book2 = new Scanner(text);
		}
		
		catch (Exception FileNotFoundException) {
			System.out.println("Sorry, file not found.");
		}
		
		_counter = 0;
		_page = 0;
	}

    //each "page" is a specified number of words that, with average word length, is calculated to fit on a default terminal window
    //instead of making these Strings we can just make it void and SOP--evaluate return types for this and other classes
    //changes int page += 1 so the book "flips" forward
    public String next() { 
		if (_page==_numPgs) {
			return "The end - you are on the last page!";
		}
		else {
			_page+= 1;
			}
		System.out.println("going to next");
		return printPage();
	}

    //changes int page -= 1 so the book "flips" backward
    public String back() {
		if (_page==0) {
			return "You are on the first page.";
		}
		else {
			_page--;
			}
		System.out.println("going to previous");
		return printPage();
		}
		
	public int calcPgs() {
		if (wordCounter()%350 == 0) {
			_numPgs = wordCounter()/350;
		}
		else {
			_numPgs = wordCounter()/350 + 1;
		}
		return _numPgs;
	}
		
 	public String printPage(){
 	    String text = "";
			int ctrStart = (_page-1)*350;
			int ctrEnd = (_page)*350;
			int ctr = 0;
 	    while (_book2.hasNext()) {
			while( ctr < ctrStart ) {
				_book2.next();
				System.out.println("nw");
				ctr+= 1;
			}
 			while( ctr > ctrStart && ctr < ctrEnd ) {
 				text += _book2.next() + " "; //prints out word plus space
				System.out.println("nc");
				ctr+= 1;
 			}
		}
 		return text;
  	}

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
	
	//likely oversimplified but it works!
 	public int wordCounter() {
		while (_book.hasNext()) {
			_book.next();
			//comment out the previous line and uncomment the following line if you would also like to see the text (a temporary fix)
			//System.out.print(_book.next() + " ");
			_counter+= 1;
			}
			//_book.close();
		return _counter;
	}
	
    /* public static void main (String[] args) {
		
		ReadBook blue = new ReadBook("Paine_CommonSense - short.txt");
		System.out.println();
		System.out.println(blue.wordCounter()); */
		
	/* Scanner lineScanner;
	    String text = ""; 
	    while (sc.hasNext()) {
		int counter = 0;
		String nextInputLine = sc.nextLine();
		lineScanner = new Scanner(nextInputLine);
		while (lineScanner.hasNextLine())
		    {
			_counter += 1;
			text += lineScanner.next() + " "; //prints out word plus space 
			if (_counter >= 10) { //after ten words add a line break
			    _counter = 0; //temp fix will have to change after we implement sentence parsing
			    text += "\n"; 
			}
		    }
		    }
	    System.out.println(countWords(text));
	} */
    //}

} //end class ReadBook
