public class DataFilm {
    NodeTugas2 head;
    int size;

    public DataFilm (){
        head = null;
        size = 0 ;
    }

    public boolean isEmpety (){
        return head == null;
    }

    public void addFrist (int idFilm, String namaFilm, double rating ){
        if (isEmpety()) {
            head = new NodeTugas2(null, idFilm, namaFilm, rating, null);
            size++;
        } else {
            NodeTugas2 temp;
            temp = new NodeTugas2(null, idFilm, namaFilm, rating, head);
            head.prev = temp;
            head = temp;
            size++;
        }
    }

    public void addLast (int idFilm, String namaFilm, double rating ){
        if (isEmpety()) {
            addFrist(idFilm, namaFilm, rating);
        } else {
            NodeTugas2 temp;
            temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }   
            NodeTugas2 newNode;
            newNode = new NodeTugas2(temp, idFilm, namaFilm, rating, null);
            temp.next = newNode;
            size++;
        }
    }

    public void add (int idFilm, String namaFilm, double rating, int index) throws Exception{
        if (isEmpety()) {
            addFrist(idFilm, namaFilm, rating);
        } else if (index < 0 || index > size) {
            throw new Exception("Indexs yang dimasukan salah");
        } else {
            NodeTugas2 temp;
            temp = head;
            int i = 0;
            while (i < index ) {
                temp = temp.next;
                i++;
            }

          if (temp.prev == null) {
              NodeTugas2 newNode;
              newNode = new NodeTugas2(null, idFilm, namaFilm, rating, temp);
              temp.prev = newNode;
              head = newNode;
          } else {
              NodeTugas2 newNode;
              newNode = new NodeTugas2(temp.prev, idFilm, namaFilm, rating, temp);
              temp.prev.next = newNode;
              temp.prev = newNode;
          }  
        }
    }

    public void removeFrist () throws Exception{
        if (isEmpety()) {
            throw new Exception ("Data Masih Kosong");
        } else {
            head = head.next;
            head.prev = null;
            size--;
        }
    }

    public void removeLast () throws Exception {
        if (isEmpety()) {
            throw new Exception ("Data Masih Kosong");
        } else if (head.next == null) {
            head = null;
            size--;
            return;
        }
        NodeTugas2 temp = head;
        while (temp.next == null) {
            temp = temp.next;
        }
        temp.prev.next = null;
        size--;  
        
    }

    public void removeAdd (int index)throws Exception{
        if (isEmpety()) {
            throw new Exception ("Data Masih Kosong");
        } else if (index == 0) {
            removeFrist();
        } else {
            NodeTugas2 temp = head;
            int i = 0;
            while (i<index) {
                temp = temp.next;
                i++;
            }

            if (temp.prev == null ) {
                temp.next = temp.next;
                temp.prev = null;
                head = temp;

            } else if (temp.next == null) {
                temp.prev.next = null;
                size--;
            } else {
                temp.prev.next = temp.next;
                temp.next.prev = temp;
            }
            size--;
        }
    }

    public void print ()throws Exception{
        if (isEmpety()) {
            throw new Exception("Data Masih Kosong");
        } else {
            NodeTugas2 temp;
            temp = head;

            while (temp != null) {
                System.out.println("ID Film\t\t : " + temp.idFilm);
                System.out.println("Nama Film\t : " + temp.NamaFilm);
                System.out.println("Rating Film\t : " + temp.rating);
                System.out.println("-------------------------------------");
                temp = temp.next;
            }
        }
    }

    public void search (int id, NodeTugas2 temp, int cout){
        if (temp.next == null) {
            System.out.println("Data tidak Ditemukan");
        }
        if (id == temp.idFilm) {
            System.out.println("Data dengan ID Film : "+ id+" di Node Ke-"+cout);
            System.out.println("ID Film\t\t : " + temp.idFilm);
            System.out.println("Nama Film\t : " + temp.NamaFilm);
            System.out.println("Rating Film\t : " + temp.rating);
        } else {
            search(id, temp.next, cout++);
        }
    }

    public void shorting ()throws Exception{
        NodeTugas2 current, index, temp;
        if (isEmpety()) {
            throw new Exception("Data Masih kosong");
        } else{
            for (current = head; current != null; current = current.next) {
                for (index = current.next; index != null; index =  index.next) {
                    if (current.rating < index.rating) {
                        temp = current;
                        
                        current.idFilm = index.idFilm;
                        current.NamaFilm = index.NamaFilm;
                        current.rating = index.rating;

                        System.out.println("Index " + index.idFilm);
                        System.out.println("current " + index.idFilm);

                        index.idFilm = temp.idFilm;
                        index.NamaFilm = temp.NamaFilm;
                        index.rating = temp.rating; 
                    }
                }
            }
        }
    }
}
