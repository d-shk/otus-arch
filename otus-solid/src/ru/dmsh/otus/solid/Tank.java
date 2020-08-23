package ru.dmsh.otus.solid;

import java.util.Vector;

public class Tank {

    Vector<Integer> position;
    Vector<Integer> speed;
    Double direction;

    public void update() {

    }

    public Vector<Integer> getPosition() {
        return position;
    }

    public void setPosition(Vector<Integer> position) {
        this.position = position;
    }

    public Vector<Integer> getSpeed() {
        return speed;
    }

    public void setSpeed(Vector<Integer> speed) {
        this.speed = speed;
    }

    public Double getDirection() {
        return direction;
    }

    public void setDirection(Double direction) {
        this.direction = direction;
    }
}
