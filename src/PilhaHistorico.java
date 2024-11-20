import java.util.Stack;

public class PilhaHistorico {
    private Stack<String> historico;

    public PilhaHistorico() {
        historico = new Stack<>();
    }

    // Adicionar ação ao histórico
    public void adicionarAção(String acao) {
        historico.push(acao);
    }

    // Remover última ação
    public String removerUltimaAção() {
        return historico.isEmpty() ? null : historico.pop();
    }

    // Exibir histórico de ações
    public void exibirHistorico() {
        System.out.println("\nHistórico de Ações:");
        for (String acao : historico) {
            System.out.println(acao);
        }
    }
}
