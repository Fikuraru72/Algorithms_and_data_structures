/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asd1;

import java.util.Scanner;

public class ASDTugas2 {
    
    static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        boolean key = true;
        while (key) {  
            System.out.println("===================================");
            System.out.println("Progam Hitung Kecepatan/Jarak/Waktu");
            System.out.println("===================================");
            System.out.println("1. Kecepatan");
            System.out.println("2. Jarak");
            System.out.println("3. Waktu");
            System.out.println("----------------");
            System.out.print("Pilih Menu : ");
            int in = sc.nextInt(); 
            if (in == 1) {
                System.out.print("Masukan Jarak (M) : ");
                double jarak = sc.nextDouble();
                System.out.print("Masukan Waktu (S):  ");
                double waktu = sc.nextDouble();
                System.out.println("Hasil perhitungan Kecepatan "+KecWat(jarak, waktu));
            } else if (in == 2){
                System.out.print("Masukan Kecepatan(M/S) : ");
                double kecepatan = sc.nextDouble();
                System.out.print("Masukan Waktu(S) :  ");
                double waktu = sc.nextDouble();
                System.out.println("hasil Perhitungan Jarak "+jarak(waktu, kecepatan));
            } else if (in == 3){
                System.out.print("Masukan Jarak(M) : ");
                double jarak = sc.nextDouble();
                System.out.print("Masukan Kecepatan(M/S) :  ");
                double kecepatan = sc.nextDouble();
                System.out.println("hasil Perhitungan Waktu "+KecWat(jarak, kecepatan));
            } else {
                System.out.println("Menu yang anda masukan salah");
            }
        }
        
    }
    
    static double KecWat (double a, double b){
        double total = a/b;
        return total;
    }
    
    static double jarak (double a, double b) {
        double total = a*b;
        return total;
    }
}
