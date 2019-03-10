package com.formiga;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class RoverShould {
    private Rover rover;

    @Before
    public void init() {
        Grid grid = new Grid();
        rover = new Rover(grid);
    }

    @Test
    @Parameters({
            "R, 0:0:E",
            "RR, 0:0:S",
            "RRR, 0:0:W",
            "RRRR, 0:0:N"
    })
    public void rotateRight(String commands, String positions) {
        assertThat(rover.execute(commands), is(positions));
    }

    @Test
    @Parameters({
            "L, 0:0:W",
            "LL, 0:0:S",
            "LLL, 0:0:E",
            "LLLL, 0:0:N"
    })
    public void rotateLeft(String commands, String positions) {
        assertThat(rover.execute(commands), is(positions));
    }

    @Test
    @Parameters({
            "M, 0:1:N",
            "MM, 0:2:N",
            "MMM, 0:3:N",
            "MMMM, 0:4:N"
    })
    public void moveUp(String commands, String positions) {
        assertThat(rover.execute(commands), is(positions));
    }

    @Test
    @Parameters({
            "MMMMMMMMMM, 0:0:N",
            "MMMMMMMMMMMMMMM, 0:5:N"
    })
    public void wrapToBottomWhenMovingNorth(String commands, String positions) {
        assertThat(rover.execute(commands), is(positions));
    }

    @Test
    @Parameters({
            "RM, 1:0:E",
            "RMMMMM, 5:0:E"
    })
    public void moveRight(String commands, String positions) {
        assertThat(rover.execute(commands), is(positions));
    }

    @Test
    @Parameters({
            "RMMMMMMMMMM, 0:0:E",
            "RMMMMMMMMMMMMMMM, 5:0:E"
    })
    public void wrapToLeftWhenMovingRight(String commands, String positions) {
        assertThat(rover.execute(commands), is(positions));
    }

    @Test
    @Parameters({
            "LM, 9:0:W",
            "LMMMMM, 5:0:W"
    })
    public void moveLeft(String commands, String positions) {
        assertThat(rover.execute(commands), is(positions));
    }

    @Test
    @Parameters({
            "LLM, 0:9:S",
            "LLMMMMM, 0:5:S"
    })
    public void moveSouth(String commands, String positions) {
        assertThat(rover.execute(commands), is(positions));
    }

    @Test
    @Parameters({
            "MMMM, O:0:3:N",
            "RMM, O:1:0:E"
    })
    public void reportObstacles(String commands, String positions) {
        Grid grid = new Grid(Arrays.asList(new Coordinate(0, 4), new Coordinate(2, 0)));
        rover = new Rover(grid);
        assertThat(rover.execute(commands), is(positions));
    }

}
