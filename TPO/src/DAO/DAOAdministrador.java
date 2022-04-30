package DAO;

import java.util.ArrayList;

import Archivo.Archivo;
import Negocio.Administrador;

public class DAOAdministrador {

     public void guardar(Administrador administrador){
        Archivo archivo = new Archivo("Administrador.txt");
        ArrayList<Object> list = archivo.listar();
        long max = 0;

        if(administrador.getId() == 0) {
           for(Object objeto: list){
               if(((Administrador) objeto).getId() > max)
                   max = ((Administrador) objeto).getId();
           }
           administrador.setId(max + 1);
           list.add(administrador);
       }
       else{
           Administrador a = null;
           for(Object objeto : list){
               if(((Administrador) objeto).getId() == administrador.getId()){
                   a = (Administrador) objeto;
               }
           }
            list.remove(a);
            list.add(administrador);
       }
        archivo.guardar(list);
    }

    public Administrador recuperar(int id){
        ArrayList<Administrador> list = this.listar();
        Administrador retorno = null;

        for(Administrador administrador: list){
            if(administrador.getId() == id)
                retorno = administrador;
        }
        return retorno;
    }

    public void eliminar(int id){
        Archivo archivo = new Archivo("Administrador.txt");
        ArrayList<Object> list = archivo.listar();
        
        int index = 0;
        int i = 0;
        for (Object objeto: list){
            if(((Administrador)objeto).getId() == id)
                index = i;
            i++;
        }
        
        list.remove(index);
        archivo.guardar(list);
    }

    public ArrayList<Administrador> listar(){
        Archivo archivo = new Archivo("Administrador.txt");
        ArrayList<Object> list = archivo.listar();
        ArrayList<Administrador> administrador = new ArrayList<>();

        for(Object objeto: list)
            administrador.add((Administrador)objeto);
        
        return administrador;
    }
    
}