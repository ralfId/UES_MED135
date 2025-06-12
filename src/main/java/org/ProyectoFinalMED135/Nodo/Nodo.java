package org.ProyectoFinalMED135.Nodo;

/**
 * Nodo para listas simplemente enlazadas
 * @param <T> Tipo de dato que almacena el nodo
 */
public class Nodo<T> {
    public T dato;
    public Nodo<T> siguiente;

    /**
     * @param dato Dato a almacenar en el nodo
     */
    public Nodo(T dato) {
        this.dato = dato;
        this.siguiente = null;
    }
}
