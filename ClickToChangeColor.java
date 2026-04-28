// Task 2: Click to Change Color
// Create a JPanel with a rectangle that changes color every time it is clicked. 
// Use MouseListener to detect the click, and Cycle through colors randomly each time.

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ClickToChangeColor extends JPanel {

    private Color currentColor = Color.RED;

    public ClickToChangeColor() {
        // Set up the JPanel size and background color
        // Add MouseListener to change the rectangle color on mouse click
        JFrame frame = new JFrame("Changing Colors");
        this.setPreferredSize(new Dimension(400,640));
        this.setBackground(Color.BLACK);

        frame.add(this);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        addMouseListener(new ColorChangeListener());


    }

    @Override
    public void paintComponent(Graphics g) {
        // Override paintComponent to draw a rectangle with the current color
        // Draw the rectangle using the currentColor

        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(currentColor);
        g2d.fillRect(150, 300, 200, 250);



    }

    private void changeColor() {
        // Change currentColor to a random color and call repaint to update the panel

                currentColor = getRandomColor();
                repaint();
        
    }

    private Color getRandomColor() {
        int r = (int) (Math.random() * 256);
        int g = (int) (Math.random() * 256);
        int b = (int) (Math.random() * 256);

        return new Color(r,g,b);

    }

    public class ColorChangeListener implements MouseListener {
        public void mouseClicked(MouseEvent e) {
            // Call changeColor when the panel is clicked
            changeColor();
        }
        public void mouseEntered(MouseEvent e) {}
        public void mouseExited(MouseEvent e) {}
        public void mousePressed(MouseEvent e) {}
        public void mouseReleased(MouseEvent e) {}
    }

    public static void main(String[] args) {
        // Create JFrame, add ClickToChangeColor panel, and make it interactive
        new ClickToChangeColor();
    }
}

