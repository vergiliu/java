package org.stuff.Assignment1;
/*
 * File: CollectNewspaperKarel.java
 * --------------------------------
 * At present, the CollectNewspaperKarel subclass collects the newspaper.
 * Your job in the assignment is to add the necessary code to
 * instruct Karel to walk to the door of its house, pick up the
 * newspaper (represented by a beeper, of course), and then return
 * to its initial position in the upper left corner of the house.
 */

import stanford.karel.*;

/*
 * Name: Vergiliu, 29 Aug 2010
 * Section Leader: n/a
 */

public class CollectNewspaperKarel extends SuperKarel {

    @Override
	public void run() {
		// You fill in this part
        move();
        move();
        turnRight();
        move();
        turnLeft();
        move();
        pickBeeper();
        turnAround();
        move();
        move();
        move();
        turnRight();
        move();
        turnRight();
	}
	public static void main(String[] args) {
		String[] newArgs = new String[args.length + 1];
		System.arraycopy(args, 0, newArgs, 0, args.length);
		newArgs[args.length] = "code=" + new SecurityManager(){ public String className() { return this.getClassContext()[1].getCanonicalName(); } }.className();
		SuperKarel.main(newArgs);
	}
}
