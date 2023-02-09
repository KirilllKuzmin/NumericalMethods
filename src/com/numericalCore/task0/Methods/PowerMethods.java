package com.numericalCore.task0.Methods;

import com.numericalCore.task0.Objects.Matrix;
import com.numericalCore.task0.Objects.Vectors;



public class PowerMethods {

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

    private static Vectors getApproximation(Vectors vector) {

        Vectors result = new Vectors(vector.getRank());

        double norm = norm(vector);

        for (int i = 0; i < vector.getRank(); i++)
            result.set(i, vector.get(i) / norm);

        return result;
    }

    public static double start(Matrix matrix, Vectors approximateVector, double eps){

        Vectors y = matrix.multByVector(approximateVector);

        double eigenValue = multByScalar(y, approximateVector);

        double lastEigenValue = eigenValue + 1;

        while (Math.abs(eigenValue - lastEigenValue) > eps) {

            y = matrix.multByVector(approximateVector);
            lastEigenValue = eigenValue;
            eigenValue = multByScalar(y, approximateVector);
            approximateVector = getApproximation(y);

        }

        return eigenValue;

    }

}
