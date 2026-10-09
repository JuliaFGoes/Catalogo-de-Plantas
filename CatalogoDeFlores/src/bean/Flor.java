/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bean;

/**
 *
 * @author Julia
 */
public class Flor {
    private int id;
    private String nome;
    private String nomeCientifico;
    private String tamanho;
    private double altura;
    private String cor;
    private String tipo;
    private String necessidadeSol;
    private String email;
    private String foto;
    
    public int getId(){
        return id;
    }
    public String getNome(){
        return nome;
    }
    public String getNomeCientifico(){
        return nomeCientifico;
    }
    public String getTamanho(){
        return tamanho;
    }
    public Double getAltura(){
        return altura;
    }
    public String getCor(){
        return cor;
    }
    public String getTipo(){
        return tipo;
    }
    public String getNecessidadeSol(){
        return necessidadeSol;
    }
    
    public void setId(int id){
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNomeCientifico(String nomeCientifico) {
        this.nomeCientifico = nomeCientifico;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setNecessidadeSol(String necessidadeSol) {
        this.necessidadeSol = necessidadeSol;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }   

    public String getFoto() {
     return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
    
}
