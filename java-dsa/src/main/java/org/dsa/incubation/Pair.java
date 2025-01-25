package org.dsa.incubation;

public class Pair<I extends Number, I1 extends Number> {
    Integer x;
    Integer y;

    public Pair(int x, int y) {
        this.x=x;
        this.y=y;
    }

    public Integer getY() {
        return y;
    }

    public Integer getX() {
        return x;
    }
}
