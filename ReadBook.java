// Shruthi Venkata, Kenny Lin, Maryann Foley
// APCS1 pd8
// Final Project
// 2018-01-07

//import cs1.Keyboard;
import java.util.Scanner;
import java.io.File;

public class ReadBook {
	
    //instance vars
	
	public Scanner _book;
    private int _page;
	public int _counter;
	
	//constructor
	
	public ReadBook(String bookChoice) {
		
		try {
		File text = new File("Genres/Nonfiction/" + bookChoice);
		_book = new Scanner(text);
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
    /* 	public String next() { 
		
	} */

    //changes int page -= 1 so the book "flips" backward
    	public String back() {
		if (_page==0) {
			return "You are on the first page.";
		}
		else {
			_page--;
			return "";
			}
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
 
/*     public int countWords(String text){
		boolean word = false;
		int endOfLine = text.length() - 1;
		//could we make this neater using Character.isWhitespace() ?
		for (int i = 0; i < text.length(); i++) {
			// if the char is a letter, word = true.
			if (Character.isLetter(text.charAt(i)) && i != endOfLine) {
				word = true;
			// if char isn't a letter and there have been letters before,
			// counter goes up.
			}
			else if (!Character.isLetter(text.charAt(i)) && word) {
				_counter += 1;
				word = false;
			// last word of String; if it doesn't end with a non letter, it
			// wouldn't count without this.
			}
			else if (Character.isLetter(text.charAt(i)) && i == endOfLine) {
				_counter += 1;
			}
		}
		return _counter;
    } */
	
	//likely oversimplified but it works!
 	public int wordCounter() {
		while (_book.hasNext()) {
			_book.next();
			//comment out the previous line and uncomment the following line if you would also like to see the text (a temporary fix)
			//System.out.print(_book.next() + " ");
			_counter++;
			}
		return _counter;
	}
	
    public static void main (String[] args) {

		ReadBook blue = new ReadBook("Paine_CommonSense - short.txt");
		System.out.println();
		System.out.println(blue.wordCounter());
		
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
    }

} //end class ReadBook
