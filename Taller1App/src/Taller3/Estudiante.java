
package Taller3;


public class Estudiante extends Persona {
    
    private int anioactual;
    private int duracioncarrera;
    
        public Estudiante(int cod, String nom, String ap, int ed, int aa, int da){
    
        super(cod,nom,ap,ed);  
        anioactual = aa;
        duracioncarrera = da;      
    }

    public int getAnioactual() {
        return anioactual;
    }

    public void setAnioactual(int anioactual) {
        this.anioactual = anioactual;
    }

    public int getDuracioncarrera() {
        return duracioncarrera;
    }

    public void setDuracioncarrera(int duracioncarrera) {
        this.duracioncarrera = duracioncarrera;
    }
    
        
    
}
