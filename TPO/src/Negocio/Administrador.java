package Negocio;

import java.io.Serializable;

public class Administrador implements Serializable {

    private String usuario;
    private String contraseña;
    private long id;

    public Administrador(String usuario, String contraseña, long id){
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.id = id;
    }

    public String getusuario(){
        return usuario;
    }
    public void setUsuario(String usuario){
        this.usuario = usuario;
    }

    public String getContraseña(){
        return contraseña;
    }
    public void setContraseña(String contraseña){
        this.contraseña= contraseña;
    }

    public long getId(){
        return id;
    }
    public void setId(long id){
        this.id = id;
    }
}