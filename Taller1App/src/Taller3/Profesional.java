
package Taller3;


public class Profesional extends Persona {
    
    private int sueldo;
    private int aniostrabajo;
    
    
    public Profesional(int cod, String nom, String ap, int ed, int su, int at){
    
        super(cod,nom,ap,ed);  
        sueldo = su;
        aniostrabajo = at;      
    }

    public int getSueldo() {
        return sueldo;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }

    public int getAniostrabajo() {
        return aniostrabajo;
    }

    public void setAniostrabajo(int aniostrabajo) {
        this.aniostrabajo = aniostrabajo;
    }


    
    
}
