package br.edu.senac.gestao.model;

/**
 * Classe que representa um Fornecedor no sistema
 * Especializa PessoaJuridica com atributos comerciais
 */
public class Fornecedor extends PessoaJuridica {
    
    private String codigo;
    private String ramo;
    private String produtosServicos;
    private String representanteLegal;
    private String condicoesPagamento;
    
    /**
     * Construtor padrão
     */
    public Fornecedor() {
        super();
    }
    
    /**
     * Construtor com parâmetros básicos de PessoaJuridica
     */
    public Fornecedor(String razaoSocial, String nomeFantasia, String cnpj,
                      String email, String telefone) {
        super(razaoSocial, nomeFantasia, cnpj, email, telefone);
    }
    
    /**
     * Construtor completo com dados do fornecedor
     */
    public Fornecedor(String razaoSocial, String nomeFantasia, String cnpj,
                      String email, String telefone, String ramo,
                      String produtosServicos, String representanteLegal,
                      String condicoesPagamento) {
        super(razaoSocial, nomeFantasia, cnpj, email, telefone);
        this.ramo = ramo;
        this.produtosServicos = produtosServicos;
        this.representanteLegal = representanteLegal;
        this.condicoesPagamento = condicoesPagamento;
    }
    
    // Getters e Setters
    public String getCodigo() {
        return codigo;
    }
    
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    public String getRamo() {
        return ramo;
    }
    
    public void setRamo(String ramo) {
        this.ramo = ramo;
    }
    
    public String getProdutosServicos() {
        return produtosServicos;
    }
    
    public void setProdutosServicos(String produtosServicos) {
        this.produtosServicos = produtosServicos;
    }
    
    public String getRepresentanteLegal() {
        return representanteLegal;
    }
    
    public void setRepresentanteLegal(String representanteLegal) {
        this.representanteLegal = representanteLegal;
    }
    
    public String getCondicoesPagamento() {
        return condicoesPagamento;
    }
    
    public void setCondicoesPagamento(String condicoesPagamento) {
        this.condicoesPagamento = condicoesPagamento;
    }
    
    /**
     * Gera código de fornecedor automaticamente
     */
    public void gerarCodigo() {
        String random = String.format("%06d", (int)(Math.random() * 1000000));
        this.codigo = "FORN" + random;
    }
    
    /**
     * Método para fornecer produtos/serviços
     */
    public void fornecer(String produto, int quantidade) {
        System.out.println(getRazaoSocial() + " está fornecendo " + 
                         quantidade + " unidade(s) de " + produto);
    }
    
    /**
     * Método para atualizar catálogo de produtos
     */
    public void atualizarCatalogo(String novosProdutos) {
        this.produtosServicos = novosProdutos;
        System.out.println("Catálogo de produtos atualizado para " + getRazaoSocial());
    }
    
    /**
     * Valida dados específicos do fornecedor
     */
    public boolean validarDadosFornecedor() {
        return ramo != null && !ramo.isEmpty() &&
               produtosServicos != null && !produtosServicos.isEmpty() &&
               representanteLegal != null && !representanteLegal.isEmpty() &&
               condicoesPagamento != null && !condicoesPagamento.isEmpty();
    }
    
    /**
     * Sobrescreve validarDados para incluir validações do fornecedor
     */
    @Override
    public boolean validarDados() {
        return super.validarDados() && validarDadosFornecedor();
    }
    
    @Override
    public String toString() {
        return "Fornecedor{" +
                "id='" + getId() + '\'' +
                ", codigo='" + codigo + '\'' +
                ", razaoSocial='" + getRazaoSocial() + '\'' +
                ", nomeFantasia='" + getNomeFantasia() + '\'' +
                ", cnpj='" + getCnpj() + '\'' +
                ", ramo='" + ramo + '\'' +
                ", produtosServicos='" + produtosServicos + '\'' +
                ", representanteLegal='" + representanteLegal + '\'' +
                ", condicoesPagamento='" + condicoesPagamento + '\'' +
                '}';
    }
}
