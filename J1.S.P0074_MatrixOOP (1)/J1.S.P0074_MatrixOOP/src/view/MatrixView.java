 package view;

public class MatrixView {
    public void showMenu() {
        System.out.println("===========Calculator program=============");
        System.out.println("1. Addition Matrix");
        System.out.println("2. Subtraction Matrix");
        System.out.println("3. Multiplication Matrix");
        System.out.println("4. Quit");
    }

    public void displayMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print("[" + val + "]");
            }
            System.out.println();
        }
    }

    public void displayResult(int[][] m1, int[][] m2, int[][] result, String op) {
        System.out.println("-----------Result-------------");
        displayMatrix(m1);
        System.out.println(op);
        displayMatrix(m2);
        System.out.println("=");
        displayMatrix(result);
    }

    public void displayErrorMessages(String error) {
        System.err.println(error);
    }
}