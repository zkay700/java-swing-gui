// Task 5: Right Click to Draw Oval
// Create a JPanel where a small oval is drawn at the mouse location
// only when the user right-clicks (mouse button 3).
// Use MouseListener to detect right clicks.

import javax.swing.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.event.*;

public class RightClickOvalDrawer extends JPanel {
    int ovalX = 0;
    int ovalY = 0;

    public RightClickOvalDrawer() {
        // Set up the panel and add MouseListener
        JFrame frame = new JFrame();

        this.setPreferredSize(new Dimension(400, 400));
        this.setBackground(Color.BLACK);

        frame.add(this);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        addMouseListener(new RightClickListener());
        setFocusable(true);
    }

    private void addOvalAt(int x, int y) {
        // Store the oval's position and repaint
        ovalX = x;
        ovalY = y;

        repaint();
    }

    @Override
    protected void paintComponent(java.awt.Graphics g) {
        super.paintComponent(g);
        // Draw all stored ovals

        Graphics2D g2d = (Graphics2D) g;

        if (ovalX > 0 && ovalY > 0) {

        g2d.setColor(Color.YELLOW);
        g2d.fillOval(ovalX, ovalY, 100, 100);
        }
    }

    public class RightClickListener implements MouseListener {

        public void mouseClicked(MouseEvent e) {
            if (e.getButton() == MouseEvent.BUTTON3) {
                addOvalAt(e.getX(), e.getY());
            }
        }
        public void mouseEntered(MouseEvent e) {}
        public void mouseExited(MouseEvent e) {}
        public void mousePressed(MouseEvent e) {}
        public void mouseReleased(MouseEvent e) {}
        
    }

    public static void main(String[] args) {
        // Create the GUI and show the panel
        new RightClickOvalDrawer();
    }
}

