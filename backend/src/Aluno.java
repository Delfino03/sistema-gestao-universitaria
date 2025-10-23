package br.edu.senac.gestao.model;

import java.time.LocalDate;

/**
 * Classe que representa um Aluno no sistema
 * Especializa PessoaFisica com atributos acadêmicos
 */
public class Aluno extends PessoaFisica {
    
    private String matriculaAcademica;
    private String curso;
    private String turno;
    private LocalDate dataIngresso;
    private String formaIngresso;
    private String status;
    
    /**
     * Construtor padrão
     */
    public Aluno() {
        super();
        this.status = "Ativo";
    }
    
    /**
     * Construtor com parâmetros básicos de PessoaFisica
     */
    public Aluno(String nome, String cpf, LocalDate dataNascimento,
                 String email, String telefone) {
        super(nome, cpf, dataNascimento, email, telefone);
        this.status = "Ativo";
    }
    
    /**
     * Construtor completo com dados do aluno
     */
    public Aluno(String nome, String cpf, LocalDate dataNascimento,
                 String email, String telefone, String curso, String turno,
                 LocalDate dataIngresso, String formaIngresso) {
        super(nome, cpf, dataNascimento, email, telefone);
        this.curso = curso;
        this.turno = turno;
        this.dataIngresso = dataIngresso;
        this.formaIngresso = formaIngresso;
        this.status = "Ativo";
    }
    
    // Getters e Setters
    public String getMatriculaAcademica() {
        return matriculaAcademica;
    }
    
    public void setMatriculaAcademica(String matriculaAcademica) {
        this.matriculaAcademica = matriculaAcademica;
    }
    
    public String getCurso() {
        return curso;
    }
    
    public void setCurso(String curso) {
        this.curso = curso;
    }
    
    public String getTurno() {
        return turno;
    }
    
    public void setTurno(String turno) {
        this.turno = turno;
    }
    
    public LocalDate getDataIngresso() {
        return dataIngresso;
    }
    
    public void setDataIngresso(LocalDate dataIngresso) {
        this.dataIngresso = dataIngresso;
    }
    
    public String getFormaIngresso() {
        return formaIngresso;
    }
    
    public void setFormaIngresso(String formaIngresso) {
        this.formaIngresso = formaIngresso;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    /**
     * Gera matrícula acadêmica automaticamente
     */
    public void gerarMatriculaAcademica() {
        String ano = String.valueOf(LocalDate.now().getYear());
        String random = String.format("%06d", (int)(Math.random() * 1000000));
        this.matriculaAcademica = ano + random;
    }
    
    /**
     * Método para matricular aluno em disciplina
     */
    public void matricular(String disciplina) {
        if ("Ativo".equals(this.status)) {
            System.out.println(getNome() + " foi matriculado em " + disciplina);
        } else {
            System.out.println("Aluno não está com status ativo. Status atual: " + this.status);
        }
    }
    
    /**
     * Método para trancar matrícula
     */
    public void trancarMatricula() {
        this.status = "Trancado";
        System.out.println("Matrícula de " + getNome() + " foi trancada.");
    }
    
    /**
     * Método para reativar matrícula
     */
    public void reativarMatricula() {
        this.status = "Ativo";
        System.out.println("Matrícula de " + getNome() + " foi reativada.");
    }
    
    /**
     * Valida dados específicos do aluno
     */
    public boolean validarDadosAluno() {
        return curso != null && !curso.isEmpty() &&
               turno != null && !turno.isEmpty() &&
               dataIngresso != null &&
               formaIngresso != null && !formaIngresso.isEmpty() &&
               status != null && !status.isEmpty();
    }
    
    /**
     * Sobrescreve validarDados para incluir validações do aluno
     */
    @Override
    public boolean validarDados() {
        return super.validarDados() && validarDadosAluno();
    }
    
    @Override
    public String toString() {
        return "Aluno{" +
                "id='" + getId() + '\'' +
                ", nome='" + getNome() + '\'' +
                ", cpf='" + getCpf() + '\'' +
                ", matriculaAcademica='" + matriculaAcademica + '\'' +
                ", curso='" + curso + '\'' +
                ", turno='" + turno + '\'' +
                ", dataIngresso=" + dataIngresso +
                ", formaIngresso='" + formaIngresso + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
