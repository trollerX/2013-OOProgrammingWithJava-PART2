
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextField;

/**
 *
 * @author TrollerX
 */
public class ZeroListener extends MyListener {

    
    public ZeroListener(Calculator calculator, JTextField input, JTextField output, JButton zero) {
        super(calculator, input, output, zero);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        getOutput().setText("0");
        getInput().setText("");
        getZero().setEnabled(false);
    }
}
