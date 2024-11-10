import listener.myActionListener;

import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {
    JFrame frame;
    JPanel mainPanel = new JPanel(new BorderLayout());
    JPanel gridPanel = new JPanel(new GridLayout(4, 4));
    JPanel buttonPanel = new JPanel(new FlowLayout());
    JButton[] buttons = new JButton[16];
    JButton newGameButton = new JButton("New Game");
    JButton label;
    public GUI() {
        frame = new JFrame();
        setButtonPanel();
        gridPanel.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        mainPanel.add(gridPanel);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        frame.add(mainPanel);
        setGridPanel();

        mainPanel.setBackground(Color.BLUE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.pack();
    }

    public void setGridPanel() {
        gridPanel.setPreferredSize(new Dimension(300, 300));
        for (int i = 0; i < 15; i++) {
            label = new JButton();
            label.setText(String.valueOf(i + 1));
            label.setSize(new Dimension(40, 40));
            label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            label.addActionListener(new myActionListener(label, buttons, newGameButton));
            gridPanel.add(label);
            buttons[i] = label;
        }

        JButton finalButton = new JButton();
        finalButton.setText("X");
        finalButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        finalButton.addActionListener(new myActionListener(finalButton, buttons, newGameButton));
        buttons[15] = finalButton;
        gridPanel.add(finalButton);
    }

    public void setButtonPanel() {
        newGameButton.addActionListener(new myActionListener(label, buttons, newGameButton));
        buttonPanel.add(newGameButton);
    }

}
