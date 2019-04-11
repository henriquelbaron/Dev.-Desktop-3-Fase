/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.view;

import br.com.control.persistence.PersistenceDao;
import br.com.model.domain.Participante;

/**
 *
 * @author ACER
 */
public class teste {

    public static void main(String[] args) {
        Participante p = PersistenceDao.getParticipanteImpl().find(8);
        System.out.println(p);
    }
}
