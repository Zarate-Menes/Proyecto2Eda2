package arboles;

class Node{
        int data;
        Node  parent;
        Node  left;
        Node  right;
        int color; // 0: Black, 1: Red
    
        public Node(int data) {
            this.data = data;
            this.color = 1; // Los nuevos nodos son rojos 
        }
}
    


