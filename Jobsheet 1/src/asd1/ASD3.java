/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asd1;

import java.util.Scanner;
public class ASD3 {
    static int cabang [][] = {
            {10,5,15,7},
            {6,11,9,12},
            {2,10,10,5},
            {5,7,12,9}
        };
    static int harga [] = {75000,50000,60000,10000};
    static String bunga [] = {"Aglonema","Keladi","Alocasia","Mawar"};
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 
        
        System.out.println("0. Stock bunga semua toko");
        System.out.println("1. Stock bunga semua toko (Fungsi)");
        System.out.println("2. Perubahan Stock");
        System.out.println("3. Stock Bunga di Toko");
        System.out.print("Pilih : ");
        String input = sc.next();
        if (input.equals("0")){
            System.out.println("Jumlah stock bunga disemua cabang");
            System.out.println("");
            for (int i = 0; i < bunga.length; i++) {
                int total = 0;
                for (int j = 0; j < cabang.length; j++) {
                    total += cabang[j][i];
                }
                System.out.printf("Bunga Jenis %s berjumlah %s disemua toko\n",bunga[i],total);
            }
            
        } else if (input.equals("1")){
            System.out.println("Jumlah stock bunga disemua cabang");
            for (int i = 0; i < bunga.length; i++) {
                stok(cabang[0][i],cabang[1][i],cabang[2][i],cabang[3][i], i);
            }
        } else if (input.equals("2")) {
            System.out.println("Pilih cabang");
            for (int i = 1; i <= bunga.length; i++) {
                System.out.printf("%s. Royal Garden %s\n",i,i);
            } 
            System.out.print("Pilih : ");
            int in = sc.nextInt();
            for (int j = 0; j < cabang[in-1].length; j++) {
                System.out.printf("Bunga %s Layu sebanyak pada cabang Royal Garden %s : ", bunga[j], in);
                int a = sc.nextInt();
                cabang[in-1][j] = cabang[in-1][j] - a;
            }
//            newStk(in-1);
//            getvalue(in-1);
            System.out.println("");
            int all = 0;
            for (int i = 0; i < cabang[in-1].length; i++) {
                int bank = cabang[in-1][i]*harga[i];
                all += bank;
                System.out.printf("Bunga %s Royal Garden %s jumlah %s dengan harga %s, total penjualan : %s \n", 
                bunga[i], in,cabang[in-1][i], harga[i], bank);
             }
            System.out.println(" ");
            System.out.printf("Total Penjualan pada cabang Royal Garden %s : %s\n", in, all);
        } 
        else if (input.equals("3")) {
            System.out.println("Pilih cabang");
            for (int i = 1; i <= bunga.length; i++) {
                System.out.printf("%s. Royal Garden %s\n",i,i);
                tabStok(i-1);
                System.out.println(" ");
            } 
        } 
    }
    
//    print stock per bunga
    static void stok (int a, int b, int c, int d,int code) {
        int all = a+b+c+d;
        System.out.printf("Bunga Jenis %s dengan Stock %s \n", bunga[code], all);
    }
    
//    perubahan Stock 
    static void newStk (int code){
        Scanner scr = new Scanner(System.in);
            for (int j = 0; j < cabang[code].length; j++) {
                System.out.printf("Bunga %s Layu sebanyak pada cabang Royal Garden %s : ", bunga[j], code+1);
                int a = scr.nextInt();
                cabang[code][j] = cabang[code][j] - a;
            }
    }
    
//    pendapat toko 
    static void getvalue (int code) {
        int all = 0;
        for (int i = 0; i < cabang[code].length; i++) {
            int bank = cabang[code][i]*harga[i];
            all += bank;
            System.out.printf("Bunga %s Royal Garden %s jumlah %s dengan harga %s, total penjualan : %s \n", bunga[i], code+1,cabang[code][i], harga[i], bank);
        }
        System.out.printf("Total Penjualan pada cabang Royal Garden %s : %s", code+1, all);
    }
    
    static void tabStok (int code) {
        for (int i = 0; i < cabang[code].length; i++) {
            int bank = cabang[code][i]*harga[i];
            System.out.printf("Bunga %s terdapat %s Unit \n", bunga[i], code+1,cabang[code][i]);
        }
        System.out.println(" ");
    }
    
    
    
    
}
