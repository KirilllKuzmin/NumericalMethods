package com.numericalCore.task0.Objects;

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

        double sum = 0;

        for (int i = 0; i < rank; i++) {
            for (int j = 0; j < rank; j++) {
                sum += matrix[i][j] * vector.get(j);
            }
            result.set(i, sum);

            sum = 0;
        }

        return result;
    }

}
