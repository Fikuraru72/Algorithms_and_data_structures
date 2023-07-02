/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asd1;

import java.util.Scanner;

public class ASD2 {
        
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String day[] = {"Senin","Selasa","Rabu","Kamis","Juma'at","Sabtu","Minggu"};
        
        System.out.print("Masukan NIM : ");
        String nim = sc.nextLine();
        System.out.println("==================");
        String noMah = Character.toString(nim.charAt(nim.length()-2)) + Character.toString(nim.charAt(nim.length()-1)) ;
        int all = Integer.parseInt(noMah);
        if (all <10){
            all += 10;
        } 
        
        int x = 0;
        for (int i = 1; i <= all ; i++) {
            if (x == day.length){
                x = 0;
            }
            System.out.print(day[x]+" ");
            x++;
        }         
    }
}
