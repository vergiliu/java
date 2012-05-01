package org.stuff.Assignment1;
/*
 * File: CheckerboardKarel.java
 * ----------------------------
 * When you finish writing it, the CheckerboardKarel class should draw
 * a checkerboard using beepers, as described in Assignment 1.  You
 * should make sure that your program works for all of the sample
 * worlds supplied in the starter folder.
 */

import stanford.karel.*;
/*
 * Name: Vergiliu, 29 Aug 2010
 * Section Leader: n/a
 */

public class CheckerboardKarel extends SuperKarel {

    @Override
	public void run() {
        putBeeper();
        turnLeft();
        goUp();
	}

	public static void main(String[] args) {
		String[] newArgs = new String[args.length + 1];
		System.arraycopy(args, 0, newArgs, 0, args.length);
		newArgs[args.length] = "code=" + new SecurityManager(){
			public String className() {
				return this.getClassContext()[1].getCanonicalName();
			}
		}.className();
		SuperKarel.main(newArgs);
	}

    private void goUp() {
        while(frontIsClear()) {
            move();
            if (frontIsClear()) {
                move();
                putBeeper();
            }
            else {
                turnRight();
                if (frontIsClear()) {
                    move();
                    turnRight();
                    putBeeper();
                    goDownEven();
                }
            }
        }
        turnRight();
        if (frontIsClear()) {
            move();
            turnRight();
            goDownOdd();
        }

    }

    private void goDownEven() {

        while(frontIsClear()) {
            move();
            if(frontIsClear()) {
                move();
                putBeeper();
            }
            else {
                if (leftIsClear()) {
                    turnLeft();
                    moveRightThenUp();
                }
            }
        }
        turnLeft();
        if (frontIsClear()) {
            moveRightThenUp();
        }
    }

    private void goDownOdd() {

        while(frontIsClear()) {
            move();
            putBeeper();
            if (frontIsClear()) {
                move();
            }
            else {
                turnLeft();
                if (frontIsClear()) {
                    moveRightThenUp();
                }
            }
        }
        turnLeft();
        if (frontIsClear()) {
            moveRightThenUp();
        }
    }

    private void moveRightThenUp() {
        move();
        putBeeper();
        turnLeft();
        goUp();
    }

}

//public class CheckerboardKarel extends GraphicsProgram {
//    public void run() {
//        GLabel a = new GLabel("TEST", 500, 500);
//        GRect b = new GRect(100, 100, 100, 100);
//        b.setColor(Color.red);
//        a.setFont(new Font("sans", 10, 10));
//        add(a);
//        add(b);
//    }
