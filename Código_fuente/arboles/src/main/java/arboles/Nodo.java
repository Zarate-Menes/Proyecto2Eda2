
public class Nodo {

    String value;
    Nodo nDer;
    Nodo nIzq;


    //Añade el valor al nodo sin agregar a los nodos hijos
    public Nodo(String value){
        this.value = value;
        this.nDer = null;
        this.nIzq = null;
    }


    //Añade el valor al nodo y sus dos hijos
    public Nodo(String value, Nodo nIzq, Nodo nDer) {
        this.value = value;
        this.nIzq = nIzq;
        this.nDer = nDer;
    }  
    

    //Añadir al Nodo izquierdo
    public void setIzq(Nodo izq) {
        this.nIzq = izq;
    }
    

    //Añadir al Nodo derecho
    public void setDer(Nodo der) {
        this.nDer = der;
    }


    //Obtener Nodo Derecho
    public Nodo getDer(Nodo nodo){
        return nodo.nDer;
    }


    //Obtener Nodo Izquierdo
    public Nodo getIzq(Nodo nodo){
        return nodo.nIzq;
    }

}