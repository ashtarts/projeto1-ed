public class NoEvento {
    private Evento evento;
    private NoEvento proximo;

    public NoEvento(Evento evento) {
        this.evento = evento;
        this.proximo = null;
    }

    public Evento getEvento() { return evento; }
    public void setEvento(Evento evento) { this.evento = evento; }

    public NoEvento getProximo() { return proximo; }
    public void setProximo(NoEvento proximo) { this.proximo = proximo; }
}
