package com.studyAT;

public class Vector2d {
    private double x, y;

    public Vector2d(double x, double y){
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x; }

    public double getY() {
        return y; }

    public Vector2d add(Vector2d a){
        return new Vector2d(
                this.getX() + a.getX(),
                this.getY() + a.getY());
    }

    public Vector2d subtract(Vector2d a){
        return new Vector2d(
                this.getX() - a.getX(),
                this.getY() - a.getY());
    }

    public double scalarMultiply(Vector2d a){
        return this.getX() * a.getX() +
                this.getY() * a.getY();
    }

    public String toString() {
        return "{" + "x= " + x + ", y= " + y + "}";
    }
}
