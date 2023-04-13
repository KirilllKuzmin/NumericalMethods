package com.numericalCore.task2.Program;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import com.numericalCore.task2.Frame.DrawFrame;
import com.numericalCore.task2.Methods.AdamsMethods;
import com.numericalCore.task2.Objects.Dot;
import com.numericalCore.task2.Objects.Function;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class Program {

    public static double A;

    public static double B;

    public static double y0;

    public static String expression;

    public static Function function;

    public static Function ansFunction;

    private void input() throws FileNotFoundException {
        String path = Path.of("").toAbsolutePath() + "\\resources\\task2\\input3.txt";
        File file = new File(path);
        Scanner sc = new Scanner(file);
        sc.useLocale(Locale.UK);

        A = sc.nextDouble();
        B = sc.nextDouble();
        y0 = sc.nextDouble();

        sc.nextLine();

        expression = sc.nextLine();
        function = new Function(expression);

        expression = sc.nextLine();
        ansFunction = new Function(expression);
    }

    public void start() {
        try {
            input();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        List<Dot> dots = AdamsMethods.run(function, A, B, y0);

        double discrepancy = AdamsMethods.calcDiscrepancy(function, ansFunction, dots);

        System.out.println("Погрешность: " + discrepancy);

//        for (int i = 0; i < dots.size(); i++) {
//            System.out.println(dots.get(i).x + " " + dots.get(i).y);
//        }

        DrawFrame.draw(dots, ansFunction);
    }

}
