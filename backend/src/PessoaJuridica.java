package br.edu.senac.gestao.model;

/**
 * Classe que representa uma Pessoa Jurídica no sistema
 * Herda de Pessoa e adiciona atributos específicos
 */
public class PessoaJuridica extends Pessoa {
    
    private String razaoSocial;
    private String nomeFantasia;
    private String cnpj;
    
    /**
     * Construtor padrão
     */
    public PessoaJuridica() {
        super();
    }
    
    /**
     * Construtor com parâmetros
     */
    public PessoaJuridica(String razaoSocial, String nomeFantasia, String cnpj,
                          String email, String telefone) {
        super(email, telefone);
        this.razaoSocial = razaoSocial;
        this.nomeFantasia = nomeFantasia;
        this.cnpj = cnpj;
    }
    
    // Getters e Setters
    public String getRazaoSocial() {
        return razaoSocial;
    }
    
    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }
    
    public String getNomeFantasia() {
        return nomeFantasia;
    }
    
    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }
    
    public String getCnpj() {
        return cnpj;
    }
    
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    
    /**
     * Valida o CNPJ da pessoa jurídica
     */
    public boolean validarCNPJ() {
        if (cnpj == null || cnpj.isEmpty()) {
            return false;
        }
        
        // Remove caracteres não numéricos
        String cnpjNumeros = cnpj.replaceAll("[^0-9]", "");
        
        // Verifica se tem 14 dígitos
        if (cnpjNumeros.length() != 14) {
            return false;
        }
        
        // Verifica se todos os dígitos são iguais
        if (cnpjNumeros.matches("(\\d)\\1{13}")) {
            return false;
        }
        
        try {
            // Validação do primeiro dígito verificador
            int soma = 0;
            int peso = 2;
            for (int i = 11; i >= 0; i--) {
                soma += Character.getNumericValue(cnpjNumeros.charAt(i)) * peso;
                peso++;
                if (peso == 10) peso = 2;
            }
            int digito1 = 11 - (soma % 11);
            digito1 = (digito1 >= 10) ? 0 : digito1;
            
            if (digito1 != Character.getNumericValue(cnpjNumeros.charAt(12))) {
                return false;
            }
            
            // Validação do segundo dígito verificador
            soma = 0;
            peso = 2;
            for (int i = 12; i >= 0; i--) {
                soma += Character.getNumericValue(cnpjNumeros.charAt(i)) * peso;
                peso++;
                if (peso == 10) peso = 2;
            }
            int digito2 = 11 - (soma % 11);
            digito2 = (digito2 >= 10) ? 0 : digito2;
            
            return digito2 == Character.getNumericValue(cnpjNumeros.charAt(13));
            
        } catch (Exception e) {
            return false;
        }
    }
    
    /**
     * Implementação do método abstrato validarDados
     */
    @Override
    public boolean validarDados() {
        return razaoSocial != null && !razaoSocial.isEmpty() &&
               validarCNPJ() &&
               getEmail() != null && !getEmail().isEmpty() &&
               getTelefone() != null && !getTelefone().isEmpty();
    }
    
    @Override
    public String toString() {
        return "PessoaJuridica{" +
                "id='" + getId() + '\'' +
                ", razaoSocial='" + razaoSocial + '\'' +
                ", nomeFantasia='" + nomeFantasia + '\'' +
                ", cnpj='" + cnpj + '\'' +
                ", email='" + getEmail() + '\'' +
                ", telefone='" + getTelefone() + '\'' +
                '}';
    }
}
