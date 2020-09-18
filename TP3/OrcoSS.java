package TP3;


public class OrcoSS implements Runnable 
{
    private HeroeSS heroe;
    public OrcoSS (HeroeSS heroe)
    {
        this.heroe= heroe;
    }
    
    public void run () 
    {         
        System.out.println ( Thread.currentThread().getName() +": Comienza a Golpear" );
        System.out.println ( Thread.currentThread().getName() +": vida inicial del Heroe = "+ heroe.get_vida() );
        int vida = heroe.get_vida();
        int nueva_vida= vida - 2;
        heroe.set_vida(nueva_vida);   
        System.out.println ( Thread.currentThread().getName() +": Termina de Golpear" );        
        System.out.println ( Thread.currentThread().getName() +": vida final del Heroe = "+ heroe.get_vida() );
    }
} 