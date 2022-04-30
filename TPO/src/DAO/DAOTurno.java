package DAO;

import java.util.ArrayList;

import Archivo.Archivo;
import Negocio.Turno;

public class DAOTurno{
    
    public void guardar(Turno turno){
        Archivo archivo = new Archivo("Turnos.txt");
        ArrayList<Object> list = archivo.listar();
        long max = 0;

        if(turno.getNumero() == 0) {
           for(Object objeto: list){
               if(((Turno) objeto).getNumero() > max)
                   max = ((Turno) objeto).getNumero();
           }
           turno.setNumero(max + 1);
           list.add(turno);
       }
       else{
           Turno t = null;
           for(Object objeto : list){
               if(((Turno) objeto).getNumero() == turno.getNumero()){
                   t = (Turno) objeto;
               }
           }
            list.remove(t);
            list.add(turno);
       }
        archivo.guardar(list);
    }

    public Turno recuperar(int numero){
        ArrayList<Turno> list = this.listar();
        Turno retorno = null;

        for(Turno turno: list){
            if(turno.getNumero() == numero)
                retorno = turno;
        }
        return retorno;
    }

    public void eliminar(int numero){
        Archivo archivo = new Archivo("Turnos.txt");
        ArrayList<Object> list = archivo.listar();
        int index = 0;
        int i = 0;
        for (Object objeto: list){
            if(((Turno)objeto).getNumero() == numero)
                index = i;
            i++;
        }
        
        list.remove(index);
        archivo.guardar(list);
    }

    public ArrayList<Turno> listar(){
        Archivo archivo = new Archivo("Turnos.txt");
        ArrayList<Object> list = archivo.listar();
        ArrayList<Turno> turnos = new ArrayList<>();

        for(Object objeto: list)
            turnos.add((Turno)objeto);
        
        return turnos;
    }
}