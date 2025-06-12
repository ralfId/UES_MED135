package org.ProyectoFinalMED135.MenuListas;

import org.ProyectoFinalMED135.ListasEnlazadas.ListaCircularDoble;

public class MenuListaCircularDoble {
    /**
     * Prueba la lista circular doblemente enlazada
     */
    public static void probarListaCircularDoble() {
        ListaCircularDoble<Character> lista = new ListaCircularDoble<>();

        // Agregar elementos
        lista.agregarAlInicio('B');
        lista.agregarAlInicio('A');
        lista.agregarAlFinal('D');
        lista.agregarAlFinal('C');

        System.out.println("Lista después de agregar elementos: " + lista.listar());
        System.out.println("Lista en orden inverso: " + lista.listarInverso());
        System.out.println("Tamaño: " + lista.getTamanio());

        // Ordenar
        lista.ordenar();
        System.out.println("Lista después de ordenar: " + lista.listar());

        // Suprimir elemento
        lista.suprimir('B');
        System.out.println("Lista después de suprimir B: " + lista.listar());

        // Vaciar lista
        lista.vaciar();
        System.out.println("Lista después de vaciar: " + lista.listar());
    }
}
