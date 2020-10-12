package TP4.ej13;

public class Cocinero implements Runnable {   

    Confiteria la_confiteria= new Confiteria();   

    public Cocinero (Confiteria conferia) {
    
        this.la_confiteria = conferia;              
    }
    
    public void run() 
    {      
        while(true)
        {
            la_confiteria.esperando_orden_decomida();//semCocinero
            la_confiteria.preparando_comida();
           // la_confiteria.se_despide();                            
        }
        
    }

}