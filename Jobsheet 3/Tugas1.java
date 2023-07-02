import java.util.Scanner;
class rumus {
    public double in1;/*sisi miring/ Panjang sisi alas/ jari-jari bola*/
    public double in2;/*jari-jari/  tinggi limas*/

    public double Volume (int x){
        
        if (x==0){
            /*Volume Kerucut*/
            double a = Math.sqrt(Math.pow(in1, 2)+(Math.pow(in2, 2)));
            double b = 1/3 * 3.14 * Math.pow(in2, 2) * a ;
            return b;
        } else if (x == 1){
            /*Volume Limas*/
            return  (in1*in1)*in2 * 1/3;
        } else if (x == 2){
            // volume bola
            return  3.14* Math.pow(in1, 3) * 4/3;
        } else {
            return 9.0;
        }   
    }

    public double LuasPermukaan (int x) {
        if (x==0){
            /*Luas Permukaan Kerucut*/
            return (in2 + in1) * (3.14 * in2) ;
        } else if (x == 1){
            /*Luas PermukaanLimas*/
            Double a = in1 * in2 * 1/2;
            return (in1*in1) + (4 * a);
        } else if (x == 2){
            // luas permukaan bola
            return 4 * 3.15 * Math.pow(in1, 2);
        } else {
            return 9.0;
        }
             
    }
}

public class Tugas1 {
    public static void main(String[] args) {
        String name [] = {
            "Kerucut", "Limas Segi Empat", "Bola"
        };

        String atribut [][] = {
            {"Sisi Miring","Jaring-Jaring"}, {"Panjang Sisi Alas", "Tinggi Limas"}, {"Jari-Jari Bola"}
        };

        Scanner sc = new Scanner(System.in);
        rumus rumusall [] = new rumus [3];

        for(int x =0; x< 3;x++){
            rumusall[x] = new rumus();
           for(int z = 0; z < atribut[x].length; z++) {
            System.out.printf("Masukan Nilai %s %s : ",name[x],atribut[x][z]);
                if(z == 1){
                 rumusall[x].in2 = sc.nextDouble(); 
                } else {
                 rumusall[x].in1 = sc.nextDouble();
                }
           }
           System.out.println("---------------------------------------------------------");
        }

        System.out.println("===================================================================");

        for(int x =0; x<3;x++){
            System.out.printf("Luas Permukaan dari %s adalah %s\n",name[x],rumusall[x].LuasPermukaan(x));        
            System.out.printf("Volume dari %s adalah %s\n",name[x],rumusall[x]. Volume(x));   
            System.out.println("---------------------------------------------------------");     
        }

    }
}
