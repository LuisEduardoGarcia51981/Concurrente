public class Embotellador implements Runnable {
    private Fabrica una_fabrica;

    public Embotellador(Fabrica una_fabrica) {
        this.una_fabrica = una_fabrica;

    }

    public void run() {
        int i = 1;
        while (true) {

            // for (int i = 1; i <= 2; i++) {
            this.una_fabrica.verificar_caja_llena();
            System.out.println("El embotellador prepara la botella " + i + " y la pone en la caja");
            this.una_fabrica.poner_botella();
            if (i == 10) {
                i = 1;
            } else {
                i++;
            }
        }

    }

}