
import java.util.concurrent.Semaphore;

public class Recurso {
    private int b;
    private int a;
    private int c;
    private int w;
    private Semaphore semp3;

    public Recurso() {
        this.semp3 = new Semaphore(0);
    }

    public void p1(int x, int y) {
        this.a = x + y;
        System.out.println(Thread.currentThread().getName() + "hizo p1 =" + this.a);
        semp3.release(1);
    }

    public void p2(int z) {
        this.b = z - 1;
        System.out.println(Thread.currentThread().getName() + "hizo p2 =" + this.b);
        semp3.release(1);

    }

    public void p3() throws InterruptedException {
        semp3.acquire(2);
        this.c = this.a - this.b;
        System.out.println(Thread.currentThread().getName() + "hizo p3 =" + this.c);
    }

    public void p4() throws InterruptedException {
        this.w = this.c + 1;
        System.out.println(Thread.currentThread().getName() + "hizo p4 =" + this.w);
    }
}
