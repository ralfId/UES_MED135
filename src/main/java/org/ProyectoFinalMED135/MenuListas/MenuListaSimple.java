package org.ProyectoFinalMED135.MenuListas;

import org.ProyectoFinalMED135.ListasEnlazadas.ListaSimple;

public class MenuListaSimple {
    /**
     * Prueba la lista simplemente enlazada
     */
    public static void probarListaSimple() {
        ListaSimple<Integer> lista = new ListaSimple<>();

        // Agregar elementos
        lista.agregarAlInicio(3);
        lista.agregarAlInicio(1);
        lista.agregarAlFinal(5);
        lista.agregarAlFinal(2);

        System.out.println("Lista después de agregar elementos: " + lista.listar());
        System.out.println("Tamaño: " + lista.getTamanio());

        // Ordenar
        lista.ordenar();
        System.out.println("Lista después de ordenar: " + lista.listar());

        // Suprimir elemento
        lista.suprimir(3);
        System.out.println("Lista después de suprimir 3: " + lista.listar());

        // Vaciar lista
        lista.vaciar();
        System.out.println("Lista después de vaciar: " + lista.listar());
    }
}
