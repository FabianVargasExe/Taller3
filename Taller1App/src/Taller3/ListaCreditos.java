

package Taller3;


public class ListaCreditos {
    
    private Credito [] lc;
    private int cantCreditos;
    private int max;
    
    public ListaCreditos(int max){
        this.max = max;
        lc = new Credito[max];
        cantCreditos = 0;
    }
    
   public int getCantCreditos (){
       return cantCreditos;
   }

   
   public boolean ingresarCreditos (Credito c){
       if(cantCreditos < max){
           lc [cantCreditos] = c;
           cantCreditos++;
           return true;
       }else{
           return false;
       }
   }
   
   public Credito buscarCredito (int cod) {
       int i;
       for(i = 0; i < cantCreditos; i++){
           if(lc[i].getCodigo() == cod){
               break;
           }
       }
       if (i == cantCreditos){
          return null;
       }else{
            return lc[i];
       }

   }
   
   public Credito getCreditoI(int i){
       if(i < cantCreditos && i >= 0){
           return lc[i];
       }else{
            return null;
       }
   }
   
   public boolean eliminar(int cod) {

    int i;
    for(i=0; i< cantCreditos; i++){
       if(lc[i].getCodigo()== cod) {
          break;
        }
    }
    if(i== cantCreditos) { 
       return false;
    }
    else { 
       for(int j=i; j< cantCreditos - 1; j++) {
           lc[j] = lc[j+1];
       } 
          cantCreditos --; 
          return true; 
       } 
    }
    
    
}
