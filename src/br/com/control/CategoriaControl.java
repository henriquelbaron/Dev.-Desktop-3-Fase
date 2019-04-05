/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.control;

import br.com.model.domain.Categoria;
import br.com.model.dao.CategoriaImpl;
import br.com.model.domain.CategoriaTable;
import static br.com.view.TelaList.*;
import java.util.List;

/**
 *
 * @author ACER
 */
public class CategoriaControl {

    private final CategoriaImpl persistence;
    private final CategoriaTable table;
    private Integer rowsPerPage;
    private Categoria c;
    private int row;
    private Integer currentPage;
    private Integer totalPage;
    private Integer totalRegistros;

    public CategoriaControl() {
        persistence = new CategoriaImpl();
        table = new CategoriaTable();
        defaultConfig();
        refreshTable();
    }

    public void saveAction() {
        if (c == null) {
            c = new Categoria(tfCampo.getText());
            persistence.save(c);
            table.addRow(c);
            defaultConfig();
        } else {
            c.setNome(tfCampo.getText());
            persistence.update(c);
            table.updateRow(row, c);
        }
        Validation.isSelected();
        controlLabels();
        tfCampo.setText(null);
        bSalvar.setEnabled(false);
        c = null;
    }

    public void deleteAction() {
        if (Validation.confirmAction()) {
            return;
        }
        c = table.getRow(getSelectedRow());
        c.setAtivo(true);
        persistence.update(c);
        table.removeRow(getSelectedRow());
        controlLabels();
        Validation.isSelected();
        c = null;
    }

    public void updateAction() {
        c = table.getRow(getSelectedRow());
        tfCampo.setText(c.getNome());
        bSalvar.setEnabled(true);
    }

    public void refreshTable() {
        tableCategoria.setModel(table);
        controlLabels();
    }

    public void comboBoxAction() {
        rowsPerPage = Integer.valueOf(comboBox.getSelectedItem().toString());
        controlLabels();
        defaultConfig();
    }

    public void previousPag() {
        table.clearTable();
        List<Categoria> cat = persistence.listar(((currentPage * rowsPerPage) - (rowsPerPage + rowsPerPage)), rowsPerPage);
        for (Categoria categoria : cat) {
            table.addRow(categoria);
        }
        currentPage--;
        verifyEnabled();
        controlLabels();
    }

    public void nextPag() {
        table.clearTable();
        List<Categoria> cat = persistence.listar((currentPage * rowsPerPage), rowsPerPage);
        for (Categoria categoria : cat) {
            table.addRow(categoria);
        }
        currentPage++;
        verifyEnabled();
        bPrimeiro.setEnabled(true);
        bAnterior.setEnabled(true);
        controlLabels();
    }

    public void lastPage() {
        table.clearTable();
        List<Categoria> cat = persistence.listar((totalPage * rowsPerPage) - rowsPerPage, rowsPerPage);
        for (Categoria categoria : cat) {
            table.addRow(categoria);
        }
        currentPage = totalPage;
        verifyEnabled();
        controlLabels();
    }

    public void firstPage() {
        table.clearTable();
        List<Categoria> cat = persistence.listar(0, rowsPerPage);
        for (Categoria categoria : cat) {
            table.addRow(categoria);
        }
        currentPage = 1;
        verifyEnabled();
        controlLabels();
    }

    public void defaultConfig() {
        table.clearTable();
        currentPage = 1;
        rowsPerPage = Integer.valueOf(comboBox.getSelectedItem().toString());
        List<Categoria> cat = persistence.listar(0, rowsPerPage);
        for (Categoria categoria : cat) {
            table.addRow(categoria);
        }
        Validation.isSelected();
        bAnterior.setEnabled(false);
        bPrimeiro.setEnabled(false);
        bProximo.setEnabled(true);
        bUltimo.setEnabled(true);
        bSalvar.setEnabled(false);
    }

    public void newAction() {
        bSalvar.setEnabled(true);
    }

    public void controlLabels() {
        totalRegistros = persistence.listar().size();
        labelTotalRegistros.setText(totalRegistros.toString());
        labelRegistros.setText(String.valueOf(rowsPerPage));
        labelPaginaAtual.setText(currentPage.toString());
        labelTotalPaginas.setText(getTotalPage().toString());
    }

    public int getSelectedRow() {
        row = tableCategoria.getSelectedRow();
        return row;
    }

    public void getTotalRegistros() {

    }

    public Integer getTotalPage() {
        double resto = totalRegistros % rowsPerPage;
        totalPage = (totalRegistros / rowsPerPage);
        if (resto != 0) {
            totalPage++;
        }
        return totalPage;
    }

    public void verifyEnabled() {
        if (currentPage >= totalPage) {
            bProximo.setEnabled(false);
            bUltimo.setEnabled(false);
            bPrimeiro.setEnabled(true);
            bAnterior.setEnabled(true);
            return;
        }
        if (currentPage <= 1) {
            bPrimeiro.setEnabled(false);
            bAnterior.setEnabled(false);
            bProximo.setEnabled(true);
            bUltimo.setEnabled(true);
            return;
        }
        bProximo.setEnabled(true);
        bUltimo.setEnabled(true);
    }
}
