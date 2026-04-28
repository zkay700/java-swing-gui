/**
 * Simulate a traffic light using three vertically stacked circles.
 * On mouse click, cycle through Red → Yellow → Green.
 */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class TrafficLight extends JPanel {
    private int currentLight = 0; // 0 = Red, 1 = Yellow, 2 = Green

    public TrafficLight() {
        setPreferredSize(new Dimension(100, 300));
        setBackground(Color.WHITE);

        // Add MouseListener to cycle currentLight on each click
        addMouseListener(new MouseShaper());
    }

    private void drawLights(Graphics g) {
        // Draw three circles (top to bottom)
        // Fill only the circle matching currentLight

        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(Color.BLACK);

        g2.drawOval(40, 100, 50, 50);
        g2.drawOval(40, 155, 50, 50 );
        g2.drawOval(40, 205, 50, 50);

        if (currentLight == 0) {
            g2.setColor(Color.RED);
            g2.fillOval(40, 100, 50, 50);
        }

           

        else if (currentLight == 1) {
            g2.setColor(Color.YELLOW);
            g2.fillOval(40, 155, 50, 50 );
        }

        else if (currentLight == 2) {
            g2.setColor(Color.GREEN);
            g2.fillOval(40, 205, 50, 50);

        }

    }

        



    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawLights(g);
    }

    public class MouseShaper implements MouseListener {
        public void mouseClicked(MouseEvent e) {
            currentLight = (currentLight + 1) % 3;
            repaint();
        }
        public void mouseEntered(MouseEvent e) {}
        public void mouseExited(MouseEvent e) {}
        public void mousePressed(MouseEvent e) {}
        public void mouseReleased(MouseEvent e) {}
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Traffic Light");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new TrafficLight());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}


