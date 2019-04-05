/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model.domain;

import br.com.model.domain.Categoria;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ACER
 */
public class CategoriaTable extends AbstractTableModel {

    private List<Categoria> categorias = new ArrayList();

    public void clearTable() {
        this.categorias = new ArrayList<>();
    }

    static class Constantes {

        private static final String[] COLUNAS = {"Código", "Nome"};
        private static final int CODIGO = 0;
        private static final int NOME = 1;
    }

    @Override
    public int getRowCount() {
        return categorias.size();
    }

    @Override
    public int getColumnCount() {
        return Constantes.COLUNAS.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columIndex) {
        switch (columIndex) {
            case Constantes.CODIGO:
                return categorias.get(rowIndex).getId();
            case Constantes.NOME:
                return categorias.get(rowIndex).getNome();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return Constantes.COLUNAS[column];
    }

    public Categoria getRow(int row) {
        return row >= 0 ? categorias.get(row) : null;
    }

    public void addRow(Categoria c) {
        categorias.add(c);
//        this.fireTableRowsInserted(getRowCount() - 1, getRowCount()-1);
        this.fireTableDataChanged();
    }

    public void removeRow(int row) {
        categorias.remove(row);
        this.fireTableRowsUpdated(row, row);
        this.fireTableDataChanged();
    }

    public void updateRow(int row, Categoria c) {
        categorias.set(row, c);
        this.fireTableRowsUpdated(row, row);
        this.fireTableDataChanged();
    }
}
