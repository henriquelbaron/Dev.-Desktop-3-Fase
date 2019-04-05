/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atividade04.model;

/**
 *
 * @author ACER
 */
public class Boletin {

    private Double notaUm;
    private Double notaDois;
    private Double notaTres;

    public Boletin() {
    }

    public Boletin(Double notaUm, Double notaDois, Double notaTres) {
        this.notaUm = notaUm;
        this.notaDois = notaDois;
        this.notaTres = notaTres;
    }

    public Double mediaDeNotas() {
        return (notaUm + notaDois + notaTres) / 3;
    }

    public Double getNotaUm() {
        return notaUm;
    }

    public void setNotaUm(Double notaUm) {
        this.notaUm = notaUm;
    }

    public Double getNotaDois() {
        return notaDois;
    }

    public void setNotaUm(String nota) {
        setNotaUm(Double.valueOf(nota.replaceAll(",", ".")));
    }

    public void setNotaDois(String nota) {
        setNotaDois(Double.valueOf(nota.replaceAll(",", ".")));
    }

    public void setNotaTres(String nota) {
        setNotaTres(Double.valueOf(nota.replaceAll(",", ".")));
    }

    public void setNotaDois(Double notaDois) {
        this.notaDois = notaDois;
    }

    public Double getNotaTres() {
        return notaTres;
    }

    public void setNotaTres(Double notaTres) {
        this.notaTres = notaTres;
    }

}
