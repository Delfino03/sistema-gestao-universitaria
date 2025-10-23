package br.edu.senac.gestao;

import br.edu.senac.gestao.model.*;
import java.time.LocalDate;

/**
 * Classe principal para testar o Sistema de Gestão Universitária
 */
public class Main {
    
    public static void main(String[] args) {
        System.out.println("=== Sistema de Gestão Universitária ===");
        System.out.println("Grupo 48 - Senac Projeto Integrador\n");
        
        // Teste 1: Cadastrar Pessoa Física
        System.out.println("--- Teste 1: Cadastro de Pessoa Física ---");
        PessoaFisica pf1 = new PessoaFisica(
            "João da Silva Santos",
            "123.456.789-00",
            LocalDate.of(1990, 5, 15),
            "joao.silva@email.com",
            "(81) 98765-4321"
        );
        pf1.setId("PF00001");
        System.out.println(pf1);
        System.out.println("CPF válido? " + pf1.validarCPF());
        System.out.println("Dados válidos? " + pf1.validarDados());
        pf1.cadastrar();
        System.out.println();
        
        // Teste 2: Cadastrar Pessoa Jurídica
        System.out.println("--- Teste 2: Cadastro de Pessoa Jurídica ---");
        PessoaJuridica pj1 = new PessoaJuridica(
            "ACME Tecnologia e Sistemas LTDA",
            "ACME Tech",
            "12.345.678/0001-90",
            "contato@acmetech.com",
            "(81) 3333-4444"
        );
        pj1.setId("PJ00001");
        System.out.println(pj1);
        System.out.println("CNPJ válido? " + pj1.validarCNPJ());
        System.out.println("Dados válidos? " + pj1.validarDados());
        pj1.cadastrar();
        System.out.println();
        
        // Teste 3: Cadastrar Professor
        System.out.println("--- Teste 3: Cadastro de Professor ---");
        Professor prof1 = new Professor(
            "Maria Oliveira Santos",
            "987.654.321-00",
            LocalDate.of(1985, 8, 20),
            "maria.oliveira@universidade.edu.br",
            "(81) 99876-5432",
            "Ciências da Computação",
            "Doutorado",
            "Dedicação Exclusiva",
            LocalDate.of(2020, 3, 1)
        );
        prof1.setId("PF00002");
        prof1.gerarMatriculaFuncional();
        System.out.println(prof1);
        System.out.println("Dados válidos? " + prof1.validarDados());
        prof1.cadastrar();
        prof1.lecionar("Programação Orientada a Objetos");
        System.out.println();
        
        // Teste 4: Cadastrar Aluno
        System.out.println("--- Teste 4: Cadastro de Aluno ---");
        Aluno aluno1 = new Aluno(
            "Pedro Costa Lima",
            "456.789.123-00",
            LocalDate.of(2002, 11, 10),
            "pedro.lima@email.com",
            "(81) 98888-7777",
            "Análise e Desenvolvimento de Sistemas",
            "Noturno",
            LocalDate.of(2024, 2, 5),
            "Vestibular"
        );
        aluno1.setId("PF00003");
        aluno1.gerarMatriculaAcademica();
        System.out.println(aluno1);
        System.out.println("Dados válidos? " + aluno1.validarDados());
        aluno1.cadastrar();
        aluno1.matricular("Banco de Dados");
        System.out.println();
        
        // Teste 5: Cadastrar Fornecedor
        System.out.println("--- Teste 5: Cadastro de Fornecedor ---");
        Fornecedor forn1 = new Fornecedor(
            "Papelaria Moderna LTDA",
            "Papel & Cia",
            "98.765.432/0001-10",
            "vendas@papelmoderna.com.br",
            "(81) 3222-1111",
            "Papelaria e Material de Escritório",
            "Papel A4, canetas, cadernos, pastas, materiais escolares diversos",
            "Carlos Alberto Souza",
            "30/60 dias"
        );
        forn1.setId("PJ00002");
        forn1.gerarCodigo();
        System.out.println(forn1);
        System.out.println("Dados válidos? " + forn1.validarDados());
        forn1.cadastrar();
        forn1.fornecer("Papel A4", 500);
        System.out.println();
        
        // Teste 6: Operações com Aluno
        System.out.println("--- Teste 6: Operações com Aluno ---");
        System.out.println("Status inicial: " + aluno1.getStatus());
        aluno1.trancarMatricula();
        System.out.println("Status após trancamento: " + aluno1.getStatus());
        aluno1.matricular("Estrutura de Dados"); // Não deve permitir
        aluno1.reativarMatricula();
        System.out.println("Status após reativação: " + aluno1.getStatus());
        aluno1.matricular("Estrutura de Dados"); // Agora deve permitir
        System.out.println();
        
        // Teste 7: Atualização de dados
        System.out.println("--- Teste 7: Atualização de Dados ---");
        System.out.println("E-mail anterior de João: " + pf1.getEmail());
        pf1.setEmail("joao.silva.novo@email.com");
        System.out.println("E-mail atualizado de João: " + pf1.getEmail());
        pf1.atualizar();
        System.out.println();
        
        System.out.println("=== Testes Concluídos ===");
    }
}
