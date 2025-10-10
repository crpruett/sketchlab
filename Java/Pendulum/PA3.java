/* Chris Pruett
 * Programming Assignment 3
 * 4/15/11
 * Note: I still don't understand why the button won't respond.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PA3 extends JFrame {

	public PA3() {
		setLayout(new BorderLayout());
		this.add(new MovePendulum());
	}

	public static void main(String[] args) {
		PA3 frame = new PA3();
		frame.setTitle("Pendulum");
		frame.setSize(600, 400);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	// Inner Class
	class MovePendulum extends JPanel implements ActionListener {
		// Variables
		public int radius = 30;
		double length = 150;
		int x = 0;
		int y = 0;
		int x1 = 0;
		int y1 = 0;
		int leftAngle = 120;
		int rightAngle = 60;
		int angle = leftAngle; // Start from leftAngle
		int angleDelta = 5; // Swing interval
		int delay = 100;
		String labelText = "<html><body color=teal><i><b> Resume... </b></i></body></html>";
		JButton toggle = new JButton(
				("<html><body color=teal><i><u><b> Move </b> </u></i></body></html>"));
		JLabel label = new JLabel(" ");

		Timer timer;

		// actionPerfomed method as required by the ActionListener Interface
		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == toggle) {

				if (toggle.hasFocus()) {

					toggle.setEnabled(false);
					label.setText(" ");

				}
				timer.start();
				repaint();
			}
			repaint();
		}

		// The MovePendulum constructor
		public MovePendulum() {

			// Initialize the timer
			timer = new Timer(delay, this);
			timer.start();

			// Set the focus to the panel
			setFocusable(true);

			// Set the border of the panel and add elements to it.
			setBorder(BorderFactory.createTitledBorder(
					BorderFactory.createRaisedBevelBorder(), "Watch it swing!"));

			add(toggle, BorderLayout.NORTH);
			add(label, BorderLayout.SOUTH);

			// Listen for where the mouse is clicked
			this.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					if (insideCircle(e.getX(), e.getY())) {
						timer.stop();
						toggle.setEnabled(true);
						label.setText(labelText);
						repaint();

					}

				}
			});

			// Listen to which key is pressed
			this.addKeyListener(new KeyAdapter() {
				public void keyPressed(KeyEvent e) {
					switch (e.getKeyCode()) {
					case KeyEvent.VK_UP:
						delay -= 30;
						break;
					case KeyEvent.VK_DOWN:
						delay += 30;
						break;
					}
					if (delay < 0)
						delay = 10;

					timer.setDelay(delay);
				}
			});

		}

		// Paint the objects
		public void paintComponent(Graphics g) {
			super.paintComponent(g);

			x1 = getWidth() / 2;
			y1 = 35;
			if (angle < rightAngle)
				angleDelta = 1; // Swing to the left
			else if (angle > leftAngle)
				angleDelta = -1; // Swing to the right

			angle += angleDelta;
			// If timer is still running, keep moving, Otherwise, set the
			// pendulum to 90 degrees.
			if (timer.isRunning()) {
				x = x1 + (int) ((length) * Math.cos(Math.toRadians(angle)));
				y = y1 + (int) ((length) * Math.sin(Math.toRadians(angle)));
			} else {

				x = x1 + (int) (length * Math.cos(Math.toRadians(90)));
				y = y1 + (int) (length * Math.sin(Math.toRadians(90)));
			}
			g.drawLine(x1, y1, x, y); // Draw the hanger
			g.fillOval(x - radius, y - radius, 2 * radius, 2 * radius); // Draw
																		// the
																		// Circle

		}

		public boolean insideCircle(int mx, int my) {
			return distance(mx, my, x, y) < radius;
		}

		public double distance(double x1, double y1, double x2, double y2) {
			return Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
		}
	}

}
