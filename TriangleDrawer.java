// Task 3: Click to Draw Triangle Vertices
// Create a JPanel where each mouse click marks a triangle vertex.
// After 3 clicks, draw a triangle connecting those points.
// Use MouseListener to track clicks.

import javax.swing.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.event.*;

public class TriangleDrawer extends JPanel {
    int x1 = -1;
    int y1 = -1;

    int x2 = -1;
    int y2 = -1;

    int x3 = -1;
    int y3 = -1;

    int vertexCount = 0;

    public TriangleDrawer() {
        // Set up the panel and add MouseListener

        JFrame frame = new JFrame();

        this.setPreferredSize(new Dimension(600,600));
        this.setBackground(Color.WHITE);

        frame.add(this);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        addMouseListener(new VertexClickListener());

    }

    private void addVertex(int x, int y) {
        // Store vertex and repaint if 3 vertices are available

        if (vertexCount == 0) {
            x1 = x;
            y1 = y;

            vertexCount = 1;

        }

        else if (vertexCount == 1) {
            x2 = x;
            y2 = y;

            vertexCount = 2;
        }

        else if (vertexCount == 2) {
            x3 = x;
            y3 = y;

            
            repaint();

            vertexCount = 0;
        }
    }

    @Override
    protected void paintComponent(java.awt.Graphics g) {
        super.paintComponent(g);
        // Draw triangle if all 3 vertices are present

        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.BLACK);

        if (x1 != -1 && x2 != -1 && x3 != -1) {
            g2d.drawLine(x1, y1, x2, y2);
            g2d.drawLine(x1, y1, x3, y3);
            g2d.drawLine(x2, y2, x3, y3);

        }
    }

    public class VertexClickListener implements MouseListener {
        // Empty class
        public void mouseClicked(MouseEvent e) {
            // if (x1 > 0 && y1 > 0) {
            //     addVertex(e.getX(), e.getY());
            // }

            // if (x2 > 0 && y2 > 0) {
            //     addVertex(e.getX(),e.getY());
            // }

            // if (x3 > 0 && y3 > 0) {
            //     addVertex(e.getX(), e.getY());
            // }

            addVertex(e.getX(), e.getY());
        }
        public void mouseEntered(MouseEvent e) {}
        public void mouseExited(MouseEvent e) {}
        public void mousePressed(MouseEvent e) {}
        public void mouseReleased(MouseEvent e) {}
    }

    public static void main(String[] args) {
        // Create the GUI and show the panel
        new TriangleDrawer();
    }
}
