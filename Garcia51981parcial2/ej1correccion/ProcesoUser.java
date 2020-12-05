/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Garcia51981parcial2.ej1correccion;

/**
 *
 * @author tema 2
 */
public class ProcesoUser implements Runnable {

    private Impresora imp;
    private String letra;
    private String nombre;

    public ProcesoUser(Impresora la_imp, String una_letra, String mi_nombre) {
        this.imp = la_imp;
        this.letra = una_letra;
        this.nombre = mi_nombre;
    }

    public void run() {
        int i = 1;
        while (i <= 2) {
            try {
                imp.escribirenBuffer(this.letra, this.nombre);
            } catch (InterruptedException e) {               
                e.printStackTrace();
            }
            i++;
       }
    }

   
}
