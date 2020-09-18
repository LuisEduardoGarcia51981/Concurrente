package TP2;

public class Recurso51 
{
    static void uso ()
    {  // b)imprime en pantalla el nombre del thread que se encuentra actualmente en ejecucion        
        Thread t = Thread.currentThread();
        System.out.println( "en Recurso: Soy " + t.getName());
    }
}