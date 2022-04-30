package GUI;

import javax.swing.*;

import Negocio.Administrador;
import Negocio.Paciente;
import Service.ServiceAdministrador;
import Service.ServicePaciente;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PanelLogIn extends JPanel {
    private PanelManager panelmanager;
    private JLabel lblUsuario;
    private JLabel lblContra;
    private JTextField txtUsuario;
    private JTextField txtContra;
    private JPanel panelC;

    private JButton bIniciar;
    private JButton bSalir;
    private JPanel bPanel;


    public void armarPanelLogIn(PanelManager panelmanager){
        this.panelmanager = panelmanager;
        this.setLayout(new BorderLayout());

        lblUsuario = new JLabel("Usuario:");
        lblContra = new JLabel("Contraseña:");
        txtUsuario = new JTextField(5);
        txtContra = new JTextField(5);
        panelC = new JPanel(new GridLayout());

        panelC.add(lblUsuario);
        panelC.add(txtUsuario);
        panelC.add(lblContra);
        panelC.add(txtContra);

        bIniciar = new JButton("Iniciar sesión");
        bSalir = new JButton("Salir del sistema");
        bPanel = new JPanel();
        bPanel.add(bIniciar);
        bPanel.add(bSalir);

        this.add(panelC,BorderLayout.CENTER);
        this.add(bPanel,BorderLayout.SOUTH);

        bIniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(txtUsuario.getText().equals("admin")){
                    ServiceAdministrador serviceadministrador = new ServiceAdministrador();
                    ArrayList<Administrador> list = serviceadministrador.listar();
                    if(list.get(0).getContraseña().equals(txtContra.getText()))
                        panelmanager.mostrarElegirListado();
                    else{
                    JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                }
                else{
                    ServicePaciente servicepaciente = new ServicePaciente();
                    ArrayList<Paciente> list = servicepaciente.listar();
                    boolean login = false;
                    Paciente paciente = null; 
                    for(Paciente p: list){
                        if(txtUsuario.getText().equals(p.getusuario()) && txtContra.getText().equals(p.getContraseña())){
                            paciente = p;
                            login = true;
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos", "ERROR", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    if(login) 

                        panelmanager.setPaciente(paciente);
                        panelmanager.mostrarPacienteElegir();
                }
            }
        });

         bSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        
    }
}