package entities;

import java.util.Comparator;

public class Car{
	
	private String vin;
	private String make;
	private String model;
	private int year;
	private Double price;	
	private String body;	
	private String color;
	private int mileage;	
	private String transmission;	
	private String description;	
	private String condition;
	private String status;

	public Car() {
		super();
		
	}

	public Car(String vin, String make, String model, int year, Double price, String body, String color, int mileage,
			String transmission, String description, String condition, String status) {
		super();
		this.vin = vin;
		this.make = make;
		this.model = model;
		this.year = year;
		this.price = price;
		this.body = body;
		this.color = color;
		this.mileage = mileage;
		this.transmission = transmission;
		this.description = description;
		this.condition = condition;
		this.status = status;
	}

	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getMileage() {
		return mileage;
	}

	public void setMileage(int mileage) {
		this.mileage = mileage;
	}

	public String getTransmission() {
		return transmission;
	}

	public void setTransmission(String transmission) {
		this.transmission = transmission;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
    public static Comparator<Car> CarVinComparator = new Comparator<Car>() {

    	public int compare(Car car1, Car car2) {
    	   String vin1 = car1.getVin().toUpperCase();
    	   String vin2 = car2.getVin().toUpperCase();
 
    	   return vin1.compareTo(vin2);
     }};
     
     public static Comparator<Car> CarPriceComparator = new Comparator<Car>() {

     	public int compare(Car car1, Car car2) {
     	   Double price1 = car1.getPrice();
     	   Double price2 = car2.getPrice();
  
     	   return price2.compareTo(price1);
      }};
	
}
