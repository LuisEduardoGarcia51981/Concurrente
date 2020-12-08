package parcial2tema1.ej2;

public class Auto implements Runnable {

    RecursoCompartido recurso;
    


    public Auto(RecursoCompartido rc, String na) {
        this.recurso = rc;  
        System.out.println("Llego para subir el auto: "+na);
    }
    
    public void run() 
    {
        recurso.subir(Thread.currentThread().getName());
        recurso.bajar(Thread.currentThread().getName());
    }
}