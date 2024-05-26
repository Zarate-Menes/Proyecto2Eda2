package arboles;

public class RedBlackTree {
    private Node root; // Raíz del árbol
    private Node TNULL; // Nodo null (hoja negra)
    private final static String RESET = "\u001B[0m"; // Reset de color para impresión
    private final static String RED = "\u001B[31m"; // Color rojo para impresión
    private final static String BLACK = "\u001B[30m"; // Color negro para impresión

    // Constructor que inicializa el árbol con TNULL
    public RedBlackTree() {
        TNULL = new Node(0);
        TNULL.color = 0; // Negro
        TNULL.left = null;
        TNULL.right = null;
        root = TNULL;
    }

    // Método para imprimir el árbol
    public void printTree() {
        if (root == TNULL) {
            System.out.println("Tree is empty.");
            return;
        }
        printTree(root, "", true);
    }

    // Método auxiliar para imprimir el árbol
    private void printTree(Node node, String prefix, boolean isTail) {
        String color = node.color == 1 ? RED : BLACK; // Determina el color del nodo
        System.out.println(prefix + (isTail ? "└── " : "├── ") + color + node.data + RESET);
        if (node.left != TNULL || node.right != TNULL) { // Si hay hijos
            if (node.right != TNULL) {
                printTree(node.right, prefix + (isTail ? "    " : "│   "), node.left == TNULL);
            }
            if (node.left != TNULL) {
                printTree(node.left, prefix + (isTail ? "    " : "│   "), true);
            }
        }
    }

    // Balancea el árbol después de la eliminación de un nodo
    private void fixDelete(Node x) {
        Node s;
        while (x != root && x.color == 0) { // Mientras x no sea la raíz y x sea negro
            if (x == x.parent.left) { // Si x es hijo izquierdo
                s = x.parent.right; // Sibling (hermano) de x
                if (s.color == 1) { // Caso 1: s es rojo
                    s.color = 0;
                    x.parent.color = 1;
                    leftRotate(x.parent);
                    s = x.parent.right;
                }
                if (s.left.color == 0 && s.right.color == 0) { // Caso 2: ambos hijos de s son negros
                    s.color = 1;
                    x = x.parent;
                } else {
                    if (s.right.color == 0) { // Caso 3: s.right es negro
                        s.left.color = 0;
                        s.color = 1;
                        rightRotate(s);
                        s = x.parent.right;
                    }
                    // Caso 4: s.right es rojo
                    s.color = x.parent.color;
                    x.parent.color = 0;
                    s.right.color = 0;
                    leftRotate(x.parent);
                    x = root;
                }
            } else { // Si x es hijo derecho
                s = x.parent.left; // Sibling (hermano) de x
                if (s.color == 1) { // Caso 1: s es rojo
                    s.color = 0;
                    x.parent.color = 1;
                    rightRotate(x.parent);
                    s = x.parent.left;
                }
                if (s.left.color == 0 && s.right.color == 0) { // Caso 2: ambos hijos de s son negros
                    s.color = 1;
                    x = x.parent;
                } else {
                    if (s.left.color == 0) { // Caso 3: s.left es negro
                        s.right.color = 0;
                        s.color = 1;
                        leftRotate(s);
                        s = x.parent.left;
                    }
                    // Caso 4: s.left es rojo
                    s.color = x.parent.color;
                    x.parent.color = 0;
                    s.left.color = 0;
                    rightRotate(x.parent);
                    x = root;
                }
            }
        }
        x.color = 0; // Asegurarse de que x sea negro
    }

    // Reemplaza el subárbol en la posición u con el subárbol en la posición v
    private void rbTransplant(Node u, Node v) {
        if (u.parent == null) {
            root = v;
        } else if (u == u.parent.left) {
            u.parent.left = v;
        } else {
            u.parent.right = v;
        }
        v.parent = u.parent;
    }

