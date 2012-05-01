package org.stuff.Assignment1;
/*
 * File: MidpointFindingKarel.java
 * -------------------------------
 * When you finish writing it, the MidpointFindingKarel class should
 * leave a beeper on the corner closest to the center of 1st Street
 * (or either of the two central corners if 1st Street has an even
 * number of corners).  Karel can put down additional beepers as it
 * looks for the midpoint, but must pick them up again before it
 * stops.  The world may be of any size, but you are allowed to
 * assume that it is at least as tall as it is wide.
 */

import stanford.karel.*;

/*
 * Name: Vergiliu, 18 Nov 2010
 * Section Leader: n/a
 */

public class MidpointFindingKarel extends SuperKarel {

	public void run() {
        recursiveAddBeeper();
        turnLeft();
        recursiveAddBeeper();
        putBeeper();
	}
	public static void main(String[] args) {
		String[] newArgs = new String[args.length + 1];
		System.arraycopy(args, 0, newArgs, 0, args.length);
		newArgs[args.length] = "code=" + new SecurityManager(){ public String className() { return this.getClassContext()[1].getCanonicalName(); } }.className();
		SuperKarel.main(newArgs);
	}

    private void recursiveAddBeeper() {
        if (frontIsBlocked())

            ;

        else {
            move();
            if (frontIsClear()) move();
            recursiveAddBeeper();
            moveBack();
        }
    }

    private void moveBack() {
        turnAround();
        move();
        turnAround();
    }
}
