package parcial2tema1.ej2;

public class Main
 {
    public static void main (String[] args) 
    {               
        int cap_transb=10;
        int num_de_autos=25;
        RecursoCompartido rc= new RecursoCompartido(cap_transb); 

        Thread[] hilos_autos = new Thread[num_de_autos];
        for (int i = 0; i < num_de_autos; i++) {
            String nombre_auto="auto_"+i;
            hilos_autos[i] = new Thread(new Auto(rc,nombre_auto),nombre_auto );
            hilos_autos[i].start();
        }

        Transbordador el_transb= new Transbordador(rc); 
        Thread hilo_Transb= new Thread(el_transb);
        hilo_Transb.start();
        

}
}