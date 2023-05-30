package io.endeavourtech.inheritence;
import java.lang.Math;

public class Circle implements Shape{
    int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    @Override
    public int area() {
        return (int) (3.24*(radius)*radius);

    }
}
