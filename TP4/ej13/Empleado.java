package TP4.ej13;

public class Empleado implements Runnable { 
      
    Confiteria la_confiteria= new Confiteria();  
    int opcion;//1,2 3 

    public Empleado (Confiteria conferia) {
    
        this.la_confiteria = conferia;  
        opcion=1;// generarlo en forma aleatoria            
    }
    
    public void run() {

          
            la_confiteria.solicitarSilla(Thread.currentThread().getName()); 
            la_confiteria.tomar_orden(Thread.currentThread().getName());  
            la_confiteria.comer();  
            la_confiteria.se_despide();
        
    }

}