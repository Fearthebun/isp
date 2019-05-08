/*  Name: Nayaab Ali
    Teacher: Ms. Krasteva
    Date: January 18, 2019
    Assignment: This program is a calculator that can perform basic math: addition, subtraction, multiplication, and division.
    It starts with a splashscreen, which then leads the user to the main menu where they can choose to see instructions, continue to program,
    save a previous calculation, open and display a calculation, or exit.
    If the user chooses to continue to program, they input an equation one entry at a time. When they enter =, the method ends and they
    receive their result. They are then lead back to main menu.

    Variable Name           Type            Purpose
    choice                  char            stores input from mainMenu to be processed in the main method
    equation                String          stores the equation as the user enters it
    saveEquation            String          saves the equation
    answer                  String          saves the result
    counter                 int             counts the number of inputs the user gives for the equation
    fileName                File            stores the file name
    fileNameStr             String          gets input from user for file name
    dataToSave              boolean         stores whether or not there is data to save
*/

import java.awt.*;
import hsa.Console;
import java.io.*;
import javax.swing.JOptionPane;

//the "Calculator" class.
public class Calculator
{
    Console c;

    char choice;
    String equation = "";
    String saveEquation, answer;
    int counter = 0;
    File fileName;
    String fileNameStr;
    boolean dataToSave = false;

    public Calculator ()
    {
	c = new Console ("Calculator!");
    }


    // Draws the program title
    private void title ()
    {
	Color lightBlue = new Color (211, 249, 255);
	c.clear ();
	c.setColour (lightBlue);
	c.fillRect (0, 0, 640, 500);
	c.setTextBackgroundColour(lightBlue);
	c.print ("", 35);
	c.println ("Calculator!");
	c.println ();
    }


    // Pauses the program
    private void pauseProgram ()
    {
	c.println ();
	c.setCursor (24, 29);
	c.println ("Press any key to continue.");
	c.getChar ();
    }


    // Introduces the program to the user
    public void splashScreen ()
    {
	title ();
	c.setCursor (6, 35);
	c.print ("Be prepared...");
	c.setCursor (8, 17);
	c.print ("for the best calculator you have ever experienced!");

	CalculatorAnimation ca = new CalculatorAnimation (c);
	ca.start ();

	try
	{
	    Thread.sleep (8000);
	}
	catch (Exception e)
	{
	}
    }


    /* Allows the user to choose between 5 options:
       Instructions: receive instructions on how to use the program
       Continue to program: continues to program
       Save: saves the equation and result of previous calculation to a file
       Open and display: opens and displays a saved file
       Exit: exits program
    */
    public void mainMenu ()
    {
	title ();
	c.setCursor (3, 27);
	c.println ("Press 1 to get instructions");
	c.setCursor (5, 23);
	c.println ("Press 2 to continue to the program");
	c.setCursor (7, 12);
	c.println ("Press 3 to save your previous calculation to a new file");
	c.setCursor (9, 17);
	c.println ("Press 4 to open and display a saved calculation");
	c.setCursor (11, 33);
	c.println ("Press 5 to exit");

	// keeps looping until user inputs correctly
	while (true)
	{
	    choice = c.getChar ();
	    // if user inputs something that is not 1, 2, 3, 4, or 5
	    if (choice != '1' && choice != '2' && choice != '3' && choice != '4' && choice != '5') // if the input is not an option
	    {
		// error message for anything other than 1, 2, 3, 4, or 5
		JOptionPane.showMessageDialog (null, "Please enter a number from 1-5.", "Error", JOptionPane.ERROR_MESSAGE);
	    }
	    else
	    {
		break;
	    }
	}
    }



    // Gives the user more specific instructions on how to use the program.
    public void instructions ()
    {
	title ();
	c.setCursor (3, 28);
	c.println ("How to input an equation:");
	c.setCursor (6, 7);
	c.println ("Input a number, then press enter. It will be added to the equation.");
	c.setCursor (8, 5);
	c.println ("After, enter a function, then press enter. Continue doing this to build");
	c.setCursor (10, 12);
	c.println ("your equation. When you have finished your equation (with");
	c.setCursor (12, 19);
	c.println ("your last entry being a number), enter \"=\".");
	c.setCursor (15, 15);
	c.println ("The functions this calculator can use are: + - * /");
	pauseProgram ();
    }


    // Exits the program and closes the window.
    public void goodbye ()
    {
	title ();
	c.setCursor (7, 10);
	c.println ("Beep boop beep bop. Shutting down system. Come again soon :D");
	c.setCursor (9, 34);
	c.print ("By Nayaab Ali");
	try
	{
	    Thread.sleep (2000); // stays on screen for 2 seconds
	}

	catch (Exception e)
	{
	}

	c.close (); // closes the window
    }


