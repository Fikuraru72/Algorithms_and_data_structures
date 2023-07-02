import java.util.Scanner;

class sum {
    int elemen;
    double keuntungan[];
    double total;

    sum(int elemen){
        this.elemen = elemen;
        this.keuntungan = new double[elemen];
        this.total = 0;
    }

    double totalBf(double arr[]){
        for (int i = 0; i < elemen; i++) {
            total = total +arr[i];
        }
        return total;
    }

    double totalDC (double arr[], int l, int r){
        if (l==r) {
            return arr[l];
        } else if (l<r) {
            int mid = (l+r)/2;
            double lsum = totalDC(arr, l, mid-1);
            double rsum = totalDC(arr, mid+1, r);
            return lsum+rsum+arr[mid];
        }
        return 0;
    }
}

public class Latihan3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=============================================");
        System.out.println("Progam Menghitung Keuntungan Total (SatuanJuta, Misal 1,5)");
        System.out.print("Masukan Jumlah Perusahaan : ");
        int elemen = sc.nextInt();
        System.out.print("Masukan Jumlah Bulan : ");
        int elemen2 = sc.nextInt();

        // sum sm = new sum(elemen);

        sum [] sm = new sum[elemen];
        System.out.println("=============================================");
        for (int i = 0; i < elemen; i++) {
            sm[i] = new sum(elemen2);
            System.out.println("Masukan Hasil Keuntungan Perusahaan "+(i+1));
            for (int j = 0; j < elemen2; j++) {
                System.out.printf("Masukan Untung Bulan %s : ",j+1);
                sm[i].keuntungan[j] = sc.nextDouble();
            }
            System.out.println("-------------------------------------------");
        }

        System.out.println("============================================");
        System.out.println("Algoritma Brute Force");
        for (int i = 0; i < elemen; i++) {
            System.out.printf("Total keuntungan perusahaan %s selama %s bulan adalah : %.2f \n",i+1, sm[i].elemen,sm[i].totalBf(sm[i].keuntungan));
        }
        
        System.out.println("Algoritma Divide Conquer");
        for (int i = 0; i < elemen; i++) {
            System.out.printf("Total keuntungan perusahaan %s selama %s bulan adalah : %.2f \n",i+1, sm[i].elemen,sm[i].totalDC(sm[i].keuntungan, 0, sm[i].elemen-1));
        }
        
    }
}
