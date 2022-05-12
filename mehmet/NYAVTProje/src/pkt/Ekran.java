package pkt;

import java.util.Scanner;

public class Ekran implements IObserver,IEkran{


	UserFactory userFactory=new UserFactory();
    IObserver u1=userFactory.getObserver("u1");
    IObserver u2=userFactory.getObserver("u2");
    
    public int menu() {
    	
        	Scanner scanner=new Scanner(System.in);
        	
         	System.out.println("-----Yapilacak islemi seciniz.-----");
         	System.out.println("1.Sogutucuyu ac.");
            System.out.println("2.Sogutucuyu kapat.");
            System.out.println("3.Sicaklik goruntule.");
            System.out.println("4.Cikis");
            return this.secimdogrulama(scanner.nextInt());

    }
    public int secimdogrulama(int secim) {
        
    	if(secim<1||secim>4){
            return 0;
        }
        else {
            return secim;
        }

    }

    @Override
    public void update(int sicaklik) {
        System.out.println("Sicaklik "+sicaklik+" °C ");
    }
}
