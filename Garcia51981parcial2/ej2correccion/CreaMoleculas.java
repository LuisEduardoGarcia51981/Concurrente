package Garcia51981parcial2.ej2correccion;

import java.util.Random;

public class CreaMoleculas implements Runnable {


    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
    GeneradordeAgua formagua;

    public CreaMoleculas(GeneradordeAgua fa) {
        this.formagua = fa;        
    }
    
    public void run() {
        Random rnd = new Random();        
        int i=0;
        int numero;
        while(i<50)
        {
            numero = (int)(rnd.nextDouble() * 100 + 1); // genera un entero entre 1 o 100
            if (numero %2 == 0) // numero par se genera un atomo de oxigeno
            {
                formagua.oListo();                
            }
            else // numero impar se genera un atomo de hidrogeno
            {
                formagua.hListo();                
            }
            i++;
        }        
    }
}