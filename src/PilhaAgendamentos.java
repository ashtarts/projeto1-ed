import java.util.Stack;

public class PilhaAgendamentos {
    private Stack<String> historicoAcoes; // Pilha para armazenar histórico de ações
    private Stack<Agendamento> pilha;

    public PilhaAgendamentos() {
        this.pilha = new Stack<>();
        this.historicoAcoes = new Stack<>();
    }

    public void adicionarAgendamento(String nomePaciente, String dataConsulta, String detalhes) {
        Agendamento agendamento = new Agendamento(nomePaciente, dataConsulta, detalhes);
        pilha.push(agendamento);
        historicoAcoes.push("Adicionado: " + agendamento); // Armazena a ação no histórico
        System.out.println("Agendamento adicionado à pilha: " + agendamento);
    }

    public Agendamento removerAgendamento() {
        if (pilha.isEmpty()) {
            System.out.println("A pilha de agendamentos está vazia.");
            return null;
        }
        Agendamento removido = pilha.pop();
        historicoAcoes.push("Removido: " + removido); // Armazena a ação no histórico
        System.out.println("Agendamento removido da pilha: " + removido);
        return removido;
    }

    public void desfazerUltimaAcao() {
        if (historicoAcoes.isEmpty()) {
            System.out.println("Nenhuma ação para desfazer.");
            return;
        }
        String ultimaAcao = historicoAcoes.pop();
        System.out.println("Ação desfeita: " + ultimaAcao);
        // Adicionalmente, você pode implementar a lógica de reversão aqui
    }

    public void exibirAgendamentos() {
        if (pilha.isEmpty()) {
            System.out.println("A pilha de agendamentos está vazia.");
            return;
        }

        System.out.println("Agendamentos na pilha:");
        for (Agendamento agendamento : pilha) {
            System.out.println(agendamento);
        }
    }

    public void exibirHistorico() {
        if (historicoAcoes.isEmpty()) {
            System.out.println("O histórico de ações está vazio.");
            return;
        }

        System.out.println("Histórico de ações:");
        for (String acao : historicoAcoes) {
            System.out.println(acao);
        }
    }
}
