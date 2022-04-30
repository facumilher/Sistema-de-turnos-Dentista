package Service;

import java.util.ArrayList;

import DAO.DAOTurno;
import Negocio.Turno;

public class ServiceTurno{
    private DAOTurno DAOTurno;

    public ServiceTurno(){
        DAOTurno = new DAOTurno();
    }

    public void guardar(Turno Turno){
        DAOTurno.guardar(Turno);
       
    }

    public Turno recuperar(int numero){
        return DAOTurno.recuperar(numero);
    }

    public void eliminar(int numero){
        DAOTurno.eliminar(numero);
    }

    public ArrayList<Turno> listar(){
        return DAOTurno.listar();
    }
}