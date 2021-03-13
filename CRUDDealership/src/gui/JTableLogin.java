package gui;

import javax.swing.*;
import javax.swing.border.*;
import entities.User;
import entities.Admin;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class JTableLogin extends JFrame {

	//
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTextField textUserName;
	private JTextField textPassword;
	private static HashMap<String, String> loginCredentials;
	public static JTableLogin frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		loginCredentials = new HashMap<>();
		Admin admin1 = new Admin("admin1", "admin1");
		User user1 = new User("user1", "user1");
		User user2 = new User("user2", "user2");
		User user3 = new User("user3", "user3");
		User user4 = new User("user4", "user4");
		User user5 = new User("user5", "user5");
		
		loginCredentials.put(user1.getLogin(), user1.getPassword());
		loginCredentials.put(user2.getLogin(), user2.getPassword());
		loginCredentials.put(user3.getLogin(), user3.getPassword());
		loginCredentials.put(user4.getLogin(), user4.getPassword());
		loginCredentials.put(user5.getLogin(), user5.getPassword());
		loginCredentials.put(admin1.getLogin(), admin1.getPassword());
       
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new JTableLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JTableLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100,300, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUserName = new JLabel("USERNAME");
		lblUserName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUserName.setBounds(33, 30, 80, 25);
		contentPane.add(lblUserName);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPassword.setBounds(33, 70, 80, 25);
		contentPane.add(lblPassword);
		
		textUserName = new JTextField();
		textUserName.setBounds(123, 30, 120, 25);
		contentPane.add(textUserName);
		textUserName.setColumns(10);
		
		textPassword = new JTextField();
		textPassword.setColumns(10);
		textPassword.setBounds(123, 70, 120, 25);
		contentPane.add(textPassword);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String username = textUserName.getText();
				String password = textPassword.getText();
				
				if (loginCredentials.containsKey(username)&&loginCredentials.get(username).equals(password)){
					frame.setVisible(false);
					frame.dispose();
					JTableApp app = new JTableApp();
					app.setVisible(true);
					JTableApp.startJTableApp();	
					}
					else JOptionPane.showMessageDialog(null, "Incorrect login or password!");
				}				
			
		});
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLogin.setBounds(83, 115, 100, 25);
		contentPane.add(btnLogin);
	}
}
