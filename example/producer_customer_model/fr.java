package demo;

public class fr {

	public static void main(String[] args) {
		WareHouse house = new WareHouse();
		Producer p = new Producer(house);
		Customer c1 = new Customer(house);
		Customer c2 = new Customer(house);
		p.start();
		c1.start();
		c2.start();
	}

	
}
