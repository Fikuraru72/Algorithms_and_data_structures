public class AntrianVaksin {
    nodeTugas head;
    int size;

    public AntrianVaksin () {
        head = null;
        size = 0;
    } 

    public boolean isEmpety (){
        return head == null;
    }



    public void addFrist (int nomor, String nama) {
        if (isEmpety()) {
            head = new nodeTugas(nomor, nama, null, null);
            size++;
        } else {
            nodeTugas newNode = new nodeTugas(nomor, nama, head, null);
            head.prev = newNode;
            head = newNode;
            size++;
        }
    }

    public void addLast (int nomor, String nama) {
        if (isEmpety()) {
            addFrist(nomor, nama);
        } else {
            nodeTugas hitung = head;
            while (hitung.next != null) {
                hitung = hitung.next;
            }
            nodeTugas newNode = new nodeTugas(nomor, nama, null, hitung);
            hitung.next = newNode;
            size++;
        }
    }

    public void removeFrist () throws Exception {
        if (isEmpety()) {
            throw new Exception("Antrian Masih Kosoh");
        } else if (head.next == null) {
            head = null;
            size--;
        } else {
            head = head.next;
            head.prev = null;
            size--;
        }
    }

    public void print () throws Exception {
        if (isEmpety()) {
            throw new Exception("Antrian Masih Kosoh");
        } else {
            System.out.println("------------------------------------");
            System.out.println("\tDaftar Pengantri Vaksin\t");
            System.out.println("------------------------------------");
            System.out.println("|No\t\t|Nama\t\t\t|");
            nodeTugas temp = head;
            while (temp != null) {
                System.out.println("|"+temp.nomor+"\t\t"+"|"+temp.nama+"\t\t\t|");
                temp = temp.next;
            }
            System.out.println("------------------------------------");
            System.out.println("Sisa Antrain : "+ size);
        }
        
    }


    
}