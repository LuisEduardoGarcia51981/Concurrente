package TP2;

public class Ejercicio51 {
    public static void main (String[] args)
    {
        Cliente51 o1= new Cliente51();
        Cliente51 o2= new Cliente51();

        Thread juan = new Thread (o1);      
        juan.setName( "Juan Lopez" );

        Thread ines = new Thread (o2);        
        ines.setName ( "Ines Garcia" );
        
        juan.start();
        ines.start();        
        System.out.println( "en Main: Soy " + Thread.currentThread().getName());
    }
}