/**
 * Created by jared on 5/8/17.
 */

import java.util.*;

public class Sandbox {
    public static Scanner console = new Scanner(System.in);


    public static void main(String args[]) {
        String input;
        double doubleOne;
        double doubleTwo;
        String stringOne;
        String stringTwo;

        while (true)    {
            System.out.println("READY");
            // prompt for user input, make it a string
            input = console.nextLine();
            // make case insensitive
            input = input.toUpperCase();

            if (input.equals(""))   {
                System.out.println("Error: Need some input here");
            }   else if (input.charAt(0) == '$') {
                input.replace("$"," ");
                // what am i trying to do?
                // try/catch or hasNext ... if there's two doubles I want them
                // if there are not two doubles, exit with an error message
                
                if (console.hasNextDouble(input))   {
                    doubleOne = console.nextDouble();
                }   else    {

                }
                // assume intended TaxFinder
                // strip out everything that isn't a decimal or digit
                // if it has a next double, take it; otherwise error
                // pass double to taxFinder
            }   else if (input.charAt(0) == '(')    {
                // assume intended QuadrantFinder
                // strip out everything that isn't a decimal or a digit
                // if it has a next double, take it; otherwise error
                // if it has a next double, take it; otherwise error
                // pass doubles to quadrantFinder
            }   else    {
                // assume intended either SecondsPastMidnight or SecondsDifference
                // if it has a next, take it as a string
                // if it has a next, take it, if not send first string to secsPastMidnight
                // if there was a second string, send both to secondsDiff
            }
            System.out.println("Results ...");
            System.out.println("input: " + input);
            System.out.println("firstDouble: " + doubleOne);
            System.out.println("secondDouble: " + doubleTwo);
            System.out.println("firstBlurp:" + stringOne);
            System.out.println("secondBlurp:" + stringTwo);
        }   // end of while loop
    }   // end of main
}   // end of class

/*
nextLine is string
if first character is $
get rid of all non-digits/-decimals
pass into scanner for next double
pass double to taxFinder
if first character is (
        get rid of all non-digits/-decimals
        pass into scanner for next 2 doubles
pass double to quadrantFinder
else
pass it into the scanner
take a string
take a string
if it's one string
pass into SecondsPastMidnight
if it's two strings
pass into SecondsDifference

String strNew = str.replaceAll("[^A-Za-z0-9]", "");

*/