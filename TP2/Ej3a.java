package TP2;
public class Ej3a extends Thread
{

    private String cadena; // Lo que va a escribir.
    private  int delay; // Tiempo entre escritura

    public Ej3a ( String cartel, int cantMs)
    {   super();
        cadena = cartel;
        delay = cantMs;
    }
    
    public void run()
    {
        for (int i = 1; i< delay * 10; i++)
        {
            System.out.print(cadena + " ");
            /*try 
            {
                //Thread.sleep(delay);
            } 
            catch ( InterruptedException e) 
            {   System.out.println("Se genero excepcion en sleep del run ");
                //Logger.getLogger(PingPong.class.getName()).log(Level.SEVERE,null,e);
            }*/
        }
    } 
    public static void main(String[] args)
    {
        Ej3a t1 =new Ej3a("PING",3);
        Ej3a t2= new Ej3a("PONG",4);
        // Activación
        t1.start();
        t2.start();
        // Espera unos segundos
        /*try{
            // Thread.sleep(5000);
        }
        catch (InterruptedException e)
        {
           // System.out.println("sleep en main");

        };*/
            
        System.out.println("chau chau");
    
    }

} //fin clase PingPong


