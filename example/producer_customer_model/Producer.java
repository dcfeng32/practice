package demo;

public class Producer extends Thread{
	private WareHouse house; 
	public void WareHouse(WareHouse house) {
	this.house = house;
}
	
	public void run(WareHouse house) {
		while(true) {
			house.add();
			System.out.println("生产者摘下了一个西瓜！");
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		
	}
	
	
	
}
