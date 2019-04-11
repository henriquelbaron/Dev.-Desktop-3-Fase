package br.com.control;

import br.com.control.persistence.PersistenceDao;
import br.com.model.dao.ParticipanteImpl;
import br.com.model.domain.Participante;
import br.com.model.domain.ParticipanteTable;
import static br.com.view.CRUDParticipantesJFrame.*;
import java.util.List;

/**
 *
 * @author ACER
 */
public class ParticipanteControl {

    private final ParticipanteTable table;
    private Integer rowsPerPage;
    private Participante c;
    private int row;
    private Integer currentPage;
    private Integer totalPage;
    private Integer totalRegistros;
    private List<Participante> participantes;

    public ParticipanteControl() {
        table = new ParticipanteTable();
        defaultConfig();
        refreshTable();
    }

    public void saveAction() {
        if (c == null) {
            c = new Participante(tfCampo.getText());
            PersistenceDao.getParticipanteImpl().save(c);
            table.addRow(c);
            defaultConfig();
        } else {
            c.setNome(tfCampo.getText());
            PersistenceDao.getParticipanteImpl().update(c);
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
        PersistenceDao.getParticipanteImpl().update(c);
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
        participantes = PersistenceDao.getParticipanteImpl().listar(((currentPage * rowsPerPage) - (rowsPerPage + rowsPerPage)), rowsPerPage);
        for (Participante pt : participantes) {
            table.addRow(pt);
        }
        currentPage--;
        verifyEnabled();
        controlLabels();
    }

    public void nextPag() {
        table.clearTable();
        participantes = PersistenceDao.getParticipanteImpl().listar((currentPage * rowsPerPage), rowsPerPage);
        for (Participante pt : participantes) {
            table.addRow(pt);
        }
        currentPage++;
        verifyEnabled();
        bPrimeiro.setEnabled(true);
        bAnterior.setEnabled(true);
        controlLabels();
    }

    public void lastPage() {
        table.clearTable();
        participantes = PersistenceDao.getParticipanteImpl().listar((totalPage * rowsPerPage) - rowsPerPage, rowsPerPage);
        for (Participante pt : participantes) {
            table.addRow(pt);
        }
        currentPage = totalPage;
        verifyEnabled();
        controlLabels();
    }

    public void firstPage() {
        table.clearTable();
        participantes = PersistenceDao.getParticipanteImpl().listar(0, rowsPerPage);
        for (Participante pt : participantes) {
            table.addRow(pt);
        }
        currentPage = 1;
        verifyEnabled();
        controlLabels();
    }

    public void defaultConfig() {
        table.clearTable();
        currentPage = 1;
        rowsPerPage = Integer.valueOf(comboBox.getSelectedItem().toString());
        List<Participante> cat = PersistenceDao.getParticipanteImpl().listar(0, rowsPerPage);
        for (Participante categoria : cat) {
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
        totalRegistros = PersistenceDao.getParticipanteImpl().listar().size();
        labelTotalRegistros.setText(totalRegistros.toString());
        labelRegistros.setText(String.valueOf(participantes.size()));
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
