/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.control;

import static br.com.view.CRUDParticipantesJFrame.bAlterar;
import static br.com.view.CRUDParticipantesJFrame.bDeletar;
import static br.com.view.CRUDParticipantesJFrame.tableCategoria;
import br.com.view.CadastroParticipante;
import java.awt.Color;
import javax.swing.JOptionPane;

/**
 *
 * @author ACER
 */
public class Validation {

    public static boolean cpf(String strCpf) {
        int d1, d2;
        int digito1, digito2, resto;
        int digitoCPF;
        String nDigResult;
        d1 = d2 = 0;
        digito1 = digito2 = resto = 0;
        for (int nCount = 1; nCount < strCpf.length() - 1; nCount++) {
            digitoCPF = Integer.valueOf(strCpf.substring(nCount - 1, nCount)).intValue();
            d1 = d1 + (11 - nCount) * digitoCPF;
            d2 = d2 + (12 - nCount) * digitoCPF;
        }
        resto = (d1 % 11);
        if (resto < 2) {
            digito1 = 0;
        } else {
            digito1 = 11 - resto;
        }
        d2 += 2 * digito1;
        resto = (d2 % 11);
        if (resto < 2) {
            digito2 = 0;
        } else {
            digito2 = 11 - resto;
        }
        String nDigVerific = strCpf.substring(strCpf.length() - 2, strCpf.length());
        nDigResult = String.valueOf(digito1) + String.valueOf(digito2);
        return nDigVerific.equals(nDigResult);
    }

    public static void camposSenhas() {
        CadastroParticipante.labelConfirmar.setForeground(Color.BLACK);
        CadastroParticipante.labelSenha.setForeground(Color.BLACK);
        if (!CadastroParticipante.tfSenha.getText().equals(CadastroParticipante.tfConfirmaSenha.getText())) {
            CadastroParticipante.labelConfirmar.setForeground(Color.RED);
            CadastroParticipante.labelSenha.setForeground(Color.RED);
            return;
        }
    }

    public static void verificarCamposCadastros() {
        if (CadastroParticipante.tfNome == null || CadastroParticipante.tfNome.getText().trim().isEmpty()) {
            System.out.println("Campo Nome Obrigatorio");
            return;
        }
        if (CadastroParticipante.tfEmail == null || CadastroParticipante.tfEmail.getText().trim().isEmpty()) {
            System.out.println("Campo Email Obrigatorio");
            return;
        }
        if (CadastroParticipante.tfCpf == null || CadastroParticipante.tfCpf.getText().trim().isEmpty()) {
            System.out.println("Campo CPF Obrigatorio");
            return;
        } else {
            if (!cpf(CadastroParticipante.tfCpf.getText())) {
                System.out.println("CPF invalido");
                return;
            }
        }
    }

    public static void isSelected() {
        if (tableCategoria.getSelectedRow() < 0) {
            bAlterar.setEnabled(false);
            bDeletar.setEnabled(false);
        } else {
            bAlterar.setEnabled(true);
            bDeletar.setEnabled(true);
        }
    }

    public static boolean confirmAction() {
        return JOptionPane.showConfirmDialog(null, "Tem certeza?", "Atenção", JOptionPane.YES_NO_OPTION) == 1;
    }
}
