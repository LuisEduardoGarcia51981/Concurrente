package TP3;

public class HeroeCS 
{
    private int vida = 10 ;
    public HeroeCS ()
    {
    }
    public  synchronized int get_vida ()
    {
       return this.vida;
    }

    public synchronized void set_vida ( int cantidad)
    {
       this.vida = cantidad;
    }     

    public synchronized void recibe_daño(int valor, Thread t )
    { 
      System.out.println ( t.getName() +": Comienza a Golpear" );     
      System.out.println ( t.getName() +": vida inicial del Heroe = "+ this.get_vida() );     
      int nueva_vida= this.vida - valor;
      this.vida=nueva_vida;   
      System.out.println ( Thread.currentThread().getName() +": Termina de Golpear" );        
      System.out.println ( Thread.currentThread().getName() +": vida final del Heroe = "+ this.vida );

    }
    public synchronized void recibe_cura(int valor, Thread t )
    { 
      System.out.println ( t.getName() +": Comienza a Sanar" );     
      System.out.println ( t.getName() +": vida inicial del Heroe = "+ this.get_vida() );     
      int nueva_vida= this.vida + valor;
      this.vida=nueva_vida;   
      System.out.println ( Thread.currentThread().getName() +": Termina de Sanar" );        
      System.out.println ( Thread.currentThread().getName() +": vida final del Heroe = "+ this.vida );

    }
}