package TP3;

public class Ej2SS {
    public static void main (String[] args) 
    {
        HeroeSS un_heroe = new HeroeSS();
        OrcoSS un_orco = new OrcoSS(un_heroe);
        CuranderoSS un_curandero = new CuranderoSS(un_heroe);
        
        Thread hilo_orco = new Thread(un_orco,"Grom el Horco");
        Thread hilo_curandero = new Thread(un_curandero, "Gandalf el Curandero"  );
        hilo_orco.start();
        hilo_curandero.start();

    } 
}