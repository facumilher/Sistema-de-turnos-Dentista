package Service;

import java.util.ArrayList;

import DAO.DAOPaciente;
import Negocio.Paciente;

public class ServicePaciente{
    private DAOPaciente DAOPaciente;

    public ServicePaciente(){
        DAOPaciente = new DAOPaciente();
    }

    public void guardar(Paciente Paciente){
        DAOPaciente.guardar(Paciente);
       
    }

    public Paciente recuperar(int id){
        return DAOPaciente.recuperar(id);
    }

    public void eliminar(int id){
        DAOPaciente.eliminar(id);
    }

    public ArrayList<Paciente> listar(){
        return DAOPaciente.listar();
    }
}