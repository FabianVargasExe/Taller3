

package Taller3;


public class ListaPersonas {
    
    
    private Persona [] lp;
    private int cantPersonas;
    private int max;
    
    public ListaPersonas(int max){
        this.max = max;
        lp = new Persona[max];
        cantPersonas = 0;
    }
    
   public int getCantPersonas (){
       return cantPersonas;
   }

   public void ingresaTecnico(int cod, String nom, String ap, int ed, int su, int ga){
   Persona t = new Tecnico(cod, nom, ap, ed, su, ga);
   this.ingresarPersonas(t);
   }
   
   public void ingresaProfesional(int cod, String nom, String ap, int ed,  int su, int at){
   Persona p = new Profesional(cod, nom, ap, ed, su, at);
   this.ingresarPersonas(p);
   }

   public void ingresaEstudiante(int cod, String nom, String ap, int ed, int aa, int da){
   Persona e = new Estudiante(cod, nom, ap, ed, aa, da);
   this.ingresarPersonas(e);
   }
   
   public boolean ingresarPersonas (Persona p){
       if(cantPersonas < max){
           lp[cantPersonas] = p;
           cantPersonas++;
           return true;
       }else{
           return false;
       }
   }
   
   public boolean eliminar(int cod) {
// elimina la persona del contenedor
    int i;
    for(i=0; i< cantPersonas; i++){
       if(lp[i].getCodigo() == cod) {
          break;
        }
    }
    if(i== cantPersonas) { 
       return false;
    }
    else { 
       for(int j=i; j< cantPersonas - 1; j++) {
           lp[j] = lp[j+1];
       } 
          cantPersonas --; 
          return true; 
       } 
    }
   
   public Persona buscarPersona (int cod) {
       int i;
       for(i = 0; i < cantPersonas; i++){
           if(lp[i].getCodigo() == cod){
               break;
           }
       }
       if (i == cantPersonas){
          return null;
       }else{
            return lp[i];
       }

   }  
   public Persona getPersonaI(int i){
       if(i < cantPersonas && i >= 0){
           return lp[i];
       }else{
            return null;
       }
   }
   
   
    
}
