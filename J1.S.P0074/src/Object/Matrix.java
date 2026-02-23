/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Object;

/**
 *
 * @author HongHa
 */
public class Matrix {
    private int row;
    private int column;
    private int[][] matrix;
    
    public Matrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            throw new IllegalArgumentException("Matrix is invalid");
        }

        int colLength = matrix[0].length;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i].length != colLength) {
                throw new IllegalArgumentException(
                        "Rows and Columns of two matrix must be same!");
            }
        }

        this.row = matrix.length;
        this.column = colLength;
        this.matrix = matrix;
    }
    
    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public int[][] getMatrix() {
        return matrix;
    }
    
    public Matrix add(Matrix that) {
        if (this.row != that.row || this.column != that.column) {
            throw new IllegalArgumentException(
                    "Two matrices must have the same size!");
        }

        int[][] result = new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                result[i][j] = this.matrix[i][j] + that.matrix[i][j];
            }
        }
        return new Matrix(result);
    }

    public Matrix subtract(Matrix that) {
        if (this.row != that.row || this.column != that.column) {
            throw new IllegalArgumentException(
                    "Two matrices must have the same size!");
        }

        int[][] result = new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                result[i][j] = this.matrix[i][j] - that.matrix[i][j];
            }
        }
        return new Matrix(result);
    }

    public Matrix multiply(Matrix that) {
        if (this.column != that.row) {
            throw new IllegalArgumentException(
                    "Column of matrix 1 must equal row of matrix 2!");
        }

        int[][] result = new int[this.row][that.column];
        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < that.column; j++) {
                for (int k = 0; k < this.column; k++) {
                    result[i][j] += this.matrix[i][k] * that.matrix[k][j];
                }
            }
        }
        return new Matrix(result);
    }
}
