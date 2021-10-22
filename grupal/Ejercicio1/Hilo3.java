
import java.util.logging.Level;
import java.util.logging.Logger;

public class Hilo3 implements Runnable {
    Recurso recurso;

    public Hilo3(Recurso r) {
        this.recurso = r;
    }

    @Override
    public void run() {
        try {
            this.recurso.p3();
        } catch (InterruptedException ex) {
            Logger.getLogger(Hilo3.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            this.recurso.p4();
        } catch (InterruptedException ex) {
            Logger.getLogger(Hilo3.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
