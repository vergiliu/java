package org.stuff.Assignment2;
/*
 * File: Hailstone.java
 * Name: Vergiliu, 25 Jan 2011
 * Section Leader: N/A
 * --------------------
 * This file is the solution file for the Hailstone problem.
 */

import acm.program.*;

public class Hailstone extends ConsoleProgram {
	public void run() {
		/* Pick some positive integer and call it n.
If n is even, divide it by two.
If n is odd, multiply it by three and add one.
Continue this process until n is equal to one.
On page 401 of the Vintage edition, Hofstadter illustrates this process with the
following example, starting with the number 15:
is odd, so I make 3n + 1:
is even, so I take half:
is odd, so I make 3n + 1:
is even, so I take half:
is odd, so I make 3n + 1:
is even, so I take half:
is odd, so I make 3n + 1:
 */
     int myValue = readInt("Enter a number: ");
     int steps = 0;
     while (myValue != 1) {
         if ( myValue % 2 == 0) {
             print(myValue + " is even, so I take half: ");
             myValue = myValue / 2;
         }
         else {
            print(myValue + " is odd, so I make it 3n + 1: ");
            myValue = 3 * myValue + 1;
         }
         steps++;
         println(myValue);
     };
     println("The process took " + steps + " steps to reach 1");
	}

    public static void main(String[] args) {
    String[] newArgs = new String[args.length + 1];
    System.arraycopy(args, 0, newArgs, 0, args.length);
    newArgs[args.length] = "code=" + new SecurityManager(){
        public String className() {
            return this.getClassContext()[1].getCanonicalName();
        }
    }.className();
    GraphicsProgram.main(newArgs);
	}
}


