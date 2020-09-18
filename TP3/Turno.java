package TP3;

public class Turno 
{   
    private int orden ;
    
    public Turno ()
    { this.orden=1;
    }
    public  synchronized int get_orden ()
    {
       return this.orden;
    } 

    public synchronized void set_orden ( int cantidad)
    {
       this.orden = cantidad;
    }    

    
     
}