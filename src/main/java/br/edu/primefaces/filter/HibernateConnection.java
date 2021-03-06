/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.primefaces.filter;

import java.io.IOException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 *
 * @author renato
 */
public class HibernateConnection implements Filter {

    private EntityManagerFactory factory;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

        this.factory = Persistence.createEntityManagerFactory("crud");

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        //Chegada
        EntityManager manager = this.factory.createEntityManager();
        request.setAttribute("EntityManager", manager);
        manager.getTransaction().begin();
        //Chegada

        //Faces Servlet
        chain.doFilter(request, response);
        //Faces Servlet

        //Saida
        try {
            manager.getTransaction().commit();
        } catch (Exception ex) {

            manager.getTransaction().rollback();
        } finally {
            manager.close();
        }
        //Saida
    }

    @Override
    public void destroy() {
        this.factory.close();
    }

}
