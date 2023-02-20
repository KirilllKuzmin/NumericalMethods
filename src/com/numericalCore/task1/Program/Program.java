package com.numericalCore.task1.Program;



import com.numericalCore.Objects.Matrix;
import com.numericalCore.Objects.Vectors;
import com.numericalCore.task1.Methods.SPMethod;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;


public class Program {

    public static void main() throws IOException {

        //Scanner sc = new Scanner(new File("resources/task0/courseInput.txt"));
        Scanner sc = new Scanner(new File("resources/task1/input.txt"));
        sc.useLocale(Locale.UK);

        int rank = sc.nextInt();

        double eps = Math.pow(10, -6);

        Vectors approximate = new Vectors(rank);
        for (int i = 0; i < rank; i++)
            approximate.set(i, sc.nextDouble());

        Matrix matrix = new Matrix(rank);
        for (int i = 0; i < rank; i++)
            for (int j = 0; j < rank; j++)
                matrix.set(i, j, sc.nextDouble());


        DriverToMethods.ExhaustionAndSP(matrix, approximate, eps);

    }

}
