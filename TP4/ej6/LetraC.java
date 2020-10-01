package TP4.ej6;

public class LetraC implements Runnable 
{  
    private Turno mi_turno;
    public LetraC (Turno un_turno)
    {
        this.mi_turno= un_turno;
    }     
    public void run ()  
    {             
            this.mi_turno.imprimir ("C",2,3); 
            this.mi_turno.imprimir ("C",2,3);        
    }
}  