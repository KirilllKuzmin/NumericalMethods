package com.numericalCore.task1.Methods;

import com.numericalCore.Objects.Matrix;
import com.numericalCore.Objects.Vectors;

public class SPMethod {

    private static double norm(Vectors vector){

        double sum = 0;

        for (int i = 0; i < vector.getRank(); i++)
            sum += Math.pow(vector.get(i), 2);

        return Math.sqrt(sum);
    }

    private static double multByScalar(Vectors v1, Vectors v2) {

        double sum = 0;

        for (int i = 0; i < v1.getRank(); i++)
            sum += v1.get(i) * v2.get(i);

        return sum;

    }

    private static Vectors normalizationVector(Vectors vector) {

        Vectors result = new Vectors(vector.getRank());

        double norm = norm(vector);

        for (int i = 0; i < vector.getRank(); i++)
            result.set(i, vector.get(i) / norm);

        return result;
    }

    private static Matrix transposition(Matrix matrix) {

        Matrix transpositionMatrix = new Matrix(matrix.getRank());

        for (int i = 0; i < matrix.getRank(); i++) {
            for (int j = 0; j < matrix.getRank(); j++) {
                transpositionMatrix.set(j, i, matrix.get(i, j));
            }
        }

        return transpositionMatrix;
    }

    public static double start(Matrix matrix, Vectors startEigenVector, double eps){

        Vectors eigenVector = matrix.multByVector(startEigenVector);
        eigenVector = normalizationVector(eigenVector);

        Matrix transpositionMatrix = transposition(matrix);
        Vectors transpositionEigenVector = transpositionMatrix.multByVector(startEigenVector);

        eigenVector = normalizationVector(eigenVector);
        transpositionEigenVector = normalizationVector(transpositionEigenVector);

        double eigenValue = multByScalar(eigenVector, transpositionEigenVector) / multByScalar(startEigenVector, transpositionEigenVector);
        double lastEigenValue = eigenValue + 1;

        while (Math.abs(lastEigenValue - eigenValue) > eps) {

            Vectors newEigenVector = matrix.multByVector(eigenVector);
            transpositionEigenVector = transpositionMatrix.multByVector(transpositionEigenVector);

            eigenVector = normalizationVector(newEigenVector);
            transpositionEigenVector = normalizationVector(transpositionEigenVector);

            lastEigenValue = eigenValue;
            eigenValue = multByScalar(newEigenVector, transpositionEigenVector) / multByScalar(eigenVector, transpositionEigenVector);

        }

        for (int i = 0; i < eigenVector.getRank(); i++)
            System.out.println(eigenVector.get(i)/eigenVector.get(0));
        System.out.println();

        return eigenValue;
    }

}
