package org.ProyectoFinalMED135.ListasEnlazadas;

import org.ProyectoFinalMED135.Nodo.NodoDoble;

/**
 * Implementación de una Lista Circular Doblemente Enlazada genérica
 * @param <T> Tipo de dato que almacenará la lista
 */
public class ListaCircularDoble<T extends Comparable<T>> implements IListaEnlazada<T> {
    private NodoDoble<T> cabeza;
    private int tamanio;

    public ListaCircularDoble() {
        this.cabeza = null;
        this.tamanio = 0;
    }

    /**
     * Agrega un nodo al inicio de la lista
     * @param dato Dato a agregar
     */
    @Override
    public void agregarAlInicio(T dato) {
        NodoDoble<T> nuevoNodo = new NodoDoble<>(dato);

        if (cabeza == null) {
            cabeza = nuevoNodo;
            cabeza.siguiente = cabeza;
            cabeza.anterior = cabeza;
        } else {
            NodoDoble<T> ultimo = cabeza.anterior;

            nuevoNodo.siguiente = cabeza;
            nuevoNodo.anterior = ultimo;
            cabeza.anterior = nuevoNodo;
            ultimo.siguiente = nuevoNodo;
            cabeza = nuevoNodo;
        }
        tamanio++;
    }

    /**
     * Agrega un nodo al final de la lista
     * @param dato Dato a agregar
     */
    @Override
    public void agregarAlFinal(T dato) {
        NodoDoble<T> nuevoNodo = new NodoDoble<>(dato);

        if (cabeza == null) {
            cabeza = nuevoNodo;
            cabeza.siguiente = cabeza;
            cabeza.anterior = cabeza;
        } else {
            NodoDoble<T> ultimo = cabeza.anterior;

            nuevoNodo.siguiente = cabeza;
            nuevoNodo.anterior = ultimo;
            ultimo.siguiente = nuevoNodo;
            cabeza.anterior = nuevoNodo;
        }
        tamanio++;
    }

    /**
     * Suprime un nodo de la lista por su valor
     * @param dato Dato a eliminar
     * @return true si se eliminó, false si no se encontró
     */
    @Override
    public boolean suprimir(T dato) {
        if (cabeza == null) return false;

        // Si solo hay un nodo
        if (cabeza.siguiente == cabeza && cabeza.dato.equals(dato)) {
            cabeza = null;
            tamanio--;
            return true;
        }

        NodoDoble<T> actual = cabeza;

        do {
            if (actual.dato.equals(dato)) {
                actual.anterior.siguiente = actual.siguiente;
                actual.siguiente.anterior = actual.anterior;

                if (actual == cabeza) {
                    cabeza = actual.siguiente;
                }

                tamanio--;
                return true;
            }
            actual = actual.siguiente;
        } while (actual != cabeza);

        return false;
    }

    /**
     * Ordena los elementos de la lista usando bubble sort
     */
    @Override
    public void ordenar() {
        if (cabeza == null || cabeza.siguiente == cabeza) return;

        boolean intercambio;
        do {
            intercambio = false;
            NodoDoble<T> actual = cabeza;

            do {
                if (actual.dato.compareTo(actual.siguiente.dato) > 0) {
                    // Intercambiar datos
                    T temp = actual.dato;
                    actual.dato = actual.siguiente.dato;
                    actual.siguiente.dato = temp;
                    intercambio = true;
                }
                actual = actual.siguiente;
            } while (actual.siguiente != cabeza);
        } while (intercambio);
    }

    /**
     * Lista todos los elementos de la lista
     * @return String con todos los elementos
     */
    @Override
    public String listar() {
        if (cabeza == null) return "Lista vacía";

        StringBuilder sb = new StringBuilder();
        NodoDoble<T> actual = cabeza;

        do {
            sb.append(actual.dato);
            actual = actual.siguiente;
            if (actual != cabeza) sb.append(" <-> ");
        } while (actual != cabeza);

        sb.append(" <-> (circular)");
        return sb.toString();
    }

    /**
     * Lista todos los elementos de la lista en orden inverso
     * @return String con todos los elementos en orden inverso
     */
    @Override
    public String listarInverso() {
        if (cabeza == null) return "Lista vacía";

        StringBuilder sb = new StringBuilder();
        NodoDoble<T> actual = cabeza.anterior; // Último nodo

        do {
            sb.append(actual.dato);
            actual = actual.anterior;
            if (actual != cabeza.anterior) sb.append(" <-> ");
        } while (actual != cabeza.anterior);

        sb.append(" <-> (circular inverso)");
        return sb.toString();
    }

    /**
     * Vacía la lista completa
     */
    @Override
    public void vaciar() {
        cabeza = null;
        tamanio = 0;
    }

    /**
     * Obtiene el tamaño actual de la lista
     * @return Tamaño de la lista
     */
    @Override
    public int getTamanio() {
        return tamanio;
    }

    /**
     * Verifica si la lista está vacía
     * @return true si está vacía, false en caso contrario
     */
    @Override
    public boolean estaVacia() {
        return cabeza == null;
    }
}