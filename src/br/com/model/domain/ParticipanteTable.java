/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model.domain;

import br.com.model.domain.Participante;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ACER
 */
public class ParticipanteTable extends AbstractTableModel {

    private List<Participante> participantes = new ArrayList();

    public void clearTable() {
        this.participantes = new ArrayList<>();
    }

    static class Constantes {
        private static final String[] COLUNAS = {"Código", "Nome","CPF","Email","Telefone","Categorias"};
        private static final int CODIGO = 0;
        private static final int NOME = 1;
        private static final int CPF = 3;
        private static final int EMAIL = 4;
        private static final int TELEFONE = 5;
        private static final int CATEGORIAS = 6;
    }

    @Override
    public int getRowCount() {
        return participantes.size();
    }

    @Override
    public int getColumnCount() {
        return Constantes.COLUNAS.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columIndex) {
        switch (columIndex) {
            case Constantes.CODIGO:
                return participantes.get(rowIndex).getId();
            case Constantes.NOME:
                return participantes.get(rowIndex).getNome();
            case Constantes.CPF:
                return participantes.get(rowIndex).getCpf();
            case Constantes.EMAIL:
                return participantes.get(rowIndex).getEmail();
            case Constantes.TELEFONE:
                return participantes.get(rowIndex).getTelefone();
            case Constantes.CATEGORIAS:
                return participantes.get(rowIndex).getCategorias();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return Constantes.COLUNAS[column];
    }

    public Participante getRow(int row) {
        return row >= 0 ? participantes.get(row) : null;
    }

    public void addRow(Participante c) {
        participantes.add(c);
//        this.fireTableRowsInserted(getRowCount() - 1, getRowCount()-1);
        this.fireTableDataChanged();
    }

    public void removeRow(int row) {
        participantes.remove(row);
        this.fireTableRowsUpdated(row, row);
        this.fireTableDataChanged();
    }

    public void updateRow(int row, Participante c) {
        participantes.set(row, c);
        this.fireTableRowsUpdated(row, row);
        this.fireTableDataChanged();
    }
}
