/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial2tema1.ej1;



/**
 *
 * @author tema 1 ejercicio 1 Luis Garcia
 */
public class Main {

    public static void main(String[] args) {

        int num_de_Inserciones = 10;
        int num_hilos_Insertores = 2;
        int num_hilos_Extractores = 2;
        
        
        RecursoCompartido un_recurso= new RecursoCompartido();       

        Insertor[] array_insertores = new Insertor[num_hilos_Insertores];

        for (int i = 0; i < num_hilos_Insertores; i++) {
            array_insertores[i] = new Insertor(un_recurso,num_de_Inserciones);             
        }

        Thread[] hilos_insertores = new Thread[num_hilos_Insertores];
        for (int i = 0; i < num_hilos_Insertores; i++) {
            hilos_insertores[i] = new Thread(array_insertores[i], "hilo"+i);
            hilos_insertores[i].start();
        }
        

        Extractor[] array_extractores = new Extractor[num_hilos_Extractores];

        for (int i = 0; i < num_hilos_Extractores; i++) {
            array_extractores[i] = new Extractor(un_recurso,num_de_Inserciones);             
        }

        Thread[] hilos_extractores = new Thread[num_hilos_Extractores];

        for (int i = 0; i < num_hilos_Extractores; i++) {
            hilos_extractores[i] = new Thread(array_extractores[i], "hilo"+i);
            hilos_extractores[i].start();
        }
        

        
    }
}
