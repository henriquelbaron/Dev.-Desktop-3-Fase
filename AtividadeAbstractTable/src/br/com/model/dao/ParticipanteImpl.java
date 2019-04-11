/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model.dao;

import br.com.model.domain.Categoria;
import br.com.model.domain.Participante;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author ACER
 */
public class ParticipanteImpl implements Dao<Participante> {

    EntityManagerFactory emf;
    EntityManager em;

    public ParticipanteImpl() {
        emf = Persistence.createEntityManagerFactory("abstracttablemodel");
        em = emf.createEntityManager();
    }

    @Override
    public void save(Participante obj) {
        em.getTransaction().begin();
        em.persist(obj);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void update(Participante obj) {
        em.getTransaction().begin();
        em.merge(obj);
        em.getTransaction().commit();
            em.close();
    }

    @Override
    public Participante find(Integer id) {
        return em.find(Participante.class, id);
    }

    @Override
    public void remove(int id) {
        em.getTransaction().begin();
        Participante c = find(id);
        em.remove(c);
        em.getTransaction().commit();
            em.close();
    }

    @Override
    public List<Participante> listar() {
        em.getTransaction().begin();
        Query consulta = em.createQuery("Select p FROM Participante as p where p.ativo = false");
        List<Participante> lista = consulta.getResultList();
        em.getTransaction().commit();
            em.close();
        return lista;
    }

    @Override
    public List<Participante> listar(int rowMin, int rowMax) {
        Query query = em.createQuery("Select p FROM Participante as p where p.ativo = false");
        //representa a primeira linha no conjunto de dados retornado
        query.setFirstResult(rowMin);
        //numero de rows
        query.setMaxResults(rowMax);
        return query.getResultList();
    }

}
