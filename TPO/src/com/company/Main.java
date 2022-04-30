package com.company;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

import Negocio.Administrador;
import Negocio.Odontologo;
import Negocio.Paciente;
import DAO.DAOAdministrador;
import DAO.DAOOdontologo;
import DAO.DAOPaciente;

import GUI.PanelManager;


public class Main {

    public static void main(String[] args) {
        
        PanelManager panelManager=new PanelManager();
        panelManager.armarManager();
        

        

        /*
        
        
        Date date = new Date(System.currentTimeMillis());
        Paciente Carlitos = new Paciente("Carlos", "Sanchez", 36321458, "123", "123", date);
        DAOPaciente daopaciente = new DAOPaciente();
        daopaciente.guardar(Carlitos);

        Paciente Pepe = new Paciente("Pedro", "Perez", 43724595, "pedroperez", "pepino", date);
        daopaciente.guardar(Pepe);

        daopaciente.guardar(Pepe);
        daopaciente.guardar(Pepe);
        daopaciente.guardar(Pepe);

        ArrayList<Paciente> lista = daopaciente.listar();
        System.out.println(lista);

        daopaciente.guardar(Carlitos);

        System.out.println(lista); 
        
        DAOOdontologo daoodontologo = new DAOOdontologo();
        Odontologo Tino = new Odontologo("Valentino", "Salchichi", 46326421);
        daoodontologo.guardar(Tino);
        daoodontologo.guardar(Tino);
        daoodontologo.guardar(Tino);
        daoodontologo.guardar(Tino);
        daoodontologo.guardar(Tino);
        Odontologo Totobobo = new Odontologo("totovovo", "MussoliniHitler", 12345678);
        daoodontologo.guardar(Totobobo); 

        DAOAdministrador daoadministrador = new DAOAdministrador();
        Administrador admin = new Administrador("admin", "123", 0);
        daoadministrador.guardar(admin);
        */
    }
}