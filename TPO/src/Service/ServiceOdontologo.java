package Service;

import java.util.ArrayList;

import DAO.DAOOdontologo;
import Negocio.Odontologo;

public class ServiceOdontologo {
    private DAOOdontologo DAOOdontologo;

    public ServiceOdontologo(){
        DAOOdontologo = new DAOOdontologo();
    }

    public void guardar(Odontologo odontologo){
        DAOOdontologo.guardar(odontologo);
       
    }

    public Odontologo recuperar(int matricula){
        return DAOOdontologo.recuperar(matricula);
    }

    public void eliminar(int matricula){
        DAOOdontologo.eliminar(matricula);
    }

    public ArrayList<Odontologo> listar(){
        return DAOOdontologo.listar();
    }
}