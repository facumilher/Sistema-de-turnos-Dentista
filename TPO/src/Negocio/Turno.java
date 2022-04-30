package Negocio;

import java.io.Serializable;
import java.util.Date;

public class Turno implements Serializable{
    
    private Paciente paciente;
    private Date fechaTurno;
    private Odontologo odontologo;
    private long numero;

    public Turno(Paciente paciente, Date fechaTurno, Odontologo odontologo, long numero){
        this.paciente = paciente;
        this.fechaTurno = fechaTurno;
        this.odontologo = odontologo;
        this.numero = numero;
    }

    public Paciente getPaciente(){
        return paciente;
    }
    public void setPaciente(Paciente paciente){
        this.paciente = paciente;
    }

    public Date getDate(){
        return fechaTurno;
    }
    public void setDate(Date fechaTurno){
        this.fechaTurno = fechaTurno;
    }

    public Odontologo getOdontologo(){
        return odontologo;
    }
    public void setOdontologo(Odontologo odontologo){
        this.odontologo = odontologo;
    }
    
    public long getNumero(){
        return numero;
    }
    public void setNumero(long numero){
        this.numero = numero;
    }
    
} 