/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

/**
 *
 * @author HongHa
 */
public class MenuView {
    public void showMenu() {
        System.out.println("\n======== Calculator Program ========");
        System.out.println("1. Addition Matrix");
        System.out.println("2. Subtraction Matrix");
        System.out.println("3. Multiplication Matrix");
        System.out.println("4. Quit");
        System.out.print("Your choice: ");
    }
    
    public void showQuit() {
        System.out.println("\u001B[32mExit program. Bye Bye!\u001B[0m");
    }

    public void showInvalidChoice() {
        System.err.println("Invalid choice!");
    }

    public void showInputError() {
        System.err.println("Please enter number only!");
    }

    public void showInvalidMatrixSize() {
        System.err.println("\u001B[2;36mMatrix size is invalid!\u001B[0m");
    }

    public void showCannotMultiply() {
        System.err.println("\u001B[2;36mCan't multiply two matrices!\u001B[0m");
    }
}
