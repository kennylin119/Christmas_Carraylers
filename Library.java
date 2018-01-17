// Shruthi Venkata, Kenny Lin, Maryann Foley
// APCS1 pd8
// Final Project
// 2018-01

//import java.util.ArrayList;
import cs1.Keyboard;
import java.io.File;

public class Library {
    //instance vars
    private String _input;
    private String _genre;
    private String _subgenre;
    private String _title;
    private int _wpm;
 
    // returns list of Statistics from Stats class based on current book 
    /*public void printStats() {
      System.out.println();
      System.out.println("There are "+blue.wordCounter()+" words in " + lib._title);
      System.out.println("There are "+blue.calcPgs()+" pages in " + lib._title);
      System.out.println("There are "+blue.numSentences()+ " sentences in " + lib._title);
      System.out.println("The average word length is "+blue.avgWordLength()+" in " + lib._title);
      System.out.println("The average word sentence length is "+blue.avgSentenceLength()+" in " + lib._title);
      } */
    /* 	public String toString() {
    //Benefit of having toString not print stats? What else would be printed?
    //Possibly just print title/subgenre/author
    } */

    //
    public String get1d() {
	File genres = new File("Genres");
	int i = 1;
	System.out.println("Pick a genre from the below list by entering the corresponding number and hitting enter.\n");
	for (String genre : genres.list()) {
	    System.out.println(i + " " + genre);
	    i++;
	}
	System.out.println();
	_input = Keyboard.readString(); //user inputs desired subgenre
	if (Integer.parseInt(_input)-1 < i) {
	    _genre = genres.list()[Integer.parseInt(_input)-1];
	    return "You chose " + _genre;
	}
	else {
	    System.out.println("The number you entered does not correspond to any genre.\n");
	    return get1d();
	}
    }

    //enters third array dimension, containing individual titles of books pertaining to subgenre 
    public String get2d(String genre) {
	File subgenres = new File("Genres/" + _genre);
	int i = 1;
	System.out.println("Pick a subgenre from the below list by entering the corresponding number and hitting enter.\n");
	for (String subgenre : subgenres.list()) {
	    System.out.println(i + " " + subgenre);
	    i++;
	}
	System.out.println();
	_input = Keyboard.readString(); //user inputs desired subgenre
	if (Integer.parseInt(_input)-1 < i) {
	    _subgenre = subgenres.list()[Integer.parseInt(_input)-1];
	    return "You chose " + _subgenre;
	}
	else {
	    System.out.println("The number you entered does not correspond to any subgenre.\n");
	    return get2d(_genre);
	}
    }

    //returns titles
    public String get3d(String subgenre) {
	File titles = new File("Genres/" + _genre + "/" + _subgenre);
	int i = 1;
	System.out.println("Pick a title from the below list by entering the corresponding number and hitting enter.\n");
	for (String title : titles.list()) {
	    System.out.println(i + " " + title);
	    i++;
	}
	System.out.println();
	_input = Keyboard.readString(); //user inputs desired book
	if (Integer.parseInt(_input)-1 < i) {
	    _title = titles.list()[Integer.parseInt(_input)-1];
	    return "You chose " + _title;
	}
	else {
	    System.out.println("The number you entered does not correspond to any title.\n");
	    return get3d(_subgenre);
	}
    }

    //prints time estimated time to read book based on book statistics and user reading speed
    //uses calcTime?
    /* public String printTime() {
		
       } */

    //allows user to input string and checks whether it matches any book titles in the third dimension
    //will ignore any punctuation or capitalization
    /* public String searchTitle() {
		
       } */
	
    //main method
    public static void main (String[] args) {
	Library lib = new Library();
	//lib.pickBook();
	System.out.println(lib.get1d());
	System.out.println(lib.get2d(lib._genre));
	System.out.println(lib.get3d(lib._subgenre));

	ReadBook blue = new ReadBook(lib._genre, lib._subgenre, lib._title);
	blue.statCalc();
	System.out.println();
	System.out.println("There are "+blue.wordCounter()+" words in " + lib._title);
	System.out.println("There are "+blue.calcPgs()+" pages in " + lib._title);
	System.out.println("There are "+blue.numSentences()+ " sentences in " + lib._title);
	System.out.println("The average word length is "+blue.avgWordLength()+" in " + lib._title);
	System.out.println("The average sentence length is "+blue.avgSentenceLength()+" in " + lib._title);		    
	while(true){
	    System.out.println("\nEnter next or back to change pages, or go to a page by entering a page number");
	    String input = Keyboard.readString();
	    try{
		blue.goToPage(Integer.parseInt(input));
	    }
	    catch (NumberFormatException e){}
	    if (input.equals("next")) {
		//System.out.println("next");
		blue.next();
		//System.out.println("Completed next");
	    }

	    else if (input.equals("back")) {
		//System.out.println("back");
		blue.back();
	    }
	}


    }} //end class Library