    /*  Asks the user to input data
	Variable Name           Type            Purpose
	input                   String          gets and stores user input
	toParse                 boolean         stores if the input can be parsed or not
	inMiddle                boolean         checks to see if the = is in the middle of the equation
	parsedInput             double          parses the input
    */
    public void askData ()
    {
	title ();
	String input;
	equation = "";
	boolean toParse = true, inMiddle = false;
	counter = 0;

	while (true)
	{
	    toParse = true;
	    inMiddle = false;
	    c.setCursor (3, 5);
	    c.println ("Enter your equation, one entry at a time. Remember that an integer");
	    c.setCursor (5, 5);
	    c.println ("and a function count as separate entries. Press enter after each entry.");
	    c.setCursor (7, 5);
	    c.println ("Remember, this calculator can only do basic math functions: *, /, +, -");
	    c.setCursor (11, 5);
	    c.println ("Your equation:");
	    c.setCursor (9, 5);
	    c.println ();
	    c.setCursor (9, 5);
	    input = c.readLine (); // gets user input
	    counter++; // counts number of inputs by user

	    // keeps getting input until user enters =
	    while (true)
	    {
		// if the input is not a function when it should be, an error message is displayed
		if ((counter % 2 == 0) && (!input.equals ("*") && !input.equals ("/") && !input.equals ("+") && !input.equals ("-") && !input.equals ("=")))
		{
		    JOptionPane.showMessageDialog (null, "Please enter a valid entry.", "Error", JOptionPane.ERROR_MESSAGE);
		    counter--;
		    break;
		}
		// if there is an equals sign in the middle of the equation an error message is shown
		else if (counter < 4 && input.equals ("="))
		{
		    JOptionPane.showMessageDialog (null, "Please enter a valid entry.", "Error", JOptionPane.ERROR_MESSAGE);
		    counter--;
		    inMiddle = true;
		    break;
		}
		// checks if the number can be parsed
		else if (counter % 2 == 1 && toParse == true)
		{
		    // tries to parse input
		    try
		    {
			double parsedInput = Double.parseDouble (input);
		    }
		    // if it cannot be parsed, an error message is shown
		    catch (NumberFormatException e)
		    {
			JOptionPane.showMessageDialog (null, "Please enter a valid entry.", "Error", JOptionPane.ERROR_MESSAGE);
			counter--;
			toParse = false;
		    }
		    // goes back to getting input if it cannot be parsed
		    if (toParse == false)
			break;
		    // if there are no errors, it adds input to the full equation
		    else
		    {
			equation = equation + input + " ";
			c.setCursor (11, 5);
			c.println ();
			c.setCursor (11, 5);
			c.println ("Your equation:");
			c.setCursor (12, 5);
			c.print (equation);
			break;
		    }
		}
		// if there are no errors, it adds input to the full equation
		else
		{
		    equation = equation + input + " ";
		    c.setCursor (11, 5);
		    c.println ();
		    c.setCursor (11, 5);
		    c.println ("Your equation:");
		    c.setCursor (12, 5);
		    c.print (equation);
		    break;
		}
	    }
	    // if the user inputs = at the end of the equation, it breaks
	    if (input.equals ("=") && inMiddle == false)
		break;
	}

	c.setCursor (14, 5);
	c.println ("Your result is:");
    }



