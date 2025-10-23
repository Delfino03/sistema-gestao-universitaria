package br.edu.senac.gestao.model;

import java.time.LocalDateTime;

/**
 * Classe abstrata que representa uma pessoa no sistema
 * Serve como base para PessoaFisica e PessoaJuridica
 */
public abstract class Pessoa {
    
    private String id;
    private String email;
    private String telefone;
    private LocalDateTime dataCadastro;
    
    /**
     * Construtor padrão
     */
    public Pessoa() {
        this.dataCadastro = LocalDateTime.now();
    }
    
    /**
     * Construtor com parâmetros
     */
    public Pessoa(String email, String telefone) {
        this();
        this.email = email;
        this.telefone = telefone;
    }
    
    // Getters e Setters
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getTelefone() {
        return telefone;
    }
    
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }
    
    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
    
    /**
     * Método abstrato para validar dados da pessoa
     * Deve ser implementado pelas classes filhas
     */
    public abstract boolean validarDados();
    
    /**
     * Método para cadastrar a pessoa no sistema
     */
    public void cadastrar() {
        if (validarDados()) {
            // Lógica de cadastro
            System.out.println("Pessoa cadastrada com sucesso!");
        } else {
            System.out.println("Erro: Dados inválidos!");
        }
    }
    
    /**
     * Método para atualizar dados da pessoa
     */
    public void atualizar() {
        if (validarDados()) {
            // Lógica de atualização
            System.out.println("Dados atualizados com sucesso!");
        } else {
            System.out.println("Erro: Dados inválidos!");
        }
    }
    
    /**
     * Método para consultar pessoa
     */
    public Pessoa consultar() {
        // Lógica de consulta
        return this;
    }
    
    @Override
    public String toString() {
        return "Pessoa{" +
                "id='" + id + '\'' +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                ", dataCadastro=" + dataCadastro +
                '}';
    }
}
