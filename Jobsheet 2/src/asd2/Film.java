/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asd2;

/**
 *
 * @author ASUS
 */
public class Film  {
        String judul,genre,rate;
        int jumlahTiket, hargaTiket;
        
        Film(){
        }
        Film(String jd,String gr,String rt, int jt, int ht){
            judul = jd;
            genre = gr;
            rate = rt;
            jumlahTiket = jt;
            hargaTiket = ht;
        }
        
        void tampil (){
            System.out.println("Judul "+ judul);
            System.out.println("Genre "+ genre);
            System.out.println("Rate "+ rate);
            System.out.println("Jumlah Tiket "+ jumlahTiket);
            System.out.println("Harga Tiket "+ hargaTiket);
        }
        
        void tambahTiket (int n) {
            jumlahTiket += n;
        }
        
        void kurangiTiket (int n) {
            if(jumlahTiket > 0)
                jumlahTiket -= n;
            else 
                System.out.println("Tiket Telah Habis");
        }
        
        int totalRevenue(int jumlah){
            return jumlah*hargaTiket;
        }
    }
