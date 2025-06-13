package org.ProyectoFinalMED135.MenuListas;

import org.ProyectoFinalMED135.ListasEnlazadas.IListaEnlazada;
import org.ProyectoFinalMED135.ListasEnlazadas.ListaSimple;
import org.ProyectoFinalMED135.ListasEnlazadas.TipoLista;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class MenuGrid {
    private JFrame frame;
    private IListaEnlazada lista;
    private JTextArea areaLista;
    private JTextField campoDato;
    private JList listView;
    private DefaultListModel<String> listModel;
    private TipoLista tipoLista;

    public MenuGrid(JFrame mainFrame, IListaEnlazada listaEnlazada, TipoLista tipoLst) {
        frame = mainFrame;
        lista = listaEnlazada;
        tipoLista = tipoLst;
    }

    public JPanel crearGrid( String tituloLst) {
        JPanel mainPanel = new JPanel(new BorderLayout());

        JLabel titulo = new JLabel(tituloLst, SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 18));
        titulo.setBorder(new EmptyBorder(20, 10, 10, 10));
        mainPanel.add(titulo, BorderLayout.NORTH);

        JPanel gridPanel = new JPanel(new GridLayout(1, 2, 10, 10));
        gridPanel.add(crearPanelFormulario());
        gridPanel.add(crearPanelDerecho());

        mainPanel.add(gridPanel, BorderLayout.CENTER);

        return mainPanel;
    }

    private JPanel crearPanelFormulario() {
        JPanel panel = new JPanel(new BorderLayout(5, 5));
        panel.setBorder(BorderFactory.createTitledBorder("Operaciones"));

        // Panel para campos y botones
        JPanel panelControles = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Campo para ingresar datos
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panelControles.add(new JLabel("Dato:"), gbc);

        gbc.gridy = 1;
        campoDato = new JTextField(15);
        panelControles.add(campoDato, gbc);

        // Botones de operaciones
        gbc.gridwidth = 1;
        gbc.gridy = 2;
        panelControles.add(crearBoton("Agregar Inicio", e -> agregarAlInicio()), gbc);

        gbc.gridx = 1;
        panelControles.add(crearBoton("Agregar Final", e -> agregarAlFinal()), gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panelControles.add(crearBoton("Suprimir", e -> suprimir()), gbc);

        gbc.gridx = 1;
        panelControles.add(crearBoton("Ordenar", e -> ordenar()), gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        panelControles.add(crearBoton("Vaciar Lista", e -> vaciarLista()), gbc);

        panel.add(panelControles, BorderLayout.NORTH);

        return panel;
    }

    private JPanel crearPanelDerecho() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createTitledBorder("Lista"));

        // Crear modelo de datos para la JList
        listModel = new DefaultListModel<>();
        listView = new JList<>(listModel);
        listView.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listView.setLayoutOrientation(JList.VERTICAL);
        listView.setVisibleRowCount(-1);
        listView.setFont(new Font("Monospaced", Font.PLAIN, 12));

        // Añadir scroll pane
        JScrollPane scrollPane = new JScrollPane(listView);
        scrollPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        scrollPane.setPreferredSize(new Dimension(300, 200));

        panel.add(scrollPane, BorderLayout.CENTER);

        // Inicializar con mensaje de lista vacía
        mostrarLista();

        return panel;

    }

    private JButton crearBoton(String texto, ActionListener listener) {
        JButton boton = new JButton(texto);
        boton.addActionListener(listener);
        return boton;
    }

    // Métodos para operaciones con la lista
    private void agregarAlInicio() {
        String dato = campoDato.getText().trim();
        if (!dato.isEmpty()) {
            lista.agregarAlInicio(dato);
            campoDato.setText("");
            mostrarLista();
        }
    }

    private void agregarAlFinal() {
        String dato = campoDato.getText().trim();
        if (!dato.isEmpty()) {
            lista.agregarAlFinal(dato);
            campoDato.setText("");
            mostrarLista();
        }
    }

    private void suprimir() {
        String dato = campoDato.getText().trim();
        if (!dato.isEmpty()) {
            if (lista.suprimir(dato)) {
                JOptionPane.showMessageDialog(frame, "Dato eliminado: " + dato);
            } else {
                JOptionPane.showMessageDialog(frame, "Dato no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
            }
            campoDato.setText("");
            mostrarLista();
        }
    }

    private void ordenar() {
        lista.ordenar();
        mostrarLista();
        JOptionPane.showMessageDialog(frame, "Lista ordenada");
    }

    private void vaciarLista() {
        lista.vaciar();
        mostrarLista();
        JOptionPane.showMessageDialog(frame, "Lista vaciada");
    }


    /**
     * Actualiza la JList con los elementos de la lista enlazada
     */
    private void mostrarLista() {
        // Limpiar el modelo actual
        listModel.clear();

        // Obtener el string de la lista
        String contenidoLista = lista.listar();

        if (contenidoLista.equals("Lista vacía")) {
            listModel.addElement("La lista está vacía");
        } else {
            // Dividir el string por el separador " <-> " para obtener elementos individuales
            String separador = getSeparador();
            String[] elementos = contenidoLista.split(separador);
            for (String elemento : elementos) {
                listModel.addElement(elemento.trim());
            }
        }
    }

    private String getSeparador(){
        if(tipoLista.equals(TipoLista.LISTA_SIMPLE) || tipoLista.equals(TipoLista.LISTA_SIMPLE_CIRCULAR)){
            return " -> ";
        }else{
            return " <-> ";
        }
    }
}
