// Task 2: Key Press Display
// Create a JTextField in a JPanel. When a key is typed while focused on the field,
// display the typed key in a JLabel below the field.
// Use KeyListener to handle keyTyped.

import javax.swing.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.*;

public class KeyPressDisplay extends JPanel {
    JTextField tField;
    JLabel label;

    public KeyPressDisplay() {
        // Set up the text field and label
        // Add KeyListener to the text field
        this.setBackground(Color.WHITE);
        this.setPreferredSize(new Dimension(400,640));
        this.setLayout(null);

        tField = new JTextField();
        tField.setBounds(100, 220, 200, 100);
        this.add(tField);
        tField.addKeyListener(new KeyTypedListener());
        setFocusable(true);

        label = new JLabel("Key Typed");
        label.setBounds(100,370,200,50);
        this.add(label);

        JFrame frame = new JFrame("Key Press Display");
        frame.add(this);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);



    }

    private void displayKey(char keyChar) {
        // Update label to show the typed character
        label.setText("Key Typed: " + keyChar);
    }

    public class KeyTypedListener implements KeyListener {
        public void keyTyped(KeyEvent e) {
            // Call displayKey with the typed character
            displayKey(e.getKeyChar());
        }
        public void keyPressed(KeyEvent e) {}
        public void keyReleased(KeyEvent e) {}
    }

    public static void main(String[] args) {
        // Create the GUI and show the panel
        new KeyPressDisplay();
    }
}

