# Sistema de Gestão Universitária - Projeto Integrador

## 📋 Sobre o Projeto

Sistema para gestão de dados de uma universidade, com foco no cadastro e manutenção de diferentes tipos de pessoas que interagem com o ecossistema institucional.

**Grupo 48**

---

## 📑 Índice

- [Fase 1 - Modelagem UML](#fase-1---modelagem-uml)
  - [Diagrama de Caso de Uso](#diagrama-de-caso-de-uso)
  - [Descrições dos Casos de Uso](#descrições-dos-casos-de-uso)
  - [Diagrama de Classes](#diagrama-de-classes)
- [Fase 2 - Prototipação](#fase-2---prototipação)
  - [Protótipos de Interface](#protótipos-de-interface)
  - [Tecnologias Utilizadas](#tecnologias-utilizadas)
- [Como Executar o Projeto](#como-executar-o-projeto)

---

## 🎯 Fase 1 - Modelagem UML

### Diagrama de Caso de Uso

O sistema contempla cinco casos de uso principais, todos executados pelo ator **Administrador**:

```
┌─────────────────────────────────────────────────────┐
│        Sistema de Gestão Universitária              │
│                                                      │
│  ┌──────────────────────────────────┐              │
│  │  Cadastrar Pessoa Física         │              │
│  └──────────────────────────────────┘              │
│                    ↑                                 │
│  ┌──────────────────────────────────┐              │
│  │  Cadastrar Pessoa Jurídica       │              │
│  └──────────────────────────────────┘              │
│                    ↑                                 │
│                    │                                 │
│         [Administrador]                              │
│                    │                                 │
│                    ↓                                 │
│  ┌──────────────────────────────────┐              │
│  │  Cadastrar Professor             │              │
│  └──────────────────────────────────┘              │
│                    ↓                                 │
│  ┌──────────────────────────────────┐              │
│  │  Cadastrar Fornecedor            │              │
│  └──────────────────────────────────┘              │
│                    ↓                                 │
│  ┌──────────────────────────────────┐              │
│  │  Cadastrar Aluno                 │              │
│  └──────────────────────────────────┘              │
│                                                      │
└─────────────────────────────────────────────────────┘
```

**Relacionamentos:**
- Cadastrar Professor **extends** Cadastrar Pessoa Física
- Cadastrar Aluno **extends** Cadastrar Pessoa Física
- Cadastrar Fornecedor **extends** Cadastrar Pessoa Jurídica

---

### Descrições dos Casos de Uso

#### 1. Cadastrar Pessoa Física

**Descrição:** O administrador registra uma nova pessoa física no sistema.

**Pré-condições:**
- Administrador autenticado
- Sistema disponível e estável

**Cenário Principal:**
1. Selecionar "Cadastrar Pessoa Física"
2. Sistema abre formulário com campos: nome completo, CPF, data de nascimento, e-mail e telefone
3. Preencher campos obrigatórios
4. Sistema valida formatos e consistência dos dados
5. Salvar os dados
6. Sistema exibe confirmação de sucesso
7. Sistema gera e exibe ID único da pessoa

**Cenário Alternativo 1 - Dados Inválidos:**
1. Na validação (passo 4), sistema identifica erros
2. Campos problemáticos são destacados com mensagem explicativa
3. Administrador corrige e reenvia formulário
4. Validação é executada novamente

**Cenário Alternativo 2 - CPF já Cadastrado:**
1. Na validação (passo 4), sistema detecta CPF existente
2. Sistema exibe aviso "CPF já cadastrado"
3. Oferece opções: "Visualizar cadastro existente" ou "Cancelar"
4. Se escolher Visualizar, sistema mostra registro atual

**Pós-condições:**
- Nova pessoa física registrada com ID único
- Data/hora do cadastro gravadas
- Dados disponíveis para demais módulos

---

#### 2. Cadastrar Pessoa Jurídica

**Descrição:** Registra uma nova empresa/organização no sistema.

**Pré-condições:**
- Administrador autenticado
- Sistema disponível

**Cenário Principal:**
1. Selecionar "Cadastrar Pessoa Jurídica"
2. Sistema abre formulário com: razão social, nome fantasia, CNPJ, e-mail e telefone
3. Preencher campos obrigatórios
4. Sistema valida informações, especialmente CNPJ
5. Salvar dados
6. Sistema exibe confirmação de sucesso
7. Sistema gera e exibe ID único da PJ

**Cenário Alternativo 1 - CNPJ Inválido:**
1. Na validação (passo 4), CNPJ é considerado inválido
2. Campo é destacado com mensagem explicativa
3. Administrador corrige o CNPJ
4. Validação é refeita

**Cenário Alternativo 2 - Dados Incompletos:**
1. Na validação (passo 4), faltam campos obrigatórios
2. Sistema destaca campos a preencher
3. Administrador completa informações
4. Validação é executada novamente

**Pós-condições:**
- Nova pessoa jurídica cadastrada com ID único
- Registro de data/hora armazenado
- Dados prontos para uso por outros módulos

---

#### 3. Cadastrar Professor

**Descrição:** Vincula o papel de Professor a uma pessoa física já cadastrada.

**Pré-condições:**
- Administrador autenticado
- Sistema operante
- Pessoa física do professor já existe no sistema

**Cenário Principal:**
1. Selecionar "Cadastrar Professor"
2. Informar CPF ou ID da pessoa física
3. Sistema localiza e exibe dados da pessoa
4. Sistema abre formulário complementar: departamento, titulação, regime de trabalho, data de admissão
5. Preencher campos e enviar
6. Sistema valida informações
7. Vincular dados ao registro da PF
8. Gerar matrícula funcional do professor
9. Exibir confirmação de sucesso

**Cenário Alternativo 1 - Pessoa Física Não Encontrada:**
1. Na localização (passo 3), nenhum registro é encontrado
2. Sistema informa "Pessoa física não cadastrada"
3. Oferece: "Cadastrar nova PF" ou "Cancelar"
4. Se optar por cadastrar, inicia caso Cadastrar Pessoa Física
5. Concluído cadastro, retorna para finalizar vínculo de professor

**Cenário Alternativo 2 - Professor Já Cadastrado:**
1. Sistema detecta que PF já tem vínculo de professor
2. Exibe aviso e oferece: Visualizar, Atualizar ou Cancelar
3. Em Atualizar, permite editar dados e salva alterações

**Pós-condições:**
- Dados do professor vinculados à PF
- Matrícula funcional criada
- Registro de data/hora armazenado

---

#### 4. Cadastrar Fornecedor

**Descrição:** Registra empresa parceira como Fornecedor a partir de PJ existente.

**Pré-condições:**
- Administrador autenticado
- Pessoa jurídica do fornecedor já cadastrada
- Sistema operacional

**Cenário Principal:**
1. Selecionar "Cadastrar Fornecedor"
2. Informar CNPJ ou ID da PJ
3. Sistema localiza e exibe dados da empresa
4. Sistema abre formulário: ramo, produtos/serviços, representante legal, condições de pagamento
5. Preencher e enviar
6. Sistema valida informações
7. Vincular dados à PJ
8. Gerar código de fornecedor
9. Exibir confirmação

**Cenário Alternativo 1 - Pessoa Jurídica Não Encontrada:**
1. Na busca (passo 3), PJ não é localizada
2. Sistema informa "Pessoa jurídica não cadastrada"
3. Oferece: "Cadastrar nova PJ" ou "Cancelar"
4. Se cadastrar, inicia caso Cadastrar Pessoa Jurídica
5. Concluído, retorna para finalizar fornecedor

**Cenário Alternativo 2 - Fornecedor Já Cadastrado:**
1. Sistema encontra vínculo de fornecedor existente
2. Oferece: Visualizar, Atualizar ou Cancelar
3. Em Atualizar, permite editar dados e salva

**Pós-condições:**
- Dados de fornecedor vinculados à PJ
- Código de fornecedor gerado
- Registro de data/hora armazenado

---

#### 5. Cadastrar Aluno

**Descrição:** Vincula candidato aprovado como Aluno a partir de PF existente.

**Pré-condições:**
- Administrador autenticado
- Pessoa física do aluno já cadastrada
- Sistema operacional

**Cenário Principal:**
1. Selecionar "Cadastrar Aluno"
2. Informar CPF ou ID da PF
3. Sistema localiza e exibe pessoa
4. Sistema abre formulário acadêmico: curso, turno, data e forma de ingresso, status
5. Preencher e enviar
6. Sistema valida curso/turno e formato de matrícula
7. Vincular dados à PF
8. Gerar matrícula acadêmica
9. Exibir confirmação

**Cenário Alternativo 1 - Pessoa Física Não Encontrada:**
1. Busca não retorna resultados
2. Sistema informa "Pessoa física não cadastrada"
3. Oferece: "Cadastrar nova PF" ou "Cancelar"
4. Se cadastrar PF, retorna e finaliza vínculo de aluno

**Cenário Alternativo 2 - Curso Indisponível:**
1. Na validação, curso está indisponível para matrícula
2. Sistema oferece selecionar outro curso ou cancelar
3. Escolhendo outro curso, validação é refeita e cadastro concluído

**Pós-condições:**
- PF vinculada ao perfil Aluno com matrícula acadêmica criada
- Aluno habilitado nos sistemas acadêmicos
- Registro de data/hora armazenado

---

### Diagrama de Classes

```
┌─────────────────────────────────────┐
│           <<abstract>>              │
│             Pessoa                  │
├─────────────────────────────────────┤
│ - id: String                        │
│ - email: String                     │
│ - telefone: String                  │
│ - dataCadastro: Date                │
├─────────────────────────────────────┤
│ + cadastrar(): void                 │
│ + atualizar(): void                 │
│ + consultar(): Pessoa               │
│ + validarDados(): boolean           │
└─────────────────────────────────────┘
           ▲                    ▲
           │                    │
           │                    │
┌──────────┴──────────┐  ┌─────┴──────────────────┐
│   PessoaFisica      │  │   PessoaJuridica       │
├─────────────────────┤  ├────────────────────────┤
│ - nome: String      │  │ - razaoSocial: String  │
│ - cpf: String       │  │ - nomeFantasia: String │
│ - dataNascimento:   │  │ - cnpj: String         │
│   Date              │  │                        │
├─────────────────────┤  ├────────────────────────┤
│ + validarCPF():     │  │ + validarCNPJ():       │
│   boolean           │  │   boolean              │
└─────────────────────┘  └────────────────────────┘
         ▲                          ▲
         │                          │
         │                          │
    ┌────┴────┐                     │
    │         │                     │
┌───┴────┐ ┌──┴─────┐        ┌─────┴──────┐
│Professor│ │ Aluno  │        │ Fornecedor │
├─────────┤ ├────────┤        ├────────────┤
│- matricula│-matricula│       │- codigo:   │
│  Funcional│ Academica│       │  String    │
│- departa- │- curso:  │       │- ramo:     │
│  mento    │  String  │       │  String    │
│- titulacao│- turno:  │       │- produtos: │
│- regime   │  String  │       │  String    │
│- dataAdm  │- dataIng │       │- repres    │
├───────────├──────────┤       │- condicoes │
│+ lecionar │+ matricu │       ├────────────┤
│           │  lar     │       │+ fornecer  │
└───────────┴──────────┘       └────────────┘
```

**Relacionamentos:**
- **Herança**: PessoaFisica e PessoaJuridica herdam de Pessoa
- **Especialização**: Professor e Aluno especializam PessoaFisica
- **Especialização**: Fornecedor especializa PessoaJuridica

---

## 🎨 Fase 2 - Prototipação

### Protótipos de Interface

Os protótipos foram desenvolvidos utilizando HTML5 e CSS3, seguindo os casos de uso modelados na Fase 1.

#### Estrutura das Interfaces:

1. **Tela Principal (Dashboard)**
   - Menu de navegação com acesso a todos os cadastros
   - Interface limpa e intuitiva

2. **Cadastro de Pessoa Física**
   - Formulário com validação de CPF
   - Campos: Nome, CPF, Data de Nascimento, E-mail, Telefone
   - Máscaras de entrada para CPF e Telefone

3. **Cadastro de Pessoa Jurídica**
   - Formulário com validação de CNPJ
   - Campos: Razão Social, Nome Fantasia, CNPJ, E-mail, Telefone
   - Máscaras de entrada para CNPJ

4. **Cadastro de Professor**
   - Busca por CPF/ID de Pessoa Física existente
   - Campos complementares: Departamento, Titulação, Regime, Data de Admissão
   - Geração automática de matrícula funcional

5. **Cadastro de Fornecedor**
   - Busca por CNPJ/ID de Pessoa Jurídica existente
   - Campos: Ramo, Produtos/Serviços, Representante, Condições de Pagamento
   - Geração automática de código de fornecedor

6. **Cadastro de Aluno**
   - Busca por CPF/ID de Pessoa Física existente
   - Campos: Curso, Turno, Data de Ingresso, Forma de Ingresso, Status
   - Geração automática de matrícula acadêmica

### Tecnologias Utilizadas

#### Frontend:
- **HTML5** - Estrutura das páginas
- **CSS3** - Estilização e responsividade
- **JavaScript** - Validações e interatividade

#### Backend (Opcional):
- **Java** - Lógica de negócio
- **Classes modeladas** - Implementação do diagrama de classes da Fase 1

---

## 🚀 Como Executar o Projeto

### Requisitos:
- Navegador web moderno (Chrome, Firefox, Edge, Safari)
- Java JDK 11+ (para backend opcional)

### Executando os Protótipos:

1. Clone o repositório:
```bash
git clone https://github.com/[seu-usuario]/sistema-gestao-universitaria.git
cd sistema-gestao-universitaria
```

2. Abra os arquivos HTML no navegador:
```bash
# Windows
start prototipos/index.html

# Linux/Mac
open prototipos/index.html
```

3. Navegue pelas diferentes telas através do menu

### Executando o Backend (Opcional):

1. Compile as classes Java:
```bash
cd backend/src
javac *.java
```

2. Execute a aplicação:
```bash
java Main
```

---

## 👥 Contribuidores

**Grupo 48**

- [Nome do Integrante 1]
- [Nome do Integrante 2]
- [Nome do Integrante 3]
- [Nome do Integrante 4]
- [Nome do Integrante 5]

---

## 📄 Licença

Este projeto foi desenvolvido para fins acadêmicos como parte do Projeto Integrador.

---

## 📞 Contato

Para dúvidas ou sugestões sobre o projeto, entre em contato através do GitHub.

---

**Senac - Projeto Integrador**  
*Desenvolvimento de Sistemas Orientado a Objetos*
