/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package transporte;

/**
 *
 * @author HP
 */
public class Cliente {
    private String nome;
    private int idade;
    private Endereco endereco;
    private Contacto contacto;

    public Cliente( String nome, int idade, Endereco endereco, Contacto contacto) {
        this.nome = nome;
        this.idade = idade;
        this.endereco = endereco;
        this.contacto = contacto;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Contacto getContacto() {
        return contacto;
    }

    public void setContacto(Contacto contacto) {
        this.contacto = contacto;
    }

    @Override
    public String toString() {
        return "Cliente{" + "nome=" + nome + ", idade=" + idade + ", endereco=" + endereco + ", contacto=" + contacto + '}';
    }

  
    
    
    
}
