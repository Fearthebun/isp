/*  Name: Nayaab Ali
    Teacher: Ms. Krasteva
    Date: January 18, 2019
    Assignment: This is for the animation of my calculator ISP.
*/

import java.awt.*;
import hsa.Console;

public class CalculatorAnimation extends Thread
{
    private Console c;

    public void animation ()
    {
	Color purple = new Color (210, 78, 188); //purple
	Color blue = new Color (86, 213, 231); // blue
	Color lightBlue = new Color (211, 249, 255);

	for (int x = 0 ; x < 300 ; x++)
	{
	    c.setColor (lightBlue);
	    c.fillOval (-101 + x, 355, 20, 20); // top circle div erase
	    c.fillRect (-126 + x, 380, 73, 20); // rect div erase
	    c.fillOval (-101 + x, 405, 20, 20); // bottom circle div erase

	    c.fillRect (-101 + x, 270, 80, 42); // equals erase

	    c.fillRect (701 - x, 280, 80, 20); // subtraction erase

	    c.fillRect (751 - x, 400, 80, 20); // horizontal addition erase
	    c.fillRect (779 - x, 370, 22, 77); // vetical addition

	    c.setColor (purple);
	    c.fillOval (-100 + x, 355, 20, 20); // top circle div
	    c.fillRect (-125 + x, 380, 73, 20); // rect div
	    c.fillOval (-100 + x, 405, 20, 20); // bottom circle div

	    c.setColor (blue);
	    c.fillRect (-100 + x, 270, 80, 17); // top rect equals
	    c.fillRect (-100 + x, 295, 80, 17); // bottom rect equals

	    c.setColor (Color.yellow);
	    c.fillRect (700 - x, 280, 80, 20); // subtraction

	    c.setColor (Color.green);
	    c.fillRect (750 - x, 400, 80, 20); // horizontal addition
	    c.fillRect (778 - x, 370, 22, 77); // vetical addition

	    c.setColor (Color.black);
	    c.fillOval (-80 + x, 273, 10, 10); // left eye equals
	    c.fillOval (-50 + x, 273, 10, 10); // right eye equals
	    c.drawArc (-65 + x, 295, 10, 10, 180, 180); // smile equals

	    c.fillOval (710 - x, 283, 10, 10); // left eye subtraction
	    c.fillOval (760 - x, 283, 10, 10); // right eye subtraction
	    c.drawArc (735 - x, 283, 10, 10, 180, 180); // smile subtraction

	    c.fillOval (760 - x, 405, 10, 10); // left eye addition
	    c.fillOval (810 - x, 405, 10, 10); // right eye addition
	    c.drawArc (785 - x, 420, 10, 10, 180, 180); // smile addition

	    c.fillOval (-110 + x, 383, 10, 10); // left eye div
	    c.fillOval (-70 + x, 383, 10, 10); // right eye div
	    c.drawArc (-90 + x, 383, 10, 10, 180, 180); // smile div

	    try
	    {
		Thread.sleep (5);
	    }
	    catch (Exception e)
	    {
	    }
	}
	try
	{
	    Thread.sleep (1500);
	}
	catch (Exception e)
	{
	}

	for (int x = 0 ; x < 500 ; x++)
	{
	    c.setColor (lightBlue);
	    c.fillOval (199 + x, 355, 20, 20); // top circle div erase
	    c.fillRect (174 + x, 380, 73, 20); // rect div erase
	    c.fillOval (199 + x, 405, 20, 20); // bottom circle div erase

	    c.fillRect (199 + x, 270, 80, 42); // equals erase

	    c.fillRect (399 + x, 280, 80, 20); // subtraction erase

	    c.fillRect (449 + x, 400, 80, 20); // horizontal addition erase
	    c.fillRect (477 + x, 370, 22, 77); // vetical addition

	    c.setColor (purple);
	    c.fillOval (200 + x, 355, 20, 20); // top circle div
	    c.fillRect (175 + x, 380, 73, 20); // rect div
	    c.fillOval (200 + x, 405, 20, 20); // bottom circle div

	    c.setColor (blue);
	    c.fillRect (200 + x, 270, 80, 17); // top rect equals
	    c.fillRect (200 + x, 295, 80, 17); // bottom rect equals

	    c.setColor (Color.yellow);
	    c.fillRect (400 + x, 280, 80, 20); // subtraction

	    c.setColor (Color.green);
	    c.fillRect (450 + x, 400, 80, 20); // horizontal addition
	    c.fillRect (478 + x, 370, 22, 77); // vetical addition

	    c.setColor (Color.black);
	    c.fillOval (220 + x, 273, 10, 10); // left eye equals
	    c.fillOval (250 + x, 273, 10, 10); // right eye equals
	    c.drawArc (235 + x, 295, 10, 10, 180, 180); // smile equals

	    c.fillOval (410 + x, 283, 10, 10); // left eye subtraction
	    c.fillOval (460 + x, 283, 10, 10); // right eye subtraction
	    c.drawArc (435 + x, 283, 10, 10, 180, 180); // smile subtraction

	    c.fillOval (460 + x, 405, 10, 10); // left eye addition
	    c.fillOval (510 + x, 405, 10, 10); // right eye addition
	    c.drawArc (485 + x, 420, 10, 10, 180, 180); // smile addition

	    c.fillOval (190 + x, 383, 10, 10); // left eye div
	    c.fillOval (230 + x, 383, 10, 10); // right eye div
	    c.drawArc (210 + x, 383, 10, 10, 180, 180); // smile div

	    try
	    {
		Thread.sleep (5);
	    }
	    catch (Exception e)
	    {
	    }
	}
    }


    public CalculatorAnimation (Console con)
    {
	c = con;
    }


    public void run ()
    {
	animation ();
    }
}


