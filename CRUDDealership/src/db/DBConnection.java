package db;

import java.io.*;
import java.sql.*;
import java.util.*;
import java.util.stream.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import entities.Car;
import gui.*;


public class DBConnection {
	
	private JTable table;
	
	static String conString = "jdbc:mysql://localhost:3306/?allowPublicKeyRetrieval=true&useSSL=false";
    static String username = "root";
    static String password = "Pilsner1";
    ArrayList<Car> list = (ArrayList<Car>) carList();
    
    ArrayList<Car> searchedList = new ArrayList<Car>();
    
  //Get ArrayList of Car objects from database
    public static ArrayList<Car> carList() {
    	 
    	ArrayList<Car> carList = new ArrayList<Car>();		
		
        String selectQuery = "SELECT * FROM `car_dealership`.`dealership_inventory`";
 
        try {
            Connection con = DriverManager.getConnection(conString, username, password);
            assert con != null : "Connection is null";
            Statement s = con.createStatement();             
            ResultSet rs = s.executeQuery(selectQuery);
 
            while (rs.next()) {
            	Car car = new Car();
				car.setVin(rs.getString("vin"));
				car.setMake(rs.getString("make"));
				car.setModel(rs.getString("model"));				
				car.setYear(rs.getInt("year"));
				car.setPrice(rs.getDouble("price"));
				car.setBody(rs.getString("body"));
				car.setColor(rs.getString("color"));
				car.setMileage(rs.getInt("mileage"));
				car.setTransmission(rs.getString("transmission"));
				car.setDescription(rs.getString("description"));
				car.setCondition(rs.getString("sh_condition"));
				car.setStatus(rs.getString("status"));
				carList.add(car);
			}
            rs.close();
            con.close();
		} catch (SQLException ex) {
			System.err.println(ex);	
		}
		return carList;
    }        
    
    //Get data from ArrayList and insert it in application table
    public DefaultTableModel getData() {    	
    	
    	Collections.sort(list, Car.CarVinComparator);
        
        String columns[] = {"vin", "make", "model", "year", "price", "body", "color", "mileage", "transmission", "description", "condition", "status"};

        DefaultTableModel dm = new DefaultTableModel(columns, 0);
        new DBConnection();                                                    

        //Getting values from ArrayList
        for(Car car: list) {        	
            String vin = car.getVin();
            String make = car.getMake();
            String model = car.getModel();            
            String year = String.valueOf(car.getYear());
            String price = String.valueOf(car.getPrice());
            String body = car.getBody();
            String color = car.getColor();
            String mileage = String.valueOf(car.getMileage());
            String transmission = car.getTransmission();
            String description = car.getDescription();
            String condition = car.getCondition();
            String status = car.getStatus();             
            dm.addRow(new String[]{vin, make, model, year, price, body, color, mileage, transmission, description, condition, status});            
        }         
    return dm; 
    }    
    
