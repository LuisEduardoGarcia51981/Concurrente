package TP3;

public class Ej6 {
    public static void main (String[] args) 
    {
        int  k = 40;
        int total_numeros=50000;
        int[] numeros = new int [10];
        Thread[] hilos = new Thread [k];

        for (var i = 0; i < numeros.length; i++) 
        {
            numeros[i]=(int) (Math.random()*10 );
            System.out.println(numeros[i]);
        }
        int inicio=0;
        int fin = (int) (total_numeros / k);
        for (var i = 0; i < k; i++) 
        {
            HilosSumar objeto = new HiloSumar("hilo "+i, inicio, fin, numeros);
            hilos[i]= 
            hilos[i].
           
        }
       
        VerificarCuenta vc = new VerificarCuenta();
        Thread Luis = new Thread(vc, "Luis" );
    } 
}