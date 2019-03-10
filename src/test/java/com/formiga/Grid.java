package com.formiga;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static com.formiga.Direction.EAST;
import static com.formiga.Direction.NORTH;
import static com.formiga.Direction.SOUTH;
import static com.formiga.Direction.WEST;

class Grid {

    private static final int MAX_HEIGHT = 10;
    private static final int MAX_WIDTH = 10;
    private List<Coordinate> obstacles = Collections.emptyList();

    Grid() {
    }

    Grid(List<Coordinate> obstacles) {
        this.obstacles = obstacles;
    }

    Optional<Coordinate> nextCoordinateFor(Direction direction, Coordinate coordinate) {
        int x = coordinate.x();
        int y = coordinate.y();

        if (direction == NORTH) {
            y = (coordinate.y() + 1) % MAX_HEIGHT;
        }
        if (direction == EAST) {
            x = (coordinate.x() + 1) % MAX_WIDTH;
        }
        if (direction == SOUTH) {
            y = (coordinate.y() > 0) ? coordinate.y() - 1 : MAX_HEIGHT - 1;
        }
        if (direction == WEST) {
            x = (coordinate.x() > 0) ? coordinate.x() - 1 : MAX_WIDTH - 1;
        }

        Coordinate newCoordinate = new Coordinate(x, y);
        return obstacles.contains(newCoordinate) ? Optional.empty() : Optional.of(newCoordinate);
    }
}