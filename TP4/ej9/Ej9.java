package TP4.ej9;

public class Ej9 {
    public static void main (String[] args)     
    {       
            
        Taxista taxista= new Taxista();               
        Cliente cliente= new Cliente(taxista);
       
                
        Thread hilo_taxista = new Thread(taxista);
        Thread hilo_cliente = new Thread(cliente );
            
        hilo_taxista.start();
        hilo_cliente.start();
        

    }
}
