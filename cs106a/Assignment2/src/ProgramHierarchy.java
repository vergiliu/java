package org.stuff.Assignment2;
/*
 * File: ProgramHierarchy.java
 * Name: Vergiliu, 16 Jan 2011
 * Section Leader: N/A
 * ---------------------------
 * This file is for the ProgramHierarchy problem.
 */

import acm.graphics.*;
import acm.program.*;

public class ProgramHierarchy extends GraphicsProgram {	
    static final int theWIDTH = 150;
    static final int theHEIGHT = 50;
    static final boolean ABOVE = true;
    static final boolean BELOW = false;
	public void run() {
        int x3 = this.getWidth()*3/4;
        int x2 = this.getWidth()*2/4;
        int x1 = this.getWidth()*1/4;
        int y1 = this.getHeight()*1/3;
        int y2 = this.getHeight()*2/3-theHEIGHT;

//        helper lines for drawing
//        this.add(new GLine(x1, 0, x1, this.getHeight()));
//        this.add(new GLine(x2, 0, x2, this.getHeight()));
//        this.add(new GLine(x3, 0, x3, this.getHeight()));
//        this.add(new GLine(0, y1, this.getWidth(), y1));
//        this.add(new GLine(0, y2, this.getWidth(), y2));

//        lines for connections between boxes
        this.add(new GLine(x2, y1, x1, y2));
        this.add(new GLine(x2, y1, x2, y2));
        this.add(new GLine(x2, y1, x3, y2));

//        the boxes
        addBox(x2, y1, "Program", ABOVE);
        addBox(x1, y2, "GraphicsProgram", BELOW);
        addBox(x2, y2, "ConsoleProgram", BELOW);
        addBox(x3, y2, "DialogProgram", BELOW);

	}

    private void addBox(int theX, int theY, String theString, boolean aboveOrBelow) {
        this.add(new GRect(theX-theWIDTH/2, theY+(aboveOrBelow ? -theHEIGHT : +0), theWIDTH, theHEIGHT));
        GLabel temp = new GLabel(theString);
        this.add(temp, theX - temp.getWidth()/2, theY + (aboveOrBelow ? - theHEIGHT/2  + temp.getHeight()/2 : theHEIGHT/2 + temp.getHeight()/2 ));

        
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

