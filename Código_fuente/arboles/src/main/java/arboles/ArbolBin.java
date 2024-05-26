package arboles;

public class ArbolBin {

    Nodo raiz;


    //Nodo raiz
    public ArbolBin(){
        raiz = null;
    }


    //Incializa el nodo raiz
    public ArbolBin(String value){
        raiz = new Nodo(value);
    }
        
    
    //Imprime el valor del nodo indicado
    protected void visit(Nodo n){
        System.out.println(n.value + " ");
    }	


    //Recorrido en InOrden del arbol
    public void inOrden(Nodo nodo){
        if(nodo == null){
            return;
        }else{
           inOrden(nodo.getIzq(nodo));
           visit(nodo);
           inOrden(nodo.getDer(nodo));
        }
    }


    //Recorrido en PostOrden del arbol
    public void postOrden(Nodo nodo){
        if(nodo == null){
            return;
        }else{
           postOrden(nodo.getIzq(nodo));
           postOrden(nodo.getDer(nodo));
           visit(nodo);
        }
    }
}