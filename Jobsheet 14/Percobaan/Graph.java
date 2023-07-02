package Percobaan;

import java.util.ArrayList;
import java.util.List;


public class Graph <E>{
    int vertex;
    ArrayList<DoubleLinkedList <E>> List ;

    public Graph (int vertex){
        this.vertex = vertex;
        List = new ArrayList <DoubleLinkedList <E>> (vertex);
        for (int i = 0; i < vertex; i++) {
            List.add(new DoubleLinkedList<E>());
        }
    }

    // add
    public void addEdge (E source, E destination){
        // add Frist
        List[source].addFirst(destination);

        // add Last
        List[destination].addFirst(source);
    } 

    // Degree
    public void degree (E source) throws Exception {
        // Degeree undirected 
        System.out.println("Degree Vertex "+ source + " : " + List[source].size());

        // Degree derect 
            // in-Degree 
            int k, totalIn = 0, totalOut = 0;
            for (int i = 0; i < vertex; i++) {
                for (int j = 0; j < List[i].size(); j++) {
                    if (List[i].get(j) == source) {
                        totalIn++;
                    }
                }

                    // Out- Degree
                for (k = 0; k < List[source].size(); k++) {
                    List[source].get(k);
                }

                totalOut = k;
            }

        System.out.println("In-Degree dari Vertex "+ source + " : " + totalIn);
        System.out.println("Out-Degree dari Vertex "+ source + " : " + totalOut);
        System.out.println("Degree dari Vertex "+ source + " : " + (totalIn + totalOut));
    }

    // remove edge
    public void removeEdge (E source, E destination) throws Exception {
        for (int i = 0; i < vertex; i++) {
            if (i == destination) {
                List[source].remove(destination);
            }

            if (degreeType(source, destination) == true) {
                List[destination].remove(source);
            }
        }
    }

    // remove all edge
    public void romoveAllEdge (){
        for (int i = 0; i < vertex; i++) {
            List[i].clear();
        }
        System.out.println("Graph Telah Dikosongkan");
    }

    // Print Graph 
    public void printGraph () throws Exception {
        for (int i = 0; i < vertex; i++) {
            if (List[i].size()>0) {
                System.out.print("Vertex "+ i + " terhubung dengan : ");
                for (int j = 0; j < List[i].size(); j++) {
                    System.out.print(List[i].get(j) + " ");
                }
                System.out.println("");
            }
        }
        System.out.println(" ");
    }

    // Degree Type 
    public boolean degreeType (int Source, int destination) {
        boolean data = List[destination].getData(Source);
        if (data == true) {
            System.out.println("Degree Direct");
            return true;
        } else {
            System.out.println("Degree Undirected");
            return false;
        }
    }


}
