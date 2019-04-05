package br.com.model.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Participante.class)
public abstract class Participante_ {

	public static volatile SingularAttribute<Participante, String> telefone;
	public static volatile SingularAttribute<Participante, Boolean> ativo;
	public static volatile ListAttribute<Participante, Categoria> categorias;
	public static volatile SingularAttribute<Participante, String> cpf;
	public static volatile SingularAttribute<Participante, String> nome;
	public static volatile SingularAttribute<Participante, Integer> id;
	public static volatile SingularAttribute<Participante, String> email;

	public static final String TELEFONE = "telefone";
	public static final String ATIVO = "ativo";
	public static final String CATEGORIAS = "categorias";
	public static final String CPF = "cpf";
	public static final String NOME = "nome";
	public static final String ID = "id";
	public static final String EMAIL = "email";

}

