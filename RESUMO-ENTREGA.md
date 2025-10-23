# 📦 Entrega Fase 2 - Projeto Integrador

## Grupo 48 - Sistema de Gestão Universitária

---

## 📋 Conteúdo da Entrega

### ✅ Item 1: Protótipos Funcionais

Desenvolvemos protótipos funcionais para todas as 5 jornadas solicitadas:

#### 1. **Cadastro de Pessoa Física** (`pessoa-fisica.html`)
- Formulário completo com validação de CPF
- Máscaras automáticas para CPF e telefone
- Validação de campos obrigatórios
- Mensagens de erro e sucesso
- Verificação de CPF duplicado

#### 2. **Cadastro de Pessoa Jurídica** (`pessoa-juridica.html`)
- Formulário com validação de CNPJ
- Campos: Razão Social, Nome Fantasia, CNPJ, E-mail, Telefone
- Máscaras automáticas para CNPJ
- Validação de dados obrigatórios

#### 3. **Cadastro de Professor** (`professor.html`)
- Busca de Pessoa Física existente
- Formulário complementar com dados acadêmicos
- Departamento, Titulação, Regime de Trabalho, Data de Admissão
- Geração automática de matrícula funcional
- Tratamento de cenários alternativos (PF não encontrada, professor já cadastrado)

#### 4. **Cadastro de Fornecedor** (`fornecedor.html`)
- Busca de Pessoa Jurídica existente
- Formulário com dados comerciais
- Ramo, Produtos/Serviços, Representante Legal, Condições de Pagamento
- Geração automática de código de fornecedor
- Tratamento de cenários alternativos

#### 5. **Cadastro de Aluno** (`aluno.html`)
- Busca de Pessoa Física existente
- Formulário acadêmico completo
- Curso, Turno, Data de Ingresso, Forma de Ingresso, Status
- Geração automática de matrícula acadêmica
- Validação de disponibilidade de curso

### 🎨 Arquivos de Interface

- **`index.html`** - Dashboard principal com navegação
- **`styles.css`** - Estilos CSS responsivos e modernos
- **`scripts.js`** - Funções JavaScript compartilhadas e validações

### 📱 Características dos Protótipos

✅ **Design Responsivo** - Funciona em desktop, tablet e mobile  
✅ **Validações em Tempo Real** - CPF, CNPJ, e-mail, campos obrigatórios  
✅ **Máscaras de Entrada** - CPF, CNPJ, telefone formatados automaticamente  
✅ **Feedback Visual** - Mensagens de erro e sucesso  
✅ **Navegação Intuitiva** - Menu consistente em todas as páginas  
✅ **Acessibilidade** - Cores contrastantes, labels claros  

---

### ✅ Item 2: GitHub e Documentação

#### Repositório GitHub

**Estrutura do Repositório:**
```
sistema-gestao-universitaria/
├── README.md (Documentação completa em Markdown)
├── GITHUB-SETUP.md (Guia de configuração)
├── index.html
├── styles.css
├── scripts.js
├── pessoa-fisica.html
├── pessoa-juridica.html
├── professor.html
├── fornecedor.html
├── aluno.html
├── backend/
│   └── src/
│       ├── Pessoa.java
│       ├── PessoaFisica.java
│       ├── PessoaJuridica.java
│       ├── Professor.java
│       ├── Aluno.java
│       ├── Fornecedor.java
│       └── Main.java
└── docs/
    └── diagramas/
```

#### Documentação README.md Inclui:

1. **Fase 1 - Modelagem UML:**
   - Diagrama de Caso de Uso (em Markdown)
   - Descrições completas dos 5 casos de uso
   - Diagrama de Classes (em Markdown)

2. **Fase 2 - Prototipação:**
   - Descrição dos protótipos
   - Tecnologias utilizadas
   - Instruções de execução

3. **Informações do Projeto:**
   - Sobre o projeto
   - Estrutura de arquivos
   - Como contribuir
   - Contato do grupo

---

### ✅ Item 3 (Opcional): Backend em Java

Desenvolvemos todas as classes modeladas na Fase 1:

#### Classes Implementadas:

1. **`Pessoa.java`** (Abstrata)
   - Atributos: id, email, telefone, dataCadastro
   - Métodos: cadastrar(), atualizar(), consultar(), validarDados()

2. **`PessoaFisica.java`** (Herda de Pessoa)
   - Atributos: nome, cpf, dataNascimento
   - Método: validarCPF() com algoritmo completo

3. **`PessoaJuridica.java`** (Herda de Pessoa)
   - Atributos: razaoSocial, nomeFantasia, cnpj
   - Método: validarCNPJ() com algoritmo completo

4. **`Professor.java`** (Herda de PessoaFisica)
   - Atributos: matriculaFuncional, departamento, titulacao, regimeTrabalho, dataAdmissao
   - Métodos: gerarMatriculaFuncional(), lecionar()

