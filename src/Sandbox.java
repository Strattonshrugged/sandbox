/**
 * Created by jared stratton on 5/8/17.
 */

import java.util.*;

public class Sandbox {
    public static Scanner console = new Scanner(System.in);

    public static void main(String args[]) {
        greeting();

        while (true)    {
            String input = "";
            int longy = 0;
            double doubleOne = 0.0;
            double doubleTwo = 0.0;

            // declare ready status and take input from user
            System.out.printf("READY\n");
            input = console.nextLine();
            // basic conditioning (case insensitive, no double spaces, trimmed)
            input = input.toUpperCase();
            input = input.replace("  "," ");
            input = input.trim();

            // sift through responses
            if (input.equals(""))   {
                System.out.println("Error: Need some input here");
            }   else if (input.charAt(0) == '$') {
                // assume intended for taxfinder
                input = input.replace("$","");
                input = input.replace(",","");
                try     {
                    doubleOne = Double.parseDouble(input);
                    taxFinder(doubleOne);
                }
                catch (NumberFormatException dollaz)   {
                    System.out.println("Error, please check formatting");
                }
            }   else if (input.charAt(0) == '(')    {
                // assume intended QuadrantFinder
                input = input.replace("(","");
                input = input.replace(")","");
                try     {
                    String [] pieces = input.split(",");
                    longy = pieces.length;
                    if (longy == 2)  {
                        doubleOne = Double.parseDouble(pieces[0]);
                        doubleTwo = Double.parseDouble(pieces[1]);
                        quadrant(doubleOne,doubleTwo);
                    }   else    {
                        System.out.println("Error, please check formatting");
                    }

                }
                catch (NumberFormatException coordinates)   {
                    System.out.println("Error, please check formatting");
                }
            }   else    {
                // assume intended for secondsAfterMidnight OR secondsDifference
                try     {
                    String [] pieces = input.split(" ");
                    longy = pieces.length;
                    if (longy == 1)    {
                        secondsAfterMidnight(pieces[0]);
                    }   else if (longy == 2)    {
                        secondsDifference(pieces[0],pieces[1]);
                    }   else    {
                        System.out.println("Error, please check formatting");
                    }
                }
                catch (NumberFormatException stringzees)     {
                    System.out.println("Error, please check formatting");
                }
            }
            //spacer
            System.out.println("");
        }   // end of while loop
    }   // end of main


    public static void greeting()       {
        System.out.println("Program Three Online: Quadrant Finder, Tax Return Calculator, and Seconds Counter");
        System.out.println("For Quadrant Finder, use the (1,1) format");
        System.out.println("For Tax Finder, use the $1111.11 format");
        System.out.println("For Seconds After Midnight, use the HH:MM:SSPM format");
        System.out.println("For Seconds Difference, use the HH:MM:SSPM HH:MM:SSPM format");
        System.out.println("");
    }


    public static void quadrant (double x, double y)    {
        System.out.println("quadrant received x of " + x + " and y of " + y);
        if (x == 0.0 && y == 0.0) {
            System.out.println("(0.0,0.0) is the origin, it is not in any quadrant");
        }   else if (x == 0.0)  {
            System.out.println("Points on the y-axis are not in any quadrant");
        }   else if (y == 0.0)  {
            System.out.println("Points on the x-axis are not in any quadrant");
        }   else if (x > 0 && y > 0)  {
            System.out.println("Quadrant One");
        }   else if (x < 0 && y > 0)  {
            System.out.println("Quadrant Two");
        }   else if (x < 0 && y < 0)  {
            System.out.println("Quadrant Three");
        }   else if (x > 0 && y < 0)  {
            System.out.println("Quadrant Four");
        }   else    {
            System.out.println("Error: values passed to quadrant unplottable");
        }
    }


    public static void taxFinder (double income)    {
        System.out.println("taxFinder received " + income);





    }


    public static void secondsAfterMidnight (String timeIndex)  {
        int seconds;
        System.out.println("secondsAfterMidnight received " + timeIndex);
        // account for possibility of 9-digit format
        if (timeIndex.length() == 9)    {
            timeIndex = '0' + timeIndex;
        }
        if (timeVerifier(timeIndex) != true)    {
            System.out.println("-1");
        }   else    {
            seconds = secondCounter(timeIndex);
            System.out.println(seconds + " seconds after midnight");
        }
    }


    public static void secondsDifference (String timeStart, String timeStop)    {
        int start;
        int stop;
        int diff;
        System.out.println("secondsDifference received " + timeStart + " and " + timeStop);
        // account for possibility of 9-digit formats
        if (timeStart.length() == 9)    {
            timeStart = '0' + timeStart;
        }
        if (timeStop.length() == 9)    {
            timeStop = '0' + timeStop;
        }
        if (timeVerifier(timeStart) != true || timeVerifier(timeStop) != true) {
            System.out.println("-99999");
        }   else    {
            start = secondCounter(timeStart);
            stop = secondCounter(timeStop);
            diff = stop - start;
            System.out.println(diff + " seconds difference");
        }
    }


    // check strings of time for format, regex would be used here
    public static boolean timeVerifier(String time)  {
        // check string length
        if (time.length() != 10)    {
            return false;
        }
        // if first hour character is not a zero or a one
        if (time.charAt(0) != '0' && time.charAt(0) != '1')    {
            return false;
        }
        // if second hour character is not a digit
        if (!Character.isDigit(time.charAt(1))) {
            return false;
        }
        // if first character is a 1, second character can only be 0, 1, or 2
        if (time.charAt(0) == '1' && "012".indexOf(time.charAt(1)) == -1) {
            return false;
        }
        // if not a colon
        if (time.charAt(2) != ':')  {
            return false;
        }
        // if first minute character is not a digit or higher than five
        if ("012345".indexOf(time.charAt(3)) == -1)   {
            return false;
        }
        // if second minute character is not a digit
        if (!Character.isDigit(time.charAt(4))) {
            return false;
        }
        // if not a colon
        if (time.charAt(5) != ':')  {
            return false;
        }
        // if first second character is not a digit or higher than five
        if ("012345".indexOf(time.charAt(6)) == -1)   {
            return false;
        }
        // if second (2nd) second character is not a digit
        if (!Character.isDigit(time.charAt(7))) {
            return false;
        }
        // if not an A or P as in AM or PM
        if (time.charAt(8) != 'A' && time.charAt(8) != 'P') {
            return false;
        }
        // if not an M
        if (time.charAt(9) != 'M')  {
            return false;
        }
        return true;
    }


    public static int secondCounter(String time)    {
        String snippet;
        int hours;
        int minutes;
        int seconds;
        int totalSeconds;

        snippet = time.substring(0,2);
        hours = Integer.parseInt(snippet);
        snippet = time.substring(3,5);
        minutes = Integer.parseInt(snippet);
        snippet = time.substring(6,8);
        seconds = Integer.parseInt(snippet);
        // account for time being inside the first hour
        if (hours == 12)    {
            hours = hours - 12;
        }
        // account for post meridian
        if (time.charAt(8) == 'P')  {
            hours = hours + 12;
        }
        System.out.println(hours + " hours " + minutes + " minutes " + seconds + " seconds ");
        totalSeconds = (hours * 3600) + (minutes * 60) + (seconds);
        return totalSeconds;
    }

}   // end of class