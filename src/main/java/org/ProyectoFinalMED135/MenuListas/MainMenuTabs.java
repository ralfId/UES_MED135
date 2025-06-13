package org.ProyectoFinalMED135.MenuListas;

import org.ProyectoFinalMED135.ListasEnlazadas.*;

import javax.swing.*;

public class MainMenuTabs {
    private JFrame frame;
    private JTabbedPane tabbedPane;

    public MainMenuTabs() {
        inicializarComponentes();
    }

    private void inicializarComponentes() {
        frame = new JFrame("Listas Enlazadas");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 500);

        tabbedPane = new JTabbedPane();
        agregarTabConGrid();

        frame.setLocationRelativeTo(null);
        frame.add(tabbedPane);
    }

    private void agregarTabConGrid() {

        // TAB para Lista Simplemente Enlazada
        ListaSimple<String> listaSimple = new ListaSimple<>();
        MenuGrid gridListaSimple =  new MenuGrid(frame, listaSimple, TipoLista.LISTA_SIMPLE);
        String title1 = "Lista Simplemente Enlazada";
        tabbedPane.addTab("Lista Simple", gridListaSimple.crearGrid(title1));

        // TAB para Lista Simplemente Enlazada Circular
        ListaCircularSimple<String> listaCircularSimple =  new ListaCircularSimple<>();
        MenuGrid gridLstCircularSimple = new MenuGrid(frame, listaCircularSimple, TipoLista.LISTA_SIMPLE_CIRCULAR);
        String title2 = "Lista Simplemente Enlazada Circular";
        tabbedPane.addTab("Lista Simple Circular", gridLstCircularSimple.crearGrid(title2));

        // TAB Para Lista Doblemente Enlazada
        ListaDoble<String> listaDoble = new ListaDoble<>();
        MenuGrid gridLstDoble = new MenuGrid(frame, listaDoble, TipoLista.LISTA_DOBLE);
        String title3 = "Lista Doblemente Enlazada";
        tabbedPane.addTab("Lista Doble", gridLstDoble.crearGrid(title3));

        // TAB Para Lista Doblemente Enlazada Circular
        ListaCircularDoble<String> listaCircularDoble = new ListaCircularDoble<>();
        MenuGrid gridLstDobleCircular = new MenuGrid(frame, listaCircularDoble, TipoLista.LISTA_DOBLE_CIRCULAR);
        String title4 = "Lista Doblemente Enlazada Circular";
        tabbedPane.addTab("Lista  Doble Circular", gridLstDobleCircular.crearGrid(title4));
    }

    public void mostrarInterfaz() {
        frame.setVisible(true);
    }

}
