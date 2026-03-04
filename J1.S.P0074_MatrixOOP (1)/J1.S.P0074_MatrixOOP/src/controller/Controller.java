import utils.Validation;
import view.MatrixView;
import model.Matrix;

public class Controller {
    private MatrixView view = new MatrixView();

    public void run()  {
        while (true) {
            view.showMenu();
            int choice = Validation.getInt("Enter choice: ",
                                          "Must be 1-4",
                                          "Invalid input",
                                          1, 4);
            switch (choice) {
                case 1: executeAddition(); break;
                case 2: executeSubtraction(); break;
                case 3: executeMultiplication(); break;
                case 4: System.exit(0);
            }
        }
    }

    private void executeAddition() {
        try {
            Matrix m1 = Validation.getMatrix(1);
            Matrix m2 = Validation.getMatrix(2);
            Matrix result = m1.add(m2);
            view.displayResult(m1.getData(), m2.getData(), result.getData(), "+");
        } catch (Exception e) {
            view.displayErrorMessages(e.getMessage());
        }
    }

    private void executeSubtraction() {
        try {
            Matrix m1 = Validation.getMatrix(1);
            Matrix m2 = Validation.getMatrix(2);
            Matrix result = m1.subtract(m2);
            view.displayResult(m1.getData(), m2.getData(), result.getData(), "-");
        } catch (Exception e) {
            view.displayErrorMessages(e.getMessage());
        }
    }

    private void executeMultiplication() {
        try {
            Matrix m1 = Validation.getMatrix(1);
            Matrix m2 = Validation.getMatrix(2);
            Matrix result = m1.multiply(m2);
            view.displayResult(m1.getData(), m2.getData(), result.getData(), "*");
        } catch (Exception e) {
            view.displayErrorMessages(e.getMessage());
        }
    }
}