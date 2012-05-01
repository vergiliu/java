package org.stuff.Assignment2;
/*
 * File: PythagoreanTheorem.java
 * Name: Vergiliu, 16 Jan 2011
 * Section Leader: N/A
 * -----------------------------
 * This file is the starter file for the PythagoreanTheorem problem.
 */

import acm.program.*;

public class PythagoreanTheorem extends ConsoleProgram {
	public void run() {
        println("Enter values to compute the Pythagorean theorem.");
        double a = readDouble("a: ");
        double b = readDouble("b: ");
        println("c = " + Math.sqrt(a*a+b*b));
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
