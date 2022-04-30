package GUI;

import javax.swing.*;

import Negocio.Odontologo;
import Service.ServiceOdontologo;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PanelFormularioOdontologoM extends JPanel {
    private PanelManager panelmanager;

    //componentes
    private JLabel lblMatricula;
    private JTextField txtMatricula;
    private JLabel lblNombre;
    private JTextField txtNombre;
    private JLabel lblApellido;
    private JTextField txtApellido;
    private JPanel panelC;

    //botones
    private JButton bGuardar;
    private JButton bCancelar;
    private JPanel panelB;

    public void armarPanelFormularioOdontologoM(PanelManager panelmanager){
        this.panelmanager = panelmanager;
        this.setLayout(new BorderLayout());
        lblMatricula = new JLabel("Matricula:");
        lblNombre = new JLabel("Nombre:");
        lblApellido = new JLabel("Apellido:");
        txtMatricula = new JTextField(5);
        txtNombre = new JTextField(5);
        txtApellido = new JTextField(5);
        panelC = new JPanel(new GridLayout());
        panelC.add(lblMatricula);
        panelC.add(txtMatricula);
        panelC.add(lblNombre);
        panelC.add(txtNombre);
        panelC.add(lblApellido);
        panelC.add(txtApellido);

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
                ServiceOdontologo serviceOdontologo = new ServiceOdontologo();
                ArrayList<Odontologo> list = serviceOdontologo.listar();
                boolean nuevo = true;
                for(Odontologo o: list){
                    if(o.getMatricula() == Integer.parseInt(txtMatricula.getText()))
                        nuevo = false;
                }
                if(!nuevo){
                    Odontologo odontologo = new Odontologo(txtNombre.getText(), txtApellido.getText(), Integer.parseInt(txtMatricula.getText()));
                    serviceOdontologo.guardar(odontologo);
                    panelmanager.mostrarListaOdontologo();
                }
                else{
                    JOptionPane.showMessageDialog(null, "No se registró odontólogo con esa matricula", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        bCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelmanager.mostrarListaOdontologo();
            }
        });

    }

}
