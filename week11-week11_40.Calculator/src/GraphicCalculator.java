
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class GraphicCalculator implements Runnable {

    private JFrame frame;
    private Calculator calculator;
    private JTextField input;
    private JTextField output;

    public GraphicCalculator(Calculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public void run() {
        frame = new JFrame("Calculator");
        frame.setPreferredSize(new Dimension(400, 200));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container) {
        GridLayout layout = new GridLayout(3, 1);
        container.setLayout(layout);

        this.output = new JTextField("0");
        output.setEnabled(false);
        this.input = new JTextField();
        JPanel operations = createPanel();

        container.add(output);
        container.add(input);
        container.add(operations);
    }

    private JPanel createPanel() {
        JPanel panel = new JPanel(new GridLayout(1, 3));

        JButton zero = new JButton("Z");
        zero.setEnabled(false);
        zero.addActionListener(new ZeroListener(calculator, input, output, zero));

        JButton plus = new JButton("+");
        plus.addActionListener(new AddListener(calculator, input, output, zero));

        JButton minus = new JButton("-");
        minus.addActionListener(new SubtractListener(calculator, input, output, zero));

        panel.add(plus);
        panel.add(minus);
        panel.add(zero);
        return panel;
    }

    public JFrame getFrame() {
        return frame;
    }
}
