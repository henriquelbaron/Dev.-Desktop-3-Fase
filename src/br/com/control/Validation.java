/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.control;

import static br.com.view.TelaList.bAlterar;
import static br.com.view.TelaList.bDeletar;
import static br.com.view.TelaList.tableCategoria;
import javax.swing.JOptionPane;

/**
 *
 * @author ACER
 */
public class Validation {

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
