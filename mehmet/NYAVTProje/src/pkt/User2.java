package pkt;

public class User2 implements IObserver{
	
	@Override
	    public void update(int temperature) {
			updateUser2(temperature);
	    }
	    public void updateUser2(int temp){
	        System.out.println("Kutay - Yeni Sicaklik: "+temp+"°C");
	    }

}
