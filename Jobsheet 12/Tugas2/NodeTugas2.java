public class NodeTugas2 {
    NodeTugas2 prev;
    int idFilm ;
    String NamaFilm;
    double rating;
    NodeTugas2 next;

    public NodeTugas2 (NodeTugas2 prev, int idFilm, String namaFilm, double rating, NodeTugas2 next){
        this.prev = prev;
        this.idFilm = idFilm;
        this.NamaFilm = namaFilm;
        this.rating = rating;
        this.next = next;
    }
}