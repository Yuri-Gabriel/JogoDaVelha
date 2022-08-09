import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.border.Border;

public class Points extends JLabel {
	
	public Points(int x, int y, String value) {
		this.setBounds(x, y, 20, 20);
		this.setFont(new Font("Arial", Font.PLAIN, 18));
		this.setText(value);
		this.setVisible(true);
	}
}
