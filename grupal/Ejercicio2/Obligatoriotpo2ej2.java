
public class Obligatoriotpo2ej2 {
    public static void main(String[] args) {

        int cantidad_botellas = 10;
        Fabrica una_fabrica = new Fabrica(cantidad_botellas);

        Embotellador un_embotellador = new Embotellador(una_fabrica);
        Thread hilo_embotellador = new Thread(un_embotellador, "Embotellador");
        hilo_embotellador.start();

        Empaquetador un_empaquetador = new Empaquetador(una_fabrica);
        Thread hilo_empaquetador = new Thread(un_empaquetador, "Empaquetador");
        hilo_empaquetador.start();

    }
}