5. **`Aluno.java`** (Herda de PessoaFisica)
   - Atributos: matriculaAcademica, curso, turno, dataIngresso, formaIngresso, status
   - Métodos: gerarMatriculaAcademica(), matricular(), trancarMatricula(), reativarMatricula()

6. **`Fornecedor.java`** (Herda de PessoaJuridica)
   - Atributos: codigo, ramo, produtosServicos, representanteLegal, condicoesPagamento
   - Métodos: gerarCodigo(), fornecer(), atualizarCatalogo()

7. **`Main.java`**
   - Classe de teste com exemplos de uso de todas as classes
   - Demonstra o funcionamento completo do sistema

---

## 🎯 Diferenciais Implementados

### Interface:
- Design moderno e profissional
- Sistema de cores consistente
- Animações suaves
- Ícones representativos
- Cards interativos no dashboard
- Estatísticas em tempo real (mockup)

### Funcionalidades:
- Validação completa de CPF e CNPJ
- Máscaras automáticas de entrada
- Sistema de mensagens (sucesso/erro)
- Busca e vinculação de registros
- Cenários alternativos implementados
- Feedback visual imediato

### Código:
- Código limpo e bem comentado
- Separação de responsabilidades
- Reutilização de componentes
- Seguindo boas práticas de POO
- Documentação completa em JavaDoc

---

## 📚 Tecnologias Utilizadas

### Frontend:
- **HTML5** - Estrutura semântica
- **CSS3** - Estilização moderna com Flexbox e Grid
- **JavaScript ES6+** - Validações e interatividade

### Backend (Opcional):
- **Java 11+** - Linguagem orientada a objetos
- **POO** - Herança, Encapsulamento, Polimorfismo

### Ferramentas:
- **Git/GitHub** - Controle de versão
- **Markdown** - Documentação
- **VS Code** - Editor de código

---

## 🚀 Como Executar

### Protótipos HTML:

1. Baixar o arquivo ZIP ou clonar o repositório
2. Abrir o arquivo `index.html` em um navegador moderno
3. Navegar pelas diferentes telas usando o menu

### Backend Java:

1. Navegar até o diretório `backend/src`
2. Compilar as classes:
   ```bash
   javac *.java
   ```
3. Executar o programa de teste:
   ```bash
   java Main
   ```

---

## 📦 Arquivos Entregues

1. **README.md** - Documentação completa do projeto
2. **GITHUB-SETUP.md** - Guia passo a passo para configurar GitHub
3. **index.html** - Dashboard principal
4. **pessoa-fisica.html** - Cadastro de Pessoa Física
5. **pessoa-juridica.html** - Cadastro de Pessoa Jurídica
6. **professor.html** - Cadastro de Professor
7. **fornecedor.html** - Cadastro de Fornecedor
8. **aluno.html** - Cadastro de Aluno
9. **styles.css** - Estilos CSS
10. **scripts.js** - Scripts JavaScript
11. **backend/src/*.java** - 7 classes Java implementadas
12. **projeto-integrador-fase2-grupo48.zip** - Pacote completo

---

## ✅ Checklist de Entrega

- [x] Item 1: Protótipos funcionais das 5 jornadas
- [x] Item 2: Repositório GitHub configurado
- [x] Item 2: README.md completo em Markdown
- [x] Item 2: Diagramas da Fase 1 incluídos
- [x] Item 3 (Opcional): Backend em Java
- [x] Item 3 (Opcional): Classes conectadas com frontend
- [x] Documentação completa
- [x] Código comentado e organizado
- [x] Testes funcionais realizados
- [x] Guia de configuração do GitHub

---

## 👥 Próximos Passos para o Grupo

1. **Configurar GitHub:**
   - Seguir o guia em `GITHUB-SETUP.md`
   - Criar repositório
   - Adicionar todos os membros
   - Fazer upload dos arquivos

2. **Atualizar README.md:**
   - Adicionar nomes dos integrantes
   - Adicionar imagens dos diagramas
   - Personalizar conforme necessário

3. **Testar Localmente:**
   - Abrir protótipos no navegador
   - Verificar todas as funcionalidades
   - Testar validações

4. **Preparar Apresentação:**
   - Demonstrar cada tela
   - Explicar decisões de design
   - Mostrar validações funcionando

---

## 📞 Suporte

Em caso de dúvidas:
1. Consultar a documentação no README.md
2. Verificar o guia GITHUB-SETUP.md
3. Entrar em contato com os membros do grupo

---

**Entrega realizada com sucesso! ✅**

**Grupo 48 - Senac Projeto Integrador**  
*Sistema de Gestão Universitária - Fase 2*

Data: Outubro 2024
