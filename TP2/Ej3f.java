package TP2;
public class Ej3f extends Thread
{

    private String cadena; // Lo que va a escribir.
    private  int delay; // Tiempo entre escritura

    public Ej3f( String cartel, int cantMs)
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
        Ej3f t1 =new Ej3f ("PING",3);
        Ej3f t2= new Ej3f ("PONG",4);
        Ej3f t3 =new Ej3f ("PANG",3);
        Ej3f t4= new Ej3f ("PUNG",4);
        // Activación
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        for(int i=0;i<=1000;i++)
        {   //Notemos que escribir i+=2 es similar a escribir i = i + 2
           // System.out.println(i);
           try{
                Thread.sleep(50);
            }
            catch (InterruptedException e)
            {
            // System.out.println("sleep en main");

            };
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


