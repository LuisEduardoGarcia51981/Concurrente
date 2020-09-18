package TP3;


public class OrcoCS implements Runnable 
{
    private HeroeCS heroe;
    public OrcoCS (HeroeCS heroe) 
    {
        this.heroe= heroe;
    }
    
    public void run ()  
    {         
       this.heroe.recibe_daño( 2, Thread.currentThread().getName() );  
    }
}