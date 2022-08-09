import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class ButtonHandler implements ActionListener{

	private JButton[][] buttons = new JButton[3][3];
	private String CorruentPlayer = "X";
	private Window window;
	
	 
	 public ButtonHandler(JButton[][] btn,
						 Window window){
		 for(int x = 0;x < 3;x++) {
			 for(int y = 0;y < 3;y++) {
				 this.buttons[x][y] = btn[x][y];
			 }
	     }
		 this.window = window;
	 }
	 
	 private void CheckIfHaveWinner() {
		 for(int x = 0;x < 3;x++) {
			 if (this.buttons[x][0].getText() == this.buttons[x][1].getText() &&
					 this.buttons[x][1].getText() == this.buttons[x][2].getText() &&
					 this.buttons[x][2].getText() != " ") {
				 this.ShowMessageOfWinner();
				 this.ResetTextOfButtons();
				 this.MarkPoints();
				 break;
			 }
		 }
		 for(int y = 0;y < 3;y++) {
			 if (this.buttons[0][y].getText() == this.buttons[1][y].getText() &&
					 this.buttons[1][y].getText() == this.buttons[2][y].getText() &&
					 this.buttons[2][y].getText() != " ") {
				 this.ShowMessageOfWinner();
				 this.ResetTextOfButtons();
				 this.MarkPoints();
				 break;
			 }
		 }
		 if (this.buttons[0][0].getText() == this.buttons[1][1].getText() &&
			this.buttons[1][1].getText() == this.buttons[2][2].getText() &&
			this.buttons[2][2].getText() != " ") {
			 this.ShowMessageOfWinner();
			 this.ResetTextOfButtons();
			 this.MarkPoints();
         }
         if (this.buttons[0][2].getText() == this.buttons[1][1].getText() &&
        	this.buttons[1][1].getText() == this.buttons[2][0].getText() &&
        	this.buttons[2][0].getText() != " ") {
        	 this.ShowMessageOfWinner();
			 this.ResetTextOfButtons();
			 this.MarkPoints();
         }
	 }
	 
	 private void ShowMessageOfWinner() {
		 
		 String messageWinner = String.format("O vencedor foi %s\nDeseja continuar?", this.CorruentPlayer);
		 int ToWinner = JOptionPane.showConfirmDialog(null, messageWinner);
		 switch(ToWinner) {
		 	case 0:
		 		this.ResetTextOfButtons();
		 		break;
		 	case 1:
		 		this.window.dispose();
		 		break;
		 }
		 
	 }
	 
	 private void ResetTextOfButtons() {
		 for(int x = 0;x < 3;x++) {
			 for(int y = 0;y < 3;y++) {
				 this.buttons[x][y].setText(" ");
			 }	 
		 }
	 }
	 
	 private void MarkPoints() {
		 if(this.CorruentPlayer == "O") {
			 int Xp = Integer.parseInt(this.window.XPoints.getText());
			 this.window.XPoints.setText(Integer.toString(++Xp));
		 } else if (this.CorruentPlayer == "X") {
			 int Op = Integer.parseInt(this.window.OPoints.getText());
			 this.window.OPoints.setText(Integer.toString(++Op));
		 }
	 }
	 
	 @Override
	 public void actionPerformed(ActionEvent event) {
		 for(int x = 0;x < 3;x++) {
			 for(int y = 0;y < 3;y++) {
				 JButton button = this.buttons[x][y];
				 if (event.getSource() == button) {
					String btnText = button.getText();
					if (btnText == " " || btnText == this.CorruentPlayer) {
						this.CorruentPlayer = this.CorruentPlayer == "X"?"O":"X";
						button.setText(this.CorruentPlayer);
					}
				 }
			 }
		 }
		 this.CheckIfHaveWinner();
	 }
	
}
