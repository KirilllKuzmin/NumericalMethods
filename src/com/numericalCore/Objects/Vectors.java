package com.numericalCore.Objects;



public class Vectors {

    private final int rank;

    private final double [] vector;

    public Vectors(int rank) {
        this.rank = rank;
        vector = new double[rank];
    }
    public Vectors(int rank, double [] vector) {
        this.rank = rank;
        this.vector = vector;
    }

    public double get(int i) { return vector[i]; }

    public int getRank() { return rank; }

    public void set(int i, double value) { vector[i] = value; }

}
