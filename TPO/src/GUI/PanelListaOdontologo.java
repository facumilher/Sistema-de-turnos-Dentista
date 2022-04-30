package GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Negocio.Odontologo;
import Service.ServiceOdontologo;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PanelListaOdontologo extends JPanel {
    private PanelManager panelmanager;

    //Tabla
    private JTable jtable;
    private DefaultTableModel contenidoTable;
    private JScrollPane scrollPane;

    //Botones
    private JButton bNuevo;
    private JButton bElimiar;
    private JButton bModifcar;
    private JButton bCancelar;
    private JPanel panelB;

    public void armarPanelListaOdontologo(PanelManager panelmanager){
        this.removeAll();
        this.panelmanager = panelmanager;
        this.setLayout(new BorderLayout());

        //creo botonera
        bNuevo = new JButton("Nuevo");
        bModifcar = new JButton("Modificar");
        bElimiar = new JButton("Eliminar");
        bCancelar = new JButton("Cancelar");
        panelB = new JPanel();
        panelB.add(bNuevo);
        panelB.add(bModifcar);
        panelB.add(bElimiar);
        panelB.add(bCancelar);

        //Creo Listado
        contenidoTable = new DefaultTableModel();
        jtable = new JTable(contenidoTable);
        scrollPane = new JScrollPane();
        scrollPane.setViewportView(jtable);

        contenidoTable.addColumn("MATRÍCULA");
        contenidoTable.addColumn("NOMBRE");
        contenidoTable.addColumn("APELLIDO");

        ServiceOdontologo serviceOdontologo = new ServiceOdontologo();
        ArrayList<Odontologo> lista = serviceOdontologo.listar();
        for(Odontologo odontologo: lista){
            Object [] row = new Object[3];
            row[0] = odontologo.getMatricula();
            row[1] = odontologo.getNombre();
            row[2] = odontologo.getApellido();
            contenidoTable.addRow(row);
        }
        
        this.add(scrollPane, BorderLayout.CENTER);
        this.add(panelB, BorderLayout.SOUTH);

        bElimiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ServiceOdontologo serviceodontologo = new ServiceOdontologo();
                int matricula =(int) jtable.getValueAt(jtable.getSelectedRow(), 0);
                serviceodontologo.eliminar(matricula);
                panelmanager.mostrarListaOdontologo();
            }
        });

        bModifcar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelmanager.mostrarFormularioOdontologoM();
            }
        });

        bNuevo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelmanager.mostrarFormularioOdontologoN();
            }
        });

        bCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelmanager.mostrarElegirListado();
            }
        });
    }

}