package org.ProyectoFinalMED135.MenuListas;

import org.ProyectoFinalMED135.ListasEnlazadas.ListaDoble;

public class MenuListaDoble {
    /**
     * Prueba la lista doblemente enlazada
     */
    public static void probarListaDoble() {
        ListaDoble<Double> lista = new ListaDoble<>();

        // Agregar elementos
        lista.agregarAlInicio(2.5);
        lista.agregarAlInicio(1.1);
        lista.agregarAlFinal(4.8);
        lista.agregarAlFinal(3.3);

        System.out.println("Lista después de agregar elementos: " + lista.listar());
        System.out.println("Lista en orden inverso: " + lista.listarInverso());
        System.out.println("Tamaño: " + lista.getTamanio());

        // Ordenar
        lista.ordenar();
        System.out.println("Lista después de ordenar: " + lista.listar());

        // Suprimir elemento
        lista.suprimir(2.5);
        System.out.println("Lista después de suprimir 2.5: " + lista.listar());
    }
}
