package java_assignment;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import javax.swing.Timer;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BelishaBeacon {

    public static void main(String[] args) {
        new BelishaBeacon();
        timer.start();
    }

    private static Timer timer;
    public class Drawing extends JPanel {
        // these values are being manually controlled to bring the ellipse at the center of the rectangle

        private double xAxis = 317.5;
        private double yAxis = 142;
        private boolean changeColors = false;


        public void paintComponent(Graphics grap) {
            super.paintComponent(grap);
            Graphics2D shapes = (Graphics2D) grap;

            /* giving the size of the rectangles and
            difference between the y axis is 45 so we increase the height by every length of 45

            controlling the rectangle to bring it to the center of the frame using its x,y axis.

            */

            Rectangle box1 = new Rectangle(340, 200, 15, 45);
            Rectangle box2 = new Rectangle(340, 245, 15, 45);
            Rectangle box3 = new Rectangle(340, 290, 15, 45);
            Rectangle box4 = new Rectangle(340, 335, 15, 45);
            Rectangle box5 = new Rectangle(340, 380, 15, 45);
            Rectangle box6 = new Rectangle(340, 425, 15, 45);
            Rectangle box7 = new Rectangle(340, 470, 15, 45);
            Rectangle box8 = new Rectangle(340, 515, 15, 45);
            Rectangle box9 = new Rectangle(340, 560, 15, 45);
            Rectangle box10 = new Rectangle(340, 605, 15, 45);

            //drawing the shapes  the rectangular boxes and the bulb (ellipse)

            Ellipse2D.Double ball = new Ellipse2D.Double(xAxis, yAxis, 60, 60);
            shapes.draw(ball);
            shapes.draw(box1);
            shapes.draw(box2);
            shapes.draw(box3);
            shapes.draw(box4);
            shapes.draw(box5);
            shapes.draw(box6);
            shapes.draw(box7);
            shapes.draw(box8);
            shapes.draw(box9);
            shapes.draw(box10);
            //coloring the shapes with their appropriate colors.
            shapes.setColor(Color.BLACK);
            shapes.fill(box1);
            shapes.fill(box3);
            shapes.fill(box5);
            shapes.fill(box7);
            shapes.fill(box9);

            shapes.setColor(Color.ORANGE);
            shapes.fill(ball);

            changeColors = !changeColors;
            if (changeColors) {
                shapes.setColor(Color.lightGray);
                shapes.fill(new Ellipse2D.Double(xAxis, yAxis, 60, 60));
            }
        }

        public void changeColors() {
            changeColors = true;  // this method changes the color to orange when the steady button is clicked
            repaint();
        }
    }

    public BelishaBeacon() {
        //Creating the frame
        JFrame frame = new JFrame();
        frame.setSize(700, 850); //setting the frame size
        frame.setTitle("Belisha Beacon");
        frame.setLayout(new BorderLayout(0, 0));
        final Drawing shapes = new Drawing();

        timer = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                shapes.repaint(); // this switches colors between orange and light grey with a time delay of half a second which is 500
            }
        });

        /*

        two buttons are created Flash and Steady so ActionListener is used to give an action the these buttons once they are clicked.
        Action even holds information about the event. So
        when clicking the button flash the flashing starts between orange and light grey.
        when clicking the steady button the flashing stops and the color stays at orange.

         */

        JButton Flash = new JButton("Flash");
        Flash.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent flash) {
                timer.start();
            }
        });

        final JButton Steady = new JButton("Steady");
        Steady.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent steady) {
                        timer.stop();
                        shapes.changeColors();
                    }
                });

        /*
        placing the buttons in the correct position with appropriate gap between them.
        proper formatting is done on the frame.
        JPanel is used to organize components, various layouts, also it is part of java swing package.
        */

        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new GridLayout(1, 2, 6, 3));
        controlPanel.add(Flash);
        controlPanel.add(Steady);

        frame.add(controlPanel, BorderLayout.SOUTH);
        frame.add(shapes);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}