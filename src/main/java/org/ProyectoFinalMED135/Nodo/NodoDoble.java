package org.ProyectoFinalMED135.Nodo;

/**
 * Nodo para listas doblemente enlazadas
 * @param <T> Tipo de dato que almacena el nodo
 */
public class NodoDoble<T> {
    public T dato;
    public NodoDoble<T> siguiente;
    public NodoDoble<T> anterior;

    /**
     * @param dato Dato a almacenar en el nodo
     */
    public NodoDoble(T dato) {
        this.dato = dato;
        this.siguiente = null;
        this.anterior = null;
    }
}
