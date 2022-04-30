package GUI;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Negocio.Turno;
import Service.ServiceTurno;

public class PanelPacienteConsultarTurnos extends JPanel {
    private PanelManager panelmanager;
    
    private JTable jtable;
    private DefaultTableModel contenidoTable;
    private JScrollPane scrollPane;

    private JLabel lblUsuario;
    private JTextField txtUsuario;
    private JButton bBuscar;
    private JButton bSalir;
    private JButton bClear;
    private JPanel panelB;
    
    public void armarPanelPacienteConsultarTurnos(PanelManager panelmanager){
        this.removeAll();
        this.panelmanager = panelmanager;
        this.setLayout(new BorderLayout());
        
        lblUsuario = new JLabel("Usuario:");
        txtUsuario = new JTextField(5);
        bBuscar = new JButton("Buscar");
        bSalir = new JButton("Salir");
        bClear = new JButton("Vaciar");
        panelB = new JPanel();
        panelB.add(lblUsuario);
        panelB.add(txtUsuario);
        panelB.add(bBuscar);
        panelB.add(bClear);
        panelB.add(bSalir);

        //Creo Listado
        contenidoTable = new DefaultTableModel();
        jtable = new JTable(contenidoTable);
        scrollPane = new JScrollPane();
        scrollPane.setViewportView(jtable);

        contenidoTable.addColumn("Número de Turno");
        contenidoTable.addColumn("Nombre Odontologo");
        contenidoTable.addColumn("Apellido Odontologo");
        contenidoTable.addColumn("Nombre Paciente");
        contenidoTable.addColumn("Apellido Paciente");
        contenidoTable.addColumn("Día del Turno");
        contenidoTable.addColumn("Hora del Turno");
        
        this.add(scrollPane, BorderLayout.CENTER);
        this.add(panelB, BorderLayout.SOUTH);
        

        bSalir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panelmanager.mostrarPacienteElegir();
            }
        });
        
        bClear.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				panelmanager.mostrarPacienteConsultarTurnos();
			} 
        });

        bBuscar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
                ServiceTurno serviceturno = new ServiceTurno();
                ArrayList<Turno> lista = serviceturno.listar();
                for(Turno tu: lista){
                    Object [] row = new Object[7];
                    if(tu.getPaciente().getusuario().equals(txtUsuario.getText())){
                        row[0] = tu.getNumero();
                        row[1] = tu.getOdontologo().getNombre();
                        row[2] = tu.getOdontologo().getApellido();
                        row[3] = tu.getPaciente().getNombre();
                        row[4] = tu.getPaciente().getApellido();
                        row[5] = tu.getDate().getDate();
                        row[6] = tu.getDate().getTime();
                        contenidoTable.addRow(row);
                    }       
                }
            }
        });
    }
}