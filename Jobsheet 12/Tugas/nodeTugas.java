public class nodeTugas {
    int nomor;
    String nama;
    nodeTugas next, prev;

    public nodeTugas(int nomor, String nama, nodeTugas next, nodeTugas prev){
        this.nomor = nomor;
        this.nama = nama;
        this.next = next;
        this.prev = prev;
    }
}