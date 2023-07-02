    import java.util.Scanner;

    class Peserta {
        String nama;
        int suara;
    }

    public class Tugas {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            Scanner scr = new Scanner(System.in);

            System.out.println("====================================");
            System.out.print("Masukan Jumlah Kandidat : ");
            int kandidat = sc.nextInt();

            Peserta [] pesertasObj = new Peserta[kandidat];
            for (int i = 0; i < kandidat; i++) {
                pesertasObj[i] = new Peserta();
                System.out.printf("Masukan Nama Kandidat ke-%s : ",i+1);
                pesertasObj[i].nama = scr.nextLine();
            }
            System.out.println("-----------------------------------");
            System.out.print("Masukan Jumlah Pemilik Hak Pilih : ");
            int jumSuara = sc.nextInt();
            if (jumSuara %2 != 0) {
              System.out.println("Jumlah Suara Pemilihan Harus Genap");  
            } 
            System.out.println();
            System.out.println("====================================");
            System.out.println("Silahkan Pilih Kandidat di Atas:");
            String hasilSuara [] = new String [jumSuara];
            for (int i = 0; i < jumSuara; i++) {
                System.out.printf("Masukan Suara Pilihan ke %s : ",i+1);
                hasilSuara[i] = scr.nextLine();
            }

            for (int i = 0; i < jumSuara ; i++) {
                for (int j = 0; j < kandidat; j++) {
                    if (hasilSuara[i].equalsIgnoreCase(pesertasObj[j].nama)) {
                        pesertasObj[j].suara++;
                    }
                }
            }

            String pemenang = " ";
            int suaraByk = 0 ;
            for (int i = 0; i < pesertasObj.length; i++) {
                if (pesertasObj[i].suara > suaraByk) {
                    suaraByk = pesertasObj[i].suara ;
                    pemenang = pesertasObj[i].nama;
                }
            }

            System.out.println("====================================");
            System.out.println("Kandidat Dengan Suara Terbanyak adalah " + pemenang);
            System.out.println("Dengan Total Suara : " + suaraByk + " suara");

        }
    }
