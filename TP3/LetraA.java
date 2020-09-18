package TP3;


public class LetraA implements Runnable 
{  
    private Turno mi_turno;
    public LetraA (Turno un_turno)
    {
        this.mi_turno= un_turno;
    }
    
    public void run () 
    {   int i=1;      
        while(i<=4)
        {
            while (this.mi_turno.get_orden() != 1)
            { }
            System.out.print("A");            
            mi_turno.set_orden(2);
            i++;
        }
    }
} 