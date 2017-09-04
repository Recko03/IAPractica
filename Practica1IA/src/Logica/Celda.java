package Logica;

import java.awt.Color;
import javax.swing.JPanel;

public class Celda{
    private int wall;//1 para camino y 0 para muro
    private boolean visitado;
    private boolean decision;
    private boolean P_inicial;
    private boolean posicion_actual;

    public Celda(int wall, boolean visitado, boolean decision, boolean P_inicial, boolean posicion_actual) {
        this.wall = wall;
        this.visitado = visitado;
        this.decision = decision;
        this.P_inicial = P_inicial;
        this.posicion_actual = posicion_actual;
    }

    public int getWall() {
        return wall;
    }

    public void setWall(int wall) {
        this.wall = wall;
    }

    public boolean isVisitado() {
        return visitado;
    }

    public void setVisitado(boolean visitado) {
        this.visitado = visitado;
    }

    public boolean isDecision() {
        return decision;
    }

    public void setDecision(boolean decision) {
        this.decision = decision;
    }

    public boolean isP_inicial() {
        return P_inicial;
    }

    public void setP_inicial(boolean P_inicial) {
        this.P_inicial = P_inicial;
    }

    public boolean isPosicion_actual() {
        return posicion_actual;
    }

    public void setPosicion_actual(boolean posicion_actual) {
        this.posicion_actual = posicion_actual;
    }

}
