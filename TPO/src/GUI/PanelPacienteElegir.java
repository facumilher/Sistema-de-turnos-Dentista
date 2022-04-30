package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelPacienteElegir extends JPanel {
    private PanelManager panelmanager;

    //botones
    private JButton bReservarT;
    private JButton bConsultarT;
    private JButton bSalir;

    public void armarPanelPacienteElegir(PanelManager panelmanager){
       this.panelmanager = panelmanager;

        bReservarT = new JButton("Reservar nuevo turno");
        bConsultarT = new JButton("Consultar turnos");
        bSalir = new JButton("Salir");

        this.add(bReservarT);
        this.add(bConsultarT);
        this.add(bSalir);

        bReservarT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelmanager.mostrarPacienteListaOdontologo();
            }
        });

        bConsultarT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelmanager.mostrarPacienteConsultarTurnos();
            }
        });

        bSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelmanager.mostrarLogIn();
            }
        });
    }
}