// Shruthi Venkata, Kenny Lin, Maryann Foley
// APCS1 pd8
// Final Project
// 2018-01-07

//import cs1.Keyboard;
import java.util.Scanner;
import java.io.File;

public class ReadBook {
	
    //instance vars

	private File _text;
    private int _page;
	private int _numPgs;
	public int _wordCount;
	private double _avgWordLength;
    private int _charCount;
    private int _sentenceCount;
    private int _avgWL;
    private int _avgSL;
    private String _textStr; //string version of text
	private String _genre;
	private String _subgenre;
	private String _title;
	
	//constructor
	
	public ReadBook(String genre, String subgenre, String title) {
		_genre = genre;
		_subgenre = subgenre;
		_title = title;
		/* try {
		_text = new File("Genres/" + genre + "/" + subgenre + "/" + title);
		}
		
		catch (Exception FileNotFoundException) {
			System.out.println("Sorry, file not found.");
		} */
		_wordCount = 0;
		_page = 0;
		_numPgs = calcPgs();
	}

    //each "page" is a specified number of words that, with average word length, is calculated to fit on a default terminal window
    //instead of making these Strings we can just make it void and SOP--evaluate return types for this and other classes
    //changes int page += 1 so the book "flips" forward
    public void next() {
		if (_page>=_numPgs-1) {
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
		if (_page<=1) {
			System.out.println("You are on the first page.");
		}
		else {
			_page-=1;
			System.out.println("previous page: " + _page);
			printPage();
			}
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
		try {
			_text = new File("Genres/" + _genre + "/" + _subgenre + "/" + _title);
			Scanner book = new Scanner(_text);
		
 	    String text = "";
			int ctrStart = (_page-1)*350;
			System.out.println("ctrStart is " + ctrStart);
			int ctrEnd = (_page)*350;
			System.out.println("ctrEnd is " + ctrEnd);
			int ctr = 0;
		System.out.println(" ");
		System.out.println("Page "+ _page );
		System.out.println(" ");
 	    while (book.hasNext() && ctr < ctrEnd) {
			if( ctr < ctrStart ) {
				book.next();
				/*_text += book.next();
				System.out.println("Hello");
				System.out.println(_text);*/    
			}
 			else if( ctr > ctrStart && ctr < ctrEnd ) {
 				System.out.print(book.next() + " "); //prints out word plus space
 			}
			ctr+=1;
		}
		book.close();}
		catch (Exception FileNotFoundException) {
			System.out.println("Sorry, file not found.");
		}

  	}

    //flips  book to specific int page number
    public void goToPage(int pg) {
		
		if (pg < _numPgs) {
			
			_page = pg;
			printPage();
		}
		else {
			System.out.println("This page does not exist");
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
		try {
		_text = new File("Genres/" + _genre + "/" + _subgenre + "/" + _title);
		Scanner book = new Scanner(_text);
		while (book.hasNext()) {
			_textStr += book.next();
			//System.out.println(_textStr);
			//comment out the previous line and uncomment the following line if you would also like to see the text (a temporary fix)
			//System.out.print(_book.next() + " ");
			_wordCount++;
			}
			book.close();
			return _wordCount;
		}
		catch (Exception FileNotFoundException) {
			System.out.println("Sorry, file not found.");
			return 0;
		}
	}
	
    public int numSentences() {
     _charCount = 0;
     _sentenceCount = 0;
    for (int i = 0; i < _textStr.length() - 1; i++) {
	String letter = _textStr.substring(i, i += 1);
	if (letter.matches("[a-zA-Z]+"))// set of all alphabets
	    {
		_charCount += 1; //increase only if actual letter
	    }
	if (letter.matches("[.?!]"))
	    {
		_sentenceCount += 1; //rough estimate of number of sentences
	    }
    } return _sentenceCount;
}

public int avgWordLength(){
     return _avgWL = _charCount/_wordCount; 
}

    public int avgSentenceLength()
    {
	int charsInSentence = _charCount/_sentenceCount;
	 return _avgSL = charsInSentence / _avgWL;
    }

} //end class ReadBook
