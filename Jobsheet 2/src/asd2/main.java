
package asd2;


public class main {
    
    public static void main(String[] args) {
        Film film1 = new Film();
        
        film1.judul = "Film Perjuang";
        film1.genre = "Romance";
        film1.rate = "Remaja";
        film1.jumlahTiket = 3000;
        film1.hargaTiket = 40000;
        
        film1.tambahTiket(1);
        film1.kurangiTiket(3);
        film1.tampil();
        
        int income = film1.totalRevenue(4);
        System.out.println("Total Jual Tiket 4 = "+income);
        System.out.println("===================================");
        
        Film film2 = new Film("Laskar Pelangi", "Slice of Live", "Remaja", 3000, 35000);
        film2.tampil();
        
        System.out.println("===================================");
        Film film3 = new Film("Waktu Magrib", "Horor", "Semua Umur", 2500, 40000);
        film3.tampil();
    }
    
}


    
    