/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Taller3;

/**
 *
 * @author favya
 */
public class Credito {
    
    private int codigo;
    private int montoSolicitado;
    private double tasaInteres;
    private int cantCoutas;
    private Persona persona;

    public Credito(int codigo, int montoSolicitado, double tasaInteres, int cantCoutas) {
        this.codigo = codigo;
        this.montoSolicitado = montoSolicitado;
        this.tasaInteres = tasaInteres;
        this.cantCoutas = cantCoutas;
        persona = null;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getMontoSolicitado() {
        return montoSolicitado;
    }

    public void setMontoSolicitado(int montoSolicitado) {
        this.montoSolicitado = montoSolicitado;
    }

    public double getTasaInteres() {
        return tasaInteres;
    }

    public void setTasaInteres(int tasaInteres) {
        this.tasaInteres = tasaInteres;
    }

    public int getCantCoutas() {
        return cantCoutas;
    }

    public void setCantCoutas(int cantCoutas) {
        this.cantCoutas = cantCoutas;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    
    
    
    
    
}
