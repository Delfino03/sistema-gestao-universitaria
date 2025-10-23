// scripts.js - Funções compartilhadas do Sistema de Gestão Universitária

// Função para formatar data no padrão brasileiro
function formatarData(data) {
    if (!data) return '';
    const d = new Date(data);
    const dia = String(d.getDate()).padStart(2, '0');
    const mes = String(d.getMonth() + 1).padStart(2, '0');
    const ano = d.getFullYear();
    return `${dia}/${mes}/${ano}`;
}

// Função para validar CPF
function validarCPF(cpf) {
    cpf = cpf.replace(/\D/g, '');
    
    if (cpf.length !== 11) return false;
    
    // Verifica se todos os dígitos são iguais
    if (/^(\d)\1{10}$/.test(cpf)) return false;
    
    // Validação do primeiro dígito verificador
    let soma = 0;
    for (let i = 0; i < 9; i++) {
        soma += parseInt(cpf.charAt(i)) * (10 - i);
    }
    let resto = 11 - (soma % 11);
    let digito1 = resto >= 10 ? 0 : resto;
    
    if (digito1 !== parseInt(cpf.charAt(9))) return false;
    
    // Validação do segundo dígito verificador
    soma = 0;
    for (let i = 0; i < 10; i++) {
        soma += parseInt(cpf.charAt(i)) * (11 - i);
    }
    resto = 11 - (soma % 11);
    let digito2 = resto >= 10 ? 0 : resto;
    
    return digito2 === parseInt(cpf.charAt(10));
}

// Função para validar CNPJ
function validarCNPJ(cnpj) {
    cnpj = cnpj.replace(/\D/g, '');
    
    if (cnpj.length !== 14) return false;
    
    // Verifica se todos os dígitos são iguais
    if (/^(\d)\1{13}$/.test(cnpj)) return false;
    
    // Validação dos dígitos verificadores
    let tamanho = cnpj.length - 2;
    let numeros = cnpj.substring(0, tamanho);
    let digitos = cnpj.substring(tamanho);
    let soma = 0;
    let pos = tamanho - 7;
    
    for (let i = tamanho; i >= 1; i--) {
        soma += numeros.charAt(tamanho - i) * pos--;
        if (pos < 2) pos = 9;
    }
    
    let resultado = soma % 11 < 2 ? 0 : 11 - soma % 11;
    if (resultado !== parseInt(digitos.charAt(0))) return false;
    
    tamanho = tamanho + 1;
    numeros = cnpj.substring(0, tamanho);
    soma = 0;
    pos = tamanho - 7;
    
    for (let i = tamanho; i >= 1; i--) {
        soma += numeros.charAt(tamanho - i) * pos--;
        if (pos < 2) pos = 9;
    }
    
    resultado = soma % 11 < 2 ? 0 : 11 - soma % 11;
    return resultado === parseInt(digitos.charAt(1));
}

// Função para validar e-mail
function validarEmail(email) {
    const regex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    return regex.test(email);
}

// Função para exibir notificação toast
function mostrarNotificacao(mensagem, tipo = 'info') {
    const cores = {
        success: '#16a34a',
        error: '#dc2626',
        warning: '#ea580c',
        info: '#2563eb'
    };

    const notificacao = document.createElement('div');
    notificacao.style.cssText = `
        position: fixed;
        top: 20px;
        right: 20px;
        background-color: ${cores[tipo]};
        color: white;
        padding: 1rem 1.5rem;
        border-radius: 8px;
        box-shadow: 0 10px 15px -3px rgba(0, 0, 0, 0.1);
        z-index: 9999;
        animation: slideIn 0.3s ease-out;
        max-width: 400px;
    `;
    notificacao.textContent = mensagem;

    document.body.appendChild(notificacao);

    setTimeout(() => {
        notificacao.style.animation = 'slideOut 0.3s ease-out';
        setTimeout(() => {
            document.body.removeChild(notificacao);
        }, 300);
    }, 3000);
}

// Adicionar estilos de animação
const style = document.createElement('style');
style.textContent = `
    @keyframes slideIn {
        from {
            transform: translateX(100%);
            opacity: 0;
        }
        to {
            transform: translateX(0);
            opacity: 1;
        }
    }
    
    @keyframes slideOut {
        from {
            transform: translateX(0);
            opacity: 1;
        }
        to {
            transform: translateX(100%);
            opacity: 0;
        }
    }
`;
document.head.appendChild(style);

// Função para simular salvamento no localStorage
function salvarDados(tipo, dados) {
    try {
        let registros = JSON.parse(localStorage.getItem(tipo) || '[]');
        registros.push({
            ...dados,
            id: gerarId(tipo),
            dataCadastro: new Date().toISOString()
        });
        localStorage.setItem(tipo, JSON.stringify(registros));
        return true;
    } catch (error) {
        console.error('Erro ao salvar dados:', error);
        return false;
    }
}

// Função para buscar dados no localStorage
function buscarDados(tipo, filtro) {
    try {
        const registros = JSON.parse(localStorage.getItem(tipo) || '[]');
        if (!filtro) return registros;
        
        return registros.filter(registro => {
            return Object.keys(filtro).every(key => {
                return registro[key] && 
                       registro[key].toLowerCase().includes(filtro[key].toLowerCase());
            });
        });
    } catch (error) {
        console.error('Erro ao buscar dados:', error);
        return [];
    }
}

// Função para gerar ID único
function gerarId(prefixo) {
    const timestamp = Date.now();
    const random = Math.floor(Math.random() * 10000);
    return `${prefixo}-${timestamp}-${random}`;
}

// Função para limpar formulário
function limparFormulario(formId) {
    const form = document.getElementById(formId);
    if (form) {
        form.reset();
    }
}

// Função para desabilitar/habilitar formulário
function toggleFormulario(formId, desabilitar) {
    const form = document.getElementById(formId);
    if (!form) return;
    
    const elementos = form.querySelectorAll('input, select, textarea, button');
    elementos.forEach(elemento => {
        elemento.disabled = desabilitar;
    });
}

// Função para scroll suave
function scrollSuave(elementoId) {
    const elemento = document.getElementById(elementoId);
    if (elemento) {
        elemento.scrollIntoView({ 
            behavior: 'smooth', 
            block: 'start' 
        });
    }
}

// Event listener para confirmar saída com dados não salvos
let dadosAlterados = false;

document.addEventListener('DOMContentLoaded', function() {
    // Detectar alterações em formulários
    const formularios = document.querySelectorAll('form');
    formularios.forEach(form => {
        form.addEventListener('input', () => {
            dadosAlterados = true;
        });
        
        form.addEventListener('submit', () => {
            dadosAlterados = false;
        });
    });
    
    // Avisar antes de sair com dados não salvos
    window.addEventListener('beforeunload', (e) => {
        if (dadosAlterados) {
            e.preventDefault();
            e.returnValue = '';
            return '';
        }
    });
});

// Função para debug (pode ser removida em produção)
function debug(mensagem, dados) {
    if (typeof console !== 'undefined') {
        console.log(`[Debug] ${mensagem}`, dados);
    }
}

// Exportar funções para uso global
window.SGU = {
    formatarData,
    validarCPF,
    validarCNPJ,
    validarEmail,
    mostrarNotificacao,
    salvarDados,
    buscarDados,
    gerarId,
    limparFormulario,
    toggleFormulario,
    scrollSuave,
    debug
};
