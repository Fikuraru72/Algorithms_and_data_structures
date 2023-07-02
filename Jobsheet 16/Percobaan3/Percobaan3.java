package Percobaan3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.lang.Comparable;



class Mahasiswa implements Comparable<Mahasiswa>{
    String nim;
    String nama;
    String notelp;
    
    public Mahasiswa (){

    }

    public Mahasiswa (String nim, String nama, String notelp){
        this.nim = nim;
        this.nama = nama;
        this.notelp = notelp;
    }

    @Override
    public String toString() {
        return "Mahasiswa{" + "Nim = " + nim + ", Nama = "+ nama + ", NoTelp = "+ notelp+ "}";
    }

    public Mahasiswa (String Nim){
        this.nim = Nim;
    } 

    public int compareTo(Mahasiswa other){
         return this.nim.compareTo(other.nim);
    }


}

class ListMahasiswa {
    List<Mahasiswa> mahasiswas = new ArrayList<>();

    public void tambah(Mahasiswa...mahasiswa){
        mahasiswas.addAll(Arrays.asList(mahasiswa));
    }

    public void hapus(int index){
        mahasiswas.remove(index);
    }

    public void update (int index, Mahasiswa mhs) {
        mahasiswas.set(index, mhs);
    }

    public void tampil () {
        mahasiswas.stream().forEach(mhs -> {
            System.out.println("" + mhs.toString());});
    }

    int linearSearch(String nim){
        for (int i = 0; i < mahasiswas.size(); i++) {
            if (nim.equals(mahasiswas.get(i).nim)) {
                return i;
            }
        }
        return -1;
    }

    public int BinarySearch (String nim){
        
        Collections.sort(mahasiswas);

        Mahasiswa key = new Mahasiswa(nim);

        int index = Collections.binarySearch(mahasiswas, key);
        
        return index;
    }

    public void sort(){

        System.out.println("Sorting by Nim");
        System.out.println();
        System.out.println("Ascending");
        mahasiswas.sort(Comparator.naturalOrder());
        for (Mahasiswa mm : mahasiswas) {
            System.out.println("Nim :" + mm.nim);
            System.out.println("Nama :" + mm.nama);
            System.out.println("NoTlp :" + mm.notelp);
            System.out.println("========================");
        }
        System.out.println();
        System.out.println("Descending");
        mahasiswas.sort(Comparator.naturalOrder());
        for (Mahasiswa mm : mahasiswas) {
            System.out.println("Nim :" + mm.nim);
            System.out.println("Nama :" + mm.nama);
            System.out.println("NoTlp :" + mm.notelp);
            System.out.println("========================");
        }
    }
}

public class Percobaan3 {
 public static void main(String[] args) {
    ListMahasiswa lm = new ListMahasiswa();

    Mahasiswa m = new Mahasiswa("201234", "Noureen", "021xx1");
    Mahasiswa m1 = new Mahasiswa("201235", "Akhleema", "021xx2");
    Mahasiswa m2 = new Mahasiswa("201236", "Shannum", "021xx3");

    lm.tambah(m, m1, m2);

    lm.tampil();

    lm.update(lm.linearSearch("201235"), new Mahasiswa("201235", "Akhleema Lela", "021xx2"));
    System.out.println();
    lm.tampil();

    System.out.println("Mahasiswa dengan Nim : 201234 berada di index : "+lm.BinarySearch("201236"));
    
    System.out.println();
    lm.sort();

 }   
}
