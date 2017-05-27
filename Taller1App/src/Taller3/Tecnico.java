

package Taller3;


public class Tecnico extends Persona {
    
    private int sueldo;
    private int gastos;
    
    
    public Tecnico(int cod, String nom, String ap, int ed, int su, int ga){
    
        super(cod,nom,ap,ed);  
        sueldo = su;
        gastos = ga;      
    }

    public int getSueldo() {
        return sueldo;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }

    public int getGastos() {
        return gastos;
    }

    public void setGastos(int gastos) {
        this.gastos = gastos;
    }
}
