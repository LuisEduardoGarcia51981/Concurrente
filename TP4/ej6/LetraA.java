package TP4.ej6;
public class LetraA implements Runnable 
{  
    private Turno mi_turno;
    public LetraA (Turno un_turno)
    {
        this.mi_turno= un_turno;
    }     
    public void run ()  
    {             
            this.mi_turno.imprimir ("A",0,1);
            this.mi_turno.imprimir ("A",0,1);         
    }
}  