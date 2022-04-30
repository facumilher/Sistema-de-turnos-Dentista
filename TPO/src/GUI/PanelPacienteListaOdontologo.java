package GUI;

import javax.swing.*;
import javax.swing.event.MouseInputListener;
import javax.swing.table.DefaultTableModel;

import Negocio.Odontologo;
import Negocio.Paciente;
import Negocio.Turno;
import Service.ServiceOdontologo;
import Service.ServiceTurno;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.util.ArrayList;

public class PanelPacienteListaOdontologo extends JPanel{

    private PanelManager panelmanager;
    private Odontologo odontologo;

    //PanelBotones
    private JButton bSeleccionar;
    private JButton bCancelar;
    private JPanel panelB;

    //PanelCentro
    private JPanel panelC;
    
    //Panel Lista Odontologos
    private JTable jtable;
    private DefaultTableModel contenidoTable;
    private JScrollPane scrollPane;

    //Panel Lista Turnos
    private JTable jtable2;
    private DefaultTableModel contenidoTable2;
    private JScrollPane scrollPane2;
    
    public void armarPanelPacienteListaOdontologo(PanelManager panelmanager){
        this.panelmanager = panelmanager;
        this.setLayout(new BorderLayout());

        //creo botonera
        bSeleccionar = new JButton("Reservar turno");
        bCancelar = new JButton("Cancelar");
        panelB = new JPanel();
        panelB.add(bSeleccionar);
        panelB.add(bCancelar);

        //creo panel centro
        panelC = new JPanel();
        panelC.setLayout(new GridLayout());

        //creo panel lista odontologo
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
        
        //creo panel turnos
        contenidoTable2 = new DefaultTableModel();
        jtable2 = new JTable(contenidoTable2);
        scrollPane2 = new JScrollPane();
        scrollPane2.setViewportView(jtable2);

        contenidoTable2.addColumn("NÚMERO");
        contenidoTable2.addColumn("DÍA");
        contenidoTable2.addColumn("HORA");
        contenidoTable2.addColumn("DISPONIBILIDAD");

        panelC.add(scrollPane);
        panelC.add(scrollPane2);
        this.add(panelC, BorderLayout.CENTER);
        this.add(panelB, BorderLayout.SOUTH);


        jtable.addMouseListener( (MouseListener) new MouseInputListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int matricula =(int) jtable.getValueAt(jtable.getSelectedRow(), 0);

                Odontologo od = new Odontologo((String) jtable.getValueAt(jtable.getSelectedRow(), 1),(String) jtable.getValueAt(jtable.getSelectedRow(), 2), matricula);

                scrollPane2.removeAll();
                contenidoTable2 = new DefaultTableModel();
                jtable2 = new JTable(contenidoTable2);
                scrollPane2 = new JScrollPane();
                scrollPane2.setViewportView(jtable2);

                ServiceTurno serviceturno = new ServiceTurno();
                ArrayList<Turno> lista = serviceturno.listar();
                contenidoTable2.addColumn("DÍA");
                contenidoTable2.addColumn("HORA");
                contenidoTable2.addColumn("DISPONIBILIDAD");
                Date date = new Date(System.currentTimeMillis());
                int diaActual = date.getDay();
                for (int dia = 1; dia < 7; dia++){
                    for (int hora = 9; hora < 20; hora++){
                        Object [] row = new Object[3];
                        row[0] = diaActual + dia;
                        row[1] = hora;
                        row[2] = "SI";
                        for(Turno tu: lista){
                            if(matricula == tu.getOdontologo().getMatricula() && dia == tu.getDate().getDay() && hora == tu.getDate().getHours())
                                row[2] = "NO";
                            
                        }
                    }
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                
            }

            @Override
            public void mouseExited(MouseEvent e) {
                
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                
            }
        });

        bSeleccionar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
                if(jtable2.getValueAt(jtable2.getSelectedRow(), 3).equals("SI")){
                    ServiceTurno serviceturno = new ServiceTurno();
                    Paciente paciente = panelmanager.getPaciente();
                    Date fechaTurno = new Date(0);
                    fechaTurno.setDate((int)jtable2.getValueAt(jtable2.getSelectedRow(), 0));
                    fechaTurno.setHours((int)jtable2.getValueAt(jtable2.getSelectedRow(), 1));

                    Turno turno = new Turno(paciente, fechaTurno, odontologo, 0);
                    serviceturno.guardar(turno);
                    
                }
                panelmanager.mostrarPacienteElegir();
			}
        }
        );

        bCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panelmanager.mostrarPacienteElegir();
			}
        });
    }
}