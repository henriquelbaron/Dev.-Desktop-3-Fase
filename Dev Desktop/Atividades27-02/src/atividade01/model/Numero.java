/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atividade01.model;

/**
 *
 * @author ACER
 */
public class Numero {
    
    private Double numeroUm;
    private Double numeroDois;
    
    public Numero() {
    }
    
    public Numero(Double numeroUm, Double numeroDois) {
        this.numeroUm = numeroUm;
        this.numeroDois = numeroDois;
    }
    
    public Double getNumeroUm() {
        return numeroUm;
    }
    
    public void setNumeroUm(String numero) {
        setNumeroUm(Double.valueOf(numero));
    }
    
    public void setNumeroDois(String numero) {
        setNumeroDois(Double.valueOf(numero));
    }
    
    public void setNumeroUm(Double numeroUm) {
        this.numeroUm = numeroUm;
    }
    
    public Double getNumeroDois() {
        return numeroDois;
    }
    
    public void setNumeroDois(Double numeroDois) {
        this.numeroDois = numeroDois;
    }
    
}
