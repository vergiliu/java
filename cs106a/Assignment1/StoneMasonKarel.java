package org.stuff.Assignment1;
/*
 * File: StoneMasonKarel.java
 * --------------------------
 * The StoneMasonKarel subclass as it appears here re-builds every 4th column.
 * When you finish writing it, it should solve the "repair the quad"
 * problem from Assignment 1.  In addition to editing the program,
 * you should be sure to edit this comment so that it no longer
 * indicates that the program does nothing.
 */

import stanford.karel.*;

/*
 * Name: Vergiliu, 29 Aug 2010
 * Section Leader: n/a
 */

public class StoneMasonKarel extends SuperKarel {

    @Override
	public void run () {
        while (frontIsClear()) {
            fixColumn();
            moveToNextColumn();
        }
        fixColumn();
	}
	public static void main(String[] args) {
		String[] newArgs = new String[args.length + 1];
		System.arraycopy(args, 0, newArgs, 0, args.length);
		newArgs[args.length] = "code=" + new SecurityManager(){ public String className() { return this.getClassContext()[1].getCanonicalName(); } }.className();
		SuperKarel.main(newArgs);
	}

    private void fixColumn() {
        turnLeft();
        while(frontIsClear()) {
            if (!beepersPresent())
                putBeeper();
            move();
        }
        if (!beepersPresent())
            putBeeper();
        getDownFromThere();
    }

    private void getDownFromThere() {
        turnAround();
        while(frontIsClear())
            move();
        turnLeft();
    }

    private void moveToNextColumn() {
        move();
        move();
        move();
        move();
    }
}
