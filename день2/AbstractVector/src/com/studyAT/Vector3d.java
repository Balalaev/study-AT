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

    public Vector3d vectorMultiply(Vector3d a){
        double newX, newY, newZ;

        newX = this.getY() * a.getZ() - this.getZ() * a.getY();
        newY = this.getX() * a.getZ() - this.getZ() * a.getX();
        newZ = this.getX() * a.getY() - this.getY() * a.getX();
        return new Vector3d(newX, newY, newZ);
    }

    public double scalarMultiply(Vector3d a){
        return  this.getX() * a.getX() +
                this.getY() * a.getY() +
                this.getZ() * a.getZ();
    }

    public String toString() {
        return "{" + "x=" + x + ", y=" + y + ", z=" + z + "}";
    }
}
