/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.control.persistence;

import br.com.model.dao.CategoriaImpl;
import br.com.model.dao.ParticipanteImpl;

/**
 *
 * @author ACER
 */
public class PersistenceDao {

    private static CategoriaImpl categoriaImpl = new CategoriaImpl();
    private static ParticipanteImpl participanteImpl = new ParticipanteImpl();

    public static CategoriaImpl getCategoriaImpl() {
        return categoriaImpl;
    }

    public static ParticipanteImpl getParticipanteImpl() {
        return participanteImpl;
    }
}
