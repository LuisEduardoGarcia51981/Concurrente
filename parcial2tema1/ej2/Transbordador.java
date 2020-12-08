package parcial2tema1.ej2;

public class Transbordador implements Runnable {

    RecursoCompartido recurso;

    public Transbordador(RecursoCompartido rc) 
    {    
        this.recurso=rc;             
    } 
    
    public void run() {   

        while(true)
        {
            this.recurso.ir();   
            System.out.println("El transbordador esta cruzando el rio con los autos"); 
            System.out.println("El transbordador llego a destino. Ahora va a descargar los autos"); 
            this.recurso.descargar_autos();
            this.recurso.volver();
            System.out.println("El transbordador esta volviendo al origen, vacio, sin autos."); 
            System.out.println("El transbordador esta en el lugar de origen. Listo para cargar"); 
        }
    }

}