    // Método auxiliar para eliminar un nodo
    private void deleteNodeHelper(Node node, int key) {
        Node z = TNULL;
        Node x, y;
        while (node != TNULL) { // Encuentra el nodo a eliminar
            if (node.data == key) {
                z = node;
            }
            if (node.data <= key) {
                node = node.right;
            } else {
                node = node.left;
            }
        }
        if (z == TNULL) { // Nodo no encontrado
            System.out.println("Couldn't find key in the tree");
            return;
        }
        y = z;
        int yOriginalColor = y.color;
        if (z.left == TNULL) { // Caso 1: z no tiene hijo izquierdo
            x = z.right;
            rbTransplant(z, z.right);
        } else if (z.right == TNULL) { // Caso 2: z no tiene hijo derecho
            x = z.left;
            rbTransplant(z, z.left);
        } else { // Caso 3: z tiene ambos hijos
            y = minimum(z.right); // Encuentra el sucesor de z
            yOriginalColor = y.color;
            x = y.right;
            if (y.parent == z) {
                x.parent = y;
            } else {
                rbTransplant(y, y.right);
                y.right = z.right;
                y.right.parent = y;
            }
            rbTransplant(z, y);
            y.left = z.left;
            y.left.parent = y;
            y.color = z.color;
        }
        if (yOriginalColor == 0) {
            fixDelete(x); // Arregla el árbol si fue un nodo negro el eliminado
        }
    }

    // Balancea el árbol después de la inserción de un nodo
    private void fixInsert(Node k) {
        Node u;
        while (k.parent.color == 1) { // Mientras el padre de k sea rojo
            if (k.parent == k.parent.parent.right) { // Si el padre de k es hijo derecho
                u = k.parent.parent.left; // Tío de k
                if (u.color == 1) { // Caso 1: El tío de k es rojo
                    u.color = 0;
                    k.parent.color = 0;
                    k.parent.parent.color = 1;
                    k = k.parent.parent; 
                } else {
                    if (k == k.parent.left) { // Caso 2: k es hijo izquierdo
                        k = k.parent;
                        rightRotate(k);
                    }
                    // Caso 3: k es hijo derecho
                    k.parent.color = 0;
                    k.parent.parent.color = 1;
                    leftRotate(k.parent.parent);
                }
            } else { // Si el padre de k es hijo izquierdo
                u = k.parent.parent.right; // Tío de k
                if (u.color == 1) { // Caso 1: El tío de k es rojo
                    u.color = 0;
                    k.parent.color = 0;
                    k.parent.parent.color = 1;
                    k = k.parent.parent;
                } else {
                    if (k == k.parent.right) { // Caso 2: k es hijo derecho
                        k = k.parent;
                        leftRotate(k);
                    }
                    // Caso 3: k es hijo izquierdo
                    k.parent.color = 0;
                    k.parent.parent.color = 1;
                    rightRotate(k.parent.parent);
                }
            }
            if (k == root) {
                break;
            }
        }
        root.color = 0; // Asegurarse de que la raíz sea negra
    }

    // Rotación a la izquierda en el subárbol
    private void leftRotate(Node x) {
        Node y = x.right;
        x.right = y.left;
        if (y.left != TNULL) {
            y.left.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == null) {
            this.root = y;
        } else if (x == x.parent.left) {
            x.parent.left = y;
        } else {
            x.parent.right = y;
        }
        y.left = x;
        x.parent = y;
    }

    // Rotación a la derecha en el subárbol
    private void rightRotate(Node x) {
        Node y = x.left;
        x.left = y.right;
        if (y.right != TNULL) {
            y.right.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == null) {
            this.root = y;
        } else if (x == x.parent.right) {
            x.parent.right = y;
        } else {
            x.parent.left = y;
        }
        y.right = x;
        x.parent = y;
    }

    // Inserta un nodo en el árbol
    public void insert(int key) {
        Node node = new Node(key);
        node.parent = null;
        node.data = key;
        node.left = TNULL;
        node.right = TNULL;
        node.color = 1; // Nuevo nodo es rojo

        Node y = null;
        Node x = this.root;

        while (x != TNULL) { // Encuentra la posición correcta para el nuevo nodo
            y = x;
            if (node.data < x.data) {
                x = x.left;
            } else {
                x = x.right;
            }
        }

        node.parent = y;
        if (y == null) { // Árbol estaba vacío
            root = node;
        } else if (node.data < y.data) {
            y.left = node;
        } else {
            y.right = node;
        }

        if (node.parent == null) { // El nuevo nodo es la raíz
            node.color = 0;
            return;
        }

        if (node.parent.parent == null) { // El nuevo nodo es hijo de la raíz
            return;
        }

        fixInsert(node); // Arregla el árbol después de la inserción
    }

    // Elimina un nodo del árbol
    public void deleteNode(int data) {
        deleteNodeHelper(this.root, data);
    }

    // Encuentra el nodo con el valor mínimo en el subárbol
    private Node minimum(Node node) {
        while (node.left != TNULL) {
            node = node.left;
        }
        return node;
    }

}
