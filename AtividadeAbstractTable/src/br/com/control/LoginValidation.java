/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.control;

import br.com.model.dao.ParticipanteImpl;
import br.com.model.domain.Participante;
import br.com.view.CRUDCategoriasJFrame;
import br.com.view.LoginFrame;

/**
 *
 * @author ACER
 */
public class LoginValidation {

    public static void user() {
        Participante p = new Participante();
        p.setEmail(LoginFrame.tfNome.getText());
        p.setSenha(LoginFrame.tfSenha.getText());
        ParticipanteImpl dao = new ParticipanteImpl();
        for (Participante pt : dao.listar()) {
            if (pt.getEmail().equals(p.getEmail()) && pt.getSenha().equals(p.getSenha())) {
                
            }
        }
    }

    public static void campos() {
        if (LoginFrame.tfNome.getText() == null || LoginFrame.tfNome.getText().trim().isEmpty()) {
            System.out.println("Digite Email!");
            return;
        }
        if (LoginFrame.tfSenha.getText() == null || LoginFrame.tfSenha.getText().trim().isEmpty()) {
            System.out.println("Digite Senha!");
            return;
        }
    }
}
