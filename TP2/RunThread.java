package TP2;
public class RunThread extends Thread{
    
    public RunThread(String cartel)
    {    super();
        Thread.currentThread().setName(cartel);
    }

    public void run() 
    {
        for (int i=0; i <30; i++)
        {
            String threadNombre = Thread.currentThread().getName();
            System.out.println(threadNombre + " en ejecucion");
        }
    }
}