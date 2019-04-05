/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atividade01.control;

import atividade01.model.Numero;
import atividade01.model.Operacao;
import atividade01.view.Tela;
import java.text.DecimalFormat;
import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.Locale;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author ACER
 */
public class Control {

    private Operacao op;
    private DecimalFormat df;

    public Control() {
        op = new Operacao();
        df = new DecimalFormat("0.##");
        desabilitaBotao();
    }

    public void carregarNumero() {
        Numero numero = new Numero();
        numero.setNumeroUm(Tela.tfUm.getText());
        numero.setNumeroDois(Tela.tfDois.getText());
        op.setNumero(numero);
    }

    public void desabilitaBotao() {
        Tela.bMais.setEnabled(false);
        Tela.bMenos.setEnabled(false);
        Tela.bVezes.setEnabled(false);
        Tela.bDividido.setEnabled(false);
    }

    public void habilitaBotao() {
        if (Tela.tfDois.getVerifyInputWhenFocusTarget() || Tela.tfUm.getVerifyInputWhenFocusTarget()) {
            Tela.bMais.setEnabled(true);
            Tela.bMenos.setEnabled(true);
            Tela.bVezes.setEnabled(true);
            Tela.bDividido.setEnabled(true);
        }
    }

    public void somarAction() {
        carregarNumero();
        mostraResultado(op.soma());
    }

    public void dividirAction() {
        carregarNumero();
        mostraResultado(op.divisao());
    }

    public void multiplicarAction() {
        carregarNumero();
        mostraResultado(op.multiplicacao());
    }

    public void subtrairAction() {
        carregarNumero();
        mostraResultado(op.subtacao());
    }

    public void mostraResultado(Double resultado) {
        Tela.labelResultado.setText(resultado.toString());
        limparCampos();
        desabilitaBotao();
    }

    public Double converterParaDouble(JTextField tf) {
//        Locale br = new Locale("pt", "BR");
//        NumberFormat nf =  NumberFormat.getInstance(br);
        String aux = tf.getText().replaceAll(",", ".");
        return Double.valueOf(aux);
    }

    public void limparCampos() {
        Tela.tfUm.setText(null);
        Tela.tfDois.setText(null);
    }

    public void validaCamposVazio() {
        if (Tela.tfUm == null || Tela.tfUm.getText().trim().isEmpty()
                || Tela.tfDois == null || Tela.tfDois.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Digite somente numero", "ERRO!", JOptionPane.ERROR_MESSAGE);
        }
    }
}
