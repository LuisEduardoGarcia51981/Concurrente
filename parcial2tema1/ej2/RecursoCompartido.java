package parcial2tema1.ej2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//dudas: un solo lock (mutex) para todo --> es incorrecto

public class RecursoCompartido {

    public static final String ANSI_BLACK = "\u001B[30m";

    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_RESET = "\u001B[0m";

   
    static Lock mutex = new ReentrantLock();    
    static Condition esperarAutos = mutex.newCondition();
    static Condition esperarDescarga = mutex.newCondition();
    static Condition esperar_para_subir = mutex.newCondition();
    static Condition esperar_para_bajar = mutex.newCondition();
    
    private int capacidadTransbordador;
    private int autos_cargados;
    private int autos_descargados;
    private boolean noBajar;
   
    Lock miCerrojo=new ReentrantLock();
    

    public RecursoCompartido(int cap_transb)
    {
        capacidadTransbordador=cap_transb;
        autos_cargados=0;
        autos_descargados=0;
        noBajar=true;
        
    }


    public void ir()
    {   mutex.lock();
        esperar_para_subir.signalAll();
        while (autos_cargados < this.capacidadTransbordador){			
			try { 
				esperarAutos.await();				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
        };  
        autos_descargados=0;                 
        System.out.println("El transbordador ya cargo los "+capacidadTransbordador+" autos en el origen");
        mutex.unlock();                    
    }  
    public void volver()
    {   mutex.lock();    
        
        while (autos_descargados < this.capacidadTransbordador) {			
			try { 
				esperarDescarga.await();				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
        }; 
        this.autos_cargados=0;  
        noBajar=true;
        System.out.println("El transbordador ya descargo los "+capacidadTransbordador+" autos en el destino");
             
        mutex.unlock();                    
    }

    public void subir(String nombreAuto) 
    {                               
        mutex.lock();        
        while (autos_cargados == this.capacidadTransbordador)
        {		
			try {
				esperar_para_subir.await();				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
        } 
        System.out.println("Acaba de subir el auto: "+nombreAuto+" al transbordador en el origen");
        autos_cargados++;    
        esperarAutos.signal();
        mutex.unlock();        
    } 
    public void bajar(String nombreAuto) 
    {                               
        mutex.lock();        
        while (noBajar)
        {		
			try {
				esperar_para_bajar.await();				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
        } 
        System.out.println("Acaba de bajar el auto: "+nombreAuto+" del transbordador en el destino");
        autos_descargados++;   
        esperarDescarga.signalAll();         
        mutex.unlock();        
    } 
    public void descargar_autos() 
    {   mutex.lock();                                                
        noBajar=false;
        esperar_para_bajar.signalAll();	        			
        mutex.unlock();
    } 
   

}