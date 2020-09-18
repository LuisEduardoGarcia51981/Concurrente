package TP3;

public class Hamster implements Runnable {   
    private Plato plato;   
    private Rueda rueda;
    private Hamaca hamaca; 
    

    public Hamster (Plato un_Plato, Rueda una_Rueda, Hamaca una_Hamaca) {
    
        this.plato = un_Plato;
        this.rueda = una_Rueda;
        this.hamaca = una_Hamaca;
        
    }
    
    public void run() {
        try 
        {            
            this.plato.comer(Thread.currentThread().getName());
            this.rueda.correr(Thread.currentThread().getName());
            this.hamaca.jugar(Thread.currentThread().getName());

                       
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}