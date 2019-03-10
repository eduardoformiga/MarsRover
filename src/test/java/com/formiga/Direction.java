package com.formiga;

public enum Direction {
    NORTH("N","E","W"),
    EAST("E","S","N"),
    SOUTH("S","W","E"),
    WEST("W","N","S");

    String value;
    String right;
    String left;

    Direction(String value, String right, String left) {
        this.value = value;
        this.right = right;
        this.left = left;
    }

    Direction right(){
        return getDirectionToThe(this.right);
    }

    Direction left(){
        return getDirectionToThe(this.left);
    }

    private Direction getDirectionToThe(String value) {
        for (Direction direction : values()) {
            if (direction.value.equals(value)) return direction;
        }
        return null;
    }

}
