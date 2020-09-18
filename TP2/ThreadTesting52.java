package TP2;

class ThreadTesting52 
{
    public static void main (String[] args)
    {
        MiEjecucion52 o1= new MiEjecucion52();        

        Thread miHilo= new Thread (o1);
        
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