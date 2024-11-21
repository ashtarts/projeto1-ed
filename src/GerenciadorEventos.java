import java.util.*;

public class GerenciadorEventos {
    private NoEventoBinario inicioEventos; // Binary tree for events
    private NoParticipante inicioParticipantes; // Linked list for participants
    private Stack<Evento> historicoEventos; // Stack for event history

    public GerenciadorEventos() {
        this.inicioEventos = null;
        this.inicioParticipantes = null;
        this.historicoEventos = new Stack<>();
    }

    // Adicionar Evento (Binary Tree)
    public void adicionarEvento(Evento evento) {
        NoEventoBinario novoNo = new NoEventoBinario(evento);
        if (inicioEventos == null) {
            inicioEventos = novoNo;
        } else {
            NoEventoBinario temp = inicioEventos;
            while (temp.getProximo() != null) {
                temp = temp.getProximo();
            }
            temp.setProximo(novoNo);
        }
        System.out.println("Evento " + evento.getNome() + " adicionado com sucesso.");
    }

    // Atualizar Evento
    public void atualizarEvento(String nome, String novaData, String novoLocal, int novaCapacidade, double novoPreco) {
        NoEventoBinario temp = inicioEventos;
        while (temp != null) {
            if (temp.getEvento().getNome().equals(nome)) {
                Evento evento = temp.getEvento();
                evento.setData(novaData);
                evento.setLocal(novoLocal);
                evento.setCapacidade(novaCapacidade);
                evento.setPreco(novoPreco);
                System.out.println("Evento " + nome + " atualizado com sucesso.");
                return;
            }
            temp = temp.getProximo();
        }
        System.out.println("Evento não encontrado.");
    }

    // Remover Evento
    public void removerEvento(String nome) {
        NoEventoBinario temp = inicioEventos;
        NoEventoBinario anterior = null;
        while (temp != null && !temp.getEvento().getNome().equals(nome)) {
            anterior = temp;
            temp = temp.getProximo();
        }
        if (temp == null) {
            System.out.println("Evento não encontrado.");
            return;
        }

        if (anterior == null) {
            inicioEventos = temp.getProximo();
        } else {
            anterior.setProximo(temp.getProximo());
        }
        System.out.println("Evento " + nome + " removido com sucesso.");
    }

    // Listar Eventos
    public void listarEventos() {
        NoEventoBinario temp = inicioEventos;
        if (temp == null) {
            System.out.println("Nenhum evento cadastrado.");
            return;
        }

        System.out.println("\nListagem de Eventos:");
        System.out.printf("%-20s %-20s %-20s %-10s %-25s%n", "Nome", "Data", "Local", "Capacidade", "Participantes");
        System.out.println(
                "---------------------------------------------------------------------------------------------------");

        while (temp != null) {
            Evento evento = temp.getEvento();
            List<String> participantesInscritos = buscarParticipantesEvento(evento.getNome());

            System.out.printf("%-20s %-20s %-20s %-10d %-25s%n",
                    evento.getNome(),
                    evento.getData(),
                    evento.getLocal(),
                    evento.getCapacidade(),
                    participantesInscritos.isEmpty() ? "Nenhum participante inscrito" : String.join(", ", participantesInscritos));

            temp = temp.getProximo();
        }
    }

    // Buscar Evento
    public Evento buscarEvento(String nome) {
        NoEventoBinario temp = inicioEventos;
        while (temp != null) {
            if (temp.getEvento().getNome().equalsIgnoreCase(nome)) {
                historicoEventos.add(temp.getEvento());
                return temp.getEvento();
            }
            temp = temp.getProximo();
        }
        System.out.println("Evento não encontrado.");
        return null;
    }

    // Mostrar Histórico de Eventos
    public void mostrarHistorico() {
        if (historicoEventos.isEmpty()) {
            System.out.println("Nenhum evento foi consultado.");
        } else {
            System.out.println("Histórico de Eventos:");
            for (Evento evento : historicoEventos) {
                System.out.println(evento);
            }
        }
    }

    // Adicionar Participante (Linked List)
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
        System.out.println("Participante " + participante.getNome() + " adicionado com sucesso.");
    }

    // Remover Participante
    // Remover Participante
    public void removerParticipante(int numeroInscricao) { // Change parameter type to int
        NoParticipante temp = inicioParticipantes;
        NoParticipante anterior = null;
        while (temp != null && temp.getParticipante().getNumeroInscricao() != numeroInscricao) { // Use '!=' for comparison
            anterior = temp;
            temp = temp.getProximo();
        }
        if (temp == null) {
            System.out.println("Participante não encontrado.");
            return;
        }

        if (anterior == null) {
            inicioParticipantes = temp.getProximo();
        } else {
            anterior.setProximo(temp.getProximo());
        }
        System.out.println("Participante removido com sucesso.");
    }


    // Listar Participantes
    public void listarParticipantes() {
        NoParticipante temp = inicioParticipantes;
        if (temp == null) {
            System.out.println("Nenhum participante cadastrado.");
            return;
        }

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

    // Buscar Participantes de um Evento
    private List<String> buscarParticipantesEvento(String nomeEvento) {
        List<String> participantesInscritos = new ArrayList<>();
        NoParticipante tempParticipante = inicioParticipantes;

        while (tempParticipante != null) {
            Participante participante = tempParticipante.getParticipante();
            if (participante.getEvento().getNome().equals(nomeEvento)) {
                participantesInscritos.add(participante.getNome());
            }
            tempParticipante = tempParticipante.getProximo();
        }

        return participantesInscritos;
    }
}
