package demo;

public class Customer extends Thread{
	private WareHouse house; 
		public void WareHouse(WareHouse house) {
		this.house = house;
	}
		
		public void run(WareHouse house) {
			while(true) {
				house.get();
				System.out.println("消费者吃了一个西瓜");
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
}
