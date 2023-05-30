package io.endeavourtech.inheritence;

import java.awt.*;

public class Rectngle implements Shape {
    int length;
    int width;

    public Rectngle(int length, int width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public String toString() {
        return "Rectngle{" +
                "length=" + length +
                ", width=" + width +
                '}';
    }

    @Override
    public int area() {
        return length*width;
    }
}
