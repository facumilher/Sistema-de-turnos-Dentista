package DAO;

import java.util.ArrayList;

import Archivo.Archivo;
import Negocio.Odontologo;

public class DAOOdontologo{
    
    public void guardar(Odontologo odontologo){
        Archivo archivo = new Archivo("Odontologos.txt");
        ArrayList<Object> list = archivo.listar();
        
        Odontologo o = null;
        for(Object objeto : list){
            if(odontologo.getMatricula() == ((Odontologo) objeto).getMatricula()){
                o = (Odontologo) objeto;
            }
        }
        list.remove(o);
        list.add(odontologo);
        archivo.guardar(list);
    }

    public Odontologo recuperar(Integer matricula){
        ArrayList<Odontologo> list = this.listar();
        Odontologo retorno = null;

        for(Odontologo odontologo: list){
            if(odontologo.getMatricula() == matricula)
                retorno = odontologo;
        }
        return retorno;
    }

    public void eliminar(Integer matricula){
        Archivo archivo = new Archivo("Odontologos.txt");
        ArrayList<Object> list = archivo.listar();
        int index = 0;
        int i = 0;
        for (Object objeto: list){
            if(((Odontologo)objeto).getMatricula() == matricula)
                index = i;
            i++;
        }
        
        list.remove(index);
        archivo.guardar(list);
    }

    public ArrayList<Odontologo> listar(){
        Archivo archivo = new Archivo("Odontologos.txt");
        ArrayList<Object> list = archivo.listar();
        ArrayList<Odontologo> odontologo = new ArrayList<>();

        for(Object objeto: list)
            odontologo.add((Odontologo)objeto);
        
        return odontologo;
    }
}