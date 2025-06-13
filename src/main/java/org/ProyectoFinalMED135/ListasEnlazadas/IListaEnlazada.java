package org.ProyectoFinalMED135.ListasEnlazadas;

public interface IListaEnlazada<T extends Comparable<T>> {
    void agregarAlInicio(T dato);
    void agregarAlFinal(T dato);
    boolean suprimir(T dato);
    void ordenar();
    String listar();
    String listarInverso();
    void vaciar();
    int getTamanio();
    boolean estaVacia();
}
