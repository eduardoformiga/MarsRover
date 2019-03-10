package com.formiga;

import java.util.Optional;

import static com.formiga.Direction.NORTH;

class Rover {

    private Grid grid;
    private Direction direction = NORTH;
    private Coordinate coordinate = new Coordinate(0, 0);

    Rover(Grid grid) {
        this.grid = grid;
    }

    String execute(String commands) {
        String obstacleMark = "";
        for (char cmd : commands.toCharArray()) {
            if (cmd == 'R') direction = direction.right();
            else if (cmd == 'L') direction = direction.left();
            else if (cmd == 'M') {
                obstacleMark = move();
            }
        }
        return obstacleMark + coordinate.x() + ":" + coordinate.y() + ":" + direction.value;
    }

    private String move() {
        Optional<Coordinate> nextCoordinate = grid.nextCoordinateFor(direction, this.coordinate);
        nextCoordinate.ifPresent(item -> coordinate = item);
        return nextCoordinate.isPresent() ? "" : "O:";
    }


}
