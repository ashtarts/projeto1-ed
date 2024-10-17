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
        if (temp == null)
            return;

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
        if (temp == null)
            return;

        if (anterior == null) {
            inicioParticipantes = temp.getProximo();
        } else {
            anterior.setProximo(temp.getProximo());
        }
    }

    public void listarEventos() {
        NoEvento temp = inicioEventos;
        System.out.println("\nListagem de Eventos:");
        System.out.printf("%-20s %-20s %-20s %-10s %-25s%n", "Nome", "Data", "Local", "Capacidade", "Participantes");
        System.out.println(
                "---------------------------------------------------------------------------------------------------");
        while (temp != null) {
            Evento evento = temp.getEvento();
            StringBuilder participantesInscritos = new StringBuilder();

            // Listar participantes inscritos no evento
            NoParticipante tempParticipante = inicioParticipantes;
            while (tempParticipante != null) {
                Participante participante = tempParticipante.getParticipante();
                if (participante.getEvento().getNome().equals(evento.getNome())) {
                    participantesInscritos.append(participante.getNome()).append(", ");
                }
                tempParticipante = tempParticipante.getProximo();
            }

            // Remover a última vírgula e espaço se houver participantes
            if (participantesInscritos.length() > 0) {
                participantesInscritos.setLength(participantesInscritos.length() - 2); // Remove o último ", "
            } else {
                participantesInscritos.append("Nenhum participante inscrito");
            }

            System.out.printf("%-20s %-20s %-20s %-10d %-25s%n",
                    evento.getNome(),
                    evento.getData(),
                    evento.getLocal(),
                    evento.getCapacidade(),
                    participantesInscritos.toString());

            temp = temp.getProximo();
        }
    }

    public void listarParticipantes() {
        NoParticipante temp = inicioParticipantes;
        System.out.println("\nListagem de Participantes:");
        System.out.printf("%-20s %-25s %-20s%n", "Nome", "Número de Inscrição", "Evento");
        System.out.println("----------------------------------------------------------");
        while (temp != null) {
            Participante participante = temp.getParticipante();
            System.out.printf("%-20s %-25s %-20s%n",
                    participante.getNome(),
                    participante.getNumeroInscricao(),
                    participante.getEvento().getNome());
            temp = temp.getProximo();
        }
    }

}