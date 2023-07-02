package Soal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

// Class Nilai 
class Nilai implements Comparable<Nilai> {
    int indexMhs;
    int indexMatkul;
    double nilai;

    public Nilai(){

    }

    public Nilai(int mhs, int matkul, double nilai){
        this.indexMatkul = matkul;
        this.indexMhs = mhs;
        this.nilai = nilai;
    }

    @Override
    public int compareTo(Nilai Other){
        return Double.compare(this.nilai, Other.nilai);
    }

    public double GetNilai (){
        return nilai;
    }

}

// Class Array List Nilai
class LinkedListNilai {
    List<Nilai> nilais = new ArrayList<>();

    // Tambah Nilai
    public void add (Nilai current){
        nilais.add(current);
    }

    // hitung panjang array 
    public int sum (){
        return nilais.size();
    }

    // Cari Mhs
    public int [] cariMhs (int key){
        int temp [] = new int [sum()];
        
        for (int i = 0; i < sum(); i++) {
            if (nilais.get(i).indexMhs == key ) {
                System.out.println("hay");        
                temp[i] = nilais.indexOf(nilais.get(i));
            }
        }
        return temp;
    }

    // Hapus Nilai
    public void removeQueue (){
        nilais.remove(0);
    }

    // Sorting Nilai
    public void sorting (){
        Collections.sort(nilais, Comparator.comparing(Nilai::GetNilai));
    }

}

// Class Mata Kuliah
class Matkul implements Comparable<Matkul>{
    int kode;
    String nama;
    int sks;

    public Matkul(){

    }

    public Matkul(int kode, String nama, int sks) {
        this.kode = kode;
        this.nama = nama;
        this.sks = sks;
    }

    public Matkul(int kode){
        this.kode = kode;
    }

    @Override
    public int compareTo(Matkul other) {
        return Integer.compare(this.kode, other.kode);
    }

    public int GetKode(){
        return kode;
    }
}

// Class Array List MataKuliah
class LinkedListMatkul {
    List<Matkul> matkuls = new ArrayList<>();

    // Tambah MataKuliah
    public void addMatkul (Matkul...matkul){
        matkuls.addAll(Arrays.asList(matkul));
    }

    // Print Daftar MAtaKuliah
    public void print (){
        System.out.println("DAFTAR MATA KULIAH");
        System.out.println("***********************************************");
        System.out.printf("%-5s %-50s %-30s\n","Kode","Nama", "Sks");
        for (Matkul matkul : matkuls) {
            System.out.printf("%-5s %-50s %-30s\n",matkul.kode, matkul.nama, matkul.sks);
        }
    }

    // Mencari MataKuliah
    public int SearchMatkul (int key){
        Matkul kunci = new Matkul(key);
        Collections.sort(matkuls, Comparator.comparingInt(Matkul::GetKode));
        return Collections.binarySearch(matkuls, kunci, Comparator.comparingInt(Matkul::GetKode));
    }

}

// Class Mahasiswa
class Mahasiswa implements Comparable<Mahasiswa> {
    int nim;
    String nama;
    String noTlpn;

    public Mahasiswa(int nim, String nama, String noTlpn) {
        this.nim = nim;
        this.nama = nama;
        this.noTlpn = noTlpn;
    }

    @Override
    public int compareTo(Mahasiswa other) {
        return Integer.compare(this.nim, other.nim);
    }
    public int getNim() {
            return nim;
    }


}

// Class Array List Mahasiswa
class LinkedListMahasiswa {
    List<Mahasiswa> mahasiswas = new ArrayList<>();

    // Tambah Data Mahasiswa
    public void addMahasiswa (Mahasiswa...mahasiswa){
        mahasiswas.addAll(Arrays.asList(mahasiswa));
    }

    // Menampilkan Daftar Mahasiswa
    public void print (){
        System.out.println("DAFTAR MAHASISWA");
        System.out.println("***********************************************");
        System.out.printf("%-15s %-15s %-15s\n","Nim","Nama","Telf");
        for (Mahasiswa mahasiswa : mahasiswas) {
            System.out.printf("%-15s %-15s %-15s\n",mahasiswa.nim , mahasiswa.nama , mahasiswa.noTlpn);
        }
    }

    // Sorting by Nim
    public void SortByNim() {
        mahasiswas.sort(Comparator.comparingInt(Mahasiswa::getNim));
    }

    // Mencari Mahasiswa
    public int searchMhs(int nim) {
        SortByNim();
        Mahasiswa key = new Mahasiswa(nim, "", "");
        int index = Collections.binarySearch(mahasiswas, key, Comparator.comparingInt(Mahasiswa::getNim));
        return index;
    }

}

