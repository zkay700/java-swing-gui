// Task 2: Toggle Circle Fill on Button Click
// Create a JPanel with a circle drawn in the center.
// Add a JButton that toggles whether the circle is filled or just outlined.
// Use ActionListener to handle the button click.

import javax.swing.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.*;

public class ToggleCircleFill extends JPanel {
    private boolean isFilled  = false;

    public ToggleCircleFill() {
        // Set up the panel and button, add ActionListener
        JFrame frame = new JFrame("Toggle Circle");
        
        this.setPreferredSize(new Dimension(400, 640));
        this.setBackground(Color.WHITE);

        frame.add(this);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JButton button =  new JButton("Click to Toggle");
        button.setBounds(100, 550, 100, 50);
        this.add(button);

        
        button.addActionListener(new ButtonClickListener());
        
    }

    private void toggleFill() {
        // Toggle fill state and repaint
        isFilled = !isFilled;
        repaint();

        
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Draw a filled or outlined circle based on current state

        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.BLACK);

        if (isFilled) {
        g2d.fillOval(100, 220, 200, 200);
        }

        else {
            g2d.drawOval(100, 220, 200, 200);

        }


    }

    public class ButtonClickListener implements ActionListener {
        // Empty class
        public void actionPerformed(ActionEvent e) {
            toggleFill();
        }

    }

    public static void main(String[] args) {
        // Create the GUI and show the panel
        new ToggleCircleFill();
    }
}

