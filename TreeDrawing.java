// Task 5: Tree Drawing
// Draw a simple tree with a rectangular trunk and a circular or triangular canopy. 
// Combine basic shapes to create a tree structure.

import javax.swing.*;
import java.awt.*;

public class TreeDrawing extends JPanel {

    public TreeDrawing() {
        // Set panel properties (size, background color) and create JFrame to display the tree

        JFrame frame = new JFrame("Tree");
        this.setBackground(Color.WHITE);
        this.setPreferredSize(new Dimension(400, 640));

        frame.add(this);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


    }

    @Override
    public void paintComponent(Graphics g) {
        // Override paintComponent to draw the tree
        // Call the method to draw the trunk and leaves
        super.paintComponent(g);
        drawTree(g);
    }

    private void drawTree(Graphics g) {
        // Draw the tree trunk as a rectangle and the leaves as a circle or triangle on top

        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.BLACK);
        g2d.fillRect(180, 320, 40, 280);

        g2d.setColor(Color.GREEN);
        g2d.fillOval(100,120,200,200);
    }

    public static void main(String[] args) {
        // Create and display the TreeDrawing panel inside a JFrame
        new TreeDrawing();
    }
}

