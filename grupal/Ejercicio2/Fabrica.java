
import java.util.concurrent.Semaphore;

public class Fabrica {
    private Semaphore sem_botellas = new Semaphore(0);
    private Semaphore sem_caja = new Semaphore(10);
    private int max_botellas;

    public Fabrica(int max_botellas) {
        this.max_botellas = max_botellas;
    }

    public void esperando_empaquetar() {
        try {
            this.sem_botellas.acquire(10);
        } catch (Exception e) {
            // TODO: handle exception
        }

    }

    public void poner_caja_nueva() {
        this.sem_caja.release(10);
    }

    public void poner_botella() {

        this.sem_botellas.release(1);

    }

    public void verificar_caja_llena() {
        try {
            this.sem_caja.acquire(1);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

}
