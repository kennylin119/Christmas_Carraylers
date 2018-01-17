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
		System.out.println("Pick a subgenre from the below list by entering the corresponding number and hitting enter. Or go back by entering 'back'.\n");
		for (String subgenre : subgenres.list()) {
			System.out.println(i + " " + subgenre);
			i++;
		}
		System.out.println();
		_input = Keyboard.readString(); //user inputs desired subgenre
		if (_input.equals("back")) {
			return get1d();
		}
		else if (Integer.parseInt(_input)-1 < i) {
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
		System.out.println("Pick a title from the below list by entering the corresponding number and hitting enter. Or go back by entering 'back'\n");
		for (String title : titles.list()) {
			System.out.println(i + " " + title);
			i++;
		}
		System.out.println();
		_input = Keyboard.readString(); //user inputs desired book
		if (_input.equals("back")) {
			return get2d(_genre);
		}
		else if (Integer.parseInt(_input)-1 < i) {
			_title = titles.list()[Integer.parseInt(_input)-1];
			return "You chose " + _title;
		}
		else {
			System.out.println("The number you entered does not correspond to any title.\n");
			return get3d(_subgenre);
		}
	}
	
//main method
	//tested with Common_Sense demo
 	public static void main (String[] args) {
		Library lib = new Library();
		System.out.println(lib.get1d());
		System.out.println(lib.get2d(lib._genre));
		System.out.println(lib.get3d(lib._subgenre));

		while(true) {
			ReadBook blue = new ReadBook(lib._genre, lib._subgenre, lib._title);
			blue.viewStats();
			System.out.println(lib.get3d(lib._subgenre));
		}
	}


} //end class Library
