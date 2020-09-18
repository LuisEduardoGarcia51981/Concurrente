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

    public synchronized void recibe_daño(int valor, String t )
    { 
      System.out.println ( t +": Comienza a Golpear" );     
      System.out.println ( t +": vida inicial del Heroe = "+ this.get_vida() );     
      int nueva_vida= this.vida - valor;
      this.vida=nueva_vida;   
      System.out.println (t +": Termina de Golpear" );        
      System.out.println ( t +": vida final del Heroe = "+ this.vida );

    }
    public synchronized void recibe_cura(int valor, String t )
    { 
      System.out.println ( t +": Comienza a Sanar" );     
      System.out.println ( t +": vida inicial del Heroe = "+ this.get_vida() );     
      int nueva_vida= this.vida + valor;
      this.vida=nueva_vida;   
      System.out.println ( t +": Termina de Sanar" );        
      System.out.println ( t +": vida final del Heroe = "+ this.vida );

    } 
}