// Task 4: Car Drawing
// Draw a basic car with a rectangular body, smaller rectangle for the roof, and circular wheels. 
// Use basic geometric shapes to create the car's structure.

import javax.swing.*;
import java.awt.*;

public class CarDrawing extends JPanel {

    public CarDrawing() {
        // Set panel properties (size, background color) and create JFrame to display the car

        JFrame frame = new JFrame("Car");
        this.setBackground(Color.WHITE);
        this.setPreferredSize(new Dimension(400,640));

        frame.add(this);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        

    }

    @Override
    public void paintComponent(Graphics g) {
        // Override paintComponent to draw the car
        // Call the method to draw the car's body, roof, and wheels
        super.paintComponent(g);
        drawCar(g);
    }

    private void drawCar(Graphics g) {
        // Draw the car body as a rectangle, the roof as a smaller rectangle, and the wheels as circles

        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.BLUE);
        g2d.fillRect(150, 400, 200, 150);
        g2d.fillRect(180, 320, 140, 80);

        g2d.setColor(Color.BLACK);
        g2d.fillOval(170,550 ,40 , 40);
        g2d.fillOval(300, 550, 40, 40);
    }

    public static void main(String[] args) {
        // Create and display the CarDrawing panel inside a JFrame
        new CarDrawing();
    }
}
