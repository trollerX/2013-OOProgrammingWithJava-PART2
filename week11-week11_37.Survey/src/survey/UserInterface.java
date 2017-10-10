package survey;

import java.awt.CheckboxGroup;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.*;

public class UserInterface implements Runnable {

    private JFrame frame;

    @Override
    public void run() {
        frame = new JFrame("Survey");
        frame.setPreferredSize(new Dimension(200, 300));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container) {
        BoxLayout layout = new BoxLayout(container, BoxLayout.Y_AXIS);
        container.setLayout(layout);

        container.add(new JLabel("Are you?"));

        JCheckBox yes = new JCheckBox("Yes!");
        JCheckBox no = new JCheckBox("No!");

        container.add(yes);
        container.add(no);

        container.add(new JLabel("Why?"));

        JRadioButton reason = new JRadioButton("No reason.");
        JRadioButton because = new JRadioButton("Because it is fun!");

        ButtonGroup bg = new ButtonGroup();
        bg.add(reason);
        bg.add(because);
        
        container.add(reason);
        container.add(because);
        
        JButton done = new JButton("Done!");
        container.add(done);
    }

    public JFrame getFrame() {
        return frame;
    }
}
