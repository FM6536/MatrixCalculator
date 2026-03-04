package utils;

import java.util.Scanner;
import model.Matrix;

public class Validation {
    private static final Scanner SCANNER = new Scanner(System.in);

    private Validation() {
        
    }

  
    public static int getInt(String messageInfo,
                             String messageErrorOutOfRange,
                             String messageErrorNumber,
                             int min, int max) {
        do {
            try {
                System.out.print(messageInfo);
                int number = Integer.parseInt(SCANNER.nextLine());
                if (number >= min && number <= max) {
                    return number;
                } else {
                    System.out.println(messageErrorOutOfRange);
                }
            } catch (NumberFormatException e) {
                System.out.println(messageErrorNumber);
            }
        } while (true);
    }

    
    public static Matrix getMatrix(int number) throws Exception {
        int rows = getInt("Enter rows for Matrix " + number + ": ",
                          "Rows must > 0",
                          "Please enter integer number!",
                          1, Integer.MAX_VALUE);

        int cols = getInt("Enter cols for Matrix " + number + ": ",
                          "Cols must > 0",
                          "Please enter integer number!",
                          1, Integer.MAX_VALUE);

        int[][] data = new int[rows][cols];
        System.out.println("Enter elements for Matrix " + number + ":");

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                data[i][j] = getInt("Matrix" + number + "[" + (i+1) + "][" + (j+1) + "]: ",
                                    "Out of range!",
                                    "Value of matrix must be a number",
                                    Integer.MIN_VALUE, Integer.MAX_VALUE);
            }
        }
        return new Matrix(data);
    }
}