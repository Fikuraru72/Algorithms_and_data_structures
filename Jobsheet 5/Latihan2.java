import java.util.Scanner;

class pangkat {
    int nilai[],pangkat[];

    pangkat(int elemen){
        this.nilai = new int[elemen];
        this.pangkat = new int [elemen];
    }

    int pangkatBF(int a, int n){
        int hasil = 1;
        for (int i = 0; i < n; i++) {
            hasil = hasil * a;
        }
        return hasil;
    }

    int pangkatDC (int a, int n){
        if (n==0) {
            return 1;
        } else {
            if (n%2==1) {
                return (pangkatDC(a, n/2)*pangkatDC(a, n/2)*a);
            } else {
                return (pangkatDC(a, n/2)*pangkatDC(a, n/2));
            }
        }
    }
}

public class Latihan2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("==============================");
        System.out.print("Masukan jumlah elemen yang ingin dihitung : ");
        int elemen = sc.nextInt();

        pangkat pgk = new pangkat(elemen);
        // pangkat [] pgk = new pangkat[elemen];

        
        for (int i = 0; i < elemen; i++) {
            System.out.printf("Masukan nilai yang akan dipangkatkan ke %s : ",i+1);
            pgk.nilai[i] = sc.nextInt();
            System.out.printf("Masukan nilai pemangkat ke %s : ",i+1);
            pgk.pangkat[i] =sc.nextInt();
        }

        System.out.println("==============================");
        boolean key = true;
        while (key) {
            System.out.println("Pilih Menu Penyelesaian :");
            System.out.println("1. Brute Force");
            System.out.println("2. Divide Conquer ");
            System.out.print("Pilih Menu : ");
            int in = sc.nextInt();
            
            if (in == 1) {
                System.out.println("==============================");
                System.out.println("Hasil Pangkat Dengan Brute Force ");
                for (int i = 0; i < elemen; i++) {
                    System.out.printf("Nilai %s pangkat %s adalah : %s \n", pgk.nilai[i], pgk.pangkat[i], pgk.pangkatBF(pgk.nilai[i], pgk.pangkat[i]));
                }
            } else if(in == 2) {
                System.out.println("==============================");
                System.out.println("Hasil Pangkat Dengan Divide and Conquer ");
                for (int i = 0; i < elemen; i++) {
                    System.out.printf("Nilai %s pangkat %s adalah : %s \n", pgk.nilai[i], pgk.pangkat[i], pgk.pangkatDC(pgk.nilai[i], pgk.pangkat[i]));
                }
                System.out.println("==============================");
            }
        }

        

        
    }

}
