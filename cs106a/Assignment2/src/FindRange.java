package org.stuff.Assignment2;
/*
 * File: FindRange.java
 * Name: Vergiliu, 16 Jan 2011
 * Section Leader: N/A
 * --------------------
 * This file is the starter file for the FindRange problem.
 */

import acm.program.*;

public class FindRange extends ConsoleProgram {
    static int previousValue;
    
	public void run() {
        println("This program find the largest and smallest numbers.");
        final int SENTINEL = 0;
        int messages = 0, largest = 0, smallest = 0, myValue;
        do {
            myValue = readInt("? ");
            if (myValue > largest) largest = myValue;
            if (myValue <= smallest) smallest = myValue;
            messages = messages + 1;
            if (messages == 1) previousValue = myValue;
        } while (myValue != SENTINEL);
        if (messages == 1)
                println("No value has been entered.");
            else
                if (messages == 2 ) println("smallest: " + previousValue + "\nlargest: " + previousValue);
                else println("smallest: " + smallest + "\nlargest: " + largest);
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

