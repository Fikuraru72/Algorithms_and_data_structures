public class latihan2 {
    
    public static void main(String[] args) {

    segitiga[] sgt = new segitiga [4];

    sgt[0] = new segitiga(10, 4);
    sgt[1] = new segitiga(20, 10);
    sgt[2] = new segitiga(15, 6);
    sgt[3] = new segitiga(25, 10);
    
    for (int i = 0; i < sgt.length; i++) {
        System.out.printf("Luas Segitiga %s = %s\n",(i+1),sgt[i].hitungLuas());
        System.out.printf("Keliling Segitiga %s = %s\n",(i+1),sgt[i].kelilingSegitiga());
    }

    // balok[] blkArray = new balok [3];
    
    // blkArray[0]= new balok(100,30,12);
    // blkArray[1]= new balok(120,40,15);
    // blkArray[2]= new balok(210,50,25);

    // for(int x = 0; x<3;x++){
    //     System.out.printf("volume Balok %s = %s\n",x,blkArray[x].hitunngVolume() );
    // }
    }
    

}

class balok {
    public int panjang;
    public int lebar;
    public int tinggi;

    public balok(int p, int l, int t){
        panjang = p;
        lebar = l;
        tinggi = t;
    }

    public int hitunngVolume (){
    return panjang*lebar*tinggi;
    }
}



class segitiga {
 int alas ;
 int tinggi ;
 segitiga(int a, int t){
    alas = a;
    tinggi = t;
 }   

 public int hitungLuas (){
    return alas * tinggi *1/2;
 }

 public double kelilingSegitiga (){
    double a = Math.sqrt(Math.pow(alas, 2)+(Math.pow(tinggi, 2)));
     return a + alas + tinggi;
 }
}
