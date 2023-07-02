import java.util.Scanner;

public class VaksinMain {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);    /* input String*/
        Scanner scr = new Scanner(System.in);   /* input Int*/
        AntrianVaksin av = new AntrianVaksin();
        int count = 120;

        boolean key = true;
        while (key) {
            System.out.println("=============================================");
            System.out.println("\t\t Antrian Vaksin \t\t");
            System.out.println("=============================================");
            System.out.println();
            System.out.println("1. Tambah Data Penerima Vaksin");
            System.out.println("2. Hapus Data Pengantri Vaksin");
            System.out.println("3. Daftar Penerima Vaksin");
            System.out.println("4. Keluar");
            System.out.println("=============================================");
            System.out.print("Masukan Pilihan : ");
            int in = scr.nextInt();
            if (in == 1) {
                count++;
                System.out.println("Nomor Antrian : "+count);
                System.out.print("Masukan Nama : ");
                String nama = sc.nextLine();
                av.addLast(count, nama);
            } else if (in == 2) {
                System.out.println(av.head.nama + " Telah Selesai Dilakukan Vaksin");
                av.removeFrist();
                av.print();
            } else {
                av.print();
            }
        }

    }
}
