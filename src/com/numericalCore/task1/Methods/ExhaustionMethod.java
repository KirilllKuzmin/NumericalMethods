package com.numericalCore.task1.Methods;

import com.numericalCore.Objects.Matrix;
import com.numericalCore.Objects.Vectors;

public class ExhaustionMethod {

    private static double scalarProduct(Vectors firstVector, Vectors secondVector) {

        double sum = 0;

        for (int i = 0; i < firstVector.getRank(); i++)
            sum += firstVector.get(i) * secondVector.get(i);

        return sum;

    }

    private static Matrix productOfVectors(Vectors firstVector, Vectors secondVector) {

        Matrix resultVector = new Matrix(firstVector.getRank());

        for (int i = 0; i < firstVector.getRank(); i++)
            for (int j = 0; j < firstVector.getRank(); j++)
                resultVector.set(i, j, firstVector.get(j) * secondVector.get(i));

        return resultVector;

    }

    private static Matrix sumOfMatrix(Matrix m1, Matrix m2) {

        Matrix resultMatrix = new Matrix(m1.getRank());

        for (int i = 0; i < m1.getRank(); i++) 
            for (int j = 0; j < m1.getRank(); j++) 
                resultMatrix.set(i, j, m1.get(i, j) + m2.get(i, j));
            
        return resultMatrix;
        
    }

    public static Matrix start(Matrix matrix, double majorEigenValue, Vectors majorEigenVector, Vectors majorTransEigenVector) {

        double intermediateEigenValue = majorEigenValue / scalarProduct(majorEigenVector, majorTransEigenVector);

        Matrix subtractibleMatrix = productOfVectors(majorEigenVector, majorTransEigenVector);

        subtractibleMatrix.multByConstant(-intermediateEigenValue);

        return sumOfMatrix(matrix, subtractibleMatrix);

    }

}
