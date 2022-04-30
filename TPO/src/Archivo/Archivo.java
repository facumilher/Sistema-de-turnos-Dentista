package Archivo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Archivo{

    private String path;

    public Archivo(String path){
        this.path = path;
    }

    public void guardar(ArrayList<Object> colleccion) {
        FileOutputStream fileOutputStream = null;
        try{
            fileOutputStream = new FileOutputStream(path);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(colleccion);
            objectOutputStream.close();
            fileOutputStream.close();
        }
        catch (FileNotFoundException ex){
            ex.printStackTrace();
        }
        catch (IOException ex){
            ex.printStackTrace();
        }
    }

    public ArrayList<Object> listar(){
        ArrayList<Object> obj = null;
        try{
            FileInputStream fileInputStream = new FileInputStream(path);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            obj = (ArrayList<Object>) objectInputStream.readObject();
            if (obj == null)
                obj = new ArrayList<Object>();
            objectInputStream.close();
            fileInputStream.close();
            
        }
        catch(FileNotFoundException ex){
            ex.printStackTrace();
        }
        catch(IOException ex){
            ex.printStackTrace();
            obj = new ArrayList<Object>();
        }
        catch(ClassNotFoundException ex){
            ex.printStackTrace();
        }
        
        return obj;
    }
}