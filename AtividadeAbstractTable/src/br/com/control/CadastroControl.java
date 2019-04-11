/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.control;

import br.com.control.persistence.PersistenceDao;
import br.com.model.domain.Categoria;
import br.com.model.domain.Participante;
import br.com.view.CadastroParticipante;
import javax.swing.JCheckBox;
import static br.com.view.CadastroParticipante.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ACER
 */
public class CadastroControl {

    private Participante participante;
    private List<Categoria> categorias;
    private List<JCheckBox> listCheckBox;

    public void carregarDados() {
        if (participante == null) {
            participante = new Participante();
        }
        Validation.verificarCamposCadastros();
        participante.setNome(CadastroParticipante.tfNome.getText());
        participante.setEmail(CadastroParticipante.tfEmail.getText());
        participante.setSenha(CadastroParticipante.tfSenha.getText());
        participante.setTelefone(CadastroParticipante.tfTelefone.getText());
        participante.setCpf(CadastroParticipante.tfCpf.getText());
        getCategoriasSelected();
    }

    public void salvarAction() {
        carregarDados();
        PersistenceDao.getParticipanteImpl().save(participante);
    }

    public CadastroControl() {
        categorias = new ArrayList<>();
        listCheckBox = new ArrayList<>();
        listarCategorias();
    }

    public void createCheckBox(Categoria c) {
        JCheckBox box = new JCheckBox();
        box.setText(c.getNome());
        buttonGroup1.add(box);
    }

    public List<Categoria> getCategoriasSelected() {
        List<Categoria> list = new ArrayList();
        for (JCheckBox jCheckBox : listCheckBox) {
            if (jCheckBox.isSelected()) {
                for (Categoria categoria : categorias) {
                    if (jCheckBox.getText().equals(categoria.getNome())) {
                        list.add(categoria);
                        participante.addList(categoria);
                    }
                }
            }
        }
        return list;
    }

    public void listarCategorias() {
        int coluna = 0;
        int filera = 0;
        for (Categoria c : PersistenceDao.getCategoriaImpl().listar()) {
            System.out.println(c.getId());
            categorias.add(c);
            JCheckBox checkBox = new JCheckBox(c.getNome());
            panelCategoria.add(checkBox);
            if (coluna > 2) {
                coluna = 0;
                filera++;
            }
            checkBox.setBounds(100 * coluna + 12, 24 * filera + 20, 100, 20);
            listCheckBox.add(checkBox);
            coluna++;
        }
    }
}
