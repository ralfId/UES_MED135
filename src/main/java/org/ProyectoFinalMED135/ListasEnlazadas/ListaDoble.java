package org.ProyectoFinalMED135.ListasEnlazadas;

import org.ProyectoFinalMED135.Nodo.NodoDoble;

/**
 * Implementación de una Lista Doblemente Enlazada genérica
 * @param <T> Tipo de dato que almacenará la lista
 */
public class ListaDoble<T extends Comparable<T>> {
    private NodoDoble<T> cabeza;
    private NodoDoble<T> cola;
    private int tamanio;

    public ListaDoble() {
        this.cabeza = null;
        this.cola = null;
        this.tamanio = 0;
    }

    /**
     * Agrega un nodo al inicio de la lista
     * @param dato Dato a agregar
     */
    public void agregarAlInicio(T dato) {
        NodoDoble<T> nuevoNodo = new NodoDoble<>(dato);

        if (cabeza == null) {
            cabeza = cola = nuevoNodo;
        } else {
            nuevoNodo.siguiente = cabeza;
            cabeza.anterior = nuevoNodo;
            cabeza = nuevoNodo;
        }
        tamanio++;
    }

    /**
     * Agrega un nodo al final de la lista
     * @param dato Dato a agregar
     */
    public void agregarAlFinal(T dato) {
        NodoDoble<T> nuevoNodo = new NodoDoble<>(dato);

        if (cola == null) {
            cabeza = cola = nuevoNodo;
        } else {
            cola.siguiente = nuevoNodo;
            nuevoNodo.anterior = cola;
            cola = nuevoNodo;
        }
        tamanio++;
    }

    /**
     * Suprime un nodo de la lista por su valor
     * @param dato Dato a eliminar
     * @return true si se eliminó, false si no se encontró
     */
    public boolean suprimir(T dato) {
        NodoDoble<T> actual = cabeza;

        while (actual != null) {
            if (actual.dato.equals(dato)) {
                // Actualizar enlaces
                if (actual.anterior != null) {
                    actual.anterior.siguiente = actual.siguiente;
                } else {
                    cabeza = actual.siguiente;
                }

                if (actual.siguiente != null) {
                    actual.siguiente.anterior = actual.anterior;
                } else {
                    cola = actual.anterior;
                }

                tamanio--;
                return true;
            }
            actual = actual.siguiente;
        }

        return false;
    }

    /**
     * Ordena los elementos de la lista usando bubble sort
     */
    public void ordenar() {
        if (cabeza == null || cabeza.siguiente == null) return;

        boolean intercambio;
        do {
            intercambio = false;
            NodoDoble<T> actual = cabeza;

            while (actual.siguiente != null) {
                if (actual.dato.compareTo(actual.siguiente.dato) > 0) {
                    // Intercambiar datos
                    T temp = actual.dato;
                    actual.dato = actual.siguiente.dato;
                    actual.siguiente.dato = temp;
                    intercambio = true;
                }
                actual = actual.siguiente;
            }
        } while (intercambio);
    }

    /**
     * Lista todos los elementos de la lista
     * @return String con todos los elementos
     */
    public String listar() {
        if (cabeza == null) return "Lista vacía";

        StringBuilder sb = new StringBuilder();
        NodoDoble<T> actual = cabeza;

        while (actual != null) {
            sb.append(actual.dato);
            if (actual.siguiente != null) sb.append(" <-> ");
            actual = actual.siguiente;
        }

        return sb.toString();
    }

    /**
     * Lista todos los elementos de la lista en orden inverso
     * @return String con todos los elementos en orden inverso
     */
    public String listarInverso() {
        if (cola == null) return "Lista vacía";

        StringBuilder sb = new StringBuilder();
        NodoDoble<T> actual = cola;

        while (actual != null) {
            sb.append(actual.dato);
            if (actual.anterior != null) sb.append(" <-> ");
            actual = actual.anterior;
        }

        return sb.toString();
    }

    /**
     * Vacía la lista completa
     */
    public void vaciar() {
        cabeza = null;
        cola = null;
        tamanio = 0;
    }

    /**
     * Obtiene el tamaño actual de la lista
     * @return Tamaño de la lista
     */
    public int getTamanio() {
        return tamanio;
    }

    /**
     * Verifica si la lista está vacía
     * @return true si está vacía, false en caso contrario
     */
    public boolean estaVacia() {
        return cabeza == null;
    }
}
