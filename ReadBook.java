// Shruthi Venkata, Kenny Lin, Maryann Foley
// APCS1 pd8
// Final Project
// 2018-01-07

//import cs1.Keyboard;
import java.util.Scanner;
import java.io.File;
import cs1.Keyboard;

public class ReadBook {
	
    //instance vars

	//private File _text;
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
	private String _input;
	
	//constructor
	
	public ReadBook(String genre, String subgenre, String title) {
		_genre = genre;
		_subgenre = subgenre;
		_title = title;
		_wordCount = 0;
		_page = 0;
		_numPgs = calcPgs();
		
	}

    //each "page" is a specified number of words that, with average word length, is calculated to fit on a default terminal window
    //instead of making these Strings we can just make it void and SOP--evaluate return types for this and other classes
    //changes int page += 1 so the book "flips" forward
    public String next() {
		String out = "";
		if (_page>=_numPgs) {
			out = "The end - you are on the last page!";
		}
		else {
			_page+=1;
			out = "next page: " + _page + printPage();
			}
		return out;
	}

    //changes int page -= 1 so the book "flips" backward
    public String back() {
		String out = "";
		if (_page<=1) {
			out = "You are on the first page.";
		}
		else {
			_page-=1;
			out = "previous page: " + _page + printPage();
			}
		return out;
	}
		
	public int calcPgs() {
		if (_wordCount%350 == 0) {
			_numPgs = _wordCount/350;
		}
		else {
			_numPgs = _wordCount/350 + 1;
		}
		return _numPgs;
	}
		
 	public String printPage(){
		String out = "";
		try {
			File txt = new File("Genres/" + _genre + "/" + _subgenre + "/" + _title);
			Scanner book = new Scanner(txt);
			int ctrStart = (_page-1)*350;
			//System.out.println("ctrStart is " + ctrStart);
			int ctrEnd = (_page)*350;
			//System.out.println("ctrEnd is " + ctrEnd);
			int ctr = 0;
		System.out.println(" ");
		System.out.println("Page "+ _page );
		System.out.println(" ");
 	    while (book.hasNext() && ctr < ctrEnd) {
			if( ctr < ctrStart ) {
				book.next(); 
			}
 			else if( ctr > ctrStart && ctr < ctrEnd ) {
 				out += book.next() + " "; //prints out word plus space
 			}
			ctr+=1;
		}
		book.close();
		return out;
		}
		catch (Exception FileNotFoundException) {
			return "\tSorry, file not found.\n";
		}

  	}

    //flips  book to specific int page number
    public String goToPage(int pg) {
		if (pg <= _numPgs) {
			_page = pg;
			return printPage();
		}
		else {
			return "\tThis page does not exist\n";
		}
	}
	
	//likely oversimplified but it works!
 	public int wordCounter() {
		try {
		File text2 = new File("Genres/" + _genre + "/" + _subgenre + "/" + _title);
		Scanner book = new Scanner(text2);
		while (book.hasNext()) {
			_wordCount++;
			_textStr += book.next() + " ";
			/* System.out.println(_wordCount);
			System.out.println(_textStr); */
			//System.out.println(_textStr);
			//comment out the previous line and uncomment the following line if you would also like to see the text (a temporary fix)
			//System.out.print(_book.next() + " ");
			}
			book.close();
			return _wordCount;
		}
		catch (Exception FileNotFoundException) {
			System.out.println("\tSorry, file not found.");
			return 0;
		}
	}
	
     public int numSentences() {
		_charCount = 0;
		_sentenceCount = 0;
		for (int i = 0; i < _textStr.length() - 1; i++) {
			String letter = _textStr.substring(i, i += 1);
			if (letter.matches("[a-zA-Z]+")) {// set of all alphabets 
			_charCount += 1; //increase only if actual letter
			}
			if (letter.matches("[.?!]")) {
				_sentenceCount += 1; //rough estimate of number of sentences
			}
		}
		return _sentenceCount;
	}

	public int avgWordLength(){
		 return _avgWL = _charCount/_wordCount; 
	}

	public int avgSentenceLength() {
		int charsInSentence = _charCount/_sentenceCount;
		 return _avgSL = charsInSentence / _avgWL;
		}
	
	//asks user whether to view Statistics
	public void viewStats() {
		System.out.println();
		System.out.println("Would you like to view the statistics for this book? Please enter 'yes' or 'no'.");
		_input = Keyboard.readString();
		if (_input.equals("yes")) {
			System.out.println("In " + _title + ": ");
			System.out.println("There are "+ wordCounter() + " words." );
			System.out.println("There are "+ calcPgs() + " pages");
			System.out.println("There are " + numSentences()+ " sentences.");
			System.out.println("The average word length is "+ avgWordLength() + ".");
			System.out.println("The average word sentence length is "+ avgSentenceLength() + ".");
			read();
		}
		//skips Stats
		else read();
	}
	
	//uses next(), back(), goToPage() to flip through book
	public void read() {
		System.out.println("\nYou are now reading " + _title + ". Exit at any time by entering 'x'.");
		while(true){
			System.out.println("\nEnter next or back to change pages, or go to a page by entering a page number");
			_input = Keyboard.readString();
			if (_input.equals("x")) {
				break;
			}
			try{
				System.out.println(goToPage(Integer.parseInt(_input)));
			}
			catch (NumberFormatException e){}
			if (_input.equals("next")) {
				//System.out.println("next");
				System.out.println(next() + "\n");
				//System.out.println("Completed next");
			}

			else if (_input.equals("back")) {
				//System.out.println("back");
				System.out.println(back() + "\n");
			}
		}
	}

	} //end class ReadBook
