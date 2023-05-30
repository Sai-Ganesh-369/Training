package io.endeavourtech.inheritence;

public class ShapeGame {
    public static void main(String[] args) {
        Square sq = new Square(5);
        Rectngle re = new Rectngle(5,5);
        Circle c = new Circle(5);
        Shape[] shapes = new Shape[3];
        shapes[0] = sq;
        shapes[1] = re;
        shapes[2] = c;

        int area = totalArea(shapes);
        System.out.println("Total area is : " + area);


    }

    private static int totalArea(Shape[] shapes) {
        int area=0;
        for(Shape shape: shapes){
            System.out.println("to String : " + shape.toString());
            area = area + shape.area();
        }
        return area;
    }
}
