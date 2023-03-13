package com.numericalCore.task1.Program;

import com.numericalCore.Objects.Matrix;
import com.numericalCore.Objects.Vectors;
import com.numericalCore.task0.Methods.PowerMethods;
import com.numericalCore.task1.Methods.ExhaustionMethod;
import com.numericalCore.task1.Methods.SPMethod;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DriverToMethods {

    public static void ExhaustionAndSP (Matrix matrix, Vectors zerothApproximationEigenVector, double eps) throws IOException {

        Matrix nextStepMatrix = matrix;

        double eigenValue;
        Vectors eigenVector = new Vectors(matrix.getRank());
        Vectors transpositionEigenVector = new Vectors(matrix.getRank());

        FileWriter answer = new FileWriter("resources/task1/output.txt");

        for (int i = 0; i < nextStepMatrix.getRank(); i++) {

            SPMethod.start(nextStepMatrix, zerothApproximationEigenVector, eps);

            Scanner sc = new Scanner(new File("src/com/numericalCore/task1/Program/tempOutput.txt"));

            eigenValue = sc.nextDouble();

            for (int j = 0; j < eigenVector.getRank(); j++)
                eigenVector.set(j, sc.nextDouble());

            for (int j = 0; j < transpositionEigenVector.getRank(); j++)
                transpositionEigenVector.set(j, sc.nextDouble());

            answer.append("Собственное значение: " + String.format("%.6f",eigenValue) + "\n");
            answer.append("Собственный вектор: " + "(");
            for (int j = 0; j < eigenVector.getRank(); j++)
                answer.append(String.format("%.6f",eigenVector.get(j)/eigenVector.get(0)) + " ");
            answer.append(")\n\n");
            //answer.flush();

            nextStepMatrix = ExhaustionMethod.start(nextStepMatrix, eigenValue, eigenVector, transpositionEigenVector);

            //nextStepMatrix.print();

        }
        answer.flush();
    }

}
