package Negocio;

import java.io.Serializable;
import java.sql.Date;

public class Paciente implements Serializable{
    
    private String nombre;
    private String apellido;
    private int dni;
    private String domicilio;
    private String usuario;
    private String contraseña;
    private Date fechaAlta;
    
    public Paciente(String nombre, String apellido, int dni, String domicilio, String usuario, String contraseña, Date fechaAlta) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.domicilio = domicilio;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.fechaAlta = fechaAlta;
    }

    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getApellido(){
        return apellido;
    }
    public void setApellido(String apellido){
        this.apellido = apellido;
    }

    public int getDni(){
        return dni;
    }
    public void setDni(int dni){
        this.dni = dni;
    }

    public String getDomicilio(){
        return domicilio;
    }
    public void setDomicilio(String domicilio){
        this.nombre = domicilio;
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

    public Date getFechadealta(){
        return fechaAlta;
    }
    public void setFechaalta(Date fechaAlta){
        this.fechaAlta= fechaAlta;
    }
}