    //Insert into database
    public static Boolean add(String vin, String make, String model, int year, double price, String body, String color, int mileage,
    		String transmission, String description, String condition, String status) {
        
    	String insertQuery = 
				"INSERT INTO car_dealership.dealership_inventory (`vin`, `make`, `model`, `year`, `price`, `body`, " + 
				"`color`, `mileage`, `transmission`, `description`, `sh_condition`, `status`) "
                + "VALUES ('"+vin+"', '"+make+"', '"+model+"', '"+year+"', '"+price+"', '"+body+"', "
                + " '"+color+"', '"+mileage+"', '"+transmission+"', '"+description+"', '"+condition+"', '"+status+"');";                		  
 
        try {
            //GET COONECTION
            Connection con = DriverManager.getConnection(conString, username, password);
            assert con != null : "Connection is null";
            Statement s = con.createStatement();            
            s.execute(insertQuery);          
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }
 
    
    //Update data
    public static Boolean update(String VIN, String make, String model, int year, double price, String body, String color, int mileage,
    		String transmission, String description, String condition, String status) {
        
    	String updateQuery = 
				"UPDATE `car_dealership`.`dealership_inventory` SET " +
				"vin = '"+VIN+"', make = '"+make+"',  model = '"+model+"', year = '"+year+"', price = '"+price+"', body = '"+body+"', "
		         + "color = '"+color+"', mileage = '"+mileage+"', transmission = '"+transmission+"', description = '"+description+
		         "', sh_condition = '"+condition+"', status = '"+status+"' WHERE vin = '" + VIN +"'";           
    	
        try {            
            Connection con = DriverManager.getConnection(conString, username, password); 
            assert con != null : "Connection is null";
            Statement s = con.createStatement(); 
            s.execute(updateQuery);
            con.close(); 
        } catch (SQLException ex) {
            ex.printStackTrace();            
            return false;
        }
        return true;
    }
 
    //Delete data
    public Boolean delete(String vin){
        
        String delQuery = "DELETE FROM `car_dealership`.`dealership_inventory` WHERE (`vin` = " + vin +")";
 
        try {            
            Connection con = DriverManager.getConnection(conString, username, password);
            assert con != null : "Connection is null";
            Statement s = con.createStatement();           
            s.execute(delQuery);            
            con.close();            
        }catch(Exception ex){
            ex.printStackTrace();            
            return false;
        }
        return true;
    }
    
    //Get data for searched VIN 
    public DefaultTableModel getSearchedData(String searchVin) {    	
    	
    	for(Car car: list) {
    		if(car.getVin().equals(searchVin)) {
    			searchedList.add(car);    			
    		}
    	}
    	Collections.sort(searchedList, Car.CarVinComparator);
                
        String columns[] = {"vin", "make", "model", "year", "price", "body", "color", "mileage", "transmission", "description", "condition", "status"};

        DefaultTableModel dm = new DefaultTableModel(columns, 0);
        new DBConnection();                                                   
        
        //Getting values from ArrayList
        for(Car car: searchedList) {        	
            String vin = car.getVin();
            String make = car.getMake();
            String model = car.getModel();            
            String year = String.valueOf(car.getYear());
            String price = String.valueOf(car.getPrice());
            String body = car.getBody();
            String color = car.getColor();
            String mileage = String.valueOf(car.getMileage());
            String transmission = car.getTransmission();
            String description = car.getDescription();
            String condition = car.getCondition();
            String status = car.getStatus();             
            dm.addRow(new String[]{vin, make, model, year, price, body, color, mileage, transmission, description, condition, status});            
        }         
    return dm; 
    }
    
    public static void loadFromFile(){
    	ArrayList<Car> listForComparison = carList();
    	BufferedReader br = null;
    	//list of arrays, where each array represents a car (read from backup file)
    	ArrayList<String[]> carsInFile = new ArrayList<String[]>();
    	//list of VINs, read from database
    	ArrayList<String> carsInDb = listForComparison.stream().
    			map(Car::getVin).
    			collect(Collectors.toCollection(ArrayList::new));    	
        try {
            br = new BufferedReader(new FileReader("D:\\backupfile.txt"));
            String line;
            while ((line = br.readLine()) != null) {
            	String[] values = line.split("\\|"); 
            	if (values[0].length() > 4)
            	carsInFile.add(values);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {if (br != null) 
                    br.close();                
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }        
    	
        for(String[] s : carsInFile) {
        	if(!carsInDb.contains(s[0]))        		
        	add(s[0], s[1], s[2], Integer.parseInt(s[3]), Double.parseDouble(s[4]), s[5], s[6], 
        			Integer.parseInt(s[7]), s[8], s[9], s[10], s[11]);        	
        	
        	else
        	update(s[0], s[1], s[2], Integer.parseInt(s[3]), Double.parseDouble(s[4]), s[5], s[6], 
        			Integer.parseInt(s[7]), s[8], s[9], s[10], s[11]);        	
        }        
    }
    
    public static void copyToFile() {
    	try {    			
			String selectQuery = "SELECT * FROM `car_dealership`.`dealership_inventory`";
            Connection con = DriverManager.getConnection(conString, username, password);
            assert con != null : "Connection is null";
            Statement s = con.createStatement();             
            ResultSet rs = s.executeQuery(selectQuery);
            String line = "";
            File file = new File("D:/backupfile.txt");
            FileWriter fw = new FileWriter(file);
            PrintWriter pw = new PrintWriter(fw);
            while (rs.next()) {                	
				line = line.concat(rs.getString("vin") + "|");
				line = line.concat(rs.getString("make") + "|");
				line = line.concat(rs.getString("model") + "|");				
				line = line.concat(rs.getInt("year") + "|");
				line = line.concat(rs.getDouble("price") + "|");
				line = line.concat(rs.getString("body") + "|");
				line = line.concat(rs.getString("color") + "|");
				line = line.concat(rs.getInt("mileage") + "|");
				line = line.concat(rs.getString("transmission") + "|");
				line = line.concat(rs.getString("description") + "|");
				line = line.concat(rs.getString("sh_condition") + "|");	
				line = line.concat(rs.getString("status") + "| " + "\n");				
			}
            pw.println(line);
			pw.flush();
            pw.close();
            rs.close();
            con.close();            
		} catch (SQLException|IOException ex) {
			System.err.println(ex);	
		}
    }
	
}