
public class Tp2Obligatorio1 {

    public static void main(String[] args) {
        int x = 4;
        int y = 5;
        int z = 7;

        Recurso rc = new Recurso();
        Hilo1 t1 = new Hilo1(rc, x, y);
        Hilo2 t2 = new Hilo2(rc, z);
        Hilo3 t3 = new Hilo3(rc);

        Thread h1 = new Thread(t1);
        Thread h2 = new Thread(t2);
        Thread h3 = new Thread(t3);

        h1.start();
        h2.start();
        h3.start();

    }

}
