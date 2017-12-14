/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.primefaces.modelo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 *
 * @author renato
 */
@Entity
@Table(name="tb_pessoa")
@NamedQuery(name= "Pessoa.findALL" , query="SELECT p FROM Pessoa p")
public class Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;

    public static enum Sexo {

        Masculino, Feminino
    }
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String nome;
    
@Enumerated(EnumType.STRING)
    private Sexo sexo;

    @Min(15)
    @Max(130)
    private Integer idade;

    public Pessoa() {
    }

    public Pessoa(Long id, String nome, Sexo sexo, Integer idade) {
        this.id = id;
        this.nome = nome;
        this.sexo = sexo;
        this.idade = idade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    
    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

}
