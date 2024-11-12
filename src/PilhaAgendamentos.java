import java.util.Stack;

public class PilhaAgendamentos {
    private Stack<Agendamento> pilha;

    public PilhaAgendamentos() {
        this.pilha = new Stack<>();
    }

    public void adicionarAgendamento(String nomePaciente, String dataConsulta, String detalhes) {
        Agendamento agendamento = new Agendamento(nomePaciente, dataConsulta, detalhes);
        pilha.push(agendamento);
        System.out.println("Agendamento adicionado à pilha: " + agendamento);
    }

    public Agendamento removerAgendamento() {
        if (pilha.isEmpty()) {
            System.out.println("A pilha de agendamentos está vazia.");
            return null;
        }
        return pilha.pop();
    }
}
