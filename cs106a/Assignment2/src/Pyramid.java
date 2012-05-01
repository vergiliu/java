package org.stuff.Assignment2;
/*
 * File: Pyramid.java
 * Name: Vergiliu, 19 Dec 2010
 * Section Leader: n/a
 */

import acm.graphics.*;
import acm.program.*;

public class Pyramid extends GraphicsProgram {

/** Width of each brick in pixels */
	private static final int BRICK_WIDTH = 30;

/** Width of each brick in pixels */
	private static final int BRICK_HEIGHT = 12;

/** Number of bricks in the base of the pyramid */
	private static final int BRICKS_IN_BASE = 14;
	
	public void run() {
        int myMaxHeight = this.getHeight();
        int myMaxWidth = this.getWidth();
        this.add(new GLabel("GOGU's Pyramid"));

        for (int i=BRICKS_IN_BASE;i>=0;i--) {
            putBricks(myMaxWidth, myMaxHeight-(BRICKS_IN_BASE-i)*BRICK_HEIGHT, i);
        }
        
	}

    void putBricks(int totalWidth, int baseY, int noBricks) {
        int startX = (totalWidth - noBricks*BRICK_WIDTH) / 2;
        for (int i=0;i<noBricks;i++) {
                this.add(new GRect(startX + i*BRICK_WIDTH, baseY-BRICK_HEIGHT-1, BRICK_WIDTH, BRICK_HEIGHT));
        }
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
