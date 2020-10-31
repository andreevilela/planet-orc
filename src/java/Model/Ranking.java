/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Andre
 */
public class Ranking {
    
    public int id;
    public String nome;
    public int pontuacao;

    public Ranking()
    { }
    
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
    
    public int getPontuacao() {
        return pontuacao;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }
}
