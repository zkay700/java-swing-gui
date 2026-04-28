// Task 4: Press Key to Change Shape
// Create a JPanel that displays a shape in the center.
// Each time the user presses a key ('C', 'R', or 'T'), change the shape between
// circle, rectangle, or triangle accordingly.
// Use KeyListener to detect the key press.

import javax.swing.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.event.*;

public class ChangeShapeOnKey extends JPanel {
    String currentShape = "";

    public ChangeShapeOnKey() {
        // Set up the panel and add KeyListener
        // Make the panel focusable

        JFrame frame = new JFrame();

        this.setPreferredSize(new Dimension(400,640));
        this.setBackground(Color.WHITE);

        frame.add(this);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        addKeyListener(new ShapeKeyListener());
        setFocusable(true);
    }

    private void changeShape(char keyChar) {
        // Set shape type based on key and repaint
        if (keyChar == 'c' || keyChar == 'C') {
            currentShape = "Circle";
        }

        else if (keyChar == 'r' || keyChar == 'R') {
            currentShape = "Rectangle";
        }

        else if (keyChar == 't' || keyChar == 'T') {
            currentShape = "Triangle";
        }

        repaint();
    }

    @Override
    protected void paintComponent(java.awt.Graphics g) {
        super.paintComponent(g);
        // Draw the selected shape in the center

        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.RED);

        if (currentShape.equals("Circle")) {
            g2d.drawOval(150, 295, 150, 150);
        }

        else if (currentShape.equals("Rectangle")) {
            g2d.drawRect(100, 295, 200, 150);
        }

        else if (currentShape.equals("Triangle")) {
            g2d.drawLine(20, 370, 200, 120);
            g2d.drawLine(380, 370, 200, 120);
            g2d.drawLine(20, 370, 380, 370);
        }
    }

    public class ShapeKeyListener implements KeyListener {
        // Empty class

        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_C) {
                changeShape('c');

            }

            if (e.getKeyCode() == KeyEvent.VK_R) {
                changeShape('r');
            }

            if (e.getKeyCode() == KeyEvent.VK_T) {
                changeShape('t');
            }
        }
        public void keyReleased(KeyEvent e) {}
        public void keyTyped(KeyEvent e) {}
    }

    public static void main(String[] args) {
        // Create the GUI and show the panel
        new ChangeShapeOnKey();
    }
}
