package Load_ApplicationContext;

public class Car {

	private String car_Name, car_brand;
	private double car_price;

	public String getCar_Name() {
		return car_Name;
	}

	public void setCar_Name(String car_Name) {
		this.car_Name = car_Name;
	}

	public String getCar_brand() {
		return car_brand;
	}

	public void setCar_brand(String car_brand) {
		this.car_brand = car_brand;
	}

	public double getCar_price() {
		return car_price;
	}

	public void setCar_price(double car_price) {
		this.car_price = car_price;
	}

	@Override
	public String toString() {
		return "Car [car_Name=" + car_Name + ", car_brand=" + car_brand + ", car_price=" + car_price + "]";
	}

}
