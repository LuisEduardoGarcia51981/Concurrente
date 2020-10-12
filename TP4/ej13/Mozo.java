package TP4.ej13;

public class Mozo implements Runnable {
    Confiteria la_confiteria= new Confiteria(); 
    
    public Mozo (Confiteria conferia) {
    
        this.la_confiteria = conferia;              
    }              

    public void run() {
        while(true)
        {
            la_confiteria.esperando_empleado();//loqueo de semMozo
            la_confiteria.preparando_menu();
           // la_confiteria.entregar_menu();
            //la_confiteria.se_despide();
        }
    }

}