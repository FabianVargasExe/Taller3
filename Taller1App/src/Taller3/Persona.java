/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Taller3;


public abstract class Persona {
    
    private int codigo;
    private String nombre;
    private String apellido;
    private int edad;
    private ListaCreditos listaCreditos;
    
    protected Persona(int cod, String nom, String ap, int ed){
        
        codigo = cod;
        nombre = nom;
        apellido = ap;
        edad = ed;
        listaCreditos = new ListaCreditos(1000);
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public ListaCreditos getListaCreditos() {
        return listaCreditos;
    }

    public void setListaCreditos(ListaCreditos listaCreditos) {
        this.listaCreditos = listaCreditos;
    }
 

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }


    
    
}
