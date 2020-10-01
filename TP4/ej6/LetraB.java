package TP4.ej6;
public class LetraB implements Runnable 
{  
    private Turno mi_turno;
    public LetraB (Turno un_turno)
    {
        this.mi_turno= un_turno;
    }     
    public void run ()  
    {             
            this.mi_turno.imprimir ("B",1,2);        
            this.mi_turno.imprimir ("B",1,2);  
    }
}  