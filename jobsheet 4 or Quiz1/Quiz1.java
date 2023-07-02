import java.util.Scanner;

class Anggota {
    String nama ;
    String kelas ;
    String kode ;
    int jmlhPinjam;
    
}

public void menguramgi (){}

public class Quiz1 {
    static Scanner sc = new Scanner(System.in);
    static Scanner scr = new Scanner(System.in);
    static Anggota [] agt = new Anggota[99];
    static int input = 0;
    static int jumBuk = 10; 

    static void instansiasiagt (){
        for (int i = 0; i < agt.length; i++) {
            agt[i]= new Anggota();
        }
    }

    public static void main(String[] args) {
        instansiasiagt();
        boolean key = true;
        while (key) {
            System.out.println("Menu Perpustakaan :");
            System.out.println("1. Anggota Baru");
            System.out.println("2. Pinjam Buku");
            System.out.println("3. Kembalikan Buku");
            System.out.println("Jumlah Buku Tersedia : "+ jumBuk);
            System.out.print("Masukan Pilihan : ");
            int in = sc.nextInt();
            System.out.println("----------------------------------");
            if (in == 1) {
                newagt();
            } else if (in == 2) {
                System.out.print("Masukan Kode Anggota : ");
                String x = scr.nextLine();
                System.out.print("Masukan Jumlah Buku dipinjam : ");
                int a = sc.nextInt();
                System.out.println("-----------------------------------");
                pinBuku(a, x);
            } else if (in == 3){
                System.out.print("Masukan Kode Anggota : ");
                String x = scr.nextLine();
                System.out.print("Masukan Jumlah Buku diKembalikan : ");
                int a = sc.nextInt();
                System.out.println("---------------------------------");
                backBuku(a, x);
            } else {
                System.out.println("Input salah masukan ulang");
            }
        }
    }

    static void newagt (){
        System.out.print("Masukan Nama : ");
        agt[input].nama = scr.nextLine();
        System.out.print("Masukan Kelas :");
        agt[input].kelas = scr.nextLine();
        System.out.print("Masukan Kode  :");
        agt[input].kode = scr.nextLine();
        input++;
    }

    static void pinBuku (int jumlahTake, String kodeAnggota){
        for (int i = 0; i < agt.length; i++) {
            if(kodeAnggota.equals(agt[i].kode)){
                if(jumBuk == 0){
                    System.out.println("Mohon Maaf Buku Telah Habis");
                }

                jumBuk -= jumlahTake;
                agt[i].jmlhPinjam += jumlahTake;
                print(i);
                
            } else if (i == agt.length) {
                System.out.println("Mohon Maaf Data Tidak Ditemukan");
            }
        }
    }

    static void backBuku (int jumlahKembali, String kodeAnggota) {
        for (int i = 0; i < agt.length; i++) {
            if(kodeAnggota.equals(agt[i].kode)){
                if(agt[i].jmlhPinjam == 0){
                    System.out.println("Mohon Tidak ada buku yang dipinjam");
                }

                jumBuk += jumlahKembali;
                agt[i].jmlhPinjam -= jumlahKembali;
                print(i);

            } else if (i == agt.length) {
                System.out.println("Mohon Maaf Data Tidak Ditemukan");
            }
        }
    }

    static void print (int kodeUser ){
        System.out.println("===========================================");
        System.out.println("Nama           : "+ agt[kodeUser].nama);
        System.out.println("Kelas          : "+ agt[kodeUser].kelas);
        System.out.println("Nama           : "+ agt[kodeUser].nama);
        System.out.println("Jumlah pinjam  : "+ agt[kodeUser].jmlhPinjam);
        System.out.println("=============================================");
    }
}
