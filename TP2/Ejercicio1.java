package TP2;

public class Ejercicio1 {
    public static void main (String[] args)
    {
        Cliente juan= new Cliente();
        juan.setName( "Juan Lopez" );
        Cliente ines= new Cliente ();
        ines.setName ( "Ines Garcia" );
        juan.start();
        ines.start();        
        System.out.println( "en Main: Soy " + Thread.currentThread().getName());
    }
}