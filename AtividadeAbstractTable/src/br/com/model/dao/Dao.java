/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model.dao;

import java.util.List;

/**
 *
 * @author ACER
 */
public interface Dao<H> {

    public void save(H obj);

    public void update(H obj);

    public H find(Integer id);

    public void remove(int id);

    public List<H> listar();

    public List<H> listar(int rowMin, int rowMax);

}
