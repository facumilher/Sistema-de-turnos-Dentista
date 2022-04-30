package GUI;

import javax.swing.*;

import Negocio.Paciente;
import Service.ServicePaciente;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;

public class PanelFormularioPacienteN extends JPanel {
    private PanelManager panelmanager;

    //componentes
    private JLabel lblDNI;
    private JTextField txtDNI;
    private JLabel lblUsuario;
    private JTextField txtUsuario;
    private JLabel lblContra;
    private JTextField txtContra;
    private JLabel lblNombre;
    private JTextField txtNombre;
    private JLabel lblApellido;
    private JTextField txtApellido;
    private JLabel lblDomicilio;
    private JTextField txtDomicilio;
    private JPanel panelC;

    //botones
    private JButton bGuardar;
    private JButton bCancelar;
    private JPanel panelB;


    public void armarPanelFormularioPacienteN(PanelManager panelmanager){
        this.panelmanager=panelmanager;
        this.setLayout(new BorderLayout());

        //armo panel componentes
        lblDNI = new JLabel("DNI:");
        lblUsuario = new JLabel("Usuario:");
        lblContra = new JLabel("Contraseña:");
        lblNombre = new JLabel("Nombre:");
        lblApellido = new JLabel("Apellido:");
        lblDomicilio = new JLabel("Domicilio:");
        txtDNI = new JTextField(5);
        txtUsuario = new JTextField(5);
        txtContra = new JTextField(5);
        txtNombre = new JTextField(5);
        txtApellido = new JTextField(5);
        txtDomicilio = new JTextField(5);
        panelC = new JPanel(new GridLayout());
        panelC.add(lblDNI);
        panelC.add(txtDNI);
        panelC.add(lblUsuario);
        panelC.add(txtUsuario);
        panelC.add(lblContra);
        panelC.add(txtContra);
        panelC.add(lblNombre);
        panelC.add(txtNombre);
        panelC.add(lblApellido);
        panelC.add(txtApellido);
        panelC.add(lblDomicilio);
        panelC.add(txtDomicilio);

        //armo panel botonera
        bGuardar = new JButton("Guardar");
        bCancelar = new JButton("Cancelar");
        panelB = new JPanel();
        panelB.add(bGuardar);
        panelB.add(bCancelar);

        this.add(panelC, BorderLayout.CENTER);
        this.add(panelB, BorderLayout.SOUTH);
        
        bGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ServicePaciente servicepaciente = new ServicePaciente();
                ArrayList<Paciente> list = servicepaciente.listar();
                boolean nuevo = true;
                for(Paciente p: list){
                    if(p.getDni() == Integer.parseInt(txtDNI.getText()))
                        nuevo = false;
                }
                if(nuevo){
                    Date date = new Date(System.currentTimeMillis());
                    Paciente paciente = new Paciente(txtNombre.getText(), txtApellido.getText(), Integer.parseInt(txtDNI.getText()), txtDomicilio.getText(), txtUsuario.getText(), txtContra.getText(), date);
                    servicepaciente.guardar(paciente);
                    panelmanager.mostrarListaPaciente();
                }
                else{
                    JOptionPane.showMessageDialog(null, "Ya se registró paciente con ese DNI", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        bCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelmanager.mostrarListaPaciente();
            }
        });

    }

}