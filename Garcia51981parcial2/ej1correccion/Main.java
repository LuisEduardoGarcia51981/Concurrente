/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Garcia51981parcial2.ej1correccion;

import java.util.Random;

/**
 *
 * @author Garcia Carrillo tema 2
 */
public class Main {

    public static void main(String[] args) {

        int cantHilos = 3;
        int capBuffer = 1;
        Impresora una_imp= new Impresora(capBuffer);       

        ProcesoUser[] arrprousers = new ProcesoUser[cantHilos];
        //Crear proceso user
        ProcesoUser prod;
        for (int i = 0; i < cantHilos; i++) {
            Random r = new Random();
            int c = r.nextInt(26) + (byte)'a';
            String letra=String.valueOf((char)c);  
            prod = new ProcesoUser(una_imp,letra,"hilo"+i);
            arrprousers[i] = prod;
        }
        //crear hilos
        Thread[] hilos_prouser = new Thread[cantHilos];
        for (int i = 0; i < cantHilos; i++) {
            hilos_prouser[i] = new Thread(arrprousers[i], "hilo"+i);
            hilos_prouser[i].start();
        }

        ServidorImpresion servidor = new ServidorImpresion(una_imp);
        Thread hilo_servidor= new Thread(servidor);
        hilo_servidor.start();

              
       
    }
}
