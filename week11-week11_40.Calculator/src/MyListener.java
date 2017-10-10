
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextField;

/**
 *
 * @author TrollerX
 */
abstract class MyListener implements ActionListener {

    private Calculator calculator;
    private JTextField input;
    private JTextField output;
    private JButton zero;

    public MyListener(Calculator calculator, JTextField input, JTextField output, JButton zero) {
        this.calculator = calculator;
        this.input = input;
        this.output = output;
        this.zero = zero;
    }

    public Calculator getCalculator() {
        return calculator;
    }

    public JTextField getInput() {
        return input;
    }

    public JTextField getOutput() {
        return output;
    }

    public JButton getZero() {
        return zero;
    }

    public void checkZ() {
        if (Integer.parseInt(getOutput().getText()) == 0) {
            zero.setEnabled(false);
        } else {
            zero.setEnabled(true);
        }
    }

    public boolean checkInput() {
        try {
            Integer.parseInt(input.getText());
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    @Override
    public abstract void actionPerformed(ActionEvent e);

}
