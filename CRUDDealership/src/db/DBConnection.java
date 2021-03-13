package db;

import java.sql.*;
import javax.swing.table.DefaultTableModel;


public class DBConnection {
	
	String conString = "jdbc:mysql://localhost:3306/?allowPublicKeyRetrieval=true&useSSL=false";
    String username = "root";
    String password = "Pilsner1";
 
    //INSERT INTO DB
    public Boolean add(String vin, String make, String model, int year, double price, String body, String color, int mileage,
    		String transmission, String description, String condition, String status) {
        
    	String insertQuery = 
				"INSERT INTO car_dealership.dealership_inventory (`vin`, `make`, `model`, `year`, `price`, `body`, " + 
				"`color`, `mileage`, `transmission`, `description`, `sh_condition`, `status`) "
                + "VALUES ('"+vin+"', '"+make+"', '"+model+"', '"+year+"', '"+price+"', '"+body+"', "
                + " '"+color+"', '"+mileage+"', '"+transmission+"', '"+description+"', '"+condition+"', '"+status+"');";                		  
 
        try {
            //GET COONECTION
            Connection con = DriverManager.getConnection(conString, username, password);             
            PreparedStatement ps = con.prepareStatement(insertQuery);            
            ps.execute(insertQuery);          
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }
 
    //RETRIEVE DATA
    public DefaultTableModel getData() {
    	
        //ADD COLUMNS TO TABLE MODEL
        DefaultTableModel dm = new DefaultTableModel();
        dm.addColumn("VIN");
        dm.addColumn("Make");
        dm.addColumn("Model");
        dm.addColumn("Year");
        dm.addColumn("Price");
        dm.addColumn("Body");
        dm.addColumn("Color");
        dm.addColumn("Mileage");
        dm.addColumn("Transmission");
        dm.addColumn("Description");
        dm.addColumn("Condition");
        dm.addColumn("Status");
 
        String selectQuery = "SELECT * FROM `car_dealership`.`dealership_inventory`";
 
        try {
            Connection con = DriverManager.getConnection(conString, username, password);             
            Statement s = con.prepareStatement(selectQuery);            
            ResultSet rs = s.executeQuery(selectQuery);
 
            //LOOP FOR GETTING ALL VALUES
            while (rs.next()) {
                String vin = rs.getString(1);
                String make = rs.getString(2);
                String model = rs.getString(3);
                String year = rs.getString(4);
                String price = rs.getString(5);
                String body = rs.getString(6);
                String color = rs.getString(7);
                String mileage = rs.getString(8);
                String transmission = rs.getString(9);
                String description = rs.getString(10);
                String condition = rs.getString(11);
                String status = rs.getString(12);
                 
                dm.addRow(new String[]{vin, make, model, year, price, body, color, mileage, transmission, description, condition, status});                
            } 
        } catch (Exception ex) {
            ex.printStackTrace();            
        }        
        return dm; 
    }
 
    //UPDATE DATA
    public Boolean update(String VIN, String make, String model, int year, double price, String body, String color, int mileage,
    		String transmission, String description, String condition, String status) {
        
    	String updateQuery = 
				"UPDATE `car_dealership`.`dealership_inventory` SET " +
				"vin = '"+VIN+"', make = '"+make+"',  model = '"+model+"', year = '"+year+"', price = '"+price+"', body = '"+body+"', "
		         + "color = '"+color+"', mileage = '"+mileage+"', transmission = '"+transmission+"', description = '"+description+
		         "', sh_condition = '"+condition+"', status = '"+status+"' WHERE vin = '" + VIN +"'";           
    	
        try {            
            Connection con = DriverManager.getConnection(conString, username, password);            
            Statement s = con.prepareStatement(updateQuery); 
            s.execute(updateQuery);
            con.close(); 
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("boolean add method failed!");
            return false;
        }
        return true;
    }
 
    //DELETE DATA
    public Boolean delete(String vin){
        
        String delQuery = "DELETE FROM `car_dealership`.`dealership_inventory` WHERE (`vin` = " + vin +");";
 
        try {            
            Connection con=DriverManager.getConnection(conString, username, password);            
            Statement s=con.prepareStatement(delQuery);            
            s.execute(delQuery);            
            con.close();
            
        }catch(Exception ex){
            ex.printStackTrace();            
            return false;
        }
        return true;
    } 
}
