
public class SalaFumadores {
    private int ingrediente1;
    private int ingrediente2;
    private boolean seguir;

    public SalaFumadores() {
        this.ingrediente1 = 0;
        this.ingrediente2 = 0;
        this.seguir = false;
    }

    public synchronized void evaluar_condicion(int fumador, int ingred1, int ingred2) {
        boolean condicion = ((this.ingrediente1 == ingred1 && this.ingrediente2 == ingred2)
                || (this.ingrediente1 == ingred2 && this.ingrediente2 == ingred1));
        while (!condicion) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            condicion = ((this.ingrediente1 == ingred1 && this.ingrediente2 == ingred2)
                    || (this.ingrediente1 == ingred2 && this.ingrediente2 == ingred1));
        }
    }

    public synchronized void terminafumar() {
        this.ingrediente1 = 0;
        this.ingrediente2 = 0;
        this.seguir = true;
        this.notifyAll(); // esta bien usado el notifyAll????
    }

    public synchronized void entrafumar(int ingrediente) {
        if (ingrediente == 1) {
            evaluar_condicion(1, 2, 3);
        } else {
            if (ingrediente == 2) {
                evaluar_condicion(2, 1, 3);
            } else {
                if (ingrediente == 3) {
                    evaluar_condicion(3, 1, 2);
                }
            }
        }
    }

    public synchronized void colocar(int ingrediente1, int ingrediente2) {
        System.out.println("el agente puso: " + ingrediente1 + " " + ingrediente2);
        if (ingrediente1 != ingrediente2) {
            this.ingrediente2 = ingrediente2;
            this.ingrediente1 = ingrediente1;
            this.notifyAll();// se puede perder esta señal si no hay nadie en un "wait", pero no pasa nada
            while (!this.seguir) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            this.seguir = false;
        } else {
            System.out.println("son iguales, asi que nadie fuma");
        }
    }
}