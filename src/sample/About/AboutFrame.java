package sample.About;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AboutFrame {
    private JPanel aboutPanel;
    JFrame frame = new JFrame("Über SystemCalc");

    public void showAboutPanel() {
        frame.setContentPane(new AboutFrame().aboutPanel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setSize(1000, 250);
        frame.setLocation(1250, 500);
        frame.setVisible(true);
    }
}
