/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package View;

/**
 *
 * @author huydo
 */

import Manage.MatrixManager;
import Utils.Validations;

public class MenuView {

    private MatrixManager manager = new MatrixManager();

    public void display() {
        while (true) {
            System.out.println("\n=======Calculator program=======");
            System.out.println("1. Addition Matrix");
            System.out.println("2. Subtraction Matrix");
            System.out.println("3. Multiplication Matrix");
            System.out.println("4. Quit");
            System.out.print("Your choice: ");
            
            int choice = Validations.checkIntLimit(1, 4);
            if (choice == 4) {
                break;
            }

            processMatrixOperation(choice);
        }
    }

    private void processMatrixOperation(int choice) {
        String operationName = "";
        String operator = "";
        if (choice == 1) { operationName = "Addition"; operator = "+"; }
        else if (choice == 2) { operationName = "Subtraction"; operator = "-"; }
        else if (choice == 3) { operationName = "Multiplication"; operator = "*"; }

        System.out.println("\n-------- " + operationName + " --------");
        
        // Nhập Matrix 1
        int row1 = getDimension("Enter Row Matrix 1: ");
        int col1 = getDimension("Enter Column Matrix 1: ");
        int[][] matrix1 = inputMatrix(1, row1, col1);

        // Nhập Matrix 2 với điều kiện ràng buộc toán học
        int row2, col2;
        while (true) {
            row2 = getDimension("Enter Row Matrix 2: ");
            col2 = getDimension("Enter Column Matrix 2: ");
            
            // Check điều kiện cộng/trừ (cùng kích thước)
            if ((choice == 1 || choice == 2) && (row1 != row2 || col1 != col2)) {
                System.err.println("Matrix 2 must have the same dimensions as Matrix 1 (" + row1 + "x" + col1 + ")!");
                continue;
            }
            // Check điều kiện nhân (cột 1 = dòng 2)
            if (choice == 3 && col1 != row2) {
                System.err.println("Row of Matrix 2 must equal Column of Matrix 1 (" + col1 + ")!");
                continue;
            }
            break;
        }
        int[][] matrix2 = inputMatrix(2, row2, col2);

        // Xử lý và in kết quả
        System.out.println("-------- Result --------");
        printMatrix(matrix1);
        System.out.println(operator);
        printMatrix(matrix2);
        System.out.println("=");

        int[][] result = null;
        if (choice == 1) result = manager.additionMatrix(matrix1, matrix2);
        else if (choice == 2) result = manager.subtractionMatrix(matrix1, matrix2);
        else if (choice == 3) result = manager.multiplicationMatrix(matrix1, matrix2);

        if (result != null) {
            printMatrix(result);
        }
    }

    private int getDimension(String prompt) {
        System.out.print(prompt);
        return Validations.checkMatrixDimension();
    }

    private int[][] inputMatrix(int nth, int row, int col) {
        int[][] matrix = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("Enter Matrix" + nth + "[" + (i + 1) + "][" + (j + 1) + "]: ");
                matrix[i][j] = Validations.checkMatrixValue();
            }
        }
        return matrix;
    }

    private void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print("[" + matrix[i][j] + "]");
            }
            System.out.println();
        }
    }
}
