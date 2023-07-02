package Tugas;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Comparator;


class Matkul implements Comparable<Matkul> {
    int kode;
    String nama;
    int sks;
    Double nilai;

    public Matkul(){

    }

    public Matkul(int kode, String nama, int sks) {
        this.kode = kode;
        this.nama = nama;
        this.sks = sks;
    }

    public Matkul(int kode, String nama, int sks, double nilai) {
        this.kode = kode;
        this.nama = nama;
        this.sks = sks;
        this.nilai = nilai;
    }

    @Override
    public int compareTo(Matkul other) {
        return Integer.compare(this.kode, other.kode);
    }
}

class LinkedListMatkul<E> {
    List<Matkul> matkuls = new ArrayList<>();

    public void tambah(Matkul... tambah) {
        matkuls.addAll(Arrays.asList(tambah));
    }

    public void tambahNilai(int kode, Double nilai) {
        Matkul key = new Matkul(kode, "", 0);
        int index = Collections.binarySearch(matkuls, key);
        if (index >= 0) {
            Matkul current = matkuls.get(index);
            current.nilai = nilai;
            matkuls.set(index, current);
        }
    }
    

    public void print() {
        System.out.println("DAFTAR MATA KULIAH");
        System.out.println("***********************************************");
        System.out.println("Kode\t\t\t" + "Nama\t\t\t" + "Sks\t\t\t");
        for (Matkul matkul : matkuls) {
            System.out.printf(matkul.kode + "\t\t\t" + matkul.nama + "\t\t\t" + matkul.sks);
            System.out.println();
        }
    }

    public void mtk(){
        Matkul mtk = new Matkul();
    }
}

class Mahasiswa implements Comparable<Mahasiswa> {
    int nim;
    String nama;
    String noTlpn;

    LinkedListMatkul linkMatkul = new LinkedListMatkul();

    public Mahasiswa(int nim, String nama, String noTlpn) {
        this.nim = nim;
        this.nama = nama;
        this.noTlpn = noTlpn;
        TambahMatkul();
    }

    public void TambahMatkul() {
        Matkul Tambah1 = new Matkul(1, "Internet Of Things", 3);
        Matkul Tambah2 = new Matkul(2, "Algoritma Dan Struktur Data", 3);
        Matkul Tambah3 = new Matkul(3, "Algoritma Dan Pemerogaman", 2);
        Matkul Tambah4 = new Matkul(4, "Praktikum Algoritma Dan Struktur Data", 2);
        Matkul Tambah5 = new Matkul(5, "Praktikum Algoritma Dan Pemerogaman", 3);

        linkMatkul.tambah(Tambah1, Tambah2, Tambah3, Tambah4, Tambah5);
    }

    public void isiNilai(int kode, double nilai) {
        linkMatkul.tambahNilai(kode, nilai);
    }

    @Override
    public int compareTo(Mahasiswa other) {
        return Integer.compare(this.nim, other.nim);
    }

    public void PrintMatkul() {
        linkMatkul.print();
    }

    public int getNim() {
        return nim;
    }
}

class LinkedListMahasiswa {
    List<Mahasiswa> mahasiswas = new ArrayList<>();

    public void tambahMhs(Mahasiswa... mhs) {
        mahasiswas.addAll(Arrays.asList(mhs));
    }

    public void SortByNim() {
        mahasiswas.sort(Comparator.comparingInt(Mahasiswa::getNim));
    }

    public int searchMhs(int nim) {
        SortByNim();
        Mahasiswa key = new Mahasiswa(nim, "", "");
        int index = Collections.binarySearch(mahasiswas, key, Comparator.comparingInt(Mahasiswa::getNim));
        return index;
    }

    public void nilai(int nim, double nilai) {
        int index = searchMhs(nim);
        if (index >= 0) {
            Mahasiswa mahasiswa = mahasiswas.get(index);
            mahasiswa.PrintMatkul();
            Scanner sc = new Scanner(System.in);
            int kode = sc.nextInt();
            mahasiswa.isiNilai(kode, nilai);
        }
    }

    public void printMhas() {
        System.out.println("DAFTAR MAHASISWA");
        System.out.println("***********************************************");
        System.out.println("Nim\t\t\tNama\t\t\tTelf");
        for (Mahasiswa mahasiswa : mahasiswas) {
            System.out.println(mahasiswa.nim + "\t\t\t" + mahasiswa.nama + "\t\t" + mahasiswa.noTlpn);
        }
    }

    public void DaftarNilai (){
        System.out.println("DAFTAR MAHASISWA");
        System.out.println("***********************************************");
        System.out.println("Nim\t\t\tNama\t\t\tMata Kuliah\t\tSKS\t\tNilai");
        for (Mahasiswa mahasiswa : mahasiswas) {
            System.out.println(mahasiswa.nim + "\t\t\t" + mahasiswa.nama + "\t\t" + mahasiswa.linkMatkul.matkuls.get(index));
        }
    }
}

public class NilaiMahasiswa {
    public static void main(String[] args) {
        LinkedListMahasiswa llm = new LinkedListMahasiswa();
        Scanner angka = new Scanner(System.in);
        Scanner huruf = new Scanner(System.in);

        Mahasiswa mh1 = new Mahasiswa(20001, "Thalhah", "021xxx");
        Mahasiswa mh2 = new Mahasiswa(20002, "Zhubair", "021xxx");
        Mahasiswa mh3 = new Mahasiswa(20003, "Abdul_Rahman", "021xxx");
        Mahasiswa mh4 = new Mahasiswa(20004, "Sa'Ad", "021xxx");
        Mahasiswa mh5 = new Mahasiswa(20005, "Sa 'Id", "021xxx");
        Mahasiswa mh6 = new Mahasiswa(20006, "Ubaidah", "021xxx");

        llm.tambahMhs(mh1, mh2, mh3, mh4, mh5, mh6);

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
            System.out.println("5. Keluar");
            System.out.println("***********************************************");
            System.out.print("Pilih\t: ");
            int in = angka.nextInt();
            if (in == 1) {
                System.out.print("Masukan Nilai : ");
                Double nilai = angka.nextDouble();
                llm.printMhas();
                System.out.print("Pilih Mahasiswa By Nim : ");
                int nim = angka.nextInt();
                llm.nilai(nim, nilai);
            } else if (in == 2) {

            } else if (in == 3) {
                
            } else if (in==4) {
                
            } else if (in == 5) {
              key = false;
            }
        }
    }
}
