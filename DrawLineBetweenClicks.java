// Task 3: Draw Line Between Two Clicks
// Create a JPanel where a user clicks two points,
// and a line is drawn connecting them.
// Use MouseListener to record the positions.

import javax.swing.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.event.*;

public class DrawLineBetweenClicks extends JPanel {
    int firstPointx = 0;
    int firstPointy = 0;

    int secondPointx = 0;
    int secondPointy = 0;

    int clickCount = 0;

    JFrame frame;

    public DrawLineBetweenClicks() {
        // Set up the panel and add MouseListener
        frame = new JFrame("Two Clicks");

        this.setPreferredSize(new Dimension(400,640));
        this.setBackground(Color.WHITE);

        frame.add(this);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        addMouseListener(new LineClickListener());

    }

    private void recordPoint(int x, int y) {
        // Store first and second point, repaint after second

        if (clickCount == 0) {
        firstPointx = x;
        firstPointy = y;
        clickCount = 1;
        }

        else if (clickCount == 1) {

        secondPointx = x;
        secondPointy = y;
        clickCount = 0;

        repaint();

        }

    
    }

    @Override
    protected void paintComponent(java.awt.Graphics g) {
        super.paintComponent(g);
        // Draw a line between the two stored points

        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.BLACK);
        g2d.drawLine(firstPointx, firstPointy, secondPointx, secondPointy);
    }

    public class LineClickListener implements MouseListener {
        // Empty class
        public void mouseClicked(MouseEvent e) {
            recordPoint(e.getX(), e.getY());
        }
        public void mouseEntered(MouseEvent e) {}
        public void mouseExited(MouseEvent e) {}
        public void mousePressed(MouseEvent e) {}
        public void mouseReleased(MouseEvent e) {}

    }

    public static void main(String[] args) {
        // Create the GUI and show the panel
        new DrawLineBetweenClicks();
    }
}
