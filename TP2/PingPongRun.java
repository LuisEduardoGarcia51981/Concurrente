package TP2;
public class PingPongRun implements Runnable
{
    private String cadena; // Lo que va a escribir.
    private int delay; // Tiempo entre escritura
    public PingPongRun(String cartel,int cantMs)
    {
        cadena = cartel;
        delay = cantMs;
    };
    public void run()
    {
        for (int i = 1; i< delay * 10; i++)
        {
            System.out.print(cadena + " ");
            try 
            { 
                Thread.sleep(delay);
            }
            catch(InterruptedException e)
            {
            }
        }
    } //fin método run()

} //fin clase PingPong