package br.com.model.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Categoria.class)
public abstract class Categoria_ {

	public static volatile SingularAttribute<Categoria, Boolean> ativo;
	public static volatile SingularAttribute<Categoria, String> nome;
	public static volatile SingularAttribute<Categoria, Integer> id;
	public static volatile ListAttribute<Categoria, Participante> participantes;

	public static final String ATIVO = "ativo";
	public static final String NOME = "nome";
	public static final String ID = "id";
	public static final String PARTICIPANTES = "participantes";

}

