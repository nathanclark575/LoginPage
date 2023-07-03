// page allows you to sign up by adding username and password, then gives option to return to login

// finish action event and what to do when button is hit

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class SignUpPage implements ActionListener
{
	JFrame frame = new JFrame();
	
	// add the sign up option
	JTextField userIDField = new JTextField();
	JPasswordField userPasswordField = new JPasswordField();
			
	JLabel userIDLabel = new JLabel("userID:");
	JLabel userPasswordLabel = new JLabel("password:");
	JLabel messageLabel = new JLabel("This is a test");
			
	JButton setUpButton = new JButton("Set");
	
	// for going back to login page
	JButton loginButton = new JButton("Login");
	
	IdandPasswords idandPasswords = new IdandPasswords();
	
	SignUpPage()
	{
		
		userIDLabel.setBounds(50, 100, 75, 25);
		userPasswordLabel.setBounds(50, 150, 75, 25);
		
		messageLabel.setBounds(125, 250, 250, 35);
		messageLabel.setFont(new Font(null, Font.ITALIC, 25));
		
		userIDField.setBounds(125, 100, 200, 25);
		userPasswordField.setBounds(125, 150, 200, 25);
		
		frame.add(userIDLabel);
		frame.add(userPasswordLabel);
		frame.add(messageLabel);
		frame.add(userIDField);
		frame.add(userPasswordField);
		
		// set button so that you can add password to id and passwords
		setUpButton.setBounds(50, 200, 75 ,25);
		setUpButton.addActionListener(this);
		setUpButton.setFocusable(false);
		frame.add(setUpButton);
		
		// login button to take you back to login page
		loginButton.setBounds(150, 200, 75, 25);
		loginButton.addActionListener(this);
		loginButton.setFocusable(false);
		frame.add(loginButton);
		
		
		frame.setTitle("Sign Up Page");
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420, 420);
		frame.setLayout(null);
		
		frame.setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		
		// gets userID and password, need to make user info on a updatable file, so it can be used
		if (e.getSource()==setUpButton)
		{
			String userID = userIDField.getText();
			String userPassword = String.valueOf(userPasswordField.getPassword());
			
			idandPasswords.addUser(userID, userPassword);
			
			System.out.println("Done");
			
			return;
		}
		
		// go back to login page
		if (e.getSource()==loginButton)
		{
			frame.dispose();
			IdandPasswords idandPasswords = new IdandPasswords();
			LoginPage loginPage = new LoginPage(idandPasswords.getLoginInfo());
		}
	}

}
