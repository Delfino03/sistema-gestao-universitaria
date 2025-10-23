package br.edu.senac.gestao.model;

import java.time.LocalDate;

/**
 * Classe que representa uma Pessoa Física no sistema
 * Herda de Pessoa e adiciona atributos específicos
 */
public class PessoaFisica extends Pessoa {
    
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    
    /**
     * Construtor padrão
     */
    public PessoaFisica() {
        super();
    }
    
    /**
     * Construtor com parâmetros
     */
    public PessoaFisica(String nome, String cpf, LocalDate dataNascimento, 
                        String email, String telefone) {
        super(email, telefone);
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }
    
    // Getters e Setters
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getCpf() {
        return cpf;
    }
    
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    public LocalDate getDataNascimento() {
        return dataNascimento;
    }
    
    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    
    /**
     * Valida o CPF da pessoa física
     */
    public boolean validarCPF() {
        if (cpf == null || cpf.isEmpty()) {
            return false;
        }
        
        // Remove caracteres não numéricos
        String cpfNumeros = cpf.replaceAll("[^0-9]", "");
        
        // Verifica se tem 11 dígitos
        if (cpfNumeros.length() != 11) {
            return false;
        }
        
        // Verifica se todos os dígitos são iguais
        if (cpfNumeros.matches("(\\d)\\1{10}")) {
            return false;
        }
        
        // Validação dos dígitos verificadores
        try {
            // Primeiro dígito verificador
            int soma = 0;
            for (int i = 0; i < 9; i++) {
                soma += Character.getNumericValue(cpfNumeros.charAt(i)) * (10 - i);
            }
            int digito1 = 11 - (soma % 11);
            digito1 = (digito1 >= 10) ? 0 : digito1;
            
            if (digito1 != Character.getNumericValue(cpfNumeros.charAt(9))) {
                return false;
            }
            
            // Segundo dígito verificador
            soma = 0;
            for (int i = 0; i < 10; i++) {
                soma += Character.getNumericValue(cpfNumeros.charAt(i)) * (11 - i);
            }
            int digito2 = 11 - (soma % 11);
            digito2 = (digito2 >= 10) ? 0 : digito2;
            
            return digito2 == Character.getNumericValue(cpfNumeros.charAt(10));
            
        } catch (Exception e) {
            return false;
        }
    }
    
    /**
     * Implementação do método abstrato validarDados
     */
    @Override
    public boolean validarDados() {
        return nome != null && !nome.isEmpty() &&
               validarCPF() &&
               dataNascimento != null &&
               getEmail() != null && !getEmail().isEmpty() &&
               getTelefone() != null && !getTelefone().isEmpty();
    }
    
    @Override
    public String toString() {
        return "PessoaFisica{" +
                "id='" + getId() + '\'' +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", email='" + getEmail() + '\'' +
                ", telefone='" + getTelefone() + '\'' +
                '}';
    }
}
