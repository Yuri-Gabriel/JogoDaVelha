import java.awt.Color;

import javax.swing.*;

public class Window extends JFrame {

	private JButton[][] btn = new JButton[3][3];
	public Points XPoints;
	public Points OPoints;
    
    private ButtonHandler handler;
    

    public Window() {
        super("teste");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setVisible(true);
		setResizable(false);
		
		for(int x = 0;x < 3;x++) {
			for(int y = 0;y < 3;y++) {
				this.btn[x][y] = new JButton();	
			}
	     }
		
        handler = new ButtonHandler(btn, this);
        
        for(int x = 0;x < 3;x++) {
			for(int y = 0;y < 3;y++) {
				this.btn[x][y].addActionListener(handler);
			}
		}
        
        this.DrawButtons();
        XPoints = new Points(225, 70, "0");
        this.add(XPoints);
        OPoints = new Points(255, 70, "0");
        this.add(OPoints);
        this.add(new MessageOfPoints());
    }
    
    private void DrawButtons() {
    	int xPos = 10;
        int yPos = 130;
        
        for(int x = 0;x < 3;x++) {
			for(int y = 0;y < 3;y++) {
				btn[x][y].setBounds(xPos, yPos, 150, 150);
	        	btn[x][y].setText(" ");
	        	add(btn[x][y]);
	        	xPos += 155;
	        	if (y == 2) {
	        		xPos = 10;
	        		yPos += 155;
	        	}
			}
        }
    }
    
    
    
}
