package br.com.faculdade.models;

import java.io.Serializable;

/**
 * Created by cardoso on 25/04/16.
 */
public class Disciplina implements Serializable{

    private int id;
    private String nome;
    private int periodo;
    private float primeiraProva;
    private float segundaProva;
    private float primeiroTrabalho;
    private float segundoTrabalho;

    @Override
    public String toString(){
        return nome +  " - MEDIA: " + media();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPeriodo() {
        return periodo;
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }

    public float getPrimeiraProva() {
        return primeiraProva;
    }

    public void setPrimeiraProva(float primeiraProva) {
        this.primeiraProva = primeiraProva;
    }

    public float getSegundaProva() {
        return segundaProva;
    }

    public void setSegundaProva(float segundaProva) {
        this.segundaProva = segundaProva;
    }

    public float getPrimeiroTrabalho() {
        return primeiroTrabalho;
    }

    public void setPrimeiroTrabalho(float primeiroTrabalho) {
        this.primeiroTrabalho = primeiroTrabalho;
    }

    public float getSegundoTrabalho() {
        return segundoTrabalho;
    }

    public void setSegundoTrabalho(float segundoTrabalho) {
        this.segundoTrabalho = segundoTrabalho;
    }

    public String media()
    {
        return String.valueOf(((this.primeiraProva + this.segundaProva)/2) + this.primeiroTrabalho + this.segundoTrabalho);
    }
}
