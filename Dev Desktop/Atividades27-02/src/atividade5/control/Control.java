/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atividade5.control;

import atividade5.model.Distancia;
import atividade5.model.Ponto;
import atividade5.view.Tela;
import java.text.DecimalFormat;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;

/**
 *
 * @author ACER
 */
public class Control {

    private Distancia distancia;
    private DecimalFormat df;

    public Control() {
        df = new DecimalFormat("0.##");
    }

    public void carregarPontos() {
        Ponto pontoInicial = new Ponto();
        pontoInicial.setLatitude(Tela.tfLatitudeInicial.getText());
        pontoInicial.setLongitude(Tela.tfLongitudeInicial.getText());
        Ponto pontoFinal = new Ponto();
        pontoFinal.setLatitude(Tela.tfLatitudeFinal.getText());
        pontoFinal.setLongitude(Tela.tfLongitudeFinal.getText());
        distancia = new Distancia(pontoInicial, pontoFinal, converterMinutos(Tela.formattedTempo), converterConsumo(Tela.tfConsumo));
    }

    public Integer converterMinutos(JFormattedTextField tf) {
        String[] tempo = tf.getText().split("[:]");
        Integer minutos = (Integer.valueOf(tempo[0]) * 60) + Integer.valueOf(tempo[1]);
        return minutos;
    }

    public Double converterConsumo(JTextField tf) {
        return Double.parseDouble(tf.getText());
//        return Double.parseDouble(tf.getText().replaceAll(".", ","));
    }

    public void calcularResultadosAction() {
        carregarPontos();
        Tela.lblDistancia.setText(df.format(distancia.getDistancia()) + " Km");
        Tela.lblVelocidadeMedia.setText(df.format(distancia.getVelocidadeMedia()) + " Km/H");
        Tela.lblAutonomia.setText(df.format(distancia.getAutonomia()));
    }
}
