package org.ProyectoFinalMED135.ListasEnlazadas;

import org.ProyectoFinalMED135.Nodo.Nodo;

/**
 * Implementación de una Lista Simplemente Enlazada genérica
 * @param <T> Tipo de dato que almacenará la lista
 */
public class ListaSimple<T extends Comparable<T>> implements IListaEnlazada<T> {
    private Nodo<T> cabeza;
    private int tamanio;

    public ListaSimple() {
        this.cabeza = null;
        this.tamanio = 0;
    }

    /**
     * Agrega un nodo al inicio de la lista
     * @param dato Dato a agregar
     */
    @Override
    public void agregarAlInicio(T dato) {
        Nodo<T> nuevoNodo = new Nodo<>(dato);
        nuevoNodo.siguiente = cabeza;
        cabeza = nuevoNodo;
        tamanio++;
    }

    /**
     * Agrega un nodo al final de la lista
     * @param dato Dato a agregar
     */
    @Override
    public void agregarAlFinal(T dato) {
        Nodo<T> nuevoNodo = new Nodo<>(dato);

        if (cabeza == null) {
            cabeza = nuevoNodo;
        } else {
            Nodo<T> actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevoNodo;
        }
        tamanio++;
    }

    /**
     * Suprimir un nodo de la lista por su valor
     * @param dato Dato a eliminar
     * @return true si se elimino, false si no se encontro
     */
    @Override
    public boolean suprimir(T dato) {
        if (cabeza == null) return false;

        // Si el nodo a eliminar es la cabeza
        if (cabeza.dato.equals(dato)) {
            cabeza = cabeza.siguiente;
            tamanio--;
            return true;
        }

        Nodo<T> actual = cabeza;
        while (actual.siguiente != null && !actual.siguiente.dato.equals(dato)) {
            actual = actual.siguiente;
        }

        if (actual.siguiente != null) {
            actual.siguiente = actual.siguiente.siguiente;
            tamanio--;
            return true;
        }

        return false;
    }

    /**
     * Ordena los elementos de la lista usando bubble sort
     */
    @Override
    public void ordenar() {
        if (cabeza == null || cabeza.siguiente == null) return;

        boolean intercambio;
        do {
            intercambio = false;
            Nodo<T> actual = cabeza;

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
    @Override
    public String listar() {
        if (cabeza == null) return "Lista vacía";

        StringBuilder sb = new StringBuilder();
        Nodo<T> actual = cabeza;

        while (actual != null) {
            sb.append(actual.dato);
            if (actual.siguiente != null) sb.append(" -> ");
            actual = actual.siguiente;
        }

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
