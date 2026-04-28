// Task 1: Button Click Counter
// Create a JPanel with a JButton and JLabel. Each time the button is clicked,
// increment a counter and update the label to show the new count.
// Use ActionListener to handle the button click.

import javax.swing.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.*;

public class ButtonClickCounter extends JPanel {
    int count = 0;
    JButton button;
    JLabel label;

    public ButtonClickCounter() {
        // Set up the button and label
        // Add ActionListener to the button
        JFrame frame = new JFrame("Button Click Counter");
        this.setBackground(Color.BLACK);
        this.setPreferredSize(new Dimension(400, 640));
        this.setLayout(null);

        frame.add(this);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        button = new JButton("Click to increment count");
        button.setBounds(100, 200, 200, 30);
        this.add(button);
        button.addActionListener(new ButtonClickListener());

        label = new JLabel("Count: 0");
        label.setBounds(160, 250, 100, 30);
        this.add(label);
        



    }

    private void updateCounter() {
        // Increment count and update the label
        count++;
        label.setText("Count: " + count);
        
    }

    public class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // Call updateCounter when button is clicked
            updateCounter();

        }
    }

    public static void main(String[] args) {
        // Create the GUI and show the panel
        new ButtonClickCounter();
        
    }
}

