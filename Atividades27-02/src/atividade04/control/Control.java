/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atividade04.control;

import atividade04.model.Boletin;
import atividade04.view.Tela04;
import java.awt.Color;
import java.text.DecimalFormat;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author ACER
 */
public class Control {

    private Boletin boletin;
    private DecimalFormat df;

    public Control() {
        df = new DecimalFormat("#.00");
    }

    public void carregarDados() {
        boletin = new Boletin();
        boletin.setNotaUm(Tela04.notaUm.getText());
        boletin.setNotaDois(Tela04.notaDois.getText());
        boletin.setNotaTres(Tela04.notaTres.getText());
    }

    public void apresentaResultadoAction() {
        carregarDados();
        Tela04.labelMedia1.setText(df.format(boletin.mediaDeNotas()));
        if (boletin.mediaDeNotas() >= 7) {
            Tela04.labelSituacao.setForeground(Color.GREEN);
            Tela04.labelSituacao.setText("Aprovado!");
        } else {
            Tela04.labelSituacao.setForeground(Color.RED);
            Tela04.labelSituacao.setText("Reprovado!");
        }
    }

    public Double converterDouble(JTextField tf) {
        String aux = tf.getText().replaceAll(",", ".");
        return Double.valueOf(aux);
    }

}
