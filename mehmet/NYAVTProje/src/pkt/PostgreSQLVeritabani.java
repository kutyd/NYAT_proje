package pkt;

import java.sql.*;

public class PostgreSQLVeritabani implements IBilgiSistemi{


   private Connection Baglanti(){
       Connection conn=null;
       try{
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/nyatdb",
                   "postgres", "kutay2001");
           if (conn != null )
               System.out.println("Veritabanina baglanildi!");
           else
               System.out.println("Baglanti girisimi basarisiz!");

       } catch (SQLException throwables) {
           throwables.printStackTrace();
       }
       return conn;
   }

    @Override
    public boolean kullaniciDogrula(String kullaniciAdi, int sifre) {
        Connection conn= Baglanti();
        //KullaniciHesabi kullaniciHesabi = null;
        boolean dogrulama=true;

        String sql = "SELECT *  FROM \"kullanicilar\" WHERE \"kullaniciAdi\"='" + kullaniciAdi + "' AND sifre=" + sifre;

        try{
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
                
            conn.close();
            boolean sonuc=rs.next();

            if(sonuc){
                do{
                        kullaniciAdi=rs.getString("kullaniciAdi");
                        sifre  = rs.getInt("sifre");
                }while(rs.next());

            }
            else{
                System.out.println("\nKullanici Dogrulamasi Basarisiz!");
                dogrulama=false;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return dogrulama;
    }

 
}