    /*
	Variable Name           Type            Purpose
	output                  double          stores the output value to be returned
	eqArr []                String array    split up version of the equation to be processed
	arrElement              int             goes through all elements in the array
	spaceLeft               int             counts how many elements in the array to the left are spaces
	spaceRight              int             counts how many elements in the array to the right are spaces
	num1                    double          stores the number before the function
	num2                    double          stores the number after the function
    */
    private double returnAnswer (String equation)
    {
	double output = 0;
	String eqArr[] = new String [counter];
	int arrElement = 0, spaceLeft = 1, spaceRight = 1;
	double num1 = 0, num2 = 0;

	//initializes all elements of array
	for (int w = 0 ; w < counter ; w++)
	{
	    eqArr [w] = "";
	}

	// splits the array manually
	for (int y = 0 ; y < equation.length () ; y++)
	{
	    // if the character isn't a space, it's added to the element of the array
	    if (equation.charAt (y) != ' ')
	    {
		eqArr [arrElement] += equation.charAt (y);
	    }
	    else
	    {
		arrElement++;
	    }
	}
	
	output = Double.parseDouble (eqArr [0]);

	// runs through the entire array
	for (int j = 1 ; j < eqArr.length ; j++)
	{
	    // MULTIPLICATION
	    if (eqArr [j].equals ("*"))
	    {
		do
		{
		    // if it is not empty it parses, else, it checks again to the left for a number
		    if (!eqArr [j - spaceLeft].equals (""))
		    {
			num1 = Double.parseDouble (eqArr [j - spaceLeft]);
		    }
		    else
			spaceLeft++;
		}
		while (eqArr [j - spaceLeft].equals (""));

		do
		{
		    // if it is not empty it parses, else, it checks again to the right for a number
		    if (!eqArr [j + spaceRight].equals (""))
		    {
			num2 = Double.parseDouble (eqArr [j + spaceRight]);
		    }
		    else
			spaceRight++;
		}
		while (eqArr [j + spaceRight].equals (""));
		output = output * num2;
		// replaces elements in the array
		eqArr [j] = Double.toString (output);
		eqArr [j - spaceLeft] = "";
		eqArr [j + spaceRight] = "";
	    }
	    else
	    {
		// DIVISION
		if (eqArr [j].equals ("/"))
		{
		    do
		    {
			// if it is not empty it parses, else, it checks again to the left for a number
			if (!eqArr [j - spaceLeft].equals (""))
			{
			    num1 = Double.parseDouble (eqArr [j - spaceLeft]);
			}
			else
			    spaceLeft++;
		    }
		    while (eqArr [j - spaceLeft].equals (""));

		    do
		    {
			// if it is not empty it parses, else, it checks again to the right for a number
			if (!eqArr [j + spaceRight].equals (""))
			{
			    num2 = Double.parseDouble (eqArr [j + spaceRight]);
			}
			else
			    spaceRight++;
		    }
		    while (eqArr [j + spaceRight].equals (""));
		    output = output / num2;
		    // replaces elements in the array
		    eqArr [j] = Double.toString (output);
		    eqArr [j - spaceLeft] = "";
		    eqArr [j + spaceRight] = "";
		}
		else
		{
		    // ADDITION
		    if (eqArr [j].equals ("+"))
		    {
			do
			{
			    // if it is not empty it parses, else, it checks again to the left for a number
			    if (!eqArr [j - spaceLeft].equals (""))
			    {
				num1 = Double.parseDouble (eqArr [j - spaceLeft]);
			    }
			    else
				spaceLeft++;
			}
			while (eqArr [j - spaceLeft].equals (""));

			do
			{
			    // if it is not empty it parses, else, it checks again to the right for a number
			    if (!eqArr [j + spaceRight].equals (""))
			    {
				num2 = Double.parseDouble (eqArr [j + spaceRight]);
			    }
			    else
				spaceRight++;
			}
			while (eqArr [j + spaceRight].equals (""));
			output = output + num2;
			// replaces elements in the array
			eqArr [j] = Double.toString (output);
			eqArr [j - spaceLeft] = "";
			eqArr [j + spaceRight] = "";
		    }
		    else
		    {
			// SUBTRACTION
			if (eqArr [j].equals ("-"))
			{
			    do
			    {
				// if it is not empty it parses, else, it checks again to the left for a number
				if (!eqArr [j - spaceLeft].equals (""))
				{
				    num1 = Double.parseDouble (eqArr [j - spaceLeft]);
				}
				else
				    spaceLeft++;
			    }
			    while (eqArr [j - spaceLeft].equals (""));

			    do
			    {
				// if it is not empty it parses, else, it checks again to the right for a number
				if (!eqArr [j + spaceRight].equals (""))
				{
				    num2 = Double.parseDouble (eqArr [j + spaceRight]);
				}
				else
				    spaceRight++;
			    }
			    while (eqArr [j + spaceRight].equals (""));
			    output = output - num2;
			    // replaces elements in the array
			    eqArr [j] = Double.toString (output);
			    eqArr [j - spaceLeft] = "";
			    eqArr [j + spaceRight] = "";
			}
		    }
		}
	    }
	}

	return output;
    }


    // Displays the final result
    public void display ()
    {
	c.setCursor (15, 5);
	c.println (returnAnswer (equation));
	dataToSave = true;
	pauseProgram ();
    }


