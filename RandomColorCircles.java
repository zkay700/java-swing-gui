// Task 1: Click to Draw Random Colored Circle
// Create a JPanel where each mouse click draws a circle at the click location.
// Each circle should be filled with a random color.
// Use MouseListener to detect the clicks.

import javax.swing.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.event.*;

public class RandomColorCircles extends JPanel {
    Color currentColor;

    int oldX = 0;
    int oldY = 0;

    public RandomColorCircles() {
        // Set up the panel and add MouseListener
        JFrame frame = new JFrame();

        this.setPreferredSize(new Dimension(600, 600));
        this.setBackground(Color.WHITE);

        frame.add(this);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        addMouseListener(new CircleClickListener());
        // setFocusable(true);

    }

    private void addCircle(int x, int y) {
        // Store position and generate random color, then repaint
        oldX = x;
        oldY = y;

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
    protected void paintComponent(java.awt.Graphics g) {
        super.paintComponent(g);
        // Draw all circles with their stored random colors

        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(currentColor);

        if (oldX > 0 && oldY > 0) {
            g2d.fillOval(oldX, oldY, 100, 100);

        } 
    }

    public class CircleClickListener implements MouseListener {
        // Empty class
        public void mouseClicked(MouseEvent e) {
            addCircle(e.getX(), e.getY());
        }
        public void mouseEntered(MouseEvent e) {}
        public void mouseExited(MouseEvent e) {}
        public void mousePressed(MouseEvent e) {}
        public void mouseReleased(MouseEvent e) {}
    }

    public static void main(String[] args) {
        // Create the GUI and show the panel
        new RandomColorCircles();
    }
}

