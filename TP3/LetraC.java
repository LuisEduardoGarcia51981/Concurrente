package TP3;


public class LetraC implements Runnable 
{  
    private Turno mi_turno;
    public LetraC (Turno un_turno)
    {
        this.mi_turno= un_turno;
    }
    
    public void run () 
    {   int i=1;      
        while(i<=4)
        {
            while (this.mi_turno.get_orden() != 3)
            { }
            System.out.print("CCC");            
            mi_turno.set_orden(1);
            i++;
        }
    }
} 