package pkt;

public class Eyleyici implements IEyleyici{

	boolean acikMi = false;
    @Override
    public void sogutucuKapat() {
    	System.out.println("Sogutucunun durumu kontrol ediliyor..");
    	 Zaman.bekle();
    	if(acikMi) {

            System.out.println("Sogutucu kapatildi.");
            acikMi = false;
    		
    	}
    	else
    		System.out.println("Zaten kapali!");
    	
    }
    
    @Override
    public void sogutucuAc() {
    	
    	System.out.println("Sogutucunun durumu kontrol ediliyor..");
   	 	Zaman.bekle();
	   	if(!acikMi) {
	
	           System.out.println("Sogutucu acildi.");
	           acikMi = true;
	   		
	   	}
	   	else
	   		System.out.println("Zaten acik!");
	    }
}
