/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

/**
 *
 * @author huydo
 */
import java.util.Scanner;

public class Validations {

    private static final Scanner sc = new Scanner(System.in);

    // Kiểm tra số nguyên với khoảng min - max cho Menu
    public static int checkIntLimit(int min, int max) {
        while (true) {
            try {
                int result = Integer.parseInt(sc.nextLine().trim());
                if (result < min || result > max) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException e) {
                System.err.print("Invalid input! Enter choice (" + min + " - " + max + "): ");
            }
        }
    }

    // Kiểm tra số nguyên dương cho Row và Column của ma trận
    public static int checkMatrixDimension() {
        while (true) {
            try {
                int result = Integer.parseInt(sc.nextLine().trim());
                if (result <= 0) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException e) {
                System.err.print("Dimension must be a positive integer. Enter again: ");
            }
        }
    }

    // Kiểm tra giá trị từng phần tử của ma trận
    public static int checkMatrixValue() {
        while (true) {
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                // Hiển thị thông báo chính xác theo yêu cầu đề bài
                System.err.println("Values of matrix must be the number");
                System.out.print("Enter again: ");
            }
        }
    }
}
