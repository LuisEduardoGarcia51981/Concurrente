package TP2;
public class Ej3b extends Thread
{

    private String cadena; // Lo que va a escribir.
    private  int delay; // Tiempo entre escritura

    public Ej3b( String cartel, int cantMs)
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
        Ej3b t1 =new Ej3b ("PING",3);
        Ej3b t2= new Ej3b ("PONG",4);
        // Activación
        t1.start();
        t2.start();
        for(int i=0;i<=10000000;i++)
        {   //Notemos que escribir i+=2 es similar a escribir i = i + 2
           // System.out.println(i);
        }
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


