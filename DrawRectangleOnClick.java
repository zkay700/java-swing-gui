// Task 1: Draw Rectangle on Click
// Create a JPanel where a rectangle is drawn at the location where the user clicks.
// Use MouseListener to detect the click and store the position.

import javax.swing.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.DisplayMode;
import java.awt.Graphics2D;
import java.awt.event.*;

public class DrawRectangleOnClick extends JPanel {
    int oldX;
    int oldY;

    public DrawRectangleOnClick() {
        // Set up the panel and add MouseListener
        JFrame frame = new JFrame("Draw Rectangle");
        
        this.setPreferredSize(new Dimension(400, 640));
        this.setBackground(Color.WHITE);

        frame.add(this);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        addMouseListener(new ClickListener());
    }

    private void setRectanglePosition(int x, int y) {
        // Store click position and call repaint
        oldX = x;
        oldY = y;

        repaint();
    }

    @Override
    protected void paintComponent(java.awt.Graphics g) {
        super.paintComponent(g);
        // Draw a rectangle at the stored location
        if (oldX >= 0 && oldY >= 0) {
            
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.RED);
        g2d.fillRect(oldX, oldY,200 , 50);
        }


    }

    public class ClickListener implements MouseListener {
        // Empty class
        public void mouseClicked(MouseEvent e) {
            setRectanglePosition(e.getX(), e.getY());
            
        }
        public void mouseEntered(MouseEvent e) {}
        public void mouseExited(MouseEvent e) {}
        public void mousePressed(MouseEvent e) {}
        public void mouseReleased(MouseEvent e) {}
    }

    public static void main(String[] args) {
        // Create the GUI and show the panel
        new DrawRectangleOnClick();
    }
}

