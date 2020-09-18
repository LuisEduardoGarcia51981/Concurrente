package TP2;
public class PingPong extends Thread
{

    private String cadena; // Lo que va a escribir.
    private  int delay; // Tiempo entre escritura

    public PingPong( String cartel, int cantMs)
    {   super();
        cadena = cartel;
        delay = cantMs;
    }
    
    public void run()
    {
        for (int i = 1; i< delay * 10; i++)
        {
            System.out.print(cadena + " ");
            try 
            {
                Thread.sleep(delay);
            } 
            catch ( InterruptedException e) 
            {   System.out.println("Se genero excepcion en sleep del run ");
                //Logger.getLogger(PingPong.class.getName()).log(Level.SEVERE,null,e);
            }
        }
    } 
    public static void main(String[] args)
    {
         PingPong t1 =new PingPong("PING",5);
         PingPong t2= new PingPong("PONG",6);
        // Activación
        t1.start();
        t2.start();
        // Espera unos segundos
        try{
            Thread.sleep(5000);
        }
        catch (InterruptedException e)
        {
            System.out.println("sleep en main");

        };
            
        System.out.println("chau chau");
    
    }

} //fin clase PingPong


