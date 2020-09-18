package TP3;


public class CuranderoCS implements Runnable 
{
    private HeroeCS heroe;
    public CuranderoCS (HeroeCS heroe)
    {
        this.heroe= heroe;
    }
    
    public void run () 
    {         
        this.heroe.recibe_cura( 3, Thread.currentThread().getName() ); 
    }
} 