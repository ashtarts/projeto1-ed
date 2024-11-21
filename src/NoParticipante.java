public class NoParticipante {
    private Participante participante;
    private NoParticipante proximo;

    public NoParticipante(Participante participante) {
        this.participante = participante;
        this.proximo = null;
    }

    public Participante getParticipante() {
        return participante;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }

    public NoParticipante getProximo() {
        return proximo;
    }

    public void setProximo(NoParticipante proximo) {
        this.proximo = proximo;
    }
}
