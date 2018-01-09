# Christmas_Carraylers
APCS Semester 1 Final Project

Maryann Foley, Kenny Lin, Shruthi Venkata

## DESCRIPTION 

Our project stores an inventory of books in a three-dimensional array sorted alphabetically in the class Library, where the three dimensions are book genres (columns), subgenres (rows), and book titles. The user navigates the library by going from the most general to most specific criterion describing the book—once inside a genre, the user can view all of the subgenres within it, and upon selecting a subgenre, can view all the book titles within it. In a subgenre, they can choose a book by entering the name of the title, its index+1, or by prompting the computer to choose a random book from that subgenre. They can also search for a book title, and the program would see if the string they entered is within the string title of any of the books (both turned lowercase, disregarding punctuation). The random selection and search features are also available before selecting a genre or subgenre.

The ReadBook class, which Library calls to allow you to read your selected book, can determine book statistics. The user is asked to input their reading speed in words/minute, which will be used to calculate the estimated reading time. When the user is in a given subgenre they can choose to see either summary statistics or estimated length. If prompted, the program calculates the estimated time to read time the selected book based on the user’s input of average words per minute. The information summary displays the following statistics:

average word length<br /> 
average sentence length<br /> 
number of words<br /> 
number of sentences<br /> 
average words per sentence<br /> 
overall reading difficulty statistics (determined based on word length/sentence length)

ReadBook facilitates reading the book page by page, with command line input permitting the user to turn to the next page("next") or previous page ("back"), go to a particular page ("pg <#>"), or exit the book ("exit"). The program will print a fixed amount of words at a time (the range determined by number of words per page multiplied by the page number).
For example, someone could enter the Fiction genre, then the Sci-Fi subgenre, and then read the book "Futuria Fantasia" by Ray Bradbury.
A feature allows the user to "bookmark" their place in a given book, which they will be asked upon exiting. At this time, they can also delete the page number stored by a previous user, if there is one. A file will store the last-saved page numbers for each book in the library, and when a user opens up a book, they will be given the choice of resuming reading from that page (if there is a page number saved).

## INSTRUCTIONS 

The user needs to have the Genres directory to run, as this is where all book files are stored.

Once you compile and run the program on terminal, explanatory prompts will appear asking you navigate to your desired subgenre/book. The first prompt will ask you to choose a genre.  Once you do this, all subgenres in the genre will be displayed and the user will be prompted to choose one.  Once they choose the subgenre, they will be promted to choose a book.  In the book, they have the choice to advance in the book, go backward, go to a particlar page, or exit the book.

TO COMPILE
javac Library.java

TO RUN
java Library
