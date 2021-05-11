package gui;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import entities.*;

public class JTableLogin extends JFrame {
	
	private JPanel contentPane;
	private JTextField textUserName;
	private JTextField textPassword;
	private static HashMap<String, String> loginCredentials;
	public static JTableLogin frame;	
	
	
	/**
	 * Launch the application.
	 */	
	public static void main(String[] args) {
		
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
		btnLogin.addActionListener((event) -> {			//ActionListener inner class replaced with lambda expression			
				
					loginCredentials = new HashMap<>();
					assert User.getList()==null : "Empty Source Of Users";
					for (User user: User.getList()) {
						loginCredentials.put(user.getLogin(), user.getPassword());
					}
					assert Admin.getList()==null : "Empty Source Of Admins";
					for (Admin admin: Admin.getList()) {
						loginCredentials.put(admin.getLogin(), admin.getPassword());
					}
									
				String username = textUserName.getText();				
				String password = textPassword.getText();				
				
				if (loginCredentials.containsKey(username)&&loginCredentials.get(username).equals(password)){
					//close login window
					frame.setVisible(false);
					frame.dispose();
					//launch main window
					JTableApp app = new JTableApp();
					app.setVisible(true);
					JTableApp.startJTableApp();	
					}
					else JOptionPane.showMessageDialog(null, "Incorrect login or password!");
				}			
		);
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLogin.setBounds(83, 115, 100, 25);
		contentPane.add(btnLogin);
	}
}
