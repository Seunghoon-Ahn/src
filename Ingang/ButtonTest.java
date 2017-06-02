package Ingang;
import java.awt.*;
import java.awt.event.*;


import javax.swing.*;

public class ButtonTest extends JFrame {
	private JButton plainButton, fancyButton;
	
	public ButtonTest() {
		super("Testing Buttons");
		Container c = getContentPane();
		c.setLayout(new FlowLayout() );
		
		plainButton = new JButton("Plain Button");
		c.add(plainButton);
		
		//Icon bug1 = new ImageIcon("bug1.gif");
		//Icon bug2 = new ImageIcon("bug2.gif");
		fancyButton = new JButton("Fancy Button");
		c.add(fancyButton);
		ButtonHandler handler = new ButtonHandler();
		fancyButton.addActionListener(handler);
		plainButton.addActionListener(handler);
		
		setSize(275, 100);
		setVisible(true);
	}
	public static void main(String[] args) {
		ButtonTest app = new ButtonTest();
		app.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);}}
			);
		}
	private class ButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null, "You pressed: "+e.getActionCommand() );
		}
	}
}
