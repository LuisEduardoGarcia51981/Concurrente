package TP2;
public class TestRunThread {

    public static void main (String[] args) 
    {
        RunThread alfa = new RunThread("Hilo Alfa");
        RunThread beta = new RunThread("Hilo Beta");
        alfa.start();
        beta.start();
        System.out.println("Chau en main");
    }
}