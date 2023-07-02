import java.util.Scanner;
class DataNasabah {
    String norek, nama, alamat;
    int umur;
    double saldo;

    DataNasabah (String norek, String nama, String alamat, int umur, double saldo){
        this.norek = norek;
        this.nama = nama;
        this.alamat = alamat;
        this.umur = umur;
        this.saldo = saldo;
    }
} 

class NasabahQueue {
    DataNasabah data [];
    int front;
    int rear;
    int size;
    int max;

    public NasabahQueue (int n){
        max= n;
        data = new DataNasabah [max];
        size =0;
        front = rear = -1;
    }

    public boolean IsEmpety (){
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean IsFull (){
        if (size==max) {
            return true;
        } else {
            return false;
        }
    }

    public void peak (){
        if (!IsEmpety()) {
            System.out.println(data[front].norek + " " + data[front].nama
                +" "+ data[front].alamat + data[front].umur + " " + data[front].saldo);
        } else {
            System.out.println("Queue Masih Kosong");
        }
    }

    public void PeakRear (){
        if (!IsEmpety()) {
            System.out.println(data[rear].norek + " " + data[rear].nama
                +" "+ data[rear].alamat + data[rear].umur + " " + data[rear].saldo);
        } else {
            System.out.println("Queue Masih Kosong");
        }
    }

    public void Print () {
        if (IsEmpety()) {
            System.out.println("Queue Masih Kosong");
        } else {
            int i = front;
            while (i != rear) {
                System.out.println(data[i].norek + " " + data[i].nama
                    +" "+ data[i].alamat + data[i].umur + " " + data[i].saldo);
                i = (i+1) % max;
            }
            System.out.println(data[i].norek + " " + data[i].nama
            +" "+ data[i].alamat + data[i].umur + " " + data[i].saldo);
            System.out.println("Jumlah element = "+ size);
        }
    }

    public void clear (){
        if (!IsEmpety()) {
            front = rear = -1;
            size = 0;
            System.out.println("Queue berhasil dikosongkan");
        } else {
            System.out.println("Queue Masih Kosong");            
        }
    }

    public void Enqueue (DataNasabah dt) {
        if (IsFull()) {
            System.out.println("Queue Sudah Penuh");
        } else {
            if (IsEmpety()) {
                front = rear = 0;
            } else {
                if (rear == max - 1) {
                    rear = 0;
                } else {
                    rear++;
                }
            }
            data[rear] = dt;
            size++;
        }
    }

    public DataNasabah Dequeue (){
        DataNasabah dt = new DataNasabah();
        if (IsEmpety()){
            System.out.println("Queue Masih Kosong");
        } else {
            dt = data[front];
            size--;
            if (IsEmpety()) {
                front = rear = -1;
            } else {
                if (front == max -1) {
                     front = 0;
                } else {
                    front++;
                }
            }
        }
        return dt;
    }
}


public class Nasabah {

    static void menu (){
        System.out.println("Pilih menu : ");
        System.out.println("1. Antrian Baru");
        System.out.println("2. Antrian Keluar");
        System.out.println("3. Cek Antrian Terdepan");
        System.out.println("4. Cek Semua Antrian");
        System.out.println("5. Cek Antrian Paling belakang");
        System.out.println("------------------------");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Scanner scr = new Scanner(System.in);
        System.out.print("Masukan Qapasitas Queue : ");
        int Jumlah = scr.nextInt();

        NasabahQueue antri = new NasabahQueue(Jumlah);

        int pilih;
        do {
            menu();
            pilih = scr.nextInt();
            switch (pilih) {
                case 1:
                    System.out.print("No Rekening : ");
                    String norek = sc.nextLine();
                    System.out.print("Nama : ");
                    String nama = sc.nextLine();
                    System.out.print("Alamat : ");
                    String alamat = sc.nextLine();
                    System.out.print("Umur : ");
                    int umur = scr.nextInt();
                    System.out.print("Saldo : ");
                    double saldo = scr.nextDouble();
                    DataNasabah nb = new DataNasabah(norek, nama, alamat, umur, saldo);
                    antri.Enqueue(nb);
                    break;

                case 2 : 
                    DataNasabah data = antri.Dequeue();
                    if (!"".equals(data.norek) && !"".equals(data.nama) && !"".equals(data.alamat)
                        && data.umur != 0 && data.saldo != 0) {
                            
                            System.out.println("Element terdepan : "+data.norek + " " + data.nama
                            +" "+ data.alamat + data.umur + " " + data.saldo);
                        break;
                    }
                
                case 3 : 
                    antri.peak();
                    break;

                case 4 : 
                    antri.Print();
                    break;

                case 5 : 
                    antri.PeakRear();
            }
            
        } while (pilih == 1 || pilih == 2 || pilih == 3 || pilih == 4 || pilih == 5);

    }
    
}
