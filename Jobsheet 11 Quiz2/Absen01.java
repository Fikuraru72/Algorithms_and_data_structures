import java.util.Scanner;

class pelanggan { 
    String nama;
    int noHp;
    pelanggan next, prev;

    pelanggan (pelanggan prev,String nama, int noHp, pelanggan next){
        this.nama = nama;
        this.noHp = noHp;
        this.next = next;
    }
}

class layanan {
    int kodeLayanan;
    String namaLayanan;
    int Harga;
    layanan next, prev;

    layanan (layanan prev, int kodeLayanan, String namaLayanan, int Harga, layanan next){
        this.kodeLayanan=kodeLayanan;
        this.namaLayanan=namaLayanan;
        this.Harga=Harga;
        this.next=next;
    }
}

class Data {

    pelanggan headPelanggan;
    layanan headLayanan;
    int sizePelanggan ;
    int sizeLayanan;
    int pemasukan;

    Data(){
        headPelanggan = null;
        headLayanan = null;
        sizePelanggan = 0;
        sizeLayanan = 0;
        pemasukan = 0;
    }

// Algoritma Pelanggan
    boolean isEmpetyPelanggan (){
       return  headPelanggan == null;
    }

    void addPelanggan (String nama, int noHp){
        headPelanggan = new pelanggan(null, nama, noHp, null);
        sizePelanggan++;
    }

    void addLastPelanggan (String nama, int noHp){
        if (headPelanggan==null) {
            addPelanggan(nama, noHp);
        } else {
            pelanggan tail = headPelanggan;
            while (tail.next != null) {
              tail = tail.next;
            }
            pelanggan temp = new pelanggan(tail, nama, noHp, null);
            tail.next = temp;
            sizePelanggan++;
        }
    }

    void removePelanggan (){                
        System.out.println("------------------------------------------");
        System.out.println("Nama : "+headPelanggan.nama);
        System.out.println("NoHp : "+headPelanggan.noHp);
        System.out.println("------------------------------------------");
        headPelanggan = headPelanggan.next;
        headPelanggan.prev = null;
        sizePelanggan--;
    }

    void printPelanggan ()throws Exception{
        if (isEmpetyPelanggan()) {
            throw new Exception("Data Masih Kosong");
        } else {
            pelanggan temp = headPelanggan;
            System.out.println("------------------------------------------");
            System.out.println("--------------Antrian Pelanggan-----------");
            while (temp != null) {
                System.out.println("------------------------------------------");
                System.out.println("Nama : "+temp.nama);
                System.out.println("NoHp : "+temp.noHp);
                temp = temp.next;
            }
        } 
    }


// Algoritma Layanan
    boolean isEmpetyLayanan (){
        return headLayanan == null;
    }

    void addLayanan (int kodeLayanan, String namaLayanan, int Harga){
        headLayanan = new layanan(null, kodeLayanan, namaLayanan, Harga, null);
        sizeLayanan++;
        pemasukan += Harga;
    }

    void addLastLayanan (int kodeLayanan, String namaLayanan, int Harga){   
        if (headLayanan == null) {
            addLayanan(kodeLayanan, namaLayanan, Harga);
        } else {
            layanan tail = headLayanan;
            while (tail.next != null) {
                tail = tail.next;
            }
            layanan temp = new layanan(tail, kodeLayanan, namaLayanan, Harga, null);
            tail.next = temp;
            sizeLayanan++;
            pemasukan += Harga;
        }
    } 

    void printLayanan () throws Exception{
        if (isEmpetyLayanan()) {
            throw new Exception("Data Masih Kosong");
        } else {
            layanan temp = headLayanan;
            System.out.println("------------------------------------------");
            System.out.println("--------------Antrian Layanan-------------");
            while (temp != null) {
                System.out.println("------------------------------------------");
                System.out.println("Nomor Layanan\t : "+temp.kodeLayanan);
                System.out.println("Nama Layanan\t : "+temp.namaLayanan);
                System.out.println("Harga Layanan\t : "+temp.Harga);
                temp = temp.next;
            }
        }
    }

    void laporan (){
        System.out.println("------------------------------------------");
        System.out.println("Banyak Layanan\t\t : "+sizeLayanan);
        System.out.println("Banyak Pemasukan\t : "+pemasukan);
    }
}

public class Absen01 {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in); /*int*/
        Scanner scr = new Scanner(System.in); /*String*/
        Data dt = new Data();
        int kodeLayanan = 100;

        boolean key = true;
        while (key) {
            System.out.println("==========================================");
            System.out.println("==============Bengkel Mobil===============");
            System.out.println("==========================================");
            System.out.println("1. Tambah Antrian");
            System.out.println("2. Cetak Antrian");
            System.out.println("3. Hapus Antrian");
            System.out.println("4. Laporan Layanan");
            System.out.print("Masukan Input (1-4): ");
            int in = sc.nextInt();
            if (in == 1) {
                
                Boolean key2 = true;
                while (key) {
                    System.out.print();
                }

                System.out.print("Nama : ");
                String nama = scr.nextLine();
                System.out.print("NoHp : ");
                int noHp = sc.nextInt();
                dt.addLastPelanggan(nama, noHp);
            } else if (in == 2){
                dt.printPelanggan();
            } else if (in == 3) {
                dt.removePelanggan();
                System.out.println("Kode Layanan : "+kodeLayanan);
                System.out.print("Nama Layanan : ");
                String namaLayanan = scr.nextLine();
                System.out.print("Harga Layanan : ");
                int Harga = sc.nextInt();
                dt.addLastLayanan(kodeLayanan, namaLayanan, Harga);
                kodeLayanan++;
            } else if(in == 4){
                dt.printLayanan();
                dt.laporan();
            }

        }

    }
    
}