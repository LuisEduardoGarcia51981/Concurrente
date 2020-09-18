package TP3;


public class LetraB implements Runnable 
{  
    private Turno mi_turno;
    public LetraB (Turno un_turno)
    {
        this.mi_turno= un_turno;
    }
    
    public void run () 
    {   int i=1;      
        while(i<=4)
        {
            while (this.mi_turno.get_orden() != 2)
            { }
            System.out.print("BB");            
            mi_turno.set_orden(3);
            i++;
        }
    }
} 