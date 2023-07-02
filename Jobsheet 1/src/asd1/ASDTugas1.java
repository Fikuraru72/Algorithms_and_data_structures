/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asd1;

import java.util.Scanner;

public class ASDTugas1 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean key = true;
        int penHar = 0;
        while (key) {            
            System.out.println("Jasa cuci pakaian Smile Laundry");
            System.out.println("===============================");
            System.out.print("Masukan Berat pakaian : ");
            int brt = sc.nextInt();
            int total = brt * 4500;
            System.out.println("Biya Rp."+total);
            if (brt >= 10){
                int disc = total * 5/100;
                System.out.println("Diskon Rp."+disc);
                total = total - disc;
            }
            System.out.println("Total Rp."+total);
            penHar += total ;
            
            System.out.println("Melanjutkan Transaksi ? (Y/N)");
            String in = sc.next();
            if (in.equalsIgnoreCase("y")) {
                
            } else if (in.equalsIgnoreCase("n")) {
                System.out.println("Pendapatan Hari Ini sebesar Rp."+penHar);
                key = false;
            } else {
                System.out.println("Input yang anda masukkan salah");
            }
        }
    }
    
}
