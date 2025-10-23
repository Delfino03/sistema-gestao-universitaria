# 📘 Guia de Configuração do GitHub - Projeto Integrador

## Passo 1: Criar Contas no GitHub

Todos os integrantes do grupo devem:

1. Acessar [github.com](https://github.com)
2. Clicar em "Sign up"
3. Seguir o processo de criação de conta
4. Confirmar o e-mail

## Passo 2: Criar o Repositório

**Um membro do grupo será responsável por criar o repositório:**

1. Fazer login no GitHub
2. Clicar no ícone "+" no canto superior direito
3. Selecionar "New repository"
4. Preencher as informações:
   - **Repository name:** `sistema-gestao-universitaria`
   - **Description:** "Sistema de Gestão Universitária - Projeto Integrador Senac - Grupo 48"
   - **Public** (marcar como público)
   - ✅ Marcar "Add a README file"
   - Escolher licença: MIT License (opcional)
5. Clicar em "Create repository"

## Passo 3: Adicionar Colaboradores

**O criador do repositório deve:**

1. Entrar no repositório criado
2. Clicar em "Settings" (configurações)
3. No menu lateral, clicar em "Collaborators"
4. Clicar em "Add people"
5. Digitar o username do GitHub de cada integrante
6. Enviar convites para todos os membros

**Os outros membros devem:**
- Verificar o e-mail e aceitar o convite
- Ou acessar o link do repositório e aceitar o convite diretamente

## Passo 4: Clonar o Repositório Localmente

Cada membro deve executar no terminal/cmd:

```bash
git clone https://github.com/[USUARIO]/sistema-gestao-universitaria.git
cd sistema-gestao-universitaria
```

## Passo 5: Adicionar os Arquivos do Projeto

### Estrutura de Diretórios

Criar a seguinte estrutura no repositório:

```
sistema-gestao-universitaria/
├── README.md
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
        ├── diagrama-casos-uso.png
        └── diagrama-classes.png
```

### Comandos para adicionar arquivos:

```bash
# Copiar todos os arquivos HTML, CSS, JS para o diretório do repositório

# Criar diretório backend
mkdir -p backend/src

# Copiar arquivos Java para backend/src

# Criar diretório para diagramas
mkdir -p docs/diagramas

# Adicionar imagens dos diagramas da Fase 1 em docs/diagramas/
```

## Passo 6: Fazer o Primeiro Commit

```bash
# Verificar status dos arquivos
git status

# Adicionar todos os arquivos
git add .

# Fazer o commit
git commit -m "feat: adiciona protótipos e documentação do projeto"

# Enviar para o GitHub
git push origin main
```

## Passo 7: Atualizar o README.md

O README.md já foi criado com toda a documentação. Para atualizá-lo:

```bash
# Editar o README.md com as informações do grupo
# Adicionar nomes dos integrantes na seção "Contribuidores"

# Fazer commit das alterações
git add README.md
git commit -m "docs: adiciona nomes dos integrantes"
git push origin main
```

## Passo 8: Adicionar Diagramas da Fase 1

1. Salvar os diagramas (Caso de Uso e Classes) como imagens PNG
2. Colocar em `docs/diagramas/`
3. Atualizar o README.md para incluir as imagens:

```markdown
### Diagrama de Caso de Uso
![Diagrama de Caso de Uso](docs/diagramas/diagrama-casos-uso.png)

### Diagrama de Classes
![Diagrama de Classes](docs/diagramas/diagrama-classes.png)
```

4. Fazer commit:
```bash
git add docs/diagramas/
git add README.md
git commit -m "docs: adiciona diagramas UML da Fase 1"
git push origin main
```

## Comandos Git Úteis

### Para atualizar seu repositório local:
```bash
git pull origin main
```

### Para ver o histórico de commits:
```bash
git log --oneline
```

### Para criar uma nova branch (opcional):
```bash
git checkout -b nome-da-branch
```

### Para ver diferenças antes do commit:
```bash
git diff
```

## Boas Práticas

1. **Sempre fazer `git pull` antes de começar a trabalhar**
2. **Commits frequentes com mensagens descritivas:**
   - `feat:` para novas funcionalidades
   - `fix:` para correções
   - `docs:` para documentação
   - `style:` para formatação
   - `refactor:` para refatoração

3. **Testar antes de fazer push**
4. **Comunicação com o grupo via issues do GitHub**

## Recursos Adicionais

- [Documentação Git](https://git-scm.com/doc)
- [GitHub Guides](https://guides.github.com/)
- [Markdown Guide](https://www.markdownguide.org/)

---

## ✅ Checklist Final

- [ ] Todos os integrantes têm conta no GitHub
- [ ] Repositório criado
- [ ] Todos os membros foram adicionados como colaboradores
- [ ] Todos aceitaram o convite
- [ ] README.md completo com toda documentação
- [ ] Protótipos HTML/CSS/JS adicionados
- [ ] Classes Java adicionadas (opcional)
- [ ] Diagramas da Fase 1 incluídos
- [ ] Primeiro commit realizado com sucesso
- [ ] Repositório visível e acessível para todos

---

**Grupo 48 - Senac Projeto Integrador**
