import java.util.Scanner;

public class Film {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        Scanner scr = new Scanner(System.in);
        DataFilm df = new DataFilm();
        int count = 122;

        boolean key = true;
        while (key) {
            System.out.println("========================================");
            System.out.println("\t\tData Film Layar Lebar\t\t");
            System.out.println("========================================");
            System.out.println("1. Tambah Data Awal");
            System.out.println("2. Tambah Data Akhir");
            System.out.println("3. Tambah Data Index Tertentu");
            System.out.println("4. Hapus Data Awal");
            System.out.println("5. Hapus Data Akhir");
            System.out.println("6. Hapus Data Index Tertentu");
            System.out.println("7. Cetak");
            System.out.println("8. Cari Id Film");
            System.out.println("9. Urut Data Rating Film Desc");
            System.out.println("10. Keluar");
            System.out.println("========================================");
            System.out.print("Masuakan Pilihan : ");
            int in = sc.nextInt();

            if (in == 1) {
                System.out.println("ID Film\t\t : " + count);
                System.out.print("Nama Film\t : ");
                String namaFilm = scr.nextLine();
                System.out.print("Rating Film\t : ");
                double rating = sc.nextDouble();
                df.addFrist(count, namaFilm, rating);
                count++;
            } else if (in == 2) {
                System.out.println("ID Film\t\t : " + count);
                System.out.print("Nama Film\t : ");
                String namaFilm = scr.nextLine();
                System.out.print("Rating Film\t : ");
                double rating = sc.nextDouble();
                df.addLast(count, namaFilm, rating);
                count++;
            } else if (in == 3) {
                System.out.print("Masukan Index\t : ");
                int index = sc.nextInt();
                System.out.println("ID Film\t\t : " + count);
                System.out.print("Nama Film\t : ");
                String namaFilm = scr.nextLine();
                System.out.print("Rating Film\t : ");
                double rating = sc.nextDouble();
                df.add(count, namaFilm, rating, index);
                count++;
            }else if (in == 4) {
                df.removeFrist();
            } else if (in == 5) {
                df.removeLast();
            }else if (in == 6){
                System.out.print("Masukan Index\t : ");
                int index = sc.nextInt();
                df.removeAdd(index);
            } else if (in == 7) {
                df.print();
            } else if (in == 8) {
                System.out.print("Masukan ID Film\t : ");
                int id = sc.nextInt();
                df.search(id, df.head, 1);
            } else if (in == 9) {
                df.shorting();
                df.print();
            } else if (in == 10) {
                
            }
        }
    }
}
