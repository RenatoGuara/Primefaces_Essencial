/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.primefaces.DAO;

import br.edu.primefaces.modelo.Pessoa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author renato
 */
public class PessoaRepository {

    /**
     * Método utilizado para obter o entity manager.
     *
     * @return
     */
    private EntityManager getEntityManager() {
        EntityManagerFactory factory = null;
        EntityManager manager = null;

        try {
            //Obtém o factory a partir da unidade de persistência.
            factory = Persistence.createEntityManagerFactory("JPA_PU");
            //Cria um entity manager.
            manager = factory.createEntityManager();

            //Fecha o factory para liberar os recursos utilizado.
        } finally {
            factory.close();
        }
        return manager;

    }

    /**
     * Método utilizado para salvar ou atualizar as informações de uma pessoa.
     *
     * @param pessoa
     * @return
     * @throws java.lang.Exception
     */
    public Pessoa salvar(Pessoa pessoa) throws Exception {
        EntityManager entityManager = getEntityManager();
        try {
            // Inicia uma transação com o banco de dados.
            entityManager.getTransaction().begin();
            System.out.println("Salvando a pessoa.");
            // Verifica se a pessoa ainda não está salva no banco de dados.
            if (pessoa.getId() == null) {
                //Salva os dados da pessoa.
                entityManager.persist(pessoa);
            } else {
                //Atualiza os dados da pessoa.
                pessoa = entityManager.merge(pessoa);
            }
            // Finaliza a transação.
            entityManager.getTransaction().commit();
        } finally {
            entityManager.close();
        }
        return pessoa;
    }
}
