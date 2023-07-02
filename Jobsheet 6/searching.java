import java.util.Scanner;
class Mahasiswa {
    int nim;
    String nama;
    int umur;
    double ipk ;

    Mahasiswa(int ni, String n, int u, double i){
        nim = ni;
        nama = n;
        umur = u;
        ipk = i;
    }

    void tampil (){
        System.out.println("Nim : "+ nim);
        System.out.println("Nama : "+ nama);
        System.out.println("Umur : "+ umur);
        System.out.println("Ipk : "+ ipk);
    }
}

class PencarianMhs{
    Mahasiswa listMhs [] = new Mahasiswa [5];
    int idx;

    void tambah(Mahasiswa m){
        if (idx< listMhs.length) {
            listMhs[idx] = m;
            idx++;
        } else {
            System.out.println("Data Sudah Penuh");
        }
    }

    void tampil (){
        for (Mahasiswa mahasiswa : listMhs) {
            mahasiswa.tampil();
            System.out.println("---------------------------------");
        }
    }
    
    int findSeqSearch (int cari){
        int posisi = -1 ;
            for (int i = 0; i < listMhs.length; i++) {
                if (listMhs[i].nim == cari) {
                    posisi = i;
                    break;
                }
            }
        return posisi;
    }

    void tampilPosisi(int x, int pos){
        if (pos != -1) {
            System.out.println("Data "+x+" Ditemukan Pada Indexs : "+pos);
        } else {
            System.out.println("Data Tidak Ditemukan");
        }
    }

    void tampiData(int x, int pos){
        if (pos!=-1) {
            System.out.println("Nim : "+ listMhs[pos].nim);
            System.out.println("Nama : "+ listMhs[pos].nama);
            System.out.println("Umur : "+ listMhs[pos].umur);
            System.out.println("Ipk : "+ listMhs[pos].ipk);
        } else {
            System.out.println("Data tidak Ditemukan");
        }
    }
}


public class searching {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Scanner scr = new Scanner(System.in);
        PencarianMhs data = new PencarianMhs();
        int jum = 5;

        System.out.println("-------------------------------------------------------------------");
        System.out.println("Masukan data Mahasiswa secara berurutn ");

        for (int i = 0; i < jum; i++) {
            System.out.println("-------------------------");
            System.out.print("Nim\t: ");
            int nim = sc.nextInt();
            System.out.print("Nama\t: ");
            String nama = scr.nextLine();
            System.out.print("Umur\t: ");
            int umur = sc.nextInt();
            System.out.print("Ipk\t: ");
            double ipk = sc.nextDouble();
            Mahasiswa m = new Mahasiswa(nim, nama, umur, ipk);
            data.tambah(m);
        }

        System.out.println("-------------------------------------------------------------------");
        System.out.println("Data Keseluruhan Mahasiswa");
        data.tampil();
        
        System.out.println("-------------------------------------------------------------------");
        System.out.println("-------------------------------------------------------------------");
        System.out.println("Pencarian Data : ");
        System.out.println("Masukan Nim Mahasiswa Yang Dicari");
        System.out.print("Nim : ");
        int cari = sc.nextInt();

        System.out.println("Menggunakan Sequental Search");
        int posisi = data.findSeqSearch(cari);
        data.tampilPosisi(cari, posisi);
        data.tampiData(cari, posisi);
    }
}