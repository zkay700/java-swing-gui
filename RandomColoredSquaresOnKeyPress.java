// Task 2: Press Key to Draw Random Colored Squares
// Each time a key is pressed, draw a small square at a random position
// with a random color.
// Use KeyListener to handle keyPressed.

import javax.swing.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.*;
import java.util.Random;

public class RandomColoredSquaresOnKeyPress extends JPanel {
    int x = -1;
    int y = -1;

    Color currentColor;

    public RandomColoredSquaresOnKeyPress() {
        // Set up panel and add KeyListener
        // Make panel focusable
        JFrame frame = new JFrame();

        this.setPreferredSize(new Dimension(600,600));
        this.setBackground(Color.WHITE);

        frame.add(this);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        addKeyListener(new KeySquareListener());
        setFocusable(true);
    }

    private void addSquare() {
        // Generate random position and color, store it, and repaint
        x = new Random().nextInt(getWidth());
        y = new Random().nextInt(getHeight());

        currentColor = getRandomColor();

        repaint();
    }

    private Color getRandomColor() {
        int r = (int) (Math.random() * 256);
        int g = (int) (Math.random() * 256);
        int b = (int) (Math.random() * 256);

        return new Color(r,g,b);
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Draw all stored squares

        Graphics2D g2d = (Graphics2D) g;

        if (x > 0 && y > 0) {
        g2d.setColor(currentColor);
        g2d.fillOval(x, y, 100, 100);

        }
    }

    public class KeySquareListener implements KeyListener {
        // Empty class
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                addSquare();
            }

        }
        public void keyReleased(KeyEvent e) {}
        public void keyTyped(KeyEvent e) {}
    }

    public static void main(String[] args) {
        // Create the GUI and show the panel
        new RandomColoredSquaresOnKeyPress();
    }
}

