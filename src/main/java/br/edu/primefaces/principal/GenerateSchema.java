/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.primefaces.principal;


import br.edu.primefaces.DAO.PessoaRepository;
import br.edu.primefaces.modelo.Pessoa;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author renato
 */
public class GenerateSchema {

    public static void main(String[] args) throws Exception {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA_PU");
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();

        Pessoa p = new Pessoa();
        p.setSexo(Pessoa.Sexo.Masculino);
        p.setIdade(Integer.SIZE);
        p.setNome("Primefaces PessoaRepository!!!!!");
        PessoaRepository repository = new PessoaRepository();
        repository.salvar(p);
        
            System.out.println("==" + p.getSexo() + "Pessoa salvo:" + p.getNome());
            
        }

    }

