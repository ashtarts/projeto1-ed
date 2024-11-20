public class NoEventoBinario {
    private Evento evento;
    private NoEventoBinario esquerda; // Referência para o filho esquerdo (árvore binária)
    private NoEventoBinario direita;  // Referência para o filho direito (árvore binária)
    private NoEventoBinario proximo;  // Referência para o próximo nó (lista encadeada)

    // Construtor
    public NoEventoBinario(Evento evento) {
        this.evento = evento;
        this.esquerda = null;
        this.direita = null;
        this.proximo = null;
    }

    // Métodos para acessar e modificar o atributo 'evento'
    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    // Métodos para acessar e modificar o filho esquerdo (árvore binária)
    public NoEventoBinario getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(NoEventoBinario esquerda) {
        this.esquerda = esquerda;
    }

    // Métodos para acessar e modificar o filho direito (árvore binária)
    public NoEventoBinario getDireita() {
        return direita;
    }

    public void setDireita(NoEventoBinario direita) {
        this.direita = direita;
    }

    // Métodos para acessar e modificar o próximo nó (lista encadeada)
    public NoEventoBinario getProximo() {
        return proximo;
    }

    public void setProximo(NoEventoBinario proximo) {
        this.proximo = proximo;
    }
}
