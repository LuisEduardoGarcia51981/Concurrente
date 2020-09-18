package TP3;

public class Ej4 {
    public static void main (String[] args) 
    {
        int cant = 5;
        Auto[] autos = new Auto[cant];
        for (int i = 0; i < cant; i++) {
            autos[i] = new Auto("p" + i, "mod" + i, "mar" + i, 199);
        }

        Thread[] hilos = new Thread[cant];
        for (int i = 0; i < cant; i++) {
            hilos[i] = new Thread(autos[i]);
            hilos[i].start();
    }
}