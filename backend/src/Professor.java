package br.edu.senac.gestao.model;

import java.time.LocalDate;

/**
 * Classe que representa um Professor no sistema
 * Especializa PessoaFisica com atributos acadêmicos
 */
public class Professor extends PessoaFisica {
    
    private String matriculaFuncional;
    private String departamento;
    private String titulacao;
    private String regimeTrabalho;
    private LocalDate dataAdmissao;
    
    /**
     * Construtor padrão
     */
    public Professor() {
        super();
    }
    
    /**
     * Construtor com parâmetros básicos de PessoaFisica
     */
    public Professor(String nome, String cpf, LocalDate dataNascimento,
                     String email, String telefone) {
        super(nome, cpf, dataNascimento, email, telefone);
    }
    
    /**
     * Construtor completo com dados do professor
     */
    public Professor(String nome, String cpf, LocalDate dataNascimento,
                     String email, String telefone, String departamento,
                     String titulacao, String regimeTrabalho, LocalDate dataAdmissao) {
        super(nome, cpf, dataNascimento, email, telefone);
        this.departamento = departamento;
        this.titulacao = titulacao;
        this.regimeTrabalho = regimeTrabalho;
        this.dataAdmissao = dataAdmissao;
    }
    
    // Getters e Setters
    public String getMatriculaFuncional() {
        return matriculaFuncional;
    }
    
    public void setMatriculaFuncional(String matriculaFuncional) {
        this.matriculaFuncional = matriculaFuncional;
    }
    
    public String getDepartamento() {
        return departamento;
    }
    
    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
    
    public String getTitulacao() {
        return titulacao;
    }
    
    public void setTitulacao(String titulacao) {
        this.titulacao = titulacao;
    }
    
    public String getRegimeTrabalho() {
        return regimeTrabalho;
    }
    
    public void setRegimeTrabalho(String regimeTrabalho) {
        this.regimeTrabalho = regimeTrabalho;
    }
    
    public LocalDate getDataAdmissao() {
        return dataAdmissao;
    }
    
    public void setDataAdmissao(LocalDate dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }
    
    /**
     * Gera matrícula funcional automaticamente
     */
    public void gerarMatriculaFuncional() {
        String ano = String.valueOf(LocalDate.now().getYear());
        String random = String.format("%06d", (int)(Math.random() * 1000000));
        this.matriculaFuncional = "PROF" + ano + random;
    }
    
    /**
     * Método para lecionar (específico de Professor)
     */
    public void lecionar(String disciplina) {
        System.out.println(getNome() + " está lecionando " + disciplina);
    }
    
    /**
     * Valida dados específicos do professor
     */
    public boolean validarDadosProfessor() {
        return departamento != null && !departamento.isEmpty() &&
               titulacao != null && !titulacao.isEmpty() &&
               regimeTrabalho != null && !regimeTrabalho.isEmpty() &&
               dataAdmissao != null;
    }
    
    /**
     * Sobrescreve validarDados para incluir validações do professor
     */
    @Override
    public boolean validarDados() {
        return super.validarDados() && validarDadosProfessor();
    }
    
    @Override
    public String toString() {
        return "Professor{" +
                "id='" + getId() + '\'' +
                ", nome='" + getNome() + '\'' +
                ", cpf='" + getCpf() + '\'' +
                ", matriculaFuncional='" + matriculaFuncional + '\'' +
                ", departamento='" + departamento + '\'' +
                ", titulacao='" + titulacao + '\'' +
                ", regimeTrabalho='" + regimeTrabalho + '\'' +
                ", dataAdmissao=" + dataAdmissao +
                '}';
    }
}
