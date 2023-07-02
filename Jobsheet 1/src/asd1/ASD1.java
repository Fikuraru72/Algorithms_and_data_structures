/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asd1;

import java.util.Scanner;

public class ASD1 {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);  
        double hasilAkhir = 0;
        
        System.out.println("Progam menghitung nilai akhir");
        System.out.println("=============================");
        
        boolean key = true;
        while (key) {            
            System.out.print("Masukan Nilai Tugas : ");
            int tugas = sc.nextInt();
            if (tugas >= 0 && tugas <= 100 ){
             tugas = tugas * 20/100; 
             hasilAkhir += tugas;
             key = false;   
            }
        } 
        
        boolean key1 = true;
        while (key1) {            
            System.out.print("Masukan Nilai UTS : ");
            int uts = sc.nextInt();
            if (uts >= 0 && uts <= 100 ){
             uts = uts * 35/100;; 
             hasilAkhir += uts;
             key1 = false;   
            }
        }
        
        boolean key2 = true;
        while (key2) {            
            System.out.print("Masukan Nilai UAS : ");
            int uas = sc.nextInt();
            if(uas >=0 && uas <=100){
             uas = uas * 45/100;
             hasilAkhir += uas;
             key2 = false;
            }
        }
        
        System.out.printf("Nilai Akhir : %s\n",hasilAkhir);
        String rate = ""; 
        if(hasilAkhir > 80 && hasilAkhir <= 100){
            rate = "A";
        } else if(hasilAkhir > 73 && hasilAkhir <= 80){
            rate = "B+";        
        } else if(hasilAkhir > 65 && hasilAkhir <= 73){
            rate = "B";
        } else if(hasilAkhir > 60 && hasilAkhir <= 65){
            rate = "C+";
        } else if(hasilAkhir > 50 && hasilAkhir <= 60){
            rate = "C";
        } else if(hasilAkhir > 39 && hasilAkhir <= 50){
            rate = "D";
        } else if(hasilAkhir < 39){
            rate = "D";
        } 
        
        System.out.printf("Nilai Huruf : %s\n",rate);
        System.out.println("=========================");
        
        if (hasilAkhir > 50 && hasilAkhir<=100){
            System.out.println("Selamat Anda Lulus");
        } else if (hasilAkhir <=50 && hasilAkhir >=0){
            System.out.println("Mohon maaf anda tidak lulus");
        }

    }
    
}
