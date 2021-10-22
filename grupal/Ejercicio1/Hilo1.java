
public class Hilo1 implements Runnable {
    Recurso recurso;
    private int x;
    private int y;

    public Hilo1(Recurso r, int x, int y) {
        this.recurso = r;
        this.x = x;
        this.y = y;
    }

    @Override
    public void run() {
        this.recurso.p1(this.x, this.y);
    }
}
