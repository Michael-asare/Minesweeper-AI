package minesweeper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Main {
    public static void main (String [] args) {
        JFrame frame = new JFrame();
        JPanel contentPanel = new JPanel();

        contentPanel.setBorder(Constants.GUI.BORDER);
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));

        JPanel gridPanel = new JPanel();
        gridPanel.add(new JButton("hehe"));
        JPanel HUDPanel = new JPanel();
        HUDPanel.add(new JButton("wewe"));

        contentPanel.add(gridPanel);
        contentPanel.add(HUDPanel);

        frame.add(contentPanel, BorderLayout.CENTER);
        setFrameProperties(frame);
    }

    private static void populateGrid(JPanel grid) {

    }

    private static void setFrameProperties(JFrame frame) {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle(Constants.GUI.TITLE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static MouseAdapter clickAdapter() {
        return new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        };
    }
}
