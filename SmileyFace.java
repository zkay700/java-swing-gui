import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class SmileyFace extends JPanel {
    // private Circle face;
    // private Circle eye1;
    // private Circle eye2;
    // private Arc smile; 

    JFrame frame = new JFrame();

    private boolean isSmiling = true;

    

    public SmileyFace() {
        // Set preferred size and background
        // Initialize face, eyes, and smile arc objects
        // Add MouseListener to toggle smile direction

        setPreferredSize(new Dimension(250, 250));
        setBackground(Color.WHITE);

        addMouseListener(new MouseShaper());





    }

    //suppose circle is 200x200, so radius is 100
    // for center, subtract radius to find top left corner (Center is (125,125))

    // Center: Half of 250x250
    //topLeftX of Circle = CenterX - Radius
    //topleftY of Circle = CenterY - Radius

    private void drawSmiley(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(Color.BLACK);
        g2.drawOval(25, 25, 200, 200);

        //Eyes are small Ovals.
        // So radius = 10, 20x20 eyes.
        //for y: Just go a little above the center which was 125
        //for x: Just go a little to the left (x decreases)
        //Opposite for right eye.

        g2.drawOval(95, 105, 20, 20);
        g2.drawOval(155,105,20,20);

        //For Mouth: (Arc)
        if (isSmiling) {
            g2.drawArc(95, 155, 100, 40, 180, 180);
        }

        else {
            g2.drawArc(95, 155, 100, 40, 0, 180);
        }




    }

    //MouseListener inner class to reverse smile (change start angle)

    public class MouseShaper implements MouseListener {
        public void mouseClicked(MouseEvent e) {}
        public void mouseEntered(MouseEvent e) {
            isSmiling = false;
            repaint();

        }
        public void mouseExited(MouseEvent e) {}
        public void mousePressed(MouseEvent e) {}
        public void mouseReleased(MouseEvent e) {}

    }

    
    public void paintComponent(Graphics g) {
        // Call super and draw face, eyes, and smile
        super.paintComponent(g);
        drawSmiley(g);


    }

    public static void main(String[] args) {
        // Create JFrame and add instance of SmileyFace

        JFrame frame = new JFrame("Smiley: ");
        SmileyFace face = new SmileyFace();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(face);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

