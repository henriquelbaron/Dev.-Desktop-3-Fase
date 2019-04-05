/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model.dao;

import br.com.model.domain.Categoria;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author ACER
 */
public class CategoriaImpl implements Dao<Categoria> {

    EntityManagerFactory emf;
    EntityManager em;

    public CategoriaImpl() {
        emf = Persistence.createEntityManagerFactory("abstracttablemodel");
        em = emf.createEntityManager();
    }

    @Override
    public void save(Categoria obj) {
        em.getTransaction().begin();
        em.persist(obj);
        em.getTransaction().commit();
    }

    @Override
    public void update(Categoria obj) {
        em.getTransaction().begin();
        em.merge(obj);
        em.getTransaction().commit();
    }

    @Override
    public Categoria find(Integer id) {
        return em.find(Categoria.class, id);
    }

    @Override
    public void remove(int id) {
        em.getTransaction().begin();
        Categoria c = find(id);
        em.remove(c);
        em.getTransaction().commit();
    }

    @Override
    public List<Categoria> listar() {
        em.getTransaction().begin();
        Query consulta = em.createQuery("Select cat FROM Categoria as cat where cat.ativo = false");
        List<Categoria> lista = consulta.getResultList();
        em.getTransaction().commit();
        return lista;
    }

    @Override
    public List<Categoria> listar(int rowMin, int rowMax) {
        Query query = em.createQuery("Select cat FROM Categoria as cat where cat.ativo = false");
        //representa a primeira linha no conjunto de dados retornado
        query.setFirstResult(rowMin);
        //numero de rows
        query.setMaxResults(rowMax);
        return query.getResultList();
    }

}
