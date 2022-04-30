package Service;

import java.util.ArrayList;

import DAO.DAOAdministrador;
import Negocio.Administrador;

public class ServiceAdministrador{
    private DAOAdministrador DAOAdministrador;

    public ServiceAdministrador(){
        DAOAdministrador = new DAOAdministrador();
    }

    public void guardar(Administrador Administrador){
        DAOAdministrador.guardar(Administrador);
       
    }

    public Administrador recuperar(int id){
        return DAOAdministrador.recuperar(id);
    }

    public void eliminar(int id){
        DAOAdministrador.eliminar(id);
    }

    public ArrayList<Administrador> listar(){
        return DAOAdministrador.listar();
    }
}