package Carrillo51951;

public class VendedorTickets implements Runnable { 
    
    Tren el_tren;     

    public VendedorTickets (Tren un_tren) 
    {    
        this.el_tren=un_tren;
    } 
    
    public void run() {

          while (true)
          {

            el_tren.esperando_cliente();
            el_tren.vender_pasaje();
          }
        
    }

}