package Garcia51981parcial2.ej2correccion;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//dudas: un solo lock (mutex) para todo --> es incorrecto

public class GeneradordeAgua {

    public static final String ANSI_BLACK = "\u001B[30m";

    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_RESET = "\u001B[0m";

    private int  moleculasHidrogeno ; 
    private int moleculasOxigeno ;
    static Lock mutex = new ReentrantLock();    
    static Condition retirarRecipiente = mutex.newCondition();
    static Condition esperarRecipiente = mutex.newCondition();
    private int recipiente;
    private int capmaxrecipiente;
    private boolean noHayRecipiente;
    

    public GeneradordeAgua(int capacidadMaxRecipiente)
    {
        this.recipiente=0;
        this.capmaxrecipiente=capacidadMaxRecipiente;
        this.moleculasHidrogeno=0 ; 
        this.moleculasOxigeno=0 ;
        this.noHayRecipiente=true;
    }
    public void oListo() {       
        this.moleculasOxigeno++;        
        System.out.println(ANSI_BLUE+"Procesando Oxigeno: "+this.moleculasOxigeno+ANSI_RESET);
        
        if (this.moleculasHidrogeno>=2)
        {
            hacerAgua();
        }        
    }
    public void hListo() {
        this.moleculasHidrogeno++;
        System.out.println(ANSI_GREEN+"Procesando Hidrogeno"+this.moleculasHidrogeno+ANSI_RESET);
                
        if ((this.moleculasHidrogeno>=2) && (this.moleculasOxigeno >=1))
        {
            this.hacerAgua();
        }        
    }

    public void hacerAgua()
    {   mutex.lock();    
        // a continuacion si no hay recipiente, no se genera mas agua       
        while (this.noHayRecipiente) {			
			try { System.out.println("Se detuvo la generacion de agua. No hay recipiente. Esperando uno");
				esperarRecipiente.await();				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
        };           
        this.moleculasOxigeno--;
        this.moleculasHidrogeno=this.moleculasHidrogeno-2;           
        System.out.println(ANSI_YELLOW+"Se genero agua. Llenando el recipiente"+ANSI_RESET);
        this.recipiente++;   
        // a continuacion si se llena el recipiente, se retira el mismo 
        if (this.recipiente==this.capmaxrecipiente)
        {
            retirarRecipiente.signal(); 
        }   
        mutex.unlock();                    
    }  

    public void recitar_el_Recipiente() 
    {                               
        mutex.lock(); 
        this.noHayRecipiente=false; 
        while (this.recipiente<this.capmaxrecipiente) {			
			try {
				retirarRecipiente.await();				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
        }
        
        System.out.println(ANSI_PURPLE+"Se envasa el agua y se retira el recipiente "+ANSI_RESET);
        this.recipiente=0;  
        this.noHayRecipiente=true;     
        esperarRecipiente.signalAll();	 
        mutex.unlock();
        
    } 

   

}