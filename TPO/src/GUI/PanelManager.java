package GUI;

import javax.swing.*;

import Negocio.Paciente;

public class PanelManager {

    private Paciente paciente;
    
    private JFrame frame;
    private PanelLogIn panellogin;
    private PanelListaPaciente panellistapaciente;
    private PanelFormularioPacienteM panelformulariopacientem;
    private PanelFormularioPacienteN panelformulariopacienten;
    private PanelElegirListado panelelegirlistado;
    private PanelListaOdontologo panellistaodontologo;
    private PanelFormularioOdontologoM panelformularioodontologom;
    private PanelFormularioOdontologoN panelformularioodontologon;
    private PanelPacienteListaOdontologo panelpacientelistaodontologo;
    private PanelPacienteElegir panelpacienteelegir;
    private PanelPacienteConsultarTurnos panelpacienteconsultarturnos;

    public void setPaciente(Paciente paciente){
        this.paciente = paciente;
    }
    public Paciente getPaciente(){
        return paciente;
    }

    public void armarManager(){
        frame = new JFrame();
        frame.setBounds(200,200,1000,200);

        panellistapaciente = new PanelListaPaciente();
        panellistapaciente.armarPanelListaPaciente(this);

        panelformulariopacientem = new PanelFormularioPacienteM();
        panelformulariopacientem.armarPanelFormularioPacienteM(this);

        panelformulariopacienten = new PanelFormularioPacienteN();
        panelformulariopacienten.armarPanelFormularioPacienteN(this);

        panelelegirlistado = new PanelElegirListado();
        panelelegirlistado.armarPanelElegirListado(this);

        panellistaodontologo = new PanelListaOdontologo();
        panellistaodontologo.armarPanelListaOdontologo(this);

        panelformularioodontologom = new PanelFormularioOdontologoM();
        panelformularioodontologom.armarPanelFormularioOdontologoM(this);

        panelformularioodontologon = new PanelFormularioOdontologoN();
        panelformularioodontologon.armarPanelFormularioOdontologoN(this);

        panelpacientelistaodontologo = new PanelPacienteListaOdontologo();
        panelpacientelistaodontologo.armarPanelPacienteListaOdontologo(this);

        panelpacienteelegir = new PanelPacienteElegir();
        panelpacienteelegir.armarPanelPacienteElegir(this);

        panelpacienteconsultarturnos = new PanelPacienteConsultarTurnos();
        panelpacienteconsultarturnos.armarPanelPacienteConsultarTurnos(this);

        panellogin = new PanelLogIn();
        panellogin.armarPanelLogIn(this);

        mostrarLogIn();
        frame.setVisible(true);
    }

    public void mostrarLogIn(){
        frame.getContentPane().removeAll();
        frame.getContentPane().add(panellogin);
        frame.getContentPane().validate();
        frame.getContentPane().repaint();
    }
    public void mostrarListaPaciente(){
        panellistapaciente.armarPanelListaPaciente(this);
        frame.getContentPane().removeAll();
        frame.getContentPane().add(panellistapaciente);
        frame.getContentPane().validate();
        frame.getContentPane().repaint();
    }
    public void mostrarFormularioPacienteM(){
        frame.getContentPane().removeAll();
        frame.getContentPane().add(panelformulariopacientem);
        frame.getContentPane().validate();
        frame.getContentPane().repaint();
    }
    public void mostrarFormularioPacienteN(){
        frame.getContentPane().removeAll();
        frame.getContentPane().add(panelformulariopacienten);
        frame.getContentPane().validate();
        frame.getContentPane().repaint();
    }
    public void mostrarElegirListado(){
        frame.getContentPane().removeAll();
        frame.getContentPane().add(panelelegirlistado);
        frame.getContentPane().validate();
        frame.getContentPane().repaint();
    }
    public void mostrarListaOdontologo(){
        panellistaodontologo.armarPanelListaOdontologo(this);
        frame.getContentPane().removeAll();
        frame.getContentPane().add(panellistaodontologo);
        frame.getContentPane().validate();
        frame.getContentPane().repaint();
    }
    public void mostrarFormularioOdontologoM(){
        frame.getContentPane().removeAll();
        frame.getContentPane().add(panelformularioodontologom);
        frame.getContentPane().validate();
        frame.getContentPane().repaint();
    }
    public void mostrarFormularioOdontologoN(){
        frame.getContentPane().removeAll();
        frame.getContentPane().add(panelformularioodontologon);
        frame.getContentPane().validate();
        frame.getContentPane().repaint();
    }
    public void mostrarPacienteListaOdontologo(){
        frame.getContentPane().removeAll();
        frame.getContentPane().add(panelpacientelistaodontologo);
        frame.getContentPane().validate();
        frame.getContentPane().repaint();
    }
    public void mostrarPacienteElegir(){
        frame.getContentPane().removeAll();
        frame.getContentPane().add(panelpacienteelegir);
        frame.getContentPane().validate();
        frame.getContentPane().repaint();
    }
    public void mostrarPacienteConsultarTurnos(){
        panelpacienteconsultarturnos.armarPanelPacienteConsultarTurnos(this);
        frame.getContentPane().removeAll();
        frame.getContentPane().add(panelpacienteconsultarturnos);
        frame.getContentPane().validate();
        frame.getContentPane().repaint();
    }
}