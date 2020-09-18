package TP3;

public class Ej2CS {
    public static void main (String[] args) 
    {
        HeroeCS un_heroe = new HeroeCS();
        OrcoCS un_orco = new OrcoCS(un_heroe);
        CuranderoCS un_curandero = new CuranderoCS(un_heroe);
        
        Thread hilo_orco = new Thread(un_orco,"Grom el Horco");
        Thread hilo_curandero = new Thread(un_curandero, "Gandalf el Curandero"  );
        hilo_orco.start();
        hilo_curandero.start(); 

    }
}