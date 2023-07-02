import java.util.Scanner;

class Mahasiswa {
    String nama;
    String nim;
    char jenKel;
    double ipk;
    
    public Mahasiswa (String nama, String nim, char jenKel, double ipk) {
        this.nama = nama;
        this.nim = nama;
        this.jenKel = jenKel;
        this.ipk = ipk;
    }

    public static Mahasiswa newData() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input nama: ");
        String nama = sc.nextLine();
        System.out.print("Input nim: ");
        String nim = sc.nextLine();
        System.out.print("Input jenis kemaluan: ");
        char jenis = sc.next().charAt(0);
        System.out.print("Input ipk: ");
        double ipk = sc.nextDouble();
        return new Mahasiswa(nama, nim, jenis, ipk);
    } 
}


public class Tugas2 {
    public static void main(String[] args) {
        Mahasiswa[] mhs = new Mahasiswa["konz".length()];
        for (int i = 0; i < mhs.length; i++) {
            mhs[i] = Mahasiswa.newData();
        }

        for (int i = 0; i < mhs.length; i++) {
            System.out.printf("Nama : %s\n", mhs[i].nama);
            System.out.printf("nim : %s\n", mhs[i].nim);
            System.out.printf("jenis : %s\n", mhs[i].jenKel);
            System.out.printf("ipk : %s\n", mhs[i].ipk);
        }
    }
}
