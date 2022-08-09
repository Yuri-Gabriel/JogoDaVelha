import java.awt.AWTException;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JLabel;
import javax.swing.Timer;

public class MessageOfPoints extends Canvas {
	
	
	
	public MessageOfPoints() {
		setSize(500, 130);
	}
	
	public void paint(Graphics g) {
		g.setColor(Color.lightGray);
		g.drawRect(10, 10, 460, 110);
		g.setColor(Color.black);
		
		g.setFont(new Font("Arial", Font.PLAIN, 25));
		g.drawString("O - X", 215, 50);
		
		g.setFont(new Font("Arial", Font.PLAIN, 18));
	}
}
