package TP4.ej8;

public class Ej8 {
    public static void main (String[] args)     
    {       
        int cant_corredores = 4;
        Atleta[] atletas = new Atleta[cant_corredores];
        Testigo testigo= new Testigo();


        for (int i = 0; i < cant_corredores; i++) {
            atletas[i] = new Atleta(testigo);             
        }

        Thread[] hilos_atletas = new Thread[cant_corredores];
        for (int i = 0; i < cant_corredores; i++) {
            hilos_atletas[i] = new Thread(atletas[i], "Atleta "+i);
            hilos_atletas[i].start();
        }
        //System.out.println("Tiempo total de la carrera: "+ testigo.tiempo_total_carrera);
    }
}
