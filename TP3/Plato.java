package TP3;

public class Plato {          
    public Plato() { }

    public synchronized void comer(String nombre) throws InterruptedException {
        System.out.println(nombre + ": comiendo ");
        Thread.sleep(700);
        System.out.println(nombre + " ya comió");        
    }
}