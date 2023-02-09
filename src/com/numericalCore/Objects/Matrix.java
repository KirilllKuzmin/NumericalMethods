package com.numericalCore.Objects;



public class Matrix {

    private final int rank;

    private final double [][] matrix;


    public Matrix(int rank) {
        this.rank = rank;
        matrix = new double[rank][rank];
    }


    public Matrix(int rank, double [][] matrix) {
        this.rank = rank;
        this.matrix = matrix;
    }


    public Vectors multByVector(Vectors vector) {

        Vectors result = new Vectors(vector.getRank());

        for (int i = 0; i < rank; i++)
            for (int j = 0; j < rank; j++)
                result.set(i, result.get(i) + matrix[i][j] * vector.get(j));

        return result;
    }

    public void print() {

        for (int i = 0; i < rank; i++) {
            for (int j = 0; j < rank; j++)
                System.out.print(matrix[i][j] + " ");

            System.out.println();
        }
    }

    public double get(int i, int j) { return matrix[i][j]; }

    public int getRank() { return rank; }

    public void set(int i, int j, double value) { matrix[i][j] = value; }

}
