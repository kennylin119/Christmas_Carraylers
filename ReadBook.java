// Shruthi Venkata, Kenny Lin, Maryann Foley
// APCS1 pd8
// Final Project
// 2018-01-07

import cs1.Keyboard;
import java.util.Scanner;
import java.io.File;
import java.lang.Object;

public class ReadBook {
	
    //instance vars
	
    private Scanner _book;
    private Scanner _bookR;
    private int _page;
    private int _numPgs;
    public int _counter;
    private double _avgWordLength;
	
    //constructor
	
    public ReadBook(String genre, String subgenre, String title) {
		
	try {
	    File text = new File("Genres/" + genre + "/" + subgenre + "/" + title);
	    _book = new Scanner(text);
	    _bookR = new Scanner(text);
	    //System.out.println("hello");
	    //String text = _book.nextLine();
	    //System.out.println(text);
	}
		
	catch (Exception FileNotFoundException) {
	    System.out.println("Sorry, file not found.");
	}
		
	_counter = 0;
	_page = 0;
	_numPgs = calcPgs();
    }

    //each "page" is a specified number of words that, with average word length, is calculated to fit on a default terminal window
    //instead of making these Strings we can just make it void and SOP--evaluate return types for this and other classes
    //changes int page += 1 so the book "flips" forward
    public void next() {
	System.out.println(_page);
	if (_page==_numPgs) {
	    System.out.println( "The end - you are on the last page!");
	}
	else {
	    _page+=1;
	    System.out.println("next page: " + _page);
	    printPage();
	}
    }

    //changes int page -= 1 so the book "flips" backward
    public void back() {
	System.out.println(_page); // this does not print 
	/*if (_page==0) {
	    System.out.println("You are on the first page.");
	}
	else {
	    _page-=1;
	    System.out.println("previous page: " + _page);
	    printPage();
	    }*/
    }
		
    public int calcPgs() {
	int x;
	if (wordCounter()%350 == 0) {
	    x = wordCounter()/350;
	}
	else {
	    x = wordCounter()/350 + 1;
	}
	return x;
    }
		
    public void printPage(){
	String text = "";
	int ctrStart = (_page-1)*350;
	System.out.println("ctrStart is " + ctrStart);
	int ctrEnd = (_page)*350;
	System.out.println("ctrEnd is " + ctrEnd);
	int ctr = 0;
	while (_bookR.hasNext()) {
	    if( ctr < ctrStart ) {
		_bookR.next();
	    }
	    else if( ctr > ctrStart && ctr < ctrEnd ) {
		System.out.print(_bookR.next() + " "); //prints out word plus space
	    }
	    ctr+=1;
	}
    }

    //flips  book to specific int page number
    public void goToPage(int pg) {
		if (pg < _numPgs) {
			System.out.println("HEEELLO");
			_page = pg;
			printPage();
		}
		else {
			System.out.println("This page does not exist");
		}
	}
    }
	
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
	    _counter++;
	}
	//_book.close();
	return _counter;
    }
	
    /* public static void main (String[] args) {
		
       ReadBook blue = new ReadBook("Paine_CommonSense - short.txt");
       System.out.println();
       System.out.println(blue.wordCounter());
       } */

} //end class ReadBook
