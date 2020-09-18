package TP3;

public class Hamaca {          
    public Hamaca() { }

    public synchronized void jugar(String nombre) throws InterruptedException {
        System.out.println(nombre + ": Hamacandose ");
        Thread.sleep(700);
        System.out.println(nombre + " ya se hamacó");        
    }
}