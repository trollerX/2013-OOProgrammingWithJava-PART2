
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextField;

/**
 *
 * @author TrollerX
 */
public class SubtractListener extends MyListener {

    

    public SubtractListener(Calculator calculator, JTextField input, JTextField output, JButton zero) {
        super(calculator, input, output, zero);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(!checkInput()){
            getInput().setText("");
            return;
        }
        getCalculator().subtract(Integer.parseInt(getInput().getText()));
        getInput().setText("");
        getOutput().setText(getCalculator().giveValue() + "");
        checkZ();
    }

}
