package org.stuff.Assignment3;
/*
 * File: Breakout.java
 * -------------------
 * Name: Vergiliu
 * Section Leader: N/A
 * 
 * This file will eventually implement the game of Breakout.
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.*;
import java.awt.*;
import java.awt.event.*;

public class Breakout extends GraphicsProgram {

/** Width and height of application window in pixels */
	public static final int APPLICATION_WIDTH = 400;
	public static final int APPLICATION_HEIGHT = 600;

/** Dimensions of game board (usually the same) */
	private static final int WIDTH = APPLICATION_WIDTH;
	private static final int HEIGHT = APPLICATION_HEIGHT;

/** Dimensions of the paddle */
	private static final int PADDLE_WIDTH = 60;
	private static final int PADDLE_HEIGHT = 10;

/** Offset of the paddle up from the bottom */
	private static final int PADDLE_Y_OFFSET = 30;

/** Number of bricks per row */
	private static final int NBRICKS_PER_ROW = 10;

/** Number of rows of bricks */
	private static final int NBRICK_ROWS = 10;

/** Separation between bricks */
	private static final int BRICK_SEP = 4;

/** Width of a brick */
	private static final int BRICK_WIDTH =
	  (WIDTH - (NBRICKS_PER_ROW - 1) * BRICK_SEP) / NBRICKS_PER_ROW;

/** Height of a brick */
	private static final int BRICK_HEIGHT = 8;

/** Radius of the ball in pixels */
	private static final int BALL_RADIUS = 10;

/** Offset of the top brick row from the top */
	private static final int BRICK_Y_OFFSET = 70;

/** Number of turns */
	private static final int NTURNS = 3;

    /* my variables*/
    private long nrClicks = 0;
    private int currentTurn = NTURNS;
    private static GRect paddle;
    private GLabel endGame;
    private GOval ball;
    private double vx, vy;
    private RandomGenerator rgen = RandomGenerator.getInstance();
    private int bricksInUse = NBRICK_ROWS * NBRICKS_PER_ROW;

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

