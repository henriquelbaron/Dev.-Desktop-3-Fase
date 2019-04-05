/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atividade5.model;

import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author ACER
 */
public class Distancia {

    private Ponto pontoInicial;
    private Ponto pontoFinal;
    private Integer tempo;
    private Double consumo;

    public Distancia() {
    }

    public Distancia(Ponto pontoInicial, Ponto pontoFinal, Integer tempo, Double consumo) {
        this.pontoInicial = pontoInicial;
        this.pontoFinal = pontoFinal;
        this.tempo = tempo;
        this.consumo = consumo;
    }

    public Double getDistancia() {
        if ((pontoInicial.getLatitude() == pontoFinal.getLatitude()) && (pontoInicial.getLongitude() == pontoFinal.getLongitude())) {
            return 0.0;
        } else {
            double distancia;
            double theta = pontoInicial.getLongitude() - pontoFinal.getLongitude();
            distancia = Math.sin(Math.toRadians(pontoInicial.getLatitude())) * Math.sin(Math.toRadians(pontoFinal.getLatitude())) + Math.cos(Math.toRadians(pontoInicial.getLatitude())) * Math.cos(Math.toRadians(pontoFinal.getLatitude())) * Math.cos(Math.toRadians(theta));
            distancia = Math.acos(distancia);
            distancia = Math.toDegrees(distancia);
            distancia = distancia * 1.609344;
            return distancia;
        }
    }

    public Double getVelocidadeMedia() {
        return getDistancia() / tempo;
    }

    public Double getAutonomia() {
        return getDistancia() / tempo;
    }

    public Ponto getPontoInicial() {
        return pontoInicial;
    }

    public void setPontoInicial(Ponto pontoInicial) {
        this.pontoInicial = pontoInicial;
    }

    public Ponto getPontoFinal() {
        return pontoFinal;
    }

    public void setPontoFinal(Ponto pontoFinal) {
        this.pontoFinal = pontoFinal;
    }

    public Integer getTempo() {
        return tempo;
    }

    public void setTempo(Integer tempo) {
        this.tempo = tempo;
    }

    public Double getConsumo() {
        return consumo;
    }

    public void setConsumo(Double consumo) {
        this.consumo = consumo;
    }

}
