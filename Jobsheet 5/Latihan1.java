import java.util.Scanner;

class Faktorial{
    int nilai ;

    // public int FaktorialBF (int n){
    //     int fakto = 1;
    //     for (int i = 1; i <=n ; i++) {
    //         fakto = fakto* i;
    //     }
    //     return fakto;
    // }

    public int FaktorialBF (int n){
        
        int fakto = 1;
        int i = 1;
        do {
            fakto = fakto* i;
            i++;
        } while (i <= n);
        
        return fakto;
    }

    public int FaktorialDC(int n) {
        if (n==1) {
            return 1;
        } else {
            int fakto = n * FaktorialDC(n-1);
            return fakto;
        }
    }

}

public class Latihan1 {

    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        System.out.println("==========================================");
        System.out.print("Masukan Jumlah Elemen yang akan dihitung : ");
        int elemen = sc.nextInt();
        Faktorial [] fk = new Faktorial[elemen];
        for (int i = 0; i < fk.length; i++) {
            fk[i]=new Faktorial();
            System.out.printf("Masukan Nilai data ke %s : ",i+1);
            fk[i].nilai = sc.nextInt();
        }

        System.out.println("==========================================");
        System.out.println("hasil faktorial dengan Brute Force");
        for (int i = 0; i < fk.length; i++) {
            System.out.println("-------------------------------------------------------");
            long startTime = System.currentTimeMillis();
            System.out.printf("Faktorial Dari Nilai %s adalah %s \n",fk[i].nilai,fk[i].FaktorialBF(fk[i].nilai));
            long endtime = System.currentTimeMillis();
            long elapsedTime= endtime - startTime;
            System.out.println("Waktu yang dibutuhkan : "+String.valueOf(elapsedTime));
            System.out.println("-------------------------------------------------------");

        }

        System.out.println("==========================================");
        System.out.println("hasil faktorial dengan Divide and Conquer");
        for (int i = 0; i < fk.length; i++) {
            System.out.println("-------------------------------------------------------");
            long startTime = System.currentTimeMillis();
            System.out.printf("Faktorial Dari Nilai %s adalah %s \n",fk[i].nilai,fk[i].FaktorialDC(fk[i].nilai));
            long endtime = System.currentTimeMillis();
            long elapsedTime= endtime - startTime;
            System.out.println("Waktu yang dibutuhkan : "+String.valueOf(elapsedTime));
            System.out.println("-------------------------------------------------------");
        }


    }

    
}