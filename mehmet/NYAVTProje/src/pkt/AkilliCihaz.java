package pkt;

import java.util.Scanner;

public class AkilliCihaz {

    private ISicaklikAlgilayici sicaklikAlgilayici;
    private IEyleyici eyleyici;
    private IBilgiSistemi bilgiSistemi;

    ISubject Arayuz=new AgArayuz();
    Ekran ekran=new Ekran();

    public AkilliCihaz(CihazBuilder builder ) {
        sicaklikAlgilayici = new SicaklikAlgilayici();
        eyleyici = new Eyleyici();
        bilgiSistemi = new PostgreSQLVeritabani();
        Arayuz.attach(ekran);

    }

    public void basla() {

        Scanner scanner = new Scanner(System.in);
        
        int sayac = 0;
        boolean temp = false;
        
        while (sayac<3) {
        	System.out.println("Kullanici adi:");
            String kullaniciAdi = scanner.next();
            System.out.println("Sifre:");
            int sifre = scanner.nextInt();
            
            temp=true;
            
            if(temp)
            {
            	if (bilgiSistemi.kullaniciDogrula(kullaniciAdi, sifre)) {
                    int secim;
                    sayac++;
                    do {
                        secim = ekran.menu();
                        if (secim == 0) {
                            System.out.println("Lutfen gecerli bir secim yapınız.");
                        }
                        else{
                            if(secim==1) {
                            	eyleyici.sogutucuAc();
                            }
                            else if(secim==2) {
                            	eyleyici.sogutucuKapat();
                            }
                            else if(secim==3) {
                            	Arayuz.notify(sicaklikAlgilayici.sicaklikOlc());
                            }
                            else if(secim==4) {
                            	System.out.println("Program kapatildi");
                            }
                        }
                    }while (secim==0 || secim!=4);
                }
                else{
                	if(sayac==3)
                		System.out.println("Giris hakkiniz dolmustur.");
                	else
                		System.out.println("Lutfen giris bilgilerinizi kontrol ediniz.");
                }
            }
            
            	
        }
        

       
    }
    public static class CihazBuilder
    {
        private String marka;

        public CihazBuilder(String marka) {
            this.marka = marka;
        }

        public AkilliCihaz build() {

            return new AkilliCihaz(this);
        }

    }
}