import java.util.Scanner;

class TheQueue {
    int data [];
    int front;
    int rear;
    int size;
    int max;

    public TheQueue (int n){
        max= n;
        data = new int [max];
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
            System.out.println("Element terdepan : "+data[front]);
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
                System.out.println(data[i]+" ");
                i = (i+1) % max;
            }
            System.out.println(data[i]+" ");
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

    public int Enqueue (int dt) {
        if (IsFull()) {
            return 0;
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
            return 1;
        }
    }

    public int Dequeue (){
        int dt = 0;
        if (IsEmpety()){
            return 0;
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

public class Queue {

    public static void menu (){
        System.out.println("Masukan Operasi Yang Digunakan : ");
        System.out.println("1. Enqueue");
        System.out.println("2. Dequeue");
        System.out.println("3. Print");
        System.out.println("4. Peek");
        System.out.println("5. Clear");
        System.out.println("---------------");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Masukan Kapasistas Queue : ");
        int n = sc.nextInt();
        TheQueue Q = new TheQueue(n);
        
        int pilih;
        do {
            menu();
            pilih = sc.nextInt();
            switch (pilih) {
                case 1:
                    System.out.print("Masukan Data baru : ");
                    int dataMasuk = sc.nextInt();
                    int hasil = Q.Enqueue (dataMasuk);
                    if (hasil == 0) {
                        System.out.println("Data Telah Penuh");
                        pilih = 0;
                    }
                    break;
                
                case 2 :
                    int dataKeluar =  Q.Dequeue();
                    if (dataKeluar != 0) {
                        System.out.println("Data Yang Dikeluarkan : " + dataKeluar);
                    } else {
                        pilih = 0;
                    }
                    break;
                
                case 3 : 
                    Q.Print();
                    break;
                
                case 4 : 
                    Q.peak();
                    break;
                
                case 5 : 
                    Q.clear();
                    break;
            }
            
        } while (pilih == 1 || pilih == 2 || pilih == 3 || pilih == 4 || pilih == 5);
    }
    
}