// Class Utama
public class Soal1 {
    public static void main(String[] args) {
        Scanner angka = new Scanner(System.in);

        // Instansiasi Class
        LinkedListMahasiswa mhs = new LinkedListMahasiswa();
        LinkedListMatkul matkul = new LinkedListMatkul();
        LinkedListNilai nilai = new LinkedListNilai();

        // Input Data Mahasiswa
        Mahasiswa mh1 = new Mahasiswa(20001, "Thalhah", "021xxx");
        Mahasiswa mh2 = new Mahasiswa(20002, "Zhubair", "021xxx");
        Mahasiswa mh3 = new Mahasiswa(20003, "Abdul_Rahman", "021xxx");
        Mahasiswa mh4 = new Mahasiswa(20004, "Sa'Ad", "021xxx");
        Mahasiswa mh5 = new Mahasiswa(20005, "Sa 'Id", "021xxx");
        Mahasiswa mh6 = new Mahasiswa(20006, "Ubaidah", "021xxx");
        mhs.addMahasiswa(mh1,mh2,mh3,mh4,mh5,mh6);

        // Input data Mata Kuliah
        Matkul mtk1 = new Matkul(1, "Internet Of Things", 3);
        Matkul mtk2 = new Matkul(2, "Algoritma Dan Struktur Data", 3);
        Matkul mtk3 = new Matkul(3, "Algoritma Dan Pemerogaman", 2);
        Matkul mtk4 = new Matkul(4, "Praktikum Algoritma Dan Struktur Data", 2);
        Matkul mtk5 = new Matkul(5, "Praktikum Algoritma Dan Pemerogaman", 3);
        matkul.addMatkul(mtk1,mtk2,mtk3,mtk4,mtk5);

        // Menu Utama
        boolean key = true;
        while (key) {
            System.out.println("***********************************************");
            System.out.println("SISTEM PENGOLAHAN DATA NILAI MAHASISWA SEMESTER");
            System.out.println("***********************************************");
            System.out.println();
            System.out.println("1. Input Nilai");
            System.out.println("2. Tampil Nilai");
            System.out.println("3. Mencari Nilai Mahasiswa");
            System.out.println("4. Urut Data Nilai");
            System.out.println("5. Hapus Nilai");
            System.out.println("6. Kembali");
            System.out.println("***********************************************");
            System.out.print("Pilih\t: ");
            int in = angka.nextInt();

            // Fitur Input Nilai
            if (in == 1) {
                // Input Nim MAhasiswa
                System.out.println();
                mhs.print();
                System.out.print("Pilih Mahasiswa By Nim : ");
                int innim = angka.nextInt();
                int indexmhs = mhs.searchMhs(innim);

                // Input Kode Mata Kuliah
                matkul.print();
                System.out.print("Pilih Mata Kuliah : ");
                int inKode = angka.nextInt();
                int indexMatkul = matkul.SearchMatkul(inKode);
                System.out.println("------------------------------------------");

                // Input Nilai Mahasiswa
                System.out.print("Masukan Nilai : ");
                Double inNilai = angka.nextDouble();
                Nilai current = new Nilai(indexmhs, indexMatkul, inNilai);
                nilai.add(current);
                
                
                
            } else if (in == 2) { /*Menampilkan Semua Nilai Mahsiswa*/
                System.out.println();
                System.out.println("DAFTAR MAHASISWA");
                System.out.println("***********************************************");
                System.out.printf("%-10s %-10s %-30s %-10s %-10s\n","Nim","Nama","Mata Kuliah","SKS","Nilai");

                
                for (int i = 0; i < nilai.sum(); i++) {
                    System.out.printf("%-10s %-10s %-30s %-10s %-10s\n",mhs.mahasiswas.get(nilai.nilais.get(i).indexMhs).nim, mhs.mahasiswas.get(nilai.nilais.get(i).indexMhs).nama,
                        matkul.matkuls.get(nilai.nilais.get(i).indexMatkul).nama,matkul.matkuls.get(nilai.nilais.get(i).indexMatkul).sks,nilai.nilais.get(i).nilai );
                }

            } else if (in == 3) { /*Menampilkan Nilai Mahsiswa Tertentu*/
                    // Input Nim Mahasiswa
                    System.out.println();
                    System.out.println("Daftar Nilai Mahasiswa");
                    System.out.println("***********************************************");
                    mhs.print();
                    System.out.print("Pilih Mahasiswa By Nim : ");
                    int innim = angka.nextInt();

                    // Mencari Nilai Mahasiswa
                    int indexmhs = mhs.searchMhs(innim);
                    int temp [] = nilai.cariMhs(indexmhs);
                    int sumSKS = 0;
                    System.out.printf("%-10s %-10s %-30s %-10s %-10s\n","Nim","Nama","Mata Kuliah","SKS","Nilai");
                    for (int i = 0; i < temp.length; i++) {
                        System.out.printf("%-10s %-10s %-30s %-10s %-10s\n",mhs.mahasiswas.get(nilai.nilais.get(temp[i]).indexMhs).nim, mhs.mahasiswas.get(nilai.nilais.get(temp[i]).indexMhs).nama,
                        matkul.matkuls.get(nilai.nilais.get(temp[i]).indexMatkul).nama,matkul.matkuls.get(nilai.nilais.get(temp[i]).indexMatkul).sks,nilai.nilais.get(temp[i]).nilai );
                        sumSKS += matkul.matkuls.get(nilai.nilais.get(temp[i]).indexMatkul).sks; /*Hitung Sks Mahasiswa*/
                    }
                    System.out.println("Total SKS yang diambil sebanyak "+sumSKS);



            } else if (in==4) { /*Mengurutkan Nilai Mahasiswa*/
                System.out.println();
                nilai.sorting();
                System.out.printf("%-10s %-10s %-30s %-10s %-10s\n","Nim","Nama","Mata Kuliah","SKS","Nilai");
                for (int i = 0; i < nilai.sum(); i++) {
                    System.out.printf("%-10s %-10s %-30s %-10s %-10s\n",mhs.mahasiswas.get(nilai.nilais.get(i).indexMhs).nim, mhs.mahasiswas.get(nilai.nilais.get(i).indexMhs).nama,
                    matkul.matkuls.get(nilai.nilais.get(i).indexMatkul).nama,matkul.matkuls.get(nilai.nilais.get(i).indexMatkul).sks,nilai.nilais.get(i).nilai );
                }

            } else if (in == 5) { /*Menghapus Nilai Mahasiswa Dengan Algoritma Queue*/
              nilai.removeQueue();

            } else if (in == 6) { /*Memberhentikan perulangan (Keluar)*/
                key = false;
            }
        }

    }
}
