// Shruthi Venkata, Kenny Lin, Maryann Foley
// APCS1 pd8
// Final Project
// 2018-01-07

//import java.util.ArrayList;
//import cs1.Keyboard;

public class Library {
	//instance vars
	private String[][][] _library;
	
	//planned for this to be an ArrayList-- benefits here of ArrayLists v regular arrays?
	public Library() {
		//_library = new String[2][10][?];
	}
    // returns list of Statistics from Stats class based on current book 
    /*	public String printStats() {
		
	} 

/* 	public String toString() {
		
	} */

    //enters second array dimension containing the list of book subgenres
	/* public String enter2d(String subgenre) {
		
	} */

    //
	/* public String backTo1d() {
		
	} */

    //enters third array dimendion, containing individual titles of books pertaining to subgenre 
	/* public String enter3d(String title) {
		
	} */

    //returns back to list of subgenres
	/* public String backTo2d() {
		
	} */

    //prints time estimated time to read book based on book statistics and user reading speed
	/* public String printTime() {
		
	} */

    //allows user to input string and checks whether it matches any book titles in the third dimension
	/* public String searchTitle() {
		
	} */

	
//main method
/* 	public static void main (String[] args) {
		Library lib = new Library();
		System.out.println(lib); 

		System.out.println("What subgenre of books would you like to read?");
		String subgenre = Keyboard.readString(); //user inputs desired subgenre 	
		lib.enter2d(subgenre); //enters inputed subgenre

		System.out.println(lib); //prints out list of book titles within subgenre
		String title = Keyboard.readString(); //user inputs desired book title 
		lib.enter3d(title);//enters inputed book 

		System.out.println(lib); // prints out book string
		lib.backTo2d();
		System.out.println(lib);
		lib.backTo1d();
		System.out.println(lib);
		
		//by the final version should have a single call to browse library
		//could refer to hw48 GuessNumber
	} */


} //end class Library
