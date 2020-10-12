package TP4.ej13;

public class Ej13
 {
    public static void main (String[] args) 
    {
        int cant=6;
        Empleado[] empleados = new Empleado[cant];

        
        Confiteria confiteria= new Confiteria();
       
        Mozo mozo= new Mozo(confiteria);
        Cocinero cocinero= new Cocinero(confiteria);

        for (int i = 0; i < cant; i++) {
            empleados[i] = new Empleado(confiteria);             
        }

        Thread[] hilos_empleados = new Thread[cant];
        for (int i = 0; i < cant; i++) {
            hilos_empleados[i] = new Thread(empleados[i], "Emp"+i);
            hilos_empleados[i].start();
        }
        Thread hilo_mozo= new Thread(mozo,"Mozo");
        hilo_mozo.start();
        Thread hilo_cocinero= new Thread(cocinero,"Cocinero");
        hilo_cocinero.start();
}
}