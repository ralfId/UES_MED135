package org.ProyectoFinalMED135.ListasEnlazadas;

import org.ProyectoFinalMED135.Nodo.Nodo;

/**
 * Implementación de una Lista Circular Simplemente Enlazada genérica
 * @param <T> Tipo de dato que almacenará la lista
 */
public class ListaCircularSimple<T extends Comparable<T>> implements IListaEnlazada<T>{
    private Nodo<T> ultimo;
    private int tamanio;

    public ListaCircularSimple() {
        this.ultimo = null;
        this.tamanio = 0;
    }

    /**
     * Agrega un nodo al inicio de la lista
     * @param dato Dato a agregar
     */
    @Override
    public void agregarAlInicio(T dato) {
        Nodo<T> nuevoNodo = new Nodo<>(dato);

        if (ultimo == null) {
            ultimo = nuevoNodo;
            ultimo.siguiente = ultimo;
        } else {
            nuevoNodo.siguiente = ultimo.siguiente;
            ultimo.siguiente = nuevoNodo;
        }
        tamanio++;
    }

    /**
     * Agrega un nodo al final de la lista
     * @param dato Dato a agregar
     */
    @Override
    public void agregarAlFinal(T dato) {
        Nodo<T> nuevoNodo = new Nodo<>(dato);

        if (ultimo == null) {
            ultimo = nuevoNodo;
            ultimo.siguiente = ultimo;
        } else {
            nuevoNodo.siguiente = ultimo.siguiente;
            ultimo.siguiente = nuevoNodo;
            ultimo = nuevoNodo;
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
        if (ultimo == null) return false;

        // Si solo hay un nodo
        if (ultimo.siguiente == ultimo && ultimo.dato.equals(dato)) {
            ultimo = null;
            tamanio--;
            return true;
        }

        Nodo<T> actual = ultimo.siguiente; // Primer nodo
        Nodo<T> anterior = ultimo;

        do {
            if (actual.dato.equals(dato)) {
                anterior.siguiente = actual.siguiente;
                if (actual == ultimo) {
                    ultimo = anterior;
                }
                tamanio--;
                return true;
            }
            anterior = actual;
            actual = actual.siguiente;
        } while (actual != ultimo.siguiente);

        return false;
    }

    /**
     * Ordena los elementos de la lista usando bubble sort
     */
    @Override
    public void ordenar() {
        if (ultimo == null || ultimo.siguiente == ultimo) return;

        boolean intercambio;
        do {
            intercambio = false;
            Nodo<T> actual = ultimo.siguiente; // Primer nodo

            do {
                if (actual.dato.compareTo(actual.siguiente.dato) > 0) {
                    // Intercambiar datos
                    T temp = actual.dato;
                    actual.dato = actual.siguiente.dato;
                    actual.siguiente.dato = temp;
                    intercambio = true;
                }
                actual = actual.siguiente;
            } while (actual.siguiente != ultimo.siguiente);
        } while (intercambio);
    }

    /**
     * Lista todos los elementos de la lista
     * @return String con todos los elementos
     */
    @Override
    public String listar() {
        if (ultimo == null) return "Lista vacía";

        StringBuilder sb = new StringBuilder();
        Nodo<T> actual = ultimo.siguiente; // Primer nodo

        do {
            sb.append(actual.dato);
            actual = actual.siguiente;
            if (actual != ultimo.siguiente) sb.append(" -> ");
        } while (actual != ultimo.siguiente);

        sb.append(" -> (circular)");
        return sb.toString();
    }

    @Override
    public String listarInverso() {
        return "";
    }

    /**
     * Vacía la lista completa
     */
    @Override
    public void vaciar() {
        ultimo = null;
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
        return ultimo == null;
    }
}
