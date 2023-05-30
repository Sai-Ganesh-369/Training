package io.endeavourtech.inheritence;

public class Square implements Shape {
    private int length;

    public Square(int length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "Square with the given length : " + length;
    }

    @Override
    public int area() {
        return length*length;
    }
}
