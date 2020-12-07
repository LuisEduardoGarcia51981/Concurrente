package Garcia51981parcial2.ej2correccion;

public class Main
 {
    public static void main (String[] args) 
    {               
        int capacidadMaxRecipiente=5;
        GeneradordeAgua ga= new GeneradordeAgua(capacidadMaxRecipiente); 
        CreaMoleculas cream= new CreaMoleculas(ga); 
        RetirarRecipiente retrec= new RetirarRecipiente(ga);             
        
        Thread hilo_CreaMoleculas= new Thread(cream);
        hilo_CreaMoleculas.start();

        Thread hilo_RetirarRec= new Thread(retrec);
        hilo_RetirarRec.start();

}
}