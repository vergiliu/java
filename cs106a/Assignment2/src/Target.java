package org.stuff.Assignment2;
/*
 * File: Target.java
 * Name: Vergiliu, 16 Jan 2011
 * Section Leader: N/A
 * -----------------
 * This file is the file for the Target problem.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class Target extends GraphicsProgram {	
    double mySizeOval1 = 72.0;
    double mySizeOval2 = mySizeOval1 * 0.65;
    double mySizeOval3 = mySizeOval1 * 0.3;

	public void run() {
        int myXAxisMid = this.getWidth()/2;
        int myYAxisMid = this.getHeight()/2;

        GOval outerRed = new GOval(mySizeOval1, mySizeOval1);
        GOval outerWhite = new GOval(mySizeOval2, mySizeOval2);
        GOval innerRed = new GOval(mySizeOval3, mySizeOval3);

        setFilledWithColor(outerRed, Color.RED);
        setFilledWithColor(outerWhite, Color.WHITE);
        setFilledWithColor(innerRed, Color.RED);

//        helper lines to check middle of drawing area
//        this.add(new GLine(myXAxisMid, 0, myXAxisMid, this.getHeight()));
//        this.add(new GLine(0, myYAxisMid, this.getWidth(), myYAxisMid));

		addOval(outerRed, mySizeOval1, myXAxisMid, myYAxisMid);
        addOval(outerWhite, mySizeOval2, myXAxisMid, myYAxisMid);
        addOval(innerRed, mySizeOval3, myXAxisMid, myYAxisMid);
	}

    private void setFilledWithColor(GOval aCircle, Color aColor) {
        aCircle.setFillColor(aColor);
        aCircle.setColor(aColor);
        aCircle.setFilled(true);
    }

    private void addOval(GOval aCircle, double theSize, double myXAxisMid, double myYAxisMid) {
        this.add(aCircle, myXAxisMid-theSize/2, myYAxisMid-theSize/2);
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
