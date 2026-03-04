package model;

public class Matrix {
    private int rows;
    private int cols;
    private int[][] data;

    public Matrix(int[][] data) throws Exception {
        if (data == null || data.length == 0) throw new Exception("Matrix data invalid");
        this.rows = data.length;
        this.cols = data[0].length;
        this.data = data;
    }

    public int[][] getData() { return data; }
    public int getRows() { return rows; }
    public int getCols() { return cols; }

    public Matrix add(Matrix other) throws Exception {
        if (rows != other.rows || cols != other.cols) throw new Exception("Size mismatch");
        int[][] result = new int[rows][cols];
        for (int i=0; i<rows; i++) {
            for (int j=0; j<cols; j++) {
                result[i][j] = this.data[i][j] + other.data[i][j];
            }
        }
        return new Matrix(result);
    }

    public Matrix subtract(Matrix other) throws Exception {
        if (rows != other.rows || cols != other.cols) throw new Exception("Size mismatch");
        int[][] result = new int[rows][cols];
        for (int i=0; i<rows; i++) {
            for (int j=0; j<cols; j++) {
                result[i][j] = this.data[i][j] - other.data[i][j];
            }
        }
        return new Matrix(result);
    }

    public Matrix multiply(Matrix other) throws Exception {
        if (cols != other.rows) throw new Exception("Cols of matrix1 must equal rows of matrix2");
        int[][] result = new int[rows][other.cols];
        for (int i=0; i<rows; i++) {
            for (int j=0; j<other.cols; j++) {
                for (int k=0; k<cols; k++) {
                    result[i][j] += this.data[i][k] * other.data[k][j];
                }
            }
        }
        return new Matrix(result);
    }
}