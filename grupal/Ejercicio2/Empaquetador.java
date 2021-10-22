public class Empaquetador implements Runnable {
    private Fabrica una_fabrica;

    public Empaquetador(Fabrica una_fabrica) {
        this.una_fabrica = una_fabrica;

    }

    public void run() {
        // while (true) {
        for (int i = 1; i <= 2; i++) {
            this.una_fabrica.esperando_empaquetar();
            System.out.println(
                    "La caja esta llena y el empaquetador comienza a trabajar (toma la caja, la sella y la guarda en un almacén)");
            try {
                Thread.sleep((int) Math.random() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(
                    "El empaquetador termino de guardar la caja en el almacen, y deposita una caja nueva vacia");
            this.una_fabrica.poner_caja_nueva();
        }

    }

}