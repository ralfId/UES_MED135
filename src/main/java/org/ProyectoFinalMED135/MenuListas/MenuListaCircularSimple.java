package org.ProyectoFinalMED135.MenuListas;

import org.ProyectoFinalMED135.ListasEnlazadas.ListaCircularSimple;

public class MenuListaCircularSimple {
    /**
     * Prueba la lista circular simplemente enlazada
     */
    public static void probarListaCircularSimple() {
        ListaCircularSimple<String> lista = new ListaCircularSimple<>();

        // Agregar elementos
        lista.agregarAlInicio("B");
        lista.agregarAlInicio("A");
        lista.agregarAlFinal("D");
        lista.agregarAlFinal("C");

        System.out.println("Lista después de agregar elementos: " + lista.listar());
        System.out.println("Tamaño: " + lista.getTamanio());

        // Ordenar
        lista.ordenar();
        System.out.println("Lista después de ordenar: " + lista.listar());

        // Suprimir elemento
        lista.suprimir("B");
        System.out.println("Lista después de suprimir B: " + lista.listar());
    }
}
