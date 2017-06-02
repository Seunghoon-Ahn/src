package Ingang;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class TextFieldDemo extends JFrame {
	private JTextField text1;
	private JLabel login, pass;
	private JPasswordField password;
	private JButton ok, cancel;
	
	public TextFieldDemo() {
		super ("Testing JTextField and JPasswordField");
		
		Container c = this.getContentPane();
		c.setLayout(new GridLayout(3, 2));
		login = new JLabel("Login : ");
		pass = new JLabel("Password : ");
		text1 = new JTextField(10);
		password = new JPasswordField();
		ok = new JButton("OK");
		cancel = new JButton("Cancel");
		
		c.add(login);
		c.add(text1);
		c.add(pass);
		c.add(password);
		c.add(ok);
		c.add(cancel);
		JButtonHandler jh = new JButtonHandler();
		ok.addActionListener(jh);
		cancel.addActionListener(jh);
		
		TextFieldHandler th = new TextFieldHandler();
		text1.addActionListener(th);
		password.addActionListener(th);
		
		setSize(325, 200);
		setLocation(300, 300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		TextFieldDemo app = new TextFieldDemo();
		app.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private class TextFieldHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == text1)
				password.requestFocus();
			else if(e.getSource() == password)
				ok.doClick();
		}
	}
	private class JButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String s = "";
			if(e.getSource() == ok) {
				if((text1.getText().equals("bmkim")) && (new String(password.getPassword())).equals("bmkim"))
					s = "축하";
				else
					s = "틀림";
				JOptionPane.showMessageDialog(null, s);
			}
			else if (e.getSource() == cancel) {
				text1.setText("");
				password.setText("");
			}
		}
	}	
}
