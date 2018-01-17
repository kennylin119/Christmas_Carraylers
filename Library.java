// Shruthi Venkata, Kenny Lin, Maryann Foley
// APCS1 pd8
// Final Project
// 2018-01

//import java.util.ArrayList;
import cs1.Keyboard;
import java.io.File;

public class Library {
	//instance vars
	//private String[][][] _library;
	private String _input;
	private String _genre;
	private String _subgenre;
	private String _title;
	private int _wpm;
	
	//planned for this to be an ArrayList-- benefits here of ArrayLists v regular arrays?
	//ArrayLists would likely make it easier to do stats
	public Library() {
		//String[][][] = _library = ;
		//_library = new String[2][10][?];
	}
 
// returns list of Statistics from Stats class based on current book 
    /*	public String printStats() {
		
	} 

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
    //Should we also have a searchAuthor?

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
		System.out.println();
		System.out.println("There are "+blue.wordCounter()+" in " + lib._title);
		System.out.println("There are "+blue.calcPgs()+" in " + lib._title);
		while(true){
		System.out.println("\nEnter next or back to change pages, or go to a page by entering a page number");
		if (Keyboard.readString().equals("next")) {
			blue.next();
		}
		else if (Keyboard.readString().equals("back")) {
			blue.back();
		}
		//just a test, has to actually take any number input:
		else {
			blue.goToPage(Integer.parseInt(Keyboard.readString()));
		}
		System.out.println("One loop dones");
	}
		

/* 		System.out.println("What subgenre of books would you like to read?");
		String subgenre = Keyboard.readString(); //user inputs desired subgenre 	
		lib.enter2d(subgenre); //enters inputed subgenre

		System.out.println(lib); //prints out list of book titles within subgenre
		String title = Keyboard.readString(); //user inputs desired book title 
		lib.enter3d(title);//enters inputed book 

		System.out.println(lib); // prints out book string
		lib.backTo2d();
		System.out.println(lib);
		lib.backTo1d();
		System.out.println(lib); */
		
		//by the final version should have a single call to browse library
		//ReadBook.main();
		//could refer to hw48 GuessNumber
	}


} //end class Library
