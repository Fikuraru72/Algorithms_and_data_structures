import java.util.Scanner;
class Mahasiswa {
    String nama ;
    String nim;
    double ipk;
    String Kelamin;
}
public class tugasKe2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Scanner scr = new Scanner(System.in);
        Mahasiswa [] mahasiswa1 = new Mahasiswa[3];

        for (int i = 0; i < mahasiswa1.length; i++) {
            System.out.println("Masukan Data Mahasiswa ke-"+(i+1));
            mahasiswa1 [i] = new Mahasiswa();
            System.out.print("Masukan Nama Mahasiswa : ");
            mahasiswa1[i].nama = sc.nextLine(); 
            System.out.print("Masukan nim Mahasiswa : ");
            mahasiswa1[i].nim = sc.nextLine(); 
            System.out.print("Masukan ipk Mahasiswa : ");
            mahasiswa1[i].ipk = scr.nextDouble(); 
            System.out.print("Masukan Jenis Kelamin Mahasiswa : ");
            mahasiswa1[i].Kelamin = sc.nextLine(); 
        }
        System.out.println("");
        for (int i = 0; i < mahasiswa1.length; i++) {
            System.out.println("Mahasiswa ke-"+i+1);
            System.out.printf("Nama Mahasiswa ke-%s = %s\n",i+1,mahasiswa1[i].nama);
            System.out.printf("NIM Mahasiswa ke-%s = %s\n",i+1,mahasiswa1[i].nim);
            System.out.printf("IPK Mahasiswa ke-%s = %s\n",i+1,mahasiswa1[i].ipk);
            System.out.printf("Jenis Kelamin Mahasiswa ke-%s = %s\n",i+1,mahasiswa1[i].Kelamin);
            System.out.println("=====================================================");
        }

    }
}