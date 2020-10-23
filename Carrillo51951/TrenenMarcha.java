package Carrillo51951;

public class TrenenMarcha implements Runnable { 

    Tren el_tren;       

    public TrenenMarcha (Tren un_tren) {
    
        this.el_tren=un_tren;           
    }
    
    public void run() {
        while (true)
        {
            el_tren.esperando_comenzar_recorrido();
            
        }
        
            
        
    }

}