public class ArvoreParticipantes {
    private NoParticipanteBinario raiz;

    // Inserir participante na árvore (por número de inscrição)
    public void inserir(Participante participante) {
        raiz = inserirRecursivo(raiz, participante);
    }

    // Inserção recursiva com base no número de inscrição
    private NoParticipanteBinario inserirRecursivo(NoParticipanteBinario no, Participante participante) {
        if (no == null)
            return new NoParticipanteBinario(participante);

        if (participante.getNumeroInscricao() < no.getParticipante().getNumeroInscricao())
            no.setEsquerda(inserirRecursivo(no.getEsquerda(), participante));
        else
            no.setDireita(inserirRecursivo(no.getDireita(), participante));

        return no;
    }

    // Buscar participante por número de inscrição
    public Participante buscarPorNumero(int numeroInscricao) {
        return buscarPorNumeroRecursivo(raiz, numeroInscricao);
    }

    private Participante buscarPorNumeroRecursivo(NoParticipanteBinario no, int numeroInscricao) {
        if (no == null)
            return null;

        if (no.getParticipante().getNumeroInscricao() == numeroInscricao)
            return no.getParticipante();

        return numeroInscricao < no.getParticipante().getNumeroInscricao()
                ? buscarPorNumeroRecursivo(no.getEsquerda(), numeroInscricao)
                : buscarPorNumeroRecursivo(no.getDireita(), numeroInscricao);
    }

    // Listar participantes em ordem crescente de número de inscrição
    public void listarParticipantesInOrder() {
        listarParticipantesInOrderRecursivo(raiz);
    }

    private void listarParticipantesInOrderRecursivo(NoParticipanteBinario no) {
        if (no != null) {
            listarParticipantesInOrderRecursivo(no.getEsquerda());
            System.out.println(no.getParticipante()); // Exibe o participante
            listarParticipantesInOrderRecursivo(no.getDireita());
        }
    }

    // Listar participantes por prioridade (ordem decrescente)
    public void listarParticipantesPorPrioridade() {
        listarParticipantesPorPrioridadeRecursivo(raiz);
    }

    private void listarParticipantesPorPrioridadeRecursivo(NoParticipanteBinario no) {
        if (no != null) {
            listarParticipantesPorPrioridadeRecursivo(no.getDireita());
            System.out.println(no.getParticipante()); // Exibe o participante com prioridade
            listarParticipantesPorPrioridadeRecursivo(no.getEsquerda());
        }
    }
}

class NoParticipanteBinario {
    private Participante participante;
    private NoParticipanteBinario esquerda;
    private NoParticipanteBinario direita;

    public NoParticipanteBinario(Participante participante) {
        this.participante = participante;
        this.esquerda = null;
        this.direita = null;
    }

    public Participante getParticipante() {
        return participante;
    }

    public NoParticipanteBinario getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(NoParticipanteBinario esquerda) {
        this.esquerda = esquerda;
    }

    public NoParticipanteBinario getDireita() {
        return direita;
    }

    public void setDireita(NoParticipanteBinario direita) {
        this.direita = direita;
    }
}
