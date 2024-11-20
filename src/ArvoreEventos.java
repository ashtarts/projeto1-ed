public class ArvoreEventos {
    private NoEventoBinario raiz;

    public ArvoreEventos() { raiz = null; }

    // Inserir evento na árvore
    public void inserir(Evento evento) {
        raiz = inserirRecursivo(raiz, evento);
    }

    private NoEventoBinario inserirRecursivo(NoEventoBinario no, Evento evento) {
        if (no == null) return new NoEventoBinario(evento);
        if (evento.getData().compareTo(no.getEvento().getData()) < 0)
            no.setEsquerda(inserirRecursivo(no.getEsquerda(), evento));
        else
            no.setDireita(inserirRecursivo(no.getDireita(), evento));
        return no;
    }

    // Buscar por nome evento
    public Evento buscar(String nome) {
        return buscarRecursivo(raiz, nome);
    }

    private Evento buscarRecursivo(NoEventoBinario no, String nome) {
        if (no == null) return null;
        if (no.getEvento().getNome().equals(nome)) return no.getEvento();
        if (nome.compareTo(no.getEvento().getNome()) < 0)
            return buscarRecursivo(no.getEsquerda(), nome);
        else
            return buscarRecursivo(no.getDireita(), nome);
    }

    // Listar eventos em ordem
    public void listarEventosInOrder() {
        listarEventosInOrderRecursivo(raiz);
    }

    private void listarEventosInOrderRecursivo(NoEventoBinario no) {
        if (no != null) {
            listarEventosInOrderRecursivo(no.getEsquerda());
            System.out.println(no.getEvento());
            listarEventosInOrderRecursivo(no.getDireita());
        }
    }
}
