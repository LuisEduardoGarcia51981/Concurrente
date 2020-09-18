package TP3;


public class CuranderoSS implements Runnable 
{
    private HeroeSS heroe;
    public CuranderoSS (HeroeSS heroe)
    {
        this.heroe= heroe;
    }
    
    public void run () 
    {         
        System.out.println ( Thread.currentThread().getName() +": Curandero Comienza a Sanar" );
        System.out.println ( Thread.currentThread().getName() +": vida inicial del Heroe = "+ heroe.get_vida() );
        int vida = heroe.get_vida();
        int nueva_vida= vida + 3;
        heroe.set_vida(nueva_vida);           
        System.out.println ( Thread.currentThread().getName() +": Curandero Termina de Sanar" );
        System.out.println ( Thread.currentThread().getName() +": vida final del Heroe = "+ vida);
    }
} 