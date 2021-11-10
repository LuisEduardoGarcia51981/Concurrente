import java.util.*;

public class Agente implements Runnable {
    private SalaFumadores sala;
    private Random r;

    public Agente(SalaFumadores sala) {
        this.sala = sala;
        r = new Random();
    }

    public void run() {
        while (true) {
            sala.colocar(r.nextInt(3) + 1, r.nextInt(3) + 1);
        } // while
    }// run
}// clase