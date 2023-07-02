import java.util.Scanner;

class Pembeli {
    String nama ;
    int noHp;

    Pembeli (String nama, int noHp){
        this.nama = nama;
        this.noHp = noHp;
    }
}

class MyQueue {
    Pembeli antrian [];
    int front;
    int rear;
    int size;
    int max;

    MyQueue (int n){
        max = n;
        antrian = new Pembeli[max];
        size = 0;
        front = rear = 0;
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

    public void Enqueue (Pembeli dt) {
        if (IsFull()) {
            System.out.println("Datah telah penuh");
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
            antrian[rear] = dt;
            size++;
        }
    }

    public Pembeli Dequeue (){
        Pembeli dt = new pembelian();
        if (IsEmpety()){
            return 0;
        } else {
            dt = antrian[front];
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


    public void Print () {
        if (IsEmpety()) {
            System.out.println("Queue Masih Kosong");
        } else {
            int i = front;
            while (i != rear) {
                System.out.println(antrian[i].nama + " " + antrian[i].noHp);
                i = (i+1) % max;
            }
            System.out.println(antrian[i].nama + " " + antrian[i].noHp);
            System.out.println("Jumlah element = "+ size);
        }
    }

    public void peak (){
        if (!IsEmpety()) {
            System.out.println(antrian[front].nama + " " + antrian[front].noHp);
        } else {
            System.out.println("Queue Masih Kosong");
        }
    }

    public void PeakRear (){
        if (!IsEmpety()) {
            System.out.println(antrian[rear].nama + " " + antrian[rear].noHp);
        } else { 
            System.out.println("Queue Masih Kosong");
        }
    }
    
    public void peekPosition (String InName){
        if (IsEmpety()) {
            System.out.println("Queue Masih Kosong");
        } else {
            int i = front;
            int count = 0;
            while (i != rear) {
                count++;
                if (InName.equalsIgnoreCase(antrian[i].nama)) {
                    System.out.println("Terdapat Pada Antrian = "+ count);
                }
                i = (i+1) % max;
            }
            if (InName.equalsIgnoreCase(antrian[i].nama)) {
                System.out.println("Terdapat Pada Antrian = "+count+1);
            }
        }
    }

}

public class warung {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Scanner scr = new Scanner(System.in);

        System.out.print("Masukan Jumlah Data : ");
        int n = sc.nextInt();
        MyQueue data = new MyQueue(n);

        boolean key = true;
        while (key) {
            System.out.println("=====================================");
            System.out.println("Daftar Menu : ");
            System.out.println("1. Menambahakan Antrian");
            System.out.println("2. Mengurangi Antrian");
            System.out.println("3. Print semua Antrian");
            System.out.println("4. Antrian Teratas");
            System.out.println("5. Antrian Terbelakang");
            System.out.println("6. Cek Posisi Antrian");
            System.out.print("Masukan Inputan : ");
            int in = sc.nextInt();
            if (in == 1) {
                System.out.println("--------------------------");
                System.out.print("Nama : ");
                String nama = scr.nextLine();
                System.out.print("No Hp : ");
                int noHp = sc.nextInt();

                Pembeli dt = new Pembeli(nama, noHp);
                data.Enqueue(dt);
            } else if (in == 2){
                Pembeli dt = data.Dequeue();
                System.out.println("Antrian yang Keluar : ");
                System.out.println(dt);
            } else if (in == 3){
                data.Print();
            } else if (in == 4){
                data.peak();
            } else if (in == 5){
                data.PeakRear();
            } else if (in == 6){
                System.out.print("Masukan Nama : ");
                String InName = scr.nextLine();
                data.peekPosition(InName);
            } else {
                System.out.println("Inputan yang dimasukan salah");
            }
        }

    }
    
}