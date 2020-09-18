package TP3;

public class Ej3 {
    public static void main (String[] args) 
    {
        Turno     obj_turno = new Turno(); 
        LetraA  obj_letra_a = new LetraA(obj_turno);
        LetraB  obj_letra_b = new LetraB(obj_turno);
        LetraC  obj_letra_c = new LetraC(obj_turno);
        
        Thread letra_a = new Thread(obj_letra_a);
        Thread letra_b = new Thread(obj_letra_b );
        Thread letra_c = new Thread(obj_letra_c);
    
        letra_a.start();
        letra_b.start();
        letra_c.start();

    } 
}