/* Method: run() */
/** Runs the Breakout program. */
	public void run() {
        drawBricks();
        drawPaddle();
        addMouseListeners();
        drawBall();
        updateSpeeds(true);
        while(true) {
            moveBall();
            pause(15);
        }
	}

    private void bounceBall(double posX, double posY, int mirrorAxis) {
        if (posX >= WIDTH || ball.getLocation().getX() <= 0.0 || mirrorAxis == 1 || mirrorAxis == 3) {
            vx = -vx;
        }
        if (posY >= HEIGHT || ball.getLocation().getY() <= 0.0 || mirrorAxis == 2 || mirrorAxis == 3) {
            if (posY >=HEIGHT) {
                currentTurn --;
                endGame = new GLabel(currentTurn + " turn(s) left");
                add(endGame,  WIDTH/2-endGame.getWidth()/2, HEIGHT/2);
                pause(3000);
                remove(endGame);
                ball.setLocation(WIDTH/2, HEIGHT/2);
                updateSpeeds(true);
                if (currentTurn == 0) {
                    remove(paddle);
                    remove(ball);
                    endGame = new GLabel("You lost in " + nrClicks + " clicks");
                    add(endGame, WIDTH/2-endGame.getWidth()/2, HEIGHT/2);
                    pause(60000);
                    System.exit(1);
                }
            }
            vy = -vy;
        }
    }

    private void bounceOnBrick(GObject myObject, double posX, double posY, int mirrorAxis) {
        if (myObject instanceof GRect) {
            if (((GRect)myObject).getWidth() == BRICK_WIDTH ) {
                remove(myObject);
                bounceBall(posX, posY, mirrorAxis);
                bricksInUse--;
                if (0 == bricksInUse) {
                    remove(ball);
                    endGame = new GLabel("WELL DONE - Finished in " + nrClicks + " clicks");
                    add(endGame, WIDTH/2-endGame.getWidth()/2, HEIGHT/2);
                    pause(60000);
                    System.exit(0);
                }
            }
            if (((GRect)myObject).getWidth() == PADDLE_WIDTH ) {
                bounceBall(posX, posY, mirrorAxis);
                nrClicks++;
                if (nrClicks % 10 == 0) updateSpeeds(false);
            }
//            bounceBall(posX, posY, 0);  // ???
        }
        else bounceBall(posX, posY, 0);
    }

    private void drawBricks() {
        Color[] colorArray = {Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.CYAN};
        for (int j=0; j<NBRICK_ROWS;j++) {
            for (int i=0; i<NBRICKS_PER_ROW; i++) {
                GRect brick = new GRect(i*BRICK_WIDTH + i*BRICK_SEP, j*BRICK_HEIGHT + j*BRICK_SEP + BRICK_Y_OFFSET, BRICK_WIDTH, BRICK_HEIGHT);
                brick.setFillColor(colorArray[j/2]);
                brick.setColor(colorArray[j/2]);
                brick.setFilled(true);
                this.add(brick);
            }
        }
    }

    // Called on mouse drag to reposition the object
    @Override
    public void mouseMoved(MouseEvent e) {
        double tempX = e.getX()-PADDLE_WIDTH/2;
        if (tempX <= 0) tempX = 0;
        else if (tempX >WIDTH - PADDLE_WIDTH) tempX = WIDTH - PADDLE_WIDTH;
        paddle.setLocation(tempX, HEIGHT - PADDLE_Y_OFFSET);
    }


    private void drawPaddle() {
        paddle = new GRect(WIDTH/2, HEIGHT - PADDLE_Y_OFFSET, PADDLE_WIDTH, PADDLE_HEIGHT);
        paddle.setFillColor(Color.BLACK);
        paddle.setColor(Color.BLACK);
        paddle.setFilled(true);
        add(paddle);
    }

    private void drawBall() {
        ball = new GOval(WIDTH/2, HEIGHT/2, 2 * BALL_RADIUS, 2 * BALL_RADIUS);
        GLine bottomLine = new GLine(0, HEIGHT, WIDTH, HEIGHT);
        GLine rightLine = new GLine(WIDTH, 0, WIDTH, HEIGHT);
        GLine leftLine = new GLine(0, 0, 0, HEIGHT);
        ball.setColor(Color.LIGHT_GRAY);
        ball.setFillColor(Color.LIGHT_GRAY);
        ball.setFilled(true);
        add(ball);
        add(bottomLine);
        add(rightLine);
        add(leftLine);
    }

    private void updateSpeeds(boolean aStart) {
        vx = rgen.nextInt(1, 3);
        if (aStart) {
            if (rgen.nextBoolean(0.5)) vx = -vx;
            vy = 1.5;
        }
    }

    private void moveBall() {
        ball.move(vx, vy);
        checkCollision();
    }

    private void checkCollision() {
        double posY = ball.getLocation().getY() + 2 * BALL_RADIUS + vy;
        double posX = ball.getLocation().getX() + 2 * BALL_RADIUS + vx;
        double posXC = posX -(2 * BALL_RADIUS + vx);
        double posYC = posY -(2 * BALL_RADIUS + vy);
        GObject myObject ;
        int mirrorAxis = 0;
        myObject  = getElementAt(posXC, posYC);

        if (myObject == null) {
            myObject = getElementAt(posXC + 2 * BALL_RADIUS, posYC);
            if (myObject == null) {
                myObject = getElementAt(posXC, posYC + 2 * BALL_RADIUS);
                if (myObject == null) {
                    myObject = getElementAt(posXC + 2 * BALL_RADIUS, posYC + 2 * BALL_RADIUS);
                    if (myObject != null) {
                        mirrorAxis = 2;
                        bounceOnBrick(myObject, posX, posY, mirrorAxis);
                    }
                    else bounceBall(posX, posY, mirrorAxis);
                }
                else  {
                    mirrorAxis = 2;
                    bounceOnBrick(myObject, posX, posY, mirrorAxis);
                }
            }
            else {
                mirrorAxis = 2;
                bounceOnBrick(myObject, posX, posY, mirrorAxis);
            }
        }
        else {
            mirrorAxis = 2;
            bounceOnBrick(myObject, posX, posY, mirrorAxis);
        }
    }
}
