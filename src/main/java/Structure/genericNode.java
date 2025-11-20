/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Structure;

public class genericNode<T> {
    
    private T dato;
    private genericNode<T> previo;
    private genericNode<T> siguiente;

    public genericNode(T dato) {
        this.dato = dato;
        this.previo = null;
        this.siguiente = null;
    }
    
    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public genericNode<T> getPrevio() {
        return previo;
    }

    public void setPrevio(genericNode<T> previo) {
        this.previo = previo;
    }

    public genericNode<T> getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(genericNode<T> siguiente) {
        this.siguiente = siguiente;
    }
    
    @Override
    public String toString() {
        return dato.toString();
    }
}
