import java.util.Stack;

public class PilhaHistorico {
    private Stack<String> historico;

    public PilhaHistorico() {
        historico = new Stack<>();
    }

    public void adicionarAcao(String acao) {
        historico.push(acao);
    }

    public String removerUltimaAcao() {
        return historico.isEmpty() ? null : historico.pop();
    }

    public void exibirHistorico() {
        System.out.println("\nHistórico de Ações:");
        for (String acao : historico) {
            System.out.println(acao);
        }
    }
}
