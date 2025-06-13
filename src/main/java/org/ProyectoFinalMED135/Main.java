package org.ProyectoFinalMED135;

import javax.swing.*;

import org.ProyectoFinalMED135.MenuListas.*;

public class Main {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(()->{
            MainMenuTabs menuTabs = new MainMenuTabs();
            menuTabs.mostrarInterfaz();
        });

    }
}
