import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginPage implements ActionListener
{
	JFrame frame = new JFrame();
	
	JButton loginButton = new JButton("Login");
	JButton resetButton = new JButton("Reset");
	JTextField userIDField = new JTextField();
	JPasswordField userPasswordField = new JPasswordField();
	
	JLabel userIDLabel = new JLabel("userID:");
	JLabel userPasswordLabel = new JLabel("password:");
	JLabel messageLabel = new JLabel("This is a test");
	
	
	HashMap<String, String> loginInfo =  new HashMap<String, String>();
	
	LoginPage(HashMap<String, String> loginInfoOriginal)
	{
		loginInfo = loginInfoOriginal;
		
		userIDLabel.setBounds(50, 100, 75, 25);
		userPasswordLabel.setBounds(50, 150, 75, 25);
		
		messageLabel.setBounds(125, 250, 250, 35);
		messageLabel.setFont(new Font(null, Font.ITALIC, 25));
		
		userIDField.setBounds(125, 100, 200, 25);
		userPasswordField.setBounds(125, 150, 200, 25);
		
		loginButton.setBounds(125, 200, 100, 25);
		loginButton.addActionListener(this);
		loginButton.setFocusable(false);
		resetButton.setBounds(225, 200, 100, 25);
		resetButton.addActionListener(this);
		resetButton.setFocusable(false);
		
		frame.add(userIDLabel);
		frame.add(userPasswordLabel);
		frame.add(messageLabel);
		frame.add(userIDField);
		frame.add(userPasswordField);
		frame.add(loginButton);
		frame.add(resetButton);
		
		frame.setTitle("Login Page");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420, 420);
		frame.setLayout(null);
		frame.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource()==resetButton)
		{
			userIDField.setText("");
			userPasswordField.setText("");
		}
		
		if (e.getSource()==loginButton)
		{
			String userID = userIDField.getText();
			// look into this
			String password = String.valueOf(userPasswordField.getPassword());
			
			// verify
			if (loginInfo.containsKey(userID))
			{
				if (loginInfo.get(userID).equals(password))
				{
					messageLabel.setForeground(Color.green);
					messageLabel.setText("login Succsessful");
					frame.dispose();
					WelcomePage welcomePage = new WelcomePage(userID);
				}
				else
				{
					messageLabel.setForeground(Color.red);
					messageLabel.setText("Wrong Password");
				}
			}
			
			else
			{
				messageLabel.setForeground(Color.red);
				messageLabel.setText("Username Not Found");
			}
		}
	}
}