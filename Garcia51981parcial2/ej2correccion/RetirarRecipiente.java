package Garcia51981parcial2.ej2correccion;

public class RetirarRecipiente implements Runnable {

    GeneradordeAgua formagua;

    public RetirarRecipiente(GeneradordeAgua formagua) 
    {    
        this.formagua=formagua;
      
       
    } 
    
    public void run() {

        while (true)
        {
            this.formagua.recitar_el_Recipiente();

        }
        
        
    }

}