import java.util.Scanner;

public class GerenciadorEventos {
    private NoEvento inicioEventos;
    private NoParticipante inicioParticipantes;

    public GerenciadorEventos() {
        this.inicioEventos = null;
        this.inicioParticipantes = null;
    }

    public void adicionarEvento(Evento evento) {
        NoEvento novoNo = new NoEvento(evento);
        if (inicioEventos == null) {
            inicioEventos = novoNo;
        } else {
            NoEvento temp = inicioEventos;
            while (temp.getProximo() != null) {
                temp = temp.getProximo();
            }
            temp.setProximo(novoNo);
        }
    }

    public void removerEvento(String nome) {
        NoEvento temp = inicioEventos;
        NoEvento anterior = null;
        while (temp != null && !temp.getEvento().getNome().equals(nome)) {
            anterior = temp;
            temp = temp.getProximo();
        }
        if (temp == null) return;

        if (anterior == null) {
            inicioEventos = temp.getProximo();
        } else {
            anterior.setProximo(temp.getProximo());
        }
    }

    public void atualizarEvento(String nome, String novaData, String novoLocal, int novaCapacidade) {
        NoEvento temp = inicioEventos;
        while (temp != null) {
            if (temp.getEvento().getNome().equals(nome)) {
                temp.getEvento().setData(novaData);
                temp.getEvento().setLocal(novoLocal);
                temp.getEvento().setCapacidade(novaCapacidade);
                return;
            }
            temp = temp.getProximo();
        }
    }

    public Evento buscarEvento(String nome) {
        NoEvento temp = inicioEventos;
        while (temp != null) {
            if (temp.getEvento().getNome().equals(nome)) {
                return temp.getEvento();
            }
            temp = temp.getProximo();
        }
        return null;
    }

    public void adicionarParticipante(Participante participante) {
        NoParticipante novoNo = new NoParticipante(participante);
        if (inicioParticipantes == null) {
            inicioParticipantes = novoNo;
        } else {
            NoParticipante temp = inicioParticipantes;
            while (temp.getProximo() != null) {
                temp = temp.getProximo();
            }
            temp.setProximo(novoNo);
        }
    }

    public void removerParticipante(String numeroInscricao) {
        NoParticipante temp = inicioParticipantes;
        NoParticipante anterior = null;
        while (temp != null && !temp.getParticipante().getNumeroInscricao().equals(numeroInscricao)) {
            anterior = temp;
            temp = temp.getProximo();
        }
        if (temp == null) return;

        if (anterior == null) {
            inicioParticipantes = temp.getProximo();
        } else {
            anterior.setProximo(temp.getProximo());
        }
    }

    public void listarEventos() {
        NoEvento temp = inicioEventos;
        while (temp != null) {
            System.out.println(temp.getEvento());
            temp = temp.getProximo();
        }
    }

    public void listarParticipantes() {
        NoParticipante temp = inicioParticipantes;
        while (temp != null) {
            System.out.println(temp.getParticipante());
            temp = temp.getProximo();
        }
    }
}