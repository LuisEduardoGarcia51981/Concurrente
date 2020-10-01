package TP4.ej8;
public class Atleta implements Runnable 
{  
    private Testigo el_testigo;  

    public Atleta (Testigo un_testigo)
    {
        this.el_testigo= un_testigo;
    }     
    public void run ()  
    {        
            this.el_testigo.correr (Thread.currentThread().getName());         
    }
} 