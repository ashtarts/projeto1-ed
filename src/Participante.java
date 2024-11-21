public class Participante {
    private String nome;
    private int numeroInscricao;
    private int prioridade;
    private Evento evento; // Add a reference to the associated Evento

    public Participante(String nome, int numeroInscricao, int prioridade, Evento evento) {
        this.nome = nome;
        this.numeroInscricao = numeroInscricao;
        this.prioridade = prioridade;
        this.evento = evento; // Initialize the associated Evento
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumeroInscricao() {
        return numeroInscricao;
    }

    public void setNumeroInscricao(int numeroInscricao) {
        this.numeroInscricao = numeroInscricao;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

    public Evento getEvento() { // Add getter for the associated Evento
        return evento;
    }

    public void setEvento(Evento evento) { // Add setter for the associated Evento
        this.evento = evento;
    }

    @Override
    public String toString() {
        return "Participante: " + nome + ", Inscrição: " + numeroInscricao + ", Prioridade: " + prioridade +
                ", Evento: " + (evento != null ? evento.getNome() : "Nenhum");
    }
}
