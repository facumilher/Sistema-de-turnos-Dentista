package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelElegirListado extends JPanel {
    private PanelManager panelmanager;

    //botones
    private JButton bListadoP;
    private JButton bListadoO;
    private JButton bSalir;

    public void armarPanelElegirListado(PanelManager panelmanager){
        this.panelmanager = panelmanager;

        bListadoP = new JButton("Abrir listado de pacientes");
        bListadoO = new JButton("Abrir listado de odontologos");
        bSalir = new JButton("Salir");

        this.add(bListadoP);
        this.add(bListadoO);
        this.add(bSalir);

        bSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelmanager.mostrarLogIn();
            }
        });

        bListadoP.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelmanager.mostrarListaPaciente();
            }
        });

        bListadoO.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelmanager.mostrarListaOdontologo();
            }
        });
    }
}