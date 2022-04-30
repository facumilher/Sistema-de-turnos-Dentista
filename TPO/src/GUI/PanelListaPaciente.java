package GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Negocio.Paciente;
import Service.ServicePaciente;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PanelListaPaciente extends JPanel {
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

    public void armarPanelListaPaciente(PanelManager panelmanager){
        this.removeAll();
        this.panelmanager=panelmanager;
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

        contenidoTable.addColumn("DNI");
        contenidoTable.addColumn("NOMBRE");
        contenidoTable.addColumn("APELLIDO");
        
        
        ServicePaciente servicepaciente = new ServicePaciente();
        ArrayList <Paciente> lista = servicepaciente.listar();
        for(Paciente paciente : lista){
            Object [] row = new Object[3];
            row[0] = paciente.getDni();
            row[1] = paciente.getNombre();
            row[2] = paciente.getApellido();
            contenidoTable.addRow(row);
        }

        this.add(scrollPane, BorderLayout.CENTER);
        this.add(panelB, BorderLayout.SOUTH);
        
        bElimiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ServicePaciente servicepaciente = new ServicePaciente();
                int dni =(int) jtable.getValueAt(jtable.getSelectedRow(), 0);
                servicepaciente.eliminar(dni);
                panelmanager.mostrarListaPaciente();
            }
        });
        
        bModifcar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelmanager.mostrarFormularioPacienteM();
            }
        });
        bNuevo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelmanager.mostrarFormularioPacienteN();
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
