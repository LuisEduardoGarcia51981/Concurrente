package TP3;

public class Ej8 {
    public static void main (String[] args) 
    {
        int cant = 3;
        Hamster[] hamster = new Hamster[cant];
        Plato plato= new Plato();
        Rueda rueda= new Rueda();
        Hamaca hamaca= new Hamaca();

        for (int i = 0; i < cant; i++) {
            hamster[i] = new Hamster(plato,rueda, hamaca);             
        }

        Thread[] mascotas = new Thread[cant];
        for (int i = 0; i < cant; i++) {
            mascotas[i] = new Thread(hamster[i], "Hamster "+i);
            mascotas[i].start();
        }
}
}