package com.studyAT;

public class Main {

    public static void main(String[] args) {

        Vector2d a = new Vector2d(4, 3);
        Vector2d b = new Vector2d(2, 1);

        Vector3d c = new Vector3d(1, 2, 3);
        Vector3d d = new Vector3d(4, 5, 6);


        System.out.println("a + b = " + a.add(b).toString());
        System.out.println("a - b = " + a.subtract(b).toString());
        System.out.println("Scalar Multiply = " + a.scalarMultiply(b));

        System.out.println("c + d = " + c.add(d).toString());
        System.out.println("c - d = " + c.subtract(d).toString());
        System.out.println("Vector Multiply = " + c.vectorMultiply(d).toString());
        System.out.println("Scalar Multiply = " + c.scalarMultiply(d));
    }

}
