/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Edgar
 */
public class Noda {
    
    int valor;
    Noda izq = null;
    Noda der = null;
    
    public Noda(){
        izq=der=null;
    }
    public Noda(int data){
        this(data,null,null);
    }
    public Noda(int data, Noda lt, Noda rt){
        valor=data;
        izq = lt;
        der = rt;
    }   
    
    public void setIzq(Noda izq) {
        this.izq = izq;
    }
    
    public void setDer(Noda der) {
        this.der = der;
    }

    
}
