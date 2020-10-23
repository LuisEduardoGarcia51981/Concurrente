package Carrillo51951;

public class ControlTren implements Runnable { 

    Tren el_tren;       

    public ControlTren (Tren un_tren) {
    
        this.el_tren=un_tren;           
    }
    
    public void run() {
        while (true)
        {
            el_tren.esperando_controlar();
            
        }
        
            
        
    }

}