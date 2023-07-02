class Node {
    int data;
    Node left;
    Node right;

    public Node (){

    }

    public Node (int data){
        this.left = null;
        this.data = data;
        this.right = null;
    }
}

    class BinaryTree {
    Node root;

    public BinaryTree (){
        root = null;
    }

    boolean IsEmpety (){
        return root == null; 
    }

    // Add Rekursif
    void addRekursif (Node current, int data){
        if (IsEmpety()) {
            root = new Node(data);  
        } else {
            if (data < current.data) {
                if (current.left != null) {
                    addRekursif(current.left, data);
                } else {
                    current.left = new Node(data);
                }
            } else if (data > current.data) {
                if (current.right != null) {
                    addRekursif(current.right, data);
                } else {
                    current.right = new Node(data);
                }
            }
        }
    }

    // Cari Nilai Terkecil
    int min (Node current, int data){
        if (IsEmpety()) {
            System.out.println("Tree Masih Kosong");
            return 0;
        } else {
            if (current.left != null) {
                if (current.data < data) {
                    data = current.data;
                    return min(current.left, data);
                } else {
                    return min(current.left, data);
                }
            } else {
                if (current.data < data) {
                    data = current.data;
                    return data;
                } else {
                    return data;
                }
            }
        }
    }

    // Cari Nilai Terbesar
    int max (Node current, int data){
        if (IsEmpety()) {
            System.out.println("Tree Masih Kosong");
            return 0;
        } else {
            if (current.right != null) {
                if (current.data > data) {
                    data = current.data;
                    return max(current.right, data);
                } else {
                    return max(current.right, data);
                }
            } else {
                if (current.data > data) {
                    data = current.data;
                    return data;
                } else {
                    return data;
                }
            }
        }
    }

    // Print Leaf 
    void printLeaf (){
        Node temp = root;
        int save = 0;

        while (true) {
            if (temp.left == null && temp.right == null) {
                if (temp.data == save) {
                    System.out.print("\n");
                    break;
                }
                save = temp.data;
                System.out.print(save + " ");
                temp = root;
            } else {
                if (temp.left == null) {
                    temp = temp.right;
                } else if (temp.left.data > save) {
                    temp = temp.left;
                } else {
                    temp = temp.right;
                }
            }
        }
        
    }

    // hitung Leaf
    int hitLeaf (){
        Node temp = root;
        int save = 0;
        int count = 0;

        while (true) {
            if (temp.left == null && temp.right == null) {
                if (temp.data == save) {
                    break;
                }
                save = temp.data;
                count++;
                temp = root;
            } else {
                if (temp.left == null) {
                    temp = temp.right;
                } else if (temp.left.data > save) {
                    temp = temp.left;
                } else {
                    temp = temp.right;
                }
            }
        }
        return count;
    }

    // Tambah Data
    void add (int data){
        if (IsEmpety()) {
            root = new Node(data);
        } else {
            Node current = root;
            while (true) {
                if (data < current.data) {
                    if (current.left != null) {
                        current = current.left;
                    } else {
                        current.left = new Node(data);
                        break;
                    }
                } else if (data > current.data) {
                    if (current.right != null) {
                        current = current.right;
                    } else {
                        current.right = new Node(data);
                        break;
                    }
                } else {
                    break;
                }
            }
        }
    }

    // Cari Data
    boolean find (int data){
        boolean hasil = false;
        Node current = root;
        while (current != null) {
            if (current.data == data) {
                hasil = true;
                break;
            } else if (data < current.data) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return hasil;
    }

    void traversePreorder (Node node){
        if (node != null) {
            System.out.print(" " + node.data);
            traversePreorder(node.left);
            traversePreorder(node.right);
        }
    }

    void traversePostOrder (Node node){
        if (node != null) {
            traversePostOrder(node.left);
            traversePostOrder(node.right);
            System.out.print(" "+ node.data);
        }
    }

    void traverseInOrder (Node node){
        if (node != null) {
            traverseInOrder(node.left);
            System.out.print(" "+ node.data);
            traverseInOrder(node.right);
        }
    }

    Node getSuccessor (Node del){
        Node Successor = del.right;
        Node SuccessorParent = del;
        while (Successor.left != null) {
            SuccessorParent = Successor;
            Successor = Successor.left;
        }
        if (Successor != del.right) {
            SuccessorParent.left = Successor.right;
            Successor.right = del.right;
        }
        return Successor;
    }

    // Delete 
    void delete (int data){
        if (IsEmpety()) {
            System.out.println("Tree Is Empety");
            return;
        }
        // Search 
        Node Parent = root;
        Node Current = root;
        boolean isLeftChild = false;
        while (Current != null) {
            if (Current.data == data) {
                break;
            } else if (data < Current.data) {
                Parent = Current;
                Current = Current.left;
            } else if (data > Current.data) {
                Parent = Current;
                Current = Current.right;
                isLeftChild = false;
            }
                
        // Delete 
        if (Current == null) {
            System.out.println("Could't Find Data");
            return;
        } else {
            // if there no child 
            if (Current.left == null && Current.right == null) {
                if (Current == root) {
                    root = null;
                } else {
                    if (isLeftChild) {
                        Parent.left = null;
                    } else {
                        Parent.right = null;
                    }
                }
            } else if (Current.left == null) {
                if (Current == root) {
                    root = Current.right;
                } else {
                    if (isLeftChild) {
                        Parent.left = Current.right;
                    } else {
                        Parent.right = Current.right;
                    }
                }
            } else if (Current.right == null) {
                if (Current == root) {
                    root = Current.left;
                } else {
                    if (isLeftChild) {
                        Parent.left = Current.left;
                    } else {
                        Parent.right = Current.left;
                    }
                }
            } else {
                Node sucessor = getSuccessor(Current);
                if (Current == root) {
                    root = sucessor;
                } else {
                    if (isLeftChild) {
                        Parent.left = sucessor;
                    } else {
                        Parent.right = sucessor;
                    }
                    sucessor.left = Current.left;
                }
            }
        }
        }
    }

}

class BinaryTreeArray {
    int [] data;
    int idxLast;

    public BinaryTreeArray (){
        data = new int [10];
    }

    void populateData (int data [], int idxLast){
        this.data = data;
        this.idxLast = idxLast;
    }

    void add(int data){
        int start = 0;
        while (true) {
            if (this.data[start]>data) {
                if (this.data[start]==0) {
                    this.data[start] = data;
                    idxLast++;
                    break;
                } else
                start = 2*start+1;
            } else  {
                if (this.data[start]==0) {
                    this.data[start] = data;
                    idxLast++;
                    break;
                } else
                start = 2*start+2; 
            }
        }
    }

    // In-Order
    void traverseInOrder(int idxStart){
        if (idxStart <= idxLast) {
            traverseInOrder(2*idxStart+1);
            System.out.print(data[idxStart]+ " ");
            traverseInOrder(2*idxStart+2);
        }
    }

    // Pre-Order
    public void traversePreOrder(int start) {
        if (start < data.length && data[start] != 0) {
            System.out.print(data[start]+" ");
            traversePreOrder(2 * start + 1); 
            traversePreOrder(2 * start + 2); 
        }
    }

    // Post-Order
    public void traversePostOrder(int start) {
        if (start < data.length && data[start] != 0) {
            traversePostOrder(2 * start + 1); 
            traversePostOrder(2 * start + 2); 
            System.out.print(data[start]+" ");
        }
    }



}

public class percobaan1 {
    public static void main(String[] args) {
        
        BinaryTree bt = new BinaryTree();

        // bt.addRekursif(bt.root,6);
        // bt.addRekursif(bt.root,4);
        // bt.addRekursif(bt.root,8);
        // bt.addRekursif(bt.root,3);
        // bt.addRekursif(bt.root,5);
        // bt.addRekursif(bt.root,7);
        // bt.addRekursif(bt.root,9);
        // bt.addRekursif(bt.root,10);
        // bt.addRekursif(bt.root,15);

        // bt.traversePreorder(bt.root);
        // System.out.println("");
        // bt.traverseInOrder(bt.root);
        // System.out.println("");
        // bt.traversePostOrder(bt.root);
        // System.out.println("");

        // System.out.println("Find : "+ bt.find(5));
        // bt.delete(8);
        // bt.traversePreorder(bt.root);
        // System.out.println("");


        BinaryTreeArray bta = new BinaryTreeArray();
        int data [] = {6,4,8,3,5,7,9,0,0,0};
        int idxLast = 6;
        bta.populateData(data, idxLast);

        System.out.print("Traverse In-Order : ");
        bta.traverseInOrder(0);
        // bta.add(2);
        System.out.println(" ");
        System.out.print("Traverse Pre-Order : ");
        // bta.traverseInOrder(0);
        bta.traversePreOrder(0);
        System.out.println(" ");
        System.out.print("Traverse Post-Order : ");
        bta.traversePostOrder(0);




        // System.out.println("Nilai Minimal : "+ bt.min(bt.root, bt.root.data));
        // System.out.println("Nilai Maximal : "+ bt.max(bt.root, bt.root.data));
        // System.out.print("Nilai Pada Leaf : " );
        // bt.printLeaf();
        // System.out.println("Jumlah Leaf : "+ bt.hitLeaf());
    }
    
}