package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import db.DBConnection;


public class JTableApp extends JFrame{
	
	// Variables declaration
	private JTextField textVIN;	
	private JTextField textMake;
	private JTextField textModel;
	private JTextField year;
	private JTextField price;
	private JTextField color;
	private JTextField mileage;
	private JTextField description;
	private JTextField textSearch;
	
	private JButton btnAdd;
	private JButton btnUpdate;
	private JButton btnDel;
	private JButton btnClear;
	private DefaultTableModel dm;
	
	private JFrame MainFrame;
	private JTable table;
	private JScrollPane scrollPane;	 
	
	//Launch the application	 
	public static void startJTableApp() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JTableApp window = new JTableApp();
					window.MainFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	//Create the application window	 
	public JTableApp() {
		initialize();
		retrieve();
	}	
	
	
	//Update application table after every change	
	private void retrieve(){
		dm = new DBConnection().getData();
		table.setModel(dm);    
     
     table.setAutoCreateRowSorter(true);
    }
	
	//Update application table after every change	
		private void retrieveSearchedTable(String searchVin){
			dm = new DBConnection().getSearchedData(searchVin);
			table.setModel(dm);   
	    }

	//Initialize the contents of the frame	
	private void initialize() {		
		
		//jframe
		MainFrame = new JFrame();
		MainFrame.setTitle("BRAZHKO MOTORS");
		MainFrame.setBounds(100, 100, 900, 560);
		MainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MainFrame.getContentPane().setLayout(null);
		
		//jlabels
		JLabel lblVIN = new JLabel("VIN");
		lblVIN.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblVIN.setBounds(32, 26, 110, 30);
		MainFrame.getContentPane().add(lblVIN);			
		
		JLabel lblMake = new JLabel("Make");
		lblMake.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMake.setBounds(32, 67, 110, 30);
		MainFrame.getContentPane().add(lblMake);
		
		JLabel lblModel = new JLabel("Model");
		lblModel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblModel.setBounds(32, 108, 110, 30);
		MainFrame.getContentPane().add(lblModel);

		JLabel lblYear = new JLabel("Year");
		lblYear.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblYear.setBounds(32, 149, 110, 30);
		MainFrame.getContentPane().add(lblYear);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPrice.setBounds(32, 190, 110, 30);
		MainFrame.getContentPane().add(lblPrice);
				
		JLabel lblBody = new JLabel("Body");
		lblBody.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblBody.setBounds(32, 231, 110, 30);
		MainFrame.getContentPane().add(lblBody);
		
		JLabel lblColor = new JLabel("Color");
		lblColor.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblColor.setBounds(318, 26, 110, 30);
		MainFrame.getContentPane().add(lblColor);
		
		JLabel lblMileage = new JLabel("Mileage");
		lblMileage.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMileage.setBounds(318, 67, 110, 30);
		MainFrame.getContentPane().add(lblMileage);
		
		JLabel lblTransmission = new JLabel("Transmission");
		lblTransmission.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTransmission.setBounds(318, 108, 110, 30);
		MainFrame.getContentPane().add(lblTransmission);
		
		JLabel lblDescription = new JLabel("Description");
		lblDescription.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDescription.setBounds(318, 149, 110, 30);
		MainFrame.getContentPane().add(lblDescription);
		
		JLabel lblCondition = new JLabel("Condition");
		lblCondition.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCondition.setBounds(318, 190, 110, 30);
		MainFrame.getContentPane().add(lblCondition);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblStatus.setBounds(318, 231, 110, 30);
		MainFrame.getContentPane().add(lblStatus);
		
		//jtexts
		textVIN = new JTextField();
		textVIN.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textVIN.setColumns(10);
		textVIN.setBounds(102, 26, 120, 30);
		MainFrame.getContentPane().add(textVIN);		
		
		textMake = new JTextField();
		textMake.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textMake.setColumns(10);
		textMake.setBounds(102, 67, 120, 30);
		MainFrame.getContentPane().add(textMake);
		
		textModel = new JTextField();
		textModel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textModel.setColumns(10);
		textModel.setBounds(102, 108, 120, 30);
		MainFrame.getContentPane().add(textModel);
		
		year = new JTextField();
		year.setFont(new Font("Tahoma", Font.PLAIN, 16));
		year.setColumns(10);
		year.setBounds(102, 149, 120, 30);
		MainFrame.getContentPane().add(year);
		
		price = new JTextField();
		price.setFont(new Font("Tahoma", Font.PLAIN, 16));
		price.setBounds(102, 190, 120, 30);
		MainFrame.getContentPane().add(price);
				
		color = new JTextField();
		color.setFont(new Font("Tahoma", Font.PLAIN, 16));
		color.setColumns(10);
		color.setBounds(438, 26, 120, 30);
		MainFrame.getContentPane().add(color);
		
		mileage = new JTextField();
		mileage.setFont(new Font("Tahoma", Font.PLAIN, 16));
		mileage.setColumns(10);
		mileage.setBounds(438, 67, 120, 30);
		MainFrame.getContentPane().add(mileage);
		
		description = new JTextField();
		description.setFont(new Font("Tahoma", Font.PLAIN, 16));
		description.setColumns(10);
		description.setBounds(438, 149, 120, 30);
		MainFrame.getContentPane().add(description);
		
		textSearch = new JTextField();
		textSearch.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textSearch.setColumns(10);
		textSearch.setBounds(115, 280, 100, 25);
		MainFrame.getContentPane().add(textSearch);		
		
		JComboBox body = new JComboBox();
		body.setAutoscrolls(true);
		body.setModel(new DefaultComboBoxModel(new String[] {"SUV", "Sedan", "Hatchback", "Truck", "Coupe", "Convertible", "Other"}));
		body.setSelectedIndex(0);
		body.setName("Body");
		body.setFont(new Font("Tahoma", Font.PLAIN, 16));
		body.setBounds(102, 231, 120, 30);
		MainFrame.getContentPane().add(body);		
		
		JComboBox transmission = new JComboBox();
		transmission.setName("transmission");
		transmission.setAutoscrolls(true);
		transmission.setFont(new Font("Tahoma", Font.PLAIN, 16));
		transmission.setModel(new DefaultComboBoxModel(new String[] {"Automatic", "Manual", "Other"}));
		transmission.setSelectedIndex(0);
		transmission.setBounds(438, 108, 120, 30);
		MainFrame.getContentPane().add(transmission);		
		
		JComboBox status = new JComboBox();
		status.setAutoscrolls(true);
		status.setFont(new Font("Tahoma", Font.PLAIN, 16));
		status.setModel(new DefaultComboBoxModel(new String[] {"In Stock", "Sold", "Pending"}));
		status.setSelectedIndex(0);
		status.setBounds(438, 231, 120, 30);
		MainFrame.getContentPane().add(status);		
		
		JComboBox condition = new JComboBox();
		condition.setModel(new DefaultComboBoxModel(new String[] {"New", "Used"}));
		condition.setSelectedIndex(0);
		condition.setFont(new Font("Tahoma", Font.PLAIN, 16));
		condition.setAutoscrolls(true);
		condition.setBounds(438, 190, 120, 30);
		MainFrame.getContentPane().add(condition);		
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(32, 319, 816, 174);
		MainFrame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 12));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.addMouseListener(new MouseAdapter() {		//MouseAdapter inner class
            
			public void mouseClicked(MouseEvent evt) {
            	//get values from selected row
            	String vin = table.getValueAt(table.getSelectedRow(), 0).toString();
    	        String make = table.getValueAt(table.getSelectedRow(), 1).toString();
    	        String model = table.getValueAt(table.getSelectedRow(), 2).toString();
    	        String y = table.getValueAt(table.getSelectedRow(), 3).toString();
    	        String pr  = table.getValueAt(table.getSelectedRow(), 4).toString();
    	        String bd = table.getValueAt(table.getSelectedRow(), 5).toString();
    	        String col  = table.getValueAt(table.getSelectedRow(), 6).toString();    	        
    	        String mil  = table.getValueAt(table.getSelectedRow(), 7).toString();
    	        String trans  = table.getValueAt(table.getSelectedRow(), 8).toString();
    	        String desc  = table.getValueAt(table.getSelectedRow(), 9).toString();
    	        String cond  = table.getValueAt(table.getSelectedRow(), 10).toString();
    	        String stat  = table.getValueAt(table.getSelectedRow(), 11).toString();
    	        //set values
    	        textVIN.setText(vin);
    	        textMake.setText(make);
    	        textModel.setText(model);
    	        year.setText(y);
    	        price.setText(pr);
    	        for (int i = 0; i < body.getItemCount(); i++)
    	        if(bd.equalsIgnoreCase((String) body.getItemAt(i)))
    	        	body.setSelectedIndex(i);    	        
    	        color.setText(col);
    	        mileage.setText(mil);
    	        for (int i = 0; i < transmission.getItemCount(); i++)
        	        if(trans.equalsIgnoreCase((String) transmission.getItemAt(i)))
        	        	transmission.setSelectedIndex(i);
    	        description.setText(desc);    	        
        		for (int i = 0; i < condition.getItemCount(); i++)
        	        if(cond.equalsIgnoreCase((String) condition.getItemAt(i)))
        	        	condition.setSelectedIndex(i);
        		for (int i = 0; i < status.getItemCount(); i++)
        	        if(stat.equalsIgnoreCase((String) status.getItemAt(i)))
        	        	status.setSelectedIndex(i);    	        
            }
        });
		scrollPane.setViewportView(table);
		
		
		//buttons
		btnAdd = new JButton("ADD");
		btnAdd.addActionListener(new ActionListener() {		//ActionListener inner class
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent e) {
				
				if(textVIN.getText().length()<4||textVIN.getText().length()>=14) {
					JOptionPane.showMessageDialog(null, "VIN must be between 5 and 14 characters!");
				}
				if (textMake.getText().length()<1) {
					JOptionPane.showMessageDialog(null, "Make cannot be empty!");
				}
				if (textModel.getText().length()<1) {
					JOptionPane.showMessageDialog(null, "Model cannot be empty!");
				}
				if (year.getText().length()< 1|| Integer.parseInt(year.getText())>2021||Integer.parseInt(year.getText())<1925) {
					JOptionPane.showMessageDialog(null, "Enter correct year!");
				}
				if (price.getText().length()<1 || Double.parseDouble(price.getText())<1.0) {
					JOptionPane.showMessageDialog(null, "Enter correct price!");
				}
				if (color.getText().length()<1) {
					JOptionPane.showMessageDialog(null, "Color cannot be empty!");
				}
				if(mileage.getText().length()<1 || Integer.parseInt(mileage.getText())<1) {
					JOptionPane.showMessageDialog(null, "Enter correct mileage!");
				}
				if (description.getText().length()<1) {
					JOptionPane.showMessageDialog(null, "Description cannot be empty!");
				}				
				if (textVIN.getText().length()>0
						 && textVIN.getText().length()<=14
						 && textMake.getText().length()>0						 
						 && textModel.getText().length()>0
						 && year.getText().length()>0
						 && Integer.parseInt(year.getText())<=2021
						 && Integer.parseInt(year.getText())>=1925
						 && price.getText().length()>1
						 && Double.parseDouble(price.getText())>1.0
						 && color.getText().length()>0
						 && mileage.getText().length()>0
						 && Integer.parseInt(mileage.getText())>0
						 && description.getText().length()>0
						 && new DBConnection().add(textVIN.getText(), textMake.getText(), textModel.getText(), Integer.parseInt(year.getText()),
			        		Double.parseDouble(price.getText()), body.getSelectedItem().toString(), color.getText(), Integer.parseInt(mileage.getText()),
			        		transmission.getSelectedItem().toString(), description.getText(), condition.getSelectedItem().toString(),
			        		status.getSelectedItem().toString()) )
						  
					{
			            JOptionPane.showMessageDialog(null, "Successfully Inserted");
			 
			            //CLEAR TXT
			            textVIN.setText("");
			            textMake.setText("");
			            textModel.setText("");
			            year.setText("");
			            price.setText("");
			            color.setText("");
			            mileage.setText("");
			            description.setText("");
			            			 
			            retrieve();
			        }
				else {
			            JOptionPane.showMessageDialog(null, "Not Saved");			            
			   }
			}
		});
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAdd.setBounds(683, 27, 100, 30);
		MainFrame.getContentPane().add(btnAdd);
		
		
		
		btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {		//ActionListener inner class
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent e) {
		       
				if(textVIN.getText().length()<4||textVIN.getText().length()>=14) {
					JOptionPane.showMessageDialog(null, "VIN must be between 5 and 14 characters!");
				}
				if (textMake.getText().length()<1) {
					JOptionPane.showMessageDialog(null, "Make cannot be empty!");
				}
				if (textModel.getText().length()<1) {
					JOptionPane.showMessageDialog(null, "Model cannot be empty!");
				}
				if (year.getText().length()< 1|| Integer.parseInt(year.getText())>2021||Integer.parseInt(year.getText())<1925) {
					JOptionPane.showMessageDialog(null, "Enter correct year!");
				}
				if (price.getText().length()<1 || Double.parseDouble(price.getText())<1.0) {
					JOptionPane.showMessageDialog(null, "Enter correct price!");
				}
				if (color.getText().length()<1) {
					JOptionPane.showMessageDialog(null, "Color cannot be empty!");
				}
				if(mileage.getText().length()<1 || Integer.parseInt(mileage.getText())<1) {
					JOptionPane.showMessageDialog(null, "Enter correct mileage!");
				}
				if (description.getText().length()<1) {
					JOptionPane.showMessageDialog(null, "Description cannot be empty!");
				}
				if (textVIN.getText().length()>0
						 && textVIN.getText().length()<=14
						 && textMake.getText().length()>0						 
						 && textModel.getText().length()>0
						 && year.getText().length()>0
						 && Integer.parseInt(year.getText())<=2021
						 && Integer.parseInt(year.getText())>=1925
						 && price.getText().length()>1
						 && Double.parseDouble(price.getText())>1.0
						 && color.getText().length()>0
						 && mileage.getText().length()>0
						 && Integer.parseInt(mileage.getText())>0
						 && description.getText().length()>0
						 && new DBConnection().update(textVIN.getText(), textMake.getText(), textModel.getText(), Integer.parseInt(year.getText()),
		        		 Double.parseDouble(price.getText()), body.getSelectedItem().toString(), color.getText(), Integer.parseInt(mileage.getText()),
		        		 transmission.getSelectedItem().toString(), description.getText(), condition.getSelectedItem().toString(),
		        		 status.getSelectedItem().toString())) {
		            JOptionPane.showMessageDialog(null, "Successfully Updated");
		 
		            //CLEAR TXT
		            textVIN.setText("");
		            textMake.setText("");
		            textModel.setText("");
		            year.setText("");
		            price.setText("");
		            color.setText("");
		            mileage.setText("");
		            description.setText("");
		 
		            retrieve();
		        } else {
		            JOptionPane.showMessageDialog(null, "Not Updated");		            
		        }
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnUpdate.setBounds(683, 68, 100, 30);
		MainFrame.getContentPane().add(btnUpdate);
		
		
		
		btnDel = new JButton("DELETE");
		btnDel.addActionListener(new ActionListener() {		//ActionListener inner class
			public void actionPerformed(ActionEvent e) {
		        String[] options = {"Yes", "No"};
		        int answ = JOptionPane.showOptionDialog(null, "Sure To Delete?", "Deleted",
		        		JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);		 
		        	if (answ == 0) {
		        		int index = table.getSelectedRow();
		        		String id = table.getValueAt(index, 0).toString();		 
		            if (new DBConnection().delete(id)) {
		                JOptionPane.showMessageDialog(null, "Deleted");
		 
		                //CLEAR TXT
		                textVIN.setText("");
			            textMake.setText("");
			            textModel.setText("");
			            year.setText("");
			            price.setText("");
			            color.setText("");
			            mileage.setText("");
			            description.setText("");
		 
			        retrieve();
		            } else
		            {
		                JOptionPane.showMessageDialog(null, "Not Deleted");		                
		            }		 
		        }
			}
		});
		btnDel.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnDel.setBounds(683, 109, 100, 30);
		MainFrame.getContentPane().add(btnDel);		
		
		
		btnClear = new JButton("CLEAR");
		btnClear.addActionListener(	(event)->{		//ActionListener inner class replaced with lambda expression
				textVIN.setText("");
	            textMake.setText("");
	            textModel.setText("");
	            year.setText("");
	            price.setText("");
	            color.setText("");
	            mileage.setText("");
	            description.setText("");}
			
		);
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnClear.setBounds(683, 150, 100, 30);
		MainFrame.getContentPane().add(btnClear);		
		
		JButton btnSearch = new JButton("VIN search");
		btnSearch.addActionListener((event) ->{			//ActionListener inner class replaced with lambda expression
			
				if(!textSearch.getText().equals("")) {					
					//CLEAR TXT
		            textVIN.setText("");
		            textMake.setText("");
		            textModel.setText("");
		            year.setText("");
		            price.setText("");
		            color.setText("");
		            mileage.setText("");
		            description.setText("");
		 
		            retrieveSearchedTable(textSearch.getText());					
				}
				else {
					retrieve();	
					JOptionPane.showMessageDialog(null, "Enter VIN!");				
				}
			}
		);
		
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSearch.setBounds(25, 280, 92, 25);
		MainFrame.getContentPane().add(btnSearch);		
		
		JButton btnLoad = new JButton("LOAD FROM FILE");
		btnLoad.addActionListener( (event) -> {			
			DBConnection.loadFromFile();			
			retrieve();
			JOptionPane.showMessageDialog(null, "Database restored from backup file!");
			}
		);
		btnLoad.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnLoad.setBounds(651, 191, 163, 30);
		MainFrame.getContentPane().add(btnLoad);
		
		JButton btnCopyToFile = new JButton("COPY TO FILE");
		btnCopyToFile.addActionListener( (event) -> {
			DBConnection.copyToFile();
			JOptionPane.showMessageDialog(null, "Database copied to backup file!");
			}
		);
		btnCopyToFile.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCopyToFile.setBounds(651, 232, 163, 30);
		MainFrame.getContentPane().add(btnCopyToFile);
	}
}
