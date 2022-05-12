package pkt;

public class UserFactory {
	
	public IObserver getObserver(String kullaniciAdi){
        
		if(kullaniciAdi==null)
            return null;
        if(kullaniciAdi.equalsIgnoreCase("k1"))
            return new User1();
        else if(kullaniciAdi.equalsIgnoreCase("k2"))
            return new User2();
        return null;
    }

}
