package com.studyAT;

public class Vector3d {
    private double x, y, z;

    public Vector3d(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return x; }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public Vector3d add(Vector3d a){
        return new Vector3d(
                this.getX() + a.getX(),
                this.getY() + a.getY(),
                this.getZ() + a.getZ());
    }

    public Vector3d subtract(Vector3d a){
        return new Vector3d(
                this.getX() - a.getX(),
                this.getY() - a.getY(),
                this.getZ() - a.getZ());
    }

    public Vector3d vectorMultip(Vector3d a){
        double newX = this.getY() * a.getZ() - this.getZ() * a.getY();
        double newY = - (this.getX() * a.getZ() - this.getZ() * a.getX());
        double newZ = this.getX() * a.getY() - this.getY() * a.getX();
        return new Vector3d(newX, newY, newZ);
    }

    public double scalarMultip(Vector3d a){
        return  this.getX() * a.getX() +
                this.getY() * a.getY() +
                this.getZ() * a.getZ();
    }

    public String toString() {
        return "{" + "x=" + x + ", y=" + y + ", z=" + z + "}";
    }
}
