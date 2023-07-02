package Percobaan;

import java.util.Scanner;

public class Percoban {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Graph graph = new Graph(6);

        // soal 1 
        // System.out.println("Silahkan Isi Graph dengan vertex (1-6) : ");
        // while (true) {
        //     System.out.println("Isi 11 untuk berhenti");
        //     System.out.print("Masukan Vertex asal : ");
        //     int source = sc.nextInt();
        //     if (source == 11) {
        //         break;
        //     }
        //     System.out.print("Masukan Vertex tujuan : ");
        //     int destination = sc.nextInt();
            
        //     graph.addEdge(source, destination);
        // }
        // System.out.println();
        // graph.printGraph();

        // Soal 2



// Percobaan 1 
        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(3, 0);

        System.out.println();
        graph.printGraph();
        graph.degree(1);

        graph.removeEdge(1, 3);
        graph.printGraph();

        System.out.println("Cari Tipe Degree ");
        System.out.print("Masukan sumber vertex : ");
        int Source = sc.nextInt();
        System.out.print("Masukan Tujuan vertex : ");
        int destination = sc.nextInt();
        graph.degreeType(Source, destination);
       
        


// Percobaan 2 
        // int v, e, count = 1, to = 0, from = 0;
        // GraphArray graph;

        // try {
        //     System.out.print("Masukan Jumlah Vertices : ");
        //     v = sc.nextInt();
        //     System.out.print("Masukan Jumlah Edge : ");
        //     e = sc.nextInt();

        //     graph = new GraphArray(v);

        //     System.out.println("Masukan Edeges : <to> <From>");
        //     while (count <=e) {
        //         to = sc.nextInt();
        //         from = sc.nextInt();

        //         graph.makeEdge(to, from, 1);
        //         count++;
        //     }

        //     System.out.println("Array 2D sebagai representasi grap sbb : ");
        //     System.out.print("  ");
        //     for (int i = 1; i <= v; i++) {
        //         System.out.print(i+ " ");
        //     }
        //     System.out.println();

        //     for (int i = 1; i <= v; i++) {
        //         System.out.print(i + " ");
        //         for (int j = 1; j <= v; j++) {
        //             System.out.print(graph.getEdge(i, j) + " ");
        //         }

        //         System.out.println();
        //     }

        // } catch (Exception E ) {
        //     System.out.println("Error. Silahkan cek kembali\n" + E.getMessage());
        // }

    }
}
