/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Utils.Validation;

/**
 *
 * @author HongHa
 */
public class MatrixView {
    public int[][] inputMatrix(String name) {
        int row;
        while (true) {
            System.out.print("Enter Row Matrix " + name + ": ");
            try {
                row = Validation.checkInput();
                if (row <= 0) {
                    System.err.println("Values must be greater than 0!");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.err.println("Values of matrix must be the number!");
            }
        }
        
        int column;
        while (true) {
            System.out.print("Enter Column Matrix " + name + ": ");
            try {
                column = Validation.checkInput();
                if (column <= 0) {
                    System.err.println("Values must be greater than 0!");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.err.println("Values of matrix must be the number!");
            }
        }

        int[][] matrix = new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                while (true) {
                    System.out.print("Enter Matrix" + name + "[" + (i + 1) + "][" + (j + 1) + "]: ");
                    try {
                        matrix[i][j] = Validation.inputValues();
                        break;
                    } catch (NumberFormatException e) {
                        System.err.println("Value of matrix is digit!");
                    }
                }
            }
        }
        return matrix;
    }

    public void displayMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print("[" + value + "]");
            }
            System.out.println();
        }
    }

    public void displayResult(int[][] matrix1, int[][] matrix2, int[][] result, String operator) {

        System.out.println("---------- Result ----------");
        displayMatrix(matrix1);
        System.out.println(operator);
        displayMatrix(matrix2);
        System.out.println("=");
        displayMatrix(result);
    }
}
