package TP2;
public class PruebaRunnable
{
    public static void main(String[] args)
    {
        // 2 objetos definen los métodos run
        PingPongRun o1 =new PingPongRun("PING",33);
        PingPongRun o2= new PingPongRun("PONG",10);
        // Se crean los hilos
        Thread t1 = new Thread (o1);
        Thread t2 = new Thread (o2);
        // se activan los hilos
        t1.start();
        t2.start();
    
    } 
};