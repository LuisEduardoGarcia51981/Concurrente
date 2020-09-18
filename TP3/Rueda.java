package TP3;

public class Rueda {          
    public Rueda() { }

    public synchronized void correr(String nombre) throws InterruptedException {
        System.out.println(nombre + ": Corriendo en la Rueda ");
        Thread.sleep(700);
        System.out.println(nombre + " ya dejo de correr en la Rueda");        
    }
}