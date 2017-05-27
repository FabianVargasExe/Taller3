
package Taller3;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import ucn.ArchivoEntrada;
import ucn.In;
import ucn.Registro;
import ucn.StdIn;
import ucn.StdOut;


public class App implements IApp {
 
    private ListaPersonas listaPersonas;
    private ListaCreditos listaCreditos;
    

    public App() {
        
        listaPersonas = new ListaPersonas(1000);
        listaCreditos = new ListaCreditos(1000);
        
    }
     
   
    
    @Override        
    public void leerPersonas() {
        
        try {
            ArchivoEntrada in = new ArchivoEntrada("Personas.txt");
            while(!in.isEndFile()){
                Registro reg = in.getRegistro();
                
                int cod = reg.getInt();
                String nombre = reg.getString();
                String apellido = reg.getString();
                int edad = reg.getInt();
                String estudio = reg.getString();
                int datos1 = reg.getInt();
                int datos2 = reg.getInt();
                
                if(estudio.equals("tecnico")){                    
                   listaPersonas.ingresaTecnico(cod, nombre, apellido, edad, datos1, datos2);
                }
                if(estudio.equals("profesional")){                   
                   listaPersonas.ingresaProfesional(cod, nombre, apellido, edad, datos1, datos2);
                }
                if(estudio.equals("estudiante")){
                   listaPersonas.ingresaEstudiante(cod, nombre, apellido, edad, datos1, datos2);
                }
                                                
            }
        } catch (IOException ex) {
            System.out.println("No se pudo leer el archivo");
        }
    }
    
    
    @Override
    /*
    * Metodo que lee los datos de los creditos de un archivo "Creditos.txt" 
    * Se asocian inmediatamente con la persona, que se entrega como dato y luego
    * se guarda en un contedor general de creditos
    */
    public void leerCreditos () {
        try {
            
            FileReader f = new FileReader("creditos.txt");
            BufferedReader  br = new BufferedReader(f);
            
            String linea;
            
            while((linea=br.readLine())!=null){
                String[] campos = linea.split(";");
   
                int cod = Integer.parseInt(campos[0]);
                int montosolicitado = Integer.parseInt(campos[1]);
                int persona = Integer.parseInt(campos[2]);
                String valueStr = campos[3];
                valueStr = valueStr.replace(',', '.');
                double interes = Double.parseDouble(valueStr);

                int cantcuotas = Integer.parseInt(campos[4]);

                Credito c = new Credito(cod,montosolicitado,interes,cantcuotas);
                // Se busca la persona según el código "persona" dado en el txt, en la lista general de personas
                Persona p = listaPersonas.buscarPersona(persona);
                // Se acocia el credito con la persona encontrada en la lista
                c.setPersona(p);
                listaCreditos.ingresarCreditos(c);                               
            }     
        } catch (IOException ex) {
            System.out.println("No se pudo leer el archivo");
        }
    } 
    
    @Override
    public void CensoRF1 ()  {
        
        String g = listaPersonas.getPersonaI(3).getNombre();
        System.out.println(g);
           
        String f = listaCreditos.getCreditoI(2).getPersona().getApellido();
        System.out.println(f);
    }    
    
    @Override
    public void DatosCensistasRF2(){
        
        int cant = listaPersonas.getCantPersonas();
        if(cant < 100){
            

        StdOut.println("Ingrese Nombre");
        String nom = StdIn.readString();
        StdOut.println("Ingrese Apellido");
        String ape = StdIn.readString();
        StdOut.println("Ingrese edad");
        int edad = StdIn.readInt();
        
        

        
        StdOut.println("Ingrese nivel de estudios \n 1.- Técnico \n 2.- Profesional \n 3.- Estudiante \n 4.- Ninguno");
        int estudio = StdIn.readInt();
        
        
        if(edad < 18 || estudio == 4){
            StdOut.println(" La persona no cumple con los requisitos.");
            
        }
        else{
            switch(estudio){
                
                case 1: 
                    
                StdOut.println("Ingrese Sueldo");
                int sueldo = StdIn.readInt();
                StdOut.println("Ingrese Gastos");
                int gastos = StdIn.readInt();
                    
                listaPersonas.ingresaTecnico(cant, nom, ape, edad, sueldo, gastos);
                break;
                    
                case 2:  
                StdOut.println("Ingrese Sueldo");
                int sueldo1 = StdIn.readInt();
                StdOut.println("Ingrese Anios en el trabajo");
                int anios = StdIn.readInt();
                    
                listaPersonas.ingresaProfesional(cant, nom, ape, edad, sueldo1, anios);
                break;          

                case 3:
                    
                StdOut.println("Ingrese Anios actual carrera");
                int aniosc = StdIn.readInt();
                StdOut.println("Ingrese Duración carrera");
                int duracion = StdIn.readInt();
                    
                listaPersonas.ingresaEstudiante(cant, nom, ape, edad, aniosc, duracion);
                break;                     
                  
                }     
            } 
         }
         
    }
 
    @Override
    public void CensistaRF3(){
        
        StdOut.println("Ingrese código de la persona a eliminar");
        int cod = StdIn.readInt();
        Persona p = listaPersonas.buscarPersona(cod);
        
        if(p!= null){
           listaPersonas.eliminar(cod);       
        }
        else{           
           StdOut.println("Ingrese código del crédito a eliminar");  
           
        }
              
    }

    @Override
    public void DatosComunaRF4() {
        
        StdOut.println("Ingrese código del crédito a eliminar");
        int cod = StdIn.readInt();
        Credito c = listaCreditos.buscarCredito(cod);
        
        if(c != null){
           listaCreditos.eliminar(cod);       
        }
        else{           
           StdOut.println("Ingrese código del crédito a eliminar \n");  
           
        }
        
        /* Se recorre la lista de personas. Se eliminara de la lista general de persona si al buscar 
         * el crédito eliminado ya no existe (retorna null) y si la cantidad de creditos asociado es 0.
         */
        for(int i=0; i< listaPersonas.getCantPersonas(); i++){
            
            Persona p = listaPersonas.getPersonaI(i);
            int codPersona = p.getCodigo();
            
            if (p.getListaCreditos().buscarCredito(cod) == null && 
                p.getListaCreditos().getCantCreditos() == 0) {
          
            listaPersonas.eliminar(codPersona);
            StdOut.println("Ingrese código del crédito a eliminar \n");  
          
          }
            
                      
        
        }

    }
}
