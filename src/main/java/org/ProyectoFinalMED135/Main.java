package org.ProyectoFinalMED135;

import org.ProyectoFinalMED135.MenuListas.MenuListaCircularDoble;
import org.ProyectoFinalMED135.MenuListas.MenuListaCircularSimple;
import org.ProyectoFinalMED135.MenuListas.MenuListaDoble;
import org.ProyectoFinalMED135.MenuListas.MenuListaSimple;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== PRUEBA DE LISTAS ENLAZADAS ===\n");

        // Prueba Lista Simplemente Enlazada
        System.out.println("1. LISTA SIMPLEMENTE ENLAZADA:");
        MenuListaSimple.probarListaSimple();


        // Prueba Lista Circular Simplemente Enlazada
        System.out.println("\n2. LISTA CIRCULAR SIMPLEMENTE ENLAZADA:");
        MenuListaCircularSimple.probarListaCircularSimple();

        // Prueba Lista Doblemente Enlazada
        System.out.println("\n3. LISTA DOBLEMENTE ENLAZADA:");
        MenuListaDoble.probarListaDoble();

        // Prueba Lista Circular Doblemente Enlazada
        System.out.println("\n4. LISTA CIRCULAR DOBLEMENTE ENLAZADA:");
        MenuListaCircularDoble.probarListaCircularDoble();
    }
}