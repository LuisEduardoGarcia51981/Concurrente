package TP2;

class ThreadTesting 
{
    public static void main (String[] args)
    {
        Thread miHilo= new MiEjecucion();
        miHilo.start();
        try 
        {
            miHilo.join();            
        } catch (InterruptedException e) 
        {
            
        }                        
        System.out.println( "En el main" );
        
                               
        
    }
}