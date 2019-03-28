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
public class Operacao {

    private Numero numero;

    public Operacao() {
    }

    public Operacao(Numero numero) {
        this.numero = numero;
    }

    public Numero getNumero() {
        return numero;
    }

    public void setNumero(Numero numero) {
        this.numero = numero;
    }

    public Double soma() {
        return numero.getNumeroUm() + numero.getNumeroDois();
    }

    public Double subtacao() {
        return numero.getNumeroUm() - numero.getNumeroDois();
    }

    public Double divisao() {
        return numero.getNumeroUm() / numero.getNumeroDois();
    }

    public Double multiplicacao() {
        return numero.getNumeroUm() * numero.getNumeroDois();
    }

}
