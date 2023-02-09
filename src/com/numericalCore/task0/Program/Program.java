package com.numericalCore.task0.Program;

import com.numericalCore.task0.Methods.PowerMethods;
import com.numericalCore.task0.Objects.Matrix;
import com.numericalCore.task0.Objects.Vectors;

import java.util.Locale;
import java.util.Scanner;



public class Program {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.UK);

        int rank = sc.nextInt();

        double[] startApproximate = new double[rank];
        for (int i = 0; i < rank; i++) {
            startApproximate[i] = sc.nextDouble();
        }

        double[][] A = new double[rank][rank];
        for (int i = 0; i < rank; i++) {
            for (int j = 0; j < rank; j++) {
                A[i][j] = sc.nextDouble();
            }
        }

        double eps = Math.pow(0.1, 6);

        Matrix matrix = new Matrix(rank, A);

        Vectors approximate = new Vectors(rank, startApproximate);

        System.out.println(PowerMethods.start(matrix, approximate, eps));

    }

}