    // Enters a new set of values into an array
    public void saveFile () throws IOException
    {
	// if data has no value an error message is shown
	if (dataToSave == false)
	{
	    JOptionPane.showMessageDialog (null, "There is no data to save.", "Error", JOptionPane.ERROR_MESSAGE);
	    return;
	}

	saveEquation = equation;
	answer = Double.toString (returnAnswer (equation));

	title (); // title
	// error traps if fileName has any characters that are not allowed
	while (true)
	{
	    c.setCursor (4, 5);
	    c.println ();
	    c.setCursor (4, 5);
	    c.print ("Please enter the name of your new file: ");
	    fileNameStr = c.readLine (); // gets input

	    // tries to create a new file
	    try
	    {
		// if file name does not contain any characters that are not allowed, the file saves
		if (fileNameStr.indexOf ("\\") == -1 && fileNameStr.indexOf ("/") == -1 && fileNameStr.indexOf (":") == -1 && fileNameStr.indexOf ("*") == -1 && fileNameStr.indexOf ("?") == -1 && fileNameStr.indexOf ("<") == -1 && fileNameStr.indexOf (">") == -1 && fileNameStr.indexOf ("\"") == -1 && fileNameStr.indexOf ("|") == -1)
		{
		    if (fileNameStr.substring (fileNameStr.length () - 4).equals (".calc"))
		    {
			fileName = new File (fileNameStr);
		    }
		    else
		    {
			fileName = new File (fileNameStr + ".calc");
		    }
		}
		// else, an error message is shown
		else
		{
		    JOptionPane.showMessageDialog (null, "A file name cannot contain the following characters: \\ / : * ? \" < > |.", "Error", JOptionPane.ERROR_MESSAGE);
		}
	    }

	    // if fileName does not contain the extension, it is added
	    catch (StringIndexOutOfBoundsException e)
	    {
		fileName = new File (fileNameStr + ".calc");
	    }
	    // if the file already exists then an error message is shown
	    if (fileName.exists ())
	    {
		JOptionPane.showMessageDialog (null, "This file name already exists. Please enter a new name.", "Error", JOptionPane.ERROR_MESSAGE);
	    }
	    // otherwise it breaks the loop
	    else
	    {
		break;
	    }
	}

	PrintWriter out = new PrintWriter (new BufferedWriter (new FileWriter (fileName)));

	out.println (saveEquation);
	out.println (answer);
	out.close ();

	c.setCursor (8, 28);
	c.println ("Your file has been saved!");
	try
	{
	    Thread.sleep (2000); // stays on screen for 2 seconds
	}
	catch (Exception e)
	{
	}
    }


    /* Reads an existing file and stores its data
       Variable Name             Type          Purpose
       msg                       int           stores choice for JOptionPane
    */
    public void openAndDisplay () throws IOException
    {
	int msg;
	title (); // title

	// error traps if file exists
	while (true)
	{
	    c.setCursor (3, 5);
	    c.println ();
	    c.setCursor (3, 5);
	    c.print ("Please enter the name of the file you want to open: ");
	    fileNameStr = c.readLine (); // gets input
	    // checks if the fileName inputted has the extension
	    try
	    {
		// if fileName has the extension it stays the same
		if (fileNameStr.substring (fileNameStr.length () - 4).equals (".calc"))
		{
		    fileName = new File (fileNameStr);
		}
		// else it is added
		else
		{
		    fileName = new File (fileNameStr + ".calc");
		}
	    }
	    // if file name is shorter than extension, extension is added
	    catch (StringIndexOutOfBoundsException e)
	    {
		fileName = new File (fileNameStr + ".calc");
	    }
	    // if fileName does not exist an error message is shown
	    if (!(fileName.exists ()))
	    {
		msg = JOptionPane.showConfirmDialog (null, "File not found. Do you wish to find another file?", "Input Error", JOptionPane.ERROR_MESSAGE, JOptionPane.YES_NO_OPTION);
		// ends method amd goes to mainMenu if user chooses not to look for another file
		if (msg == JOptionPane.NO_OPTION)
		{
		    return;
		}
	    }
	    // if name exists, method continues
	    else
	    {
		break;
	    }
	}

	BufferedReader in = new BufferedReader (new FileReader (fileName));
	saveEquation = in.readLine ();
	answer = in.readLine ();
	in.close ();

	c.setCursor (5, 5);
	c.println (saveEquation);
	c.setCursor (6, 5);
	c.println (answer);
	pauseProgram ();
    }


    public static void main (String[] args) throws IOException
    {
	Calculator a = new Calculator ();
	a.splashScreen ();
	while (true)
	{
	    a.mainMenu ();
	    // if user chose 1 in mainMenu
	    if (a.choice == '1')
		a.instructions ();
	    // if user chose 2 in mainMenu
	    else if (a.choice == '2')
	    {
		a.askData ();
		a.display ();
	    }
	    // if user chose 3 in mainMenu
	    else if (a.choice == '3')
	    {
		a.saveFile ();
	    }
	    // if user chose 4 in mainMenu
	    else if (a.choice == '4')
	    {
		a.openAndDisplay ();
	    }
	    // if user chose 5 in mainMenu
	    else if (a.choice == '5')
		break;
	}
	a.goodbye ();
    } // main method
} // Calculator class
