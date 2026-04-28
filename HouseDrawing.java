/**
 * Draw a simple house with a base rectangle, a triangle roof, and a door.
 * Toggle the door between open and closed states when the panel is clicked.
 */

 import java.awt.Color;
 import java.awt.Dimension;
 import java.awt.Graphics;
 import java.awt.Graphics2D;
 import javax.swing.JFrame;
 import javax.swing.JPanel;
 import java.awt.event.MouseEvent;
 import java.awt.event.MouseListener;

// Task 3: House Drawing
// Draw a simple house with a rectangular body, triangular roof, windows, and a door. 
// Use geometric shapes to represent different parts of the house.

import javax.swing.*;
import java.awt.*;

public class HouseDrawing extends JPanel {

    public HouseDrawing() {
        // Set panel properties (size, background color) and create JFrame to display the house

        JFrame frame = new JFrame("House");
        this.setBackground(Color.WHITE);
        this.setPreferredSize(new Dimension(400,640));

        frame.add(this);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


    }

    @Override
    public void paintComponent(Graphics g) {
        // Override paintComponent to draw the house
        // Call the method to draw the house, roof, windows, and door
        super.paintComponent(g);
        drawHouse(g);
    }

    private void drawHouse(Graphics g) {
        // Draw the body of the house as a rectangle, the roof as a triangle, windows, and door

        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.BLACK);

        g2d.drawRect(100, 400, 200, 200);
        g2d.drawRect(150, 450, 20, 20);
        g2d.drawRect(250, 450, 20, 20);

        g2d.drawRect(180, 540, 40, 60);

        g2d.drawLine(100, 400, 200, 320);
        g2d.drawLine(300, 400, 200, 320);
    }

    public static void main(String[] args) {
        // Create and display the HouseDrawing panel inside a JFrame
        new HouseDrawing();
    }
}
