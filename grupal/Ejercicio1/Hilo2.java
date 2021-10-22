
public class Hilo2 implements Runnable {

    Recurso recurso;
    private int z;

    public Hilo2(Recurso r, int z) {
        this.recurso = r;
        this.z = z;
    }

    @Override
    public void run() {
        this.recurso.p2(this.z);

    }

}
