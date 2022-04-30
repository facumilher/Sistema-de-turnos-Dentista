package DAO;

import java.util.ArrayList;

import Archivo.Archivo;
import Negocio.Paciente;

public class DAOPaciente{

    public void guardar(Paciente paciente){
        Archivo archivo = new Archivo("Pacientes.txt");
        ArrayList<Object> list = archivo.listar();
        
        Paciente p = null;
        for(Object objeto : list){
            if(paciente.getDni() == ((Paciente)objeto).getDni()){
                p = (Paciente) objeto;
            }
        }
        list.remove(p);
        list.add(paciente);
        archivo.guardar(list);
    }

    public Paciente recuperar(int dni){
        ArrayList<Paciente> list = this.listar();
        Paciente retorno = null;

        for(Paciente paciente: list){
            if(paciente.getDni() == dni)
                retorno = paciente;
        }
        return retorno;
    }

    public void eliminar(int dni){
        Archivo archivo = new Archivo("Pacientes.txt");
        ArrayList<Object> list = archivo.listar();
        int index = 0;
        int i = 0;
        for (Object objeto: list){
            if(((Paciente)objeto).getDni() == dni)
                index = i;
            i++;
        }
        
        list.remove(index);
        archivo.guardar(list);
    }

    public ArrayList<Paciente> listar(){
        Archivo archivo = new Archivo("Pacientes.txt");
        ArrayList<Object> list = archivo.listar();
        ArrayList<Paciente> pacientes = new ArrayList<>();

        for(Object objeto: list)
            pacientes.add((Paciente)objeto);
        
        return pacientes;
    }
}