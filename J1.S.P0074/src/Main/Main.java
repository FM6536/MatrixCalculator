/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Main;

import Object.Matrix;
import View.MatrixView;
import View.MenuView;
import java.util.Scanner;

/**
 *
 * @author HongHa
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MenuView menuView = new MenuView();
        MatrixView matrixView = new MatrixView();
        Scanner sc = new Scanner(System.in);


        while (true) {
            menuView.showMenu();

            int choice;
            try {
                choice = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                menuView.showInputError();
                continue;
            }
            
            int[][] matrix1Data;
            int[][] matrix2Data;
            
            Matrix matrix1;
            Matrix matrix2;

            switch (choice) {
                case 1:
                    System.out.println("\n-------- Addition --------");
                    
                    matrix1Data = matrixView.inputMatrix("1");
                    matrix2Data = matrixView.inputMatrix("2");

                    matrix1 = new Matrix(matrix1Data);
                    matrix2 = new Matrix(matrix2Data);
                    Matrix addresult = matrix1.add(matrix2);
                    
                    if (addresult == null) {
                        menuView.showInvalidMatrixSize();
                        break;
                    }
                    
                    matrixView.displayResult(matrix1.getMatrix(), matrix2.getMatrix(), addresult.getMatrix(), "+");
                    break;

                case 2:
                    System.out.println("\n-------- Subtraction --------");

                    matrix1Data = matrixView.inputMatrix("1");
                    matrix2Data = matrixView.inputMatrix("2");

                    matrix1 = new Matrix(matrix1Data);
                    matrix2 = new Matrix(matrix2Data);
                    Matrix subresult = matrix1.subtract(matrix2);
                    
                    if (subresult == null) {
                        menuView.showInvalidMatrixSize();
                        break;
                    }
                    
                    matrixView.displayResult(matrix1.getMatrix(), matrix2.getMatrix(), subresult.getMatrix(), "-");
                    break;


                case 3:
                    System.out.println("\n-------- Multiplication --------");
                    
                    matrix1Data = matrixView.inputMatrix("1");
                    matrix2Data = matrixView.inputMatrix("2");

                    matrix1 = new Matrix(matrix1Data);
                    matrix2 = new Matrix(matrix2Data);
                    Matrix mulresult = matrix1.multiply(matrix2);
                    
                    if (mulresult == null) {
                        menuView.showCannotMultiply();
                        break;
                    }
                    
                    matrixView.displayResult(matrix1.getMatrix(), matrix2.getMatrix(), mulresult.getMatrix(), "*");
                    break;

                case 4:
                    menuView.showQuit();
                    return;

                default:
                    menuView.showInvalidChoice();
            }
        }
    }
}
