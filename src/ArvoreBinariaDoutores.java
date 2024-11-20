public class ArvoreBinariaDoutores {
    private Doutor raiz;

    public ArvoreBinariaDoutores() {
        this.raiz = null;
    }

    // Método para inserir um doutor na árvore
    public void inserir(Doutor doutor) {
        raiz = inserirRecursivo(raiz, doutor);
    }

    private Doutor inserirRecursivo(Doutor atual, Doutor novoDoutor) {
        if (atual == null) {
            return novoDoutor;
        }

        int comparacao = novoDoutor.especialidade.compareToIgnoreCase(atual.especialidade);
        if (comparacao < 0) {
            atual.esquerda = inserirRecursivo(atual.esquerda, novoDoutor);
        } else if (comparacao > 0) {
            atual.direita = inserirRecursivo(atual.direita, novoDoutor);
        } else {
            // Empate: comparar pela disponibilidade
            int disponibilidadeComparacao = novoDoutor.disponibilidade.compareToIgnoreCase(atual.disponibilidade);
            if (disponibilidadeComparacao < 0) {
                atual.esquerda = inserirRecursivo(atual.esquerda, novoDoutor);
            } else {
                atual.direita = inserirRecursivo(atual.direita, novoDoutor);
            }
        }

        return atual;
    }

    // Método para remover um doutor da árvore
    public void remover(Doutor doutor) {
        raiz = removerRecursivo(raiz, doutor);
    }

    private Doutor removerRecursivo(Doutor atual, Doutor doutorParaRemover) {
        if (atual == null) {
            return null;
        }

        int comparacao = doutorParaRemover.especialidade.compareToIgnoreCase(atual.especialidade);

        if (comparacao < 0) {
            atual.esquerda = removerRecursivo(atual.esquerda, doutorParaRemover);
        } else if (comparacao > 0) {
            atual.direita = removerRecursivo(atual.direita, doutorParaRemover);
        } else {
            // Encontramos o nó a ser removido
            if (doutorParaRemover.disponibilidade.equalsIgnoreCase(atual.disponibilidade)) {
                // Caso 1: Nó sem filhos
                if (atual.esquerda == null && atual.direita == null) {
                    return null;
                }
                // Caso 2: Nó com apenas um filho
                if (atual.esquerda == null) {
                    return atual.direita;
                }
                if (atual.direita == null) {
                    return atual.esquerda;
                }
                // Caso 3: Nó com dois filhos
                Doutor sucessor = encontrarMinimo(atual.direita);
                atual.especialidade = sucessor.especialidade;
                atual.disponibilidade = sucessor.disponibilidade;
                atual.nome = sucessor.nome;
                atual.matricula = sucessor.matricula;
                atual.direita = removerRecursivo(atual.direita, sucessor);
            }
        }

        return atual;
    }

    private Doutor encontrarMinimo(Doutor atual) {
        while (atual.esquerda != null) {
            atual = atual.esquerda;
        }
        return atual;
    }

    // Método para buscar doutores por especialidade
    public void buscarPorEspecialidade(String especialidade) {
        buscarEspecialidadeRecursivo(raiz, especialidade.toLowerCase());
    }

    private void buscarEspecialidadeRecursivo(Doutor atual, String especialidade) {
        if (atual == null) {
            return;
        }

        if (atual.especialidade.equalsIgnoreCase(especialidade)) {
            System.out.println(atual);
        }

        buscarEspecialidadeRecursivo(atual.esquerda, especialidade);
        buscarEspecialidadeRecursivo(atual.direita, especialidade);
    }

    // Método para exibir todos os doutores em ordem
    public void exibirEmOrdem() {
        exibirEmOrdemRecursivo(raiz);
    }

    private void exibirEmOrdemRecursivo(Doutor atual) {
        if (atual != null) {
            exibirEmOrdemRecursivo(atual.esquerda);
            System.out.println(atual);
            exibirEmOrdemRecursivo(atual.direita);
        }
    }
}
