package com.akosha;

public class MarsRover {
    public static final int MAX_X_COORDINATE = 5;
    public static final int MAX_Y_COORDINATE = 5;
    public static final int MIN_X_COORDINATE = 0;
    public static final int MIN_Y_COORDINATE = 0;

    public static final int N = 1;
    public static final int E = 2;
    public static final int S = 3;
    public static final int W = 4;
    int x = 0;
    int y = 0;

    int roverfacing = N;

    public MarsRover() {
    }

    public void startPosition(int x, int y, int roverfacing) {
        this.x = x;
        this.y = y;
        this.roverfacing = roverfacing;
    }

    public String getPosition() {
        char dir = 'N';
        if (roverfacing == N) {
            dir = 'N';
        } else if (roverfacing == E) {
            dir = 'E';
        } else if (roverfacing == S) {
            dir = 'S';
        } else if (roverfacing == W) {
            dir = 'W';
        }
        if ((x > MAX_X_COORDINATE || y > MAX_Y_COORDINATE || x < MIN_X_COORDINATE || y < MIN_Y_COORDINATE)) {

            return "rover has reached the coordinates limit";
        }
        return x + " " + y + " " + dir;
    }

    public void process(String input) {
        for (int i = 0; i < input.length(); i++) {
            processInputCommand(input.charAt(i));
        }
    }

    public void processInputCommand(Character input) {

        if (input.equals('L')) {
            turnLeft();
        } else if (input.equals('R')) {
            turnRight();
        } else if (input.equals('M')) {
            move();
        } else {
            throw new IllegalArgumentException("error in input , please enter valid input command!");
        }
    }

    private void move() {
        if (roverfacing == N) {
            this.y++;
        } else if (roverfacing == E) {
            this.x++;
        } else if (roverfacing == S) {
            this.y--;
        } else if (roverfacing == W) {
            this.x--;
        }
    }

    private void turnLeft() {
        roverfacing = (roverfacing - 1) < N ? W : roverfacing - 1;
    }

    private void turnRight() {
        roverfacing = (roverfacing + 1) > W ? N : roverfacing + 1;
    }
}