import java.util.Scanner;
class persegiPanjang {
    public int panjang ;
    public int lebar ;
}

public class latihan1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);

       System.out.print("Masukan Jumlah Mahasiswa : ");
       int in = sc.nextInt();
       persegiPanjang [] array = new persegiPanjang[in];

        
        for(int a = 0; a < 3 ; a++){
            array[a] = new persegiPanjang();
            array[0] = new persegiPanjang();
            System.out.println("Persegi Panjang ke-"+(a+1));
            System.out.print("Masukan Panjang : ");
            array[a].panjang = sc.nextInt();
            System.out.print("Masukan Lebar : ");
            array[a].lebar = sc.nextInt();
        }

        for(int x = 0 ; x < 3; x++){
            System.out.printf("Persegi Panjang ke-%s, panjang : %s, Lebar : %s \n",x,array [x].panjang,array [x].lebar);
        
        }

        // array [0] = new persegiPanjang();
        // array [0].panjang = 110;
        // array [0].lebar = 30;

        // array [1] = new persegiPanjang();
        // array [1].panjang = 80;
        // array [1].lebar = 40;

        // array [2] = new persegiPanjang();
        // array [2].panjang = 110;
        // array [2].lebar = 20;

        // System.out.printf("Persegi Panjang ke-0, panjang : %s, Lebar : %s \n",array [0].panjang,array [0].lebar);
        // System.out.printf("Persegi Panjang ke-1, panjang : %s, Lebar : %s \n",array [1].panjang,array [1].lebar);
        // System.out.printf("Persegi Panjang ke-2, panjang : %s, Lebar : %s \n",array [2].panjang,array [2].lebar);


            

    }
}


