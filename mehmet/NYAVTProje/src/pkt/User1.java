package pkt;

public class User1 implements IObserver {
	
	@Override
    public void update(int temperature) {
		updateUser1(temperature);
    }
    public void updateUser1(int temp){
        System.out.println("Mehmet - Yeni Sicaklik: "+temp+"°C");
    }
}
