package Percobaan;
public class GraphArray {
    private final int vertices;
    private final int [][] twoD_Array;


    public GraphArray(int v) {
        vertices = v;
        twoD_Array = new int [vertices + 1] [vertices +1 ];
    }

    public void makeEdge (int to, int from, int edge){

        try {
            twoD_Array[to][from] = edge;
        } catch (ArrayIndexOutOfBoundsException index) {
            System.out.println("Vertex tidak ada");
        }

    }

    public int getEdge (int to, int from) {
        try {
            return twoD_Array[to][from];
        } catch (ArrayIndexOutOfBoundsException index) {
            System.out.println("Vertex tidak ada");
        }
        return -1;
    } 



}
