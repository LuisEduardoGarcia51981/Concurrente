/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP3;

/**
 *
 * @author b h
 */
public class ManejadorTurnos {

    private int turnoActual = 1;
    private int ultimoTurno = 0;

    public ManejadorTurnos() {
    }

    public int getTurnoActual() {
        return turnoActual;
    }

    public void setTurnoActual(int turnoActual) {
        this.turnoActual = turnoActual;
    }

    public synchronized int obtenerTurno() {
        this.ultimoTurno++;
        return ultimoTurno;
    }

    public void aumentarUltimoTurno() {
        this.ultimoTurno++;
